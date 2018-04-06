/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.relevantcodes.extentreports;

import com.relevantcodes.extentreports.model.Log;
import com.relevantcodes.extentreports.model.Test;
import com.relevantcodes.extentreports.model.TestAttribute;
import com.relevantcodes.extentreports.source.ExtentFlag;
import com.relevantcodes.extentreports.source.Icon;
import com.relevantcodes.extentreports.source.StepHtml;
import com.relevantcodes.extentreports.source.TestHtml;
import com.relevantcodes.extentreports.support.DateTimeHelper;
import java.util.ArrayList;
import java.util.Date;

class TestBuilder {
	public static String getSource(Test test) {
		if (test.isChildNode) {
			return "";
		}

		String testSource = TestHtml.getSource(3);

		if ((test.log.size() > 0) && (((Log) test.log.get(0)).stepName != "")) {
			testSource = TestHtml.getSource(4);
		}

		if ((test.description == null) || (test.description == "")) {
			testSource = testSource.replace(ExtentFlag.getPlaceHolder("descVis"), "style='display:none;'");
		}

		long diff = test.endedTime.getTime() - test.startedTime.getTime();
		long hours = diff / 3600000L % 24L;
		long mins = diff / 60000L % 60L;
		long secs = diff / 1000L % 60L;

		String[] testFlags = { ExtentFlag.getPlaceHolder("testName"), ExtentFlag.getPlaceHolder("testStatus"),
				ExtentFlag.getPlaceHolder("testStartTime"), ExtentFlag.getPlaceHolder("testEndTime"),
				ExtentFlag.getPlaceHolder("testTimeTaken"), ExtentFlag.getPlaceHolder("testDescription"),
				ExtentFlag.getPlaceHolder("descVis"), ExtentFlag.getPlaceHolder("category"),
				ExtentFlag.getPlaceHolder("testWarnings") };

		String[] testValues = { test.name, test.status.toString().toLowerCase(),
				DateTimeHelper.getFormattedDateTime(test.startedTime, LogSettings.logDateTimeFormat),
				DateTimeHelper.getFormattedDateTime(test.endedTime, LogSettings.logDateTimeFormat),
				hours + "h " + mins + "m " + secs + "s", test.description, "", "",
				TestHtml.getWarningSource(test.internalWarning) };

		testSource = SourceBuilder.build(testSource, testFlags, testValues);

		testFlags = new String[] { ExtentFlag.getPlaceHolder("testCategory"), ExtentFlag.getPlaceHolder("category") };

		for (TestAttribute attr : test.categoryList) {
			testValues = new String[] { TestHtml.getCategorySource() + ExtentFlag.getPlaceHolder("testCategory"),
					attr.getName() };

			testSource = SourceBuilder.build(testSource, testFlags, testValues);
		}

		String stepSrc = StepHtml.getSource(2);

		String[] stepFlags = { ExtentFlag.getPlaceHolder("step"), ExtentFlag.getPlaceHolder("timeStamp"),
				ExtentFlag.getPlaceHolder("stepStatusU"), ExtentFlag.getPlaceHolder("stepStatus"),
				ExtentFlag.getPlaceHolder("statusIcon"), ExtentFlag.getPlaceHolder("stepName"),
				ExtentFlag.getPlaceHolder("details") };

		if (test.log.size() > 0) {
			if (((Log) test.log.get(0)).stepName != "") {
				stepSrc = StepHtml.getSource(0);
			}

			for (int ix = 0; ix < test.log.size(); ++ix) {
				String[] stepValues = { stepSrc + ExtentFlag.getPlaceHolder("step"),
						DateTimeHelper.getFormattedDateTime(((Log) test.log.get(ix)).timestamp,
								LogSettings.logTimeFormat),
						((Log) test.log.get(ix)).logStatus.toString().toUpperCase(),
						((Log) test.log.get(ix)).logStatus.toString().toLowerCase(),
						Icon.getIcon(((Log) test.log.get(ix)).logStatus), ((Log) test.log.get(ix)).stepName,
						((Log) test.log.get(ix)).details };

				testSource = SourceBuilder.build(testSource, stepFlags, stepValues);
			}
		}

		testSource = testSource.replace(ExtentFlag.getPlaceHolder("step"), "");

		testSource = addChildTests(test, testSource, 1);

		return testSource;
	}

	private static String addChildTests(Test test, String testSource, int nodeLevel) {
		String stepSrc = "";

		String[] testFlags = { ExtentFlag.getPlaceHolder("nodeList"), ExtentFlag.getPlaceHolder("nodeName"),
				ExtentFlag.getPlaceHolder("nodeStartTime"), ExtentFlag.getPlaceHolder("nodeEndTime"),
				ExtentFlag.getPlaceHolder("nodeTimeTaken"), ExtentFlag.getPlaceHolder("nodeLevel") };

		String[] stepFlags = { ExtentFlag.getPlaceHolder("nodeStep"), ExtentFlag.getPlaceHolder("timeStamp"),
				ExtentFlag.getPlaceHolder("stepStatusU"), ExtentFlag.getPlaceHolder("stepStatus"),
				ExtentFlag.getPlaceHolder("statusIcon"), ExtentFlag.getPlaceHolder("stepName"),
				ExtentFlag.getPlaceHolder("details") };

		for (Test node : test.nodeList) {
			String nodeSource = TestHtml.getNodeSource(3);

			if ((node.log.size() > 0) && (((Log) node.log.get(0)).stepName != "")) {
				nodeSource = TestHtml.getNodeSource(4);
			}

			long diff = node.endedTime.getTime() - node.startedTime.getTime();
			long hours = diff / 3600000L % 24L;
			long mins = diff / 60000L % 60L;
			long secs = diff / 1000L % 60L;

			String[] testValues = { nodeSource + ExtentFlag.getPlaceHolder("nodeList"), node.name,
					DateTimeHelper.getFormattedDateTime(node.startedTime, LogSettings.logDateTimeFormat),
					DateTimeHelper.getFormattedDateTime(node.endedTime, LogSettings.logDateTimeFormat),
					hours + "h " + mins + "m " + secs + "s", "node-" + nodeLevel + "x" };

			testSource = SourceBuilder.build(testSource, testFlags, testValues);

			if (node.log.size() > 0) {
				testSource = SourceBuilder.build(testSource, new String[] { ExtentFlag.getPlaceHolder("nodeStatus") },
						new String[] { node.status.toString().toLowerCase() });

				stepSrc = StepHtml.getSource(2);

				if (((Log) node.log.get(0)).stepName != "") {
					stepSrc = StepHtml.getSource(0);
				}

				for (int ix = 0; ix < node.log.size(); ++ix) {
					String[] stepValues = { stepSrc + ExtentFlag.getPlaceHolder("nodeStep"),
							DateTimeHelper.getFormattedDateTime(((Log) node.log.get(ix)).timestamp,
									LogSettings.logTimeFormat),
							((Log) node.log.get(ix)).logStatus.toString().toUpperCase(),
							((Log) node.log.get(ix)).logStatus.toString().toLowerCase(),
							Icon.getIcon(((Log) node.log.get(ix)).logStatus), ((Log) node.log.get(ix)).stepName,
							((Log) node.log.get(ix)).details };

					testSource = SourceBuilder.build(testSource, stepFlags, stepValues);
				}
			}

			testSource = SourceBuilder.build(testSource,
					new String[] { ExtentFlag.getPlaceHolder("step"), ExtentFlag.getPlaceHolder("nodeStep") },
					new String[] { "", "" });

			if (node.hasChildNodes) {
				testSource = addChildTests(node, testSource, ++nodeLevel);
				--nodeLevel;
			}
		}

		return testSource;
	}

	public static String getQuickTestSummary(Test test) {
		if (test.isChildNode) {
			return "";
		}

		String src = TestHtml.getSourceQuickView();
		tmp25_21 = new TestBuilder();
		tmp25_21.getClass();
		LogCounts lc = new LogCounts().getLogCounts(test);

		String[] flags = { ExtentFlag.getPlaceHolder("testName"), ExtentFlag.getPlaceHolder("testWarnings"),
				ExtentFlag.getPlaceHolder("currentTestPassedCount"),
				ExtentFlag.getPlaceHolder("currentTestFailedCount"), ExtentFlag.getPlaceHolder("currentTestFatalCount"),
				ExtentFlag.getPlaceHolder("currentTestErrorCount"),
				ExtentFlag.getPlaceHolder("currentTestWarningCount"), ExtentFlag.getPlaceHolder("currentTestInfoCount"),
				ExtentFlag.getPlaceHolder("currentTestSkippedCount"),
				ExtentFlag.getPlaceHolder("currentTestUnknownCount"), ExtentFlag.getPlaceHolder("currentTestRunStatus"),
				ExtentFlag.getPlaceHolder("currentTestRunStatusU") };

		String[] values = { test.name, TestHtml.getWarningSource(test.internalWarning), String.valueOf(lc.pass),
				String.valueOf(lc.fail), String.valueOf(lc.fatal), String.valueOf(lc.error), String.valueOf(lc.warning),
				String.valueOf(lc.info), String.valueOf(lc.skip), String.valueOf(lc.unknown),
				test.status.toString().toLowerCase(), test.status.toString() };

		src = SourceBuilder.build(src, flags, values);

		return src;
	}

	private class LogCounts {
		public int pass = 0;
		public int fail = 0;
		public int fatal = 0;
		public int error = 0;
		public int warning = 0;
		public int info = 0;
		public int skip = 0;
		public int unknown = 0;

		public LogCounts getLogCounts(Test test) {
			for (int ix = 0; ix < test.log.size(); ++ix) {
				if (((Log) test.log.get(ix)).logStatus == LogStatus.PASS)
					this.pass += 1;
				else if (((Log) test.log.get(ix)).logStatus == LogStatus.FAIL)
					this.fail += 1;
				else if (((Log) test.log.get(ix)).logStatus == LogStatus.FATAL)
					this.fatal += 1;
				else if (((Log) test.log.get(ix)).logStatus == LogStatus.ERROR)
					this.error += 1;
				else if (((Log) test.log.get(ix)).logStatus == LogStatus.WARNING)
					this.warning += 1;
				else if (((Log) test.log.get(ix)).logStatus == LogStatus.INFO)
					this.info += 1;
				else if (((Log) test.log.get(ix)).logStatus == LogStatus.SKIP)
					this.skip += 1;
				else if (((Log) test.log.get(ix)).logStatus == LogStatus.UNKNOWN) {
					this.unknown += 1;
				}
			}
			for (Test node : test.nodeList) {
				getLogCounts(node);
			}

			return this;
		}
	}
}