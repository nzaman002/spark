/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.relevantcodes.extentreports;

import com.relevantcodes.extentreports.model.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ExtentReports {
	private ReportInstance reportInstance;
	private SystemInfo systemInfo;
	private ReportInstance.ReportConfig reportConfig;
	private List<ExtentTest> testList;

	public ExtentReports(String filePath, Boolean replaceExisting, DisplayOrder displayOrder, NetworkMode networkMode) {
		this.reportInstance = new ReportInstance();
		ReportInstance tmp24_21 = this.reportInstance;
		tmp24_21.getClass();
		this.reportConfig = new ReportInstance.ReportConfig(tmp24_21);
		this.reportInstance.initialize(filePath, replaceExisting.booleanValue(), displayOrder, networkMode);

		this.systemInfo = new SystemInfo();
	}

	public ExtentReports(String filePath, Boolean replaceExisting, DisplayOrder displayOrder) {
		this(filePath, replaceExisting, DisplayOrder.OLDEST_FIRST, NetworkMode.ONLINE);
	}

	public ExtentReports(String filePath, Boolean replaceExisting, NetworkMode networkMode) {
		this(filePath, replaceExisting, DisplayOrder.OLDEST_FIRST, networkMode);
	}

	public ExtentReports(String filePath, NetworkMode networkMode) {
		this(filePath, Boolean.valueOf(true), DisplayOrder.OLDEST_FIRST, networkMode);
	}

	public ExtentReports(String filePath, Boolean replaceExisting) {
		this(filePath, replaceExisting, DisplayOrder.OLDEST_FIRST, NetworkMode.ONLINE);
	}

	public ExtentReports(String filePath) {
		this(filePath, Boolean.valueOf(true), DisplayOrder.OLDEST_FIRST, NetworkMode.ONLINE);
	}

	public synchronized ExtentTest startTest(String testName) {
		return startTest(testName, "");
	}

	public synchronized ExtentTest startTest(String testName, String description) {
		if (this.testList == null) {
			this.testList = new ArrayList();
		}

		ExtentTest test = new ExtentTest(testName, description);
		this.testList.add(test);

		return test;
	}

	public synchronized void endTest(ExtentTest test) {
		test.getTest().hasEnded = true;

		this.reportInstance.addTest(test.getTest());
	}

	public ReportInstance.ReportConfig config() {
		return this.reportConfig;
	}

	public ExtentReports addSystemInfo(Map<String, String> info) {
		this.systemInfo.setInfo(info);

		return this;
	}

	public ExtentReports addSystemInfo(String param, String value) {
		this.systemInfo.setInfo(param, value);

		return this;
	}

	public synchronized void flush() {
		removeChildTests();

		this.reportInstance.writeAllResources(this.testList, this.systemInfo);

		this.systemInfo.clear();
	}

	public synchronized void close() {
		removeChildTests();

		this.reportInstance.terminate(this.testList);

		if (this.testList != null)
			this.testList.clear();
	}

	private synchronized void removeChildTests() {
		if (this.testList == null) {
			return;
		}

		Iterator iterator = this.testList.iterator();

		while (iterator.hasNext()) {
			Test t = ((ExtentTest) iterator.next()).getTest();

			if (t.hasChildNodes)
				;
			iterator.remove();
		}
	}
}