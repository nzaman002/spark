/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.relevantcodes.extentreports;

import com.relevantcodes.extentreports.model.Category;
import com.relevantcodes.extentreports.model.Log;
import com.relevantcodes.extentreports.model.ScreenCapture;
import com.relevantcodes.extentreports.model.Screencast;
import com.relevantcodes.extentreports.model.Test;
import com.relevantcodes.extentreports.model.TestAttribute;
import com.relevantcodes.extentreports.source.ImageHtml;
import com.relevantcodes.extentreports.source.ScreencastHtml;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ExtentTest {
	private LogStatus runStatus = LogStatus.UNKNOWN;
	private Test test;

	public ExtentTest(String testName, String description) {
		this.test = new Test();

		this.test.name = ((testName == null) ? "" : testName.trim());
		this.test.description = description.trim();
		this.test.startedTime = Calendar.getInstance().getTime();
	}

	public void log(LogStatus logStatus, String stepName, String details) {
		Log evt = new Log();

		evt.logStatus = logStatus;
		evt.stepName = ((stepName == null) ? "" : stepName.trim());
		evt.details = ((details == null) ? "" : details.trim());
		evt.timestamp = Calendar.getInstance().getTime();

		this.test.log.add(evt);

		this.test.trackLastRunStatus();
		this.runStatus = this.test.status;
	}

	public void log(LogStatus logStatus, String details) {
		log(logStatus, "", details);
	}

	public String addScreenCapture(String imgPath) {
		String screenCaptureHtml;
		String screenCaptureHtml;
		if (isPathRelative(imgPath).booleanValue()) {
			screenCaptureHtml = ImageHtml.getSource(imgPath).replace("file:///", "");
		} else {
			screenCaptureHtml = ImageHtml.getSource(imgPath);
		}

		ScreenCapture img = new ScreenCapture();
		img.src = screenCaptureHtml;
		img.testName = this.test.name;

		this.test.screenCapture.add(img);

		return screenCaptureHtml;
	}

	public String addScreencast(String screencastPath) {
		String screencastHtml;
		String screencastHtml;
		if (isPathRelative(screencastPath).booleanValue()) {
			screencastHtml = ScreencastHtml.getSource(screencastPath).replace("file:///", "");
		} else {
			screencastHtml = ScreencastHtml.getSource(screencastPath);
		}

		Screencast sc = new Screencast();
		sc.src = screencastHtml;
		sc.testName = this.test.name;

		this.test.screencast.add(sc);

		return screencastHtml;
	}

	public ExtentTest assignCategory(String[] category) {
		List list = new ArrayList();

		for (String c : category) {
			if (!(list.contains(c))) {
				this.test.categoryList.add(new Category(c));
			}

			list.add(c);
		}

		return this;
	}

	public ExtentTest appendChild(ExtentTest node) {
		node.getTest().endedTime = Calendar.getInstance().getTime();
		node.getTest().isChildNode = true;
		node.getTest().trackLastRunStatus();

		this.test.hasChildNodes = true;

		List list = new ArrayList();

		for (TestAttribute attr : this.test.categoryList) {
			if (!(list.contains(attr.getName()))) {
				list.add(attr.getName());
			}
		}

		for (TestAttribute attr : node.getTest().categoryList) {
			if (!(list.contains(attr.getName()))) {
				this.test.categoryList.add(attr);
			}
		}

		this.test.nodeList.add(node.getTest());

		return this;
	}

	public LogStatus getRunStatus() {
		return this.runStatus;
	}

	public Test getTest() {
		return this.test;
	}

	private Boolean isPathRelative(String path) {
		if ((path.indexOf("http") == 0) || (!(new File(path).isAbsolute()))) {
			return Boolean.valueOf(true);
		}

		return Boolean.valueOf(false);
	}
}