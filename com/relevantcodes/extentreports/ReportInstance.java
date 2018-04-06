/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.relevantcodes.extentreports;

import com.relevantcodes.extentreports.model.CategoryList;
import com.relevantcodes.extentreports.model.MediaList;
import com.relevantcodes.extentreports.model.RunInfo;
import com.relevantcodes.extentreports.model.ScreenCapture;
import com.relevantcodes.extentreports.model.Screencast;
import com.relevantcodes.extentreports.model.Test;
import com.relevantcodes.extentreports.model.TestAttribute;
import com.relevantcodes.extentreports.source.CategoryHtml;
import com.relevantcodes.extentreports.source.ExtentFlag;
import com.relevantcodes.extentreports.support.DateTimeHelper;
import com.relevantcodes.extentreports.support.FileReaderEx;
import com.relevantcodes.extentreports.support.RegexMatcher;
import com.relevantcodes.extentreports.support.Resources;
import com.relevantcodes.extentreports.support.Writer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class ReportInstance {
	private Boolean terminated = Boolean.valueOf(false);
	private CategoryList categoryList;
	private DisplayOrder displayOrder;
	private String filePath;
	private volatile int infoWrite = 0;
	private final Object lock = new Object();
	private final String offlineFolderParent = "extentreports";
	private MediaList mediaList;
	private String quickSummarySource = "";
	private RunInfo runInfo;
	private volatile String extentSource = null;
	private volatile String testSource = "";

	public synchronized void addTest(Test test) {
		if (test.endedTime == null) {
			test.endedTime = Calendar.getInstance().getTime();
		}

		for (ScreenCapture s : test.screenCapture) {
			this.mediaList.screenCapture.add(s);
		}

		for (Screencast s : test.screencast) {
			this.mediaList.screencast.add(s);
		}

		test.prepareFinalize();

		addTest(TestBuilder.getSource(test));
		addQuickTestSummary(TestBuilder.getQuickTestSummary(test));
		addCategories(test);
		updateCategoryView(test);
	}

	private synchronized void addTest(String source) {
		if (this.displayOrder == DisplayOrder.OLDEST_FIRST) {
			this.testSource += source;
		} else
			this.testSource = source + this.testSource;
	}

	private synchronized void addQuickTestSummary(String source) {
		if (this.displayOrder == DisplayOrder.OLDEST_FIRST) {
			this.quickSummarySource += source;
		} else
			this.quickSummarySource = source + this.quickSummarySource;
	}

	private synchronized void addCategories(Test test) {
		for (TestAttribute attr : test.categoryList)
			if (!(this.categoryList.categories.contains(attr.getName())))
				this.categoryList.categories.add(attr.getName());
	}

	private synchronized void updateCategoryView(Test test) {
		if (test.isChildNode) {
			return;
		}

		String s = "";
		String testSource = "";
		String addedFlag = "";
		String[] sourceKeys = { ExtentFlag.getPlaceHolder("categoryViewName"),
				ExtentFlag.getPlaceHolder("categoryViewNameL"), ExtentFlag.getPlaceHolder("categoryViewTestDetails") };
		String[] testKeys = { ExtentFlag.getPlaceHolder("categoryViewTestRunTime"),
				ExtentFlag.getPlaceHolder("categoryViewTestName"),
				ExtentFlag.getPlaceHolder("categoryViewTestStatus") };
		String[] testValues = { DateTimeHelper.getFormattedDateTime(test.startedTime, LogSettings.logDateTimeFormat),
				test.name, test.status.toString().toLowerCase() };

		for (TestAttribute attr : test.categoryList) {
			addedFlag = ExtentFlag.getPlaceHolder("categoryViewTestDetails" + attr.getName());

			if (this.extentSource.indexOf(addedFlag) == -1) {
				String[] sourceValues = { attr.getName(), attr.getName().trim().toLowerCase().replace(" ", ""),
						addedFlag };

				s = s + SourceBuilder.build(CategoryHtml.getCategoryViewSource(), sourceKeys, sourceValues);
				testSource = SourceBuilder.build(CategoryHtml.getCategoryViewTestSource(), testKeys, testValues);
				s = SourceBuilder.build(s, new String[] { addedFlag }, new String[] { testSource + addedFlag });
			} else {
				testSource = SourceBuilder.build(CategoryHtml.getCategoryViewTestSource(), testKeys, testValues);
				this.extentSource = SourceBuilder.build(this.extentSource, new String[] { addedFlag },
						new String[] { testSource + addedFlag });
			}
		}

		this.extentSource = this.extentSource.replace(ExtentFlag.getPlaceHolder("extentCategoryDetails"),
				s + ExtentFlag.getPlaceHolder("extentCategoryDetails"));
	}

	public synchronized void initialize(String filePath, boolean replace, DisplayOrder displayOrder,
			NetworkMode networkMode) {
		this.displayOrder = displayOrder;
		this.filePath = filePath;

		if (this.extentSource != null) {
			return;
		}

		File reportFile = new File(filePath);

		if (!(reportFile.getParentFile().exists())) {
			reportFile.getParentFile().mkdirs();
		}

		String sourceFile = "com/relevantcodes/extentreports/source/STANDARD.html";

		if (networkMode == NetworkMode.OFFLINE) {
			sourceFile = "com/relevantcodes/extentreports/source/STANDARD.offline.html";

			initOfflineMode(reportFile);
		}

		if (!(reportFile.isFile())) {
			replace = true;
		}

		if (replace) {
			this.extentSource = Resources.getText(sourceFile);
		} else {
			this.extentSource = FileReaderEx.readAllText(filePath);
		}

		this.runInfo = new RunInfo();
		this.runInfo.startedAt = DateTimeHelper.getFormattedDateTime(Calendar.getInstance().getTime(),
				LogSettings.logDateTimeFormat);

		this.categoryList = new CategoryList();
		this.mediaList = new MediaList();
	}

	private void initOfflineMode(File file) {
		String cssPath = "com/relevantcodes/extentreports/source/offline/css/";
		String jsPath = "com/relevantcodes/extentreports/source/offline/js/";

		String[] css = { "css.css", "font-awesome.css.map", "fontawesome-webfont.eot", "fontawesome-webfont.svg",
				"fontawesome-webfont.ttf", "fontawesome-webfont.woff", "fontawesome-webfont.woff2", "FontAwesome.otf" };

		String[] js = { "scripts.js" };

		String[] folderNames = { "css", "js" };

		for (String name : folderNames) {
			new File(file.getParent() + "\\" + "extentreports" + "\\" + name).mkdirs();
		}

		for (String f : css) {
			Resources.moveResource(cssPath + f, file.getParent() + "\\" + "extentreports" + "\\css\\" + f);
		}
		for (String f : js)
			Writer.getInstance().write(new File(file.getParent() + "\\" + "extentreports" + "\\js\\" + f),
					Resources.getText(jsPath + f));
	}

	public void terminate(List<ExtentTest> testList) {
		if (testList != null) {
			for (ExtentTest t : testList) {
				if (!(t.getTest().hasEnded)) {
					t.getTest().internalWarning += "Test did not end safely because endTest() was not called. There may be errors which are not reported correctly.";
					addTest(t.getTest());
				}
			}
		}

		writeAllResources(null, null);

		this.extentSource = "";
		this.categoryList = null;
		this.runInfo = null;

		this.terminated = Boolean.valueOf(true);
	}

	public synchronized void writeAllResources(List<ExtentTest> testList, SystemInfo systemInfo) {
		if (this.terminated.booleanValue()) {
			try {
				throw new IOException("Stream closed");
			} catch (IOException e) {
				e.printStackTrace();

				return;
			}
		}
		if ((systemInfo != null) && (systemInfo.getInfo() != null)) {
			updateSystemInfo(systemInfo.getInfo());
		}
		if (this.testSource == "") {
			return;
		}
		this.runInfo.endedAt = DateTimeHelper.getFormattedDateTime(Calendar.getInstance().getTime(),
				LogSettings.logDateTimeFormat);

		updateCategoryList();
		updateSuiteExecutionTime();
		updateMediaInfo();

		if (this.displayOrder == DisplayOrder.OLDEST_FIRST) {
			this.extentSource = this.extentSource
					.replace(ExtentFlag.getPlaceHolder("test"), this.testSource + ExtentFlag.getPlaceHolder("test"))
					.replace(ExtentFlag.getPlaceHolder("quickTestSummary"),
							this.quickSummarySource + ExtentFlag.getPlaceHolder("quickTestSummary"));
		} else {
			this.extentSource = this.extentSource
					.replace(ExtentFlag.getPlaceHolder("test"), ExtentFlag.getPlaceHolder("test") + this.testSource)
					.replace(ExtentFlag.getPlaceHolder("quickTestSummary"),
							ExtentFlag.getPlaceHolder("quickTestSummary") + this.quickSummarySource);
		}

		Writer.getInstance().write(new File(this.filePath), this.extentSource);

		this.testSource = "";
		this.quickSummarySource = "";
	}

	private synchronized void updateCategoryList() {
		String catsAdded = "";
		String c = "";
		Iterator iter = this.categoryList.categories.iterator();

		while (iter.hasNext()) {
			c = (String) iter.next();

			if (this.extentSource.indexOf(ExtentFlag.getPlaceHolder("categoryAdded" + c)) > 0) {
				iter.remove();
			}

			catsAdded = catsAdded
					+ ExtentFlag.getPlaceHolder(new StringBuilder().append("categoryAdded").append(c).toString());
		}

		String source = CategorySourceBuilder.buildOptions(this.categoryList.categories);

		if (source != "")
			synchronized (this.lock) {
				this.extentSource = this.extentSource
						.replace(ExtentFlag.getPlaceHolder("categoryListOptions"),
								source + ExtentFlag.getPlaceHolder("categoryListOptions"))
						.replace(ExtentFlag.getPlaceHolder("categoryAdded"),
								catsAdded + ExtentFlag.getPlaceHolder("categoryAdded"));
			}
	}

	private synchronized void updateSuiteExecutionTime() {
		String[] keys = { ExtentFlag.getPlaceHolder("suiteStartTime"), ExtentFlag.getPlaceHolder("suiteEndTime") };
		String[] values = { this.runInfo.startedAt, this.runInfo.endedAt };

		synchronized (this.lock) {
			this.extentSource = SourceBuilder.buildRegex(this.extentSource, keys, values);
		}
	}

	private synchronized void updateSystemInfo(Map<String, String> info) {
		if (info == null) {
			return;
		}
		if (this.extentSource.indexOf(ExtentFlag.getPlaceHolder("systemInfoApplied")) > 0) {
			return;
		}
		if (info.size() > 0) {
			String systemSrc = SourceBuilder.getSource(info) + ExtentFlag.getPlaceHolder("systemInfoApplied");

			String[] keys = { ExtentFlag.getPlaceHolder("systemInfoView") };
			String[] values = { systemSrc + ExtentFlag.getPlaceHolder("systemInfoView") };

			synchronized (this.lock) {
				this.extentSource = SourceBuilder.buildRegex(this.extentSource, keys, values);
			}
		}
	}

	private synchronized void updateMediaInfo() {
		String imageSrc = MediaViewBuilder.getSource(this.mediaList.screenCapture, "img");

		String[] keys = { ExtentFlag.getPlaceHolder("imagesView") };
		String[] values = { imageSrc + ExtentFlag.getPlaceHolder("imagesView") };

		if ((this.infoWrite < 1) || (values[0].indexOf("No media") < 0)) {
			synchronized (this.lock) {
				this.extentSource = SourceBuilder.buildRegex(this.extentSource, keys, values);

				if (this.mediaList.screenCapture.size() > 0) {
					try {
						String match = RegexMatcher.getNthMatch(this.extentSource,
								ExtentFlag.getPlaceHolder("objectViewNullImg") + ".*"
										+ ExtentFlag.getPlaceHolder("objectViewNullImg"),
								Integer.valueOf(0));
						this.extentSource = this.extentSource.replace(match, "");
					} catch (Exception e) {
					}
				}
			}
			this.mediaList.screenCapture.clear();
		}

		String scSrc = MediaViewBuilder.getSource(this.mediaList.screencast, "vid");

		keys = new String[] { ExtentFlag.getPlaceHolder("videosView") };
		values = new String[] { scSrc + ExtentFlag.getPlaceHolder("videosView") };

		if ((this.infoWrite < 1) || (values[0].indexOf("No media") < 0)) {
			synchronized (this.lock) {
				this.extentSource = SourceBuilder.buildRegex(this.extentSource, keys, values);

				if (this.mediaList.screencast.size() > 0) {
					try {
						String match = RegexMatcher.getNthMatch(this.extentSource,
								ExtentFlag.getPlaceHolder("objectViewNullVid") + ".*"
										+ ExtentFlag.getPlaceHolder("objectViewNullVid"),
								Integer.valueOf(0));
						this.extentSource = this.extentSource.replace(match, "");
					} catch (Exception e) {
					}
				}
			}
			this.mediaList.screencast.clear();
		}

		this.infoWrite += 1;
	}

	private void updateSource(String source) {
		synchronized (this.lock) {
			this.extentSource = source;
		}
	}

	public class ReportConfig {
		private String extentSource;

		private void updateSource() {
			this.extentSource = ReportInstance.this.extentSource;
		}

		public ReportConfig insertJs(String js) {
			js = "<script type='text/javascript'>" + js + "</script>";

			updateSource();
			ReportInstance.this.updateSource(this.extentSource.replace(ExtentFlag.getPlaceHolder("customscript"),
					js + ExtentFlag.getPlaceHolder("customscript")));

			return this;
		}

		public ReportConfig insertCustomStyles(String styles) {
			styles = "<style type='text/css'>" + styles + "</style>";

			updateSource();
			ReportInstance.this.updateSource(this.extentSource.replace(ExtentFlag.getPlaceHolder("customcss"),
					styles + ExtentFlag.getPlaceHolder("customcss")));

			return this;
		}

		public ReportConfig addCustomStylesheet(String cssFilePath) {
			String link = "<link href='file:///" + cssFilePath + "' rel='stylesheet' type='text/css' />";

			if ((cssFilePath.substring(0, 1).equals(new String(".")))
					|| (cssFilePath.substring(0, 1).equals(new String("/")))) {
				link = "<link href='" + cssFilePath + "' rel='stylesheet' type='text/css' />";
			}
			updateSource();
			ReportInstance.this.updateSource(this.extentSource.replace(ExtentFlag.getPlaceHolder("customcss"),
					link + ExtentFlag.getPlaceHolder("customcss")));

			return this;
		}

		public ReportConfig reportHeadline(String headline) {
			Integer maxLength = Integer.valueOf(70);

			if (headline.matches(".*\\<[^>]+>.*")) {
				maxLength = Integer.valueOf(9999);
			}

			if (headline.length() > maxLength.intValue()) {
				headline = headline.substring(0, maxLength.intValue() - 1);
			}

			updateSource();

			String html = this.extentSource;
			String pattern = ExtentFlag.getPlaceHolder("headline") + ".*" + ExtentFlag.getPlaceHolder("headline");
			headline = pattern.replace(".*", headline);

			String oldHeadline = RegexMatcher.getNthMatch(html, pattern, Integer.valueOf(0));
			ReportInstance.this.updateSource(html.replace(oldHeadline, headline));

			return this;
		}

		public ReportConfig reportName(String name) {
			Integer maxLength = Integer.valueOf(20);

			if (name.matches(".*\\<[^>]+>.*")) {
				maxLength = Integer.valueOf(9999);
			}

			if (name.length() > maxLength.intValue()) {
				name = name.substring(0, maxLength.intValue() - 1);
			}

			updateSource();
			String html = this.extentSource;
			String pattern = ExtentFlag.getPlaceHolder("logo") + ".*" + ExtentFlag.getPlaceHolder("logo");
			name = pattern.replace(".*", name);

			String oldName = RegexMatcher.getNthMatch(html, pattern, Integer.valueOf(0));
			ReportInstance.this.updateSource(html.replace(oldName, name));

			return this;
		}

		public ReportConfig documentTitle(String title) {
			updateSource();

			String docTitle = "<title>.*</title>";
			String html = this.extentSource;

			ReportInstance.this.updateSource(html.replace(RegexMatcher.getNthMatch(html, docTitle, Integer.valueOf(0)),
					docTitle.replace(".*", title)));

			return this;
		}
	}
}