/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.relevantcodes.extentreports.model;

import com.relevantcodes.extentreports.LogStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Test {
	public ArrayList<TestAttribute> categoryList;
	public ArrayList<TestAttribute> authorList;
	public ArrayList<Log> log;
	public ArrayList<ScreenCapture> screenCapture;
	public ArrayList<Screencast> screencast;
	public ArrayList<Test> nodeList;
	public boolean isChildNode = false;
	public boolean hasEnded = false;
	public boolean hasChildNodes = false;
	public Date startedTime;
	public Date endedTime;
	public LogStatus status = LogStatus.UNKNOWN;
	public String description;
	public String internalWarning;
	public String name;
	public String statusMessage;
	public UUID id;

	public void prepareFinalize() {
		updateTestStatusRecursively(this);

		if (this.status == LogStatus.INFO)
			this.status = LogStatus.PASS;
	}

	public void trackLastRunStatus() {
		for (Log l : this.log) {
			findStatus(l.logStatus);
		}

		if (this.status == LogStatus.INFO)
			this.status = LogStatus.PASS;
	}

	private void updateTestStatusRecursively(Test test) {
		for (Log log : test.log) {
			findStatus(log.logStatus);
		}

		if (test.hasChildNodes)
			for (Test node : test.nodeList)
				updateTestStatusRecursively(node);
	}

	private void findStatus(LogStatus logStatus) {
		if (this.status == LogStatus.FATAL)
			return;

		if (logStatus == LogStatus.FATAL) {
			this.status = logStatus;
			return;
		}

		if (this.status == LogStatus.FAIL)
			return;

		if (logStatus == LogStatus.FAIL) {
			this.status = logStatus;
			return;
		}

		if (this.status == LogStatus.ERROR)
			return;

		if (logStatus == LogStatus.ERROR) {
			this.status = logStatus;
			return;
		}

		if (this.status == LogStatus.WARNING)
			return;

		if (logStatus == LogStatus.WARNING) {
			this.status = logStatus;
			return;
		}

		if (this.status == LogStatus.PASS)
			return;

		if (logStatus == LogStatus.PASS) {
			this.status = LogStatus.PASS;
			return;
		}

		if (this.status == LogStatus.SKIP)
			return;

		if (logStatus == LogStatus.SKIP) {
			this.status = LogStatus.SKIP;
			return;
		}

		if (this.status == LogStatus.INFO)
			return;

		if (logStatus == LogStatus.INFO) {
			this.status = LogStatus.INFO;
			return;
		}

		this.status = LogStatus.UNKNOWN;
	}

	public Test() {
		this.internalWarning = "";

		this.id = UUID.randomUUID();

		this.log = new ArrayList();
		this.categoryList = new ArrayList();
		this.authorList = new ArrayList();
		this.screenCapture = new ArrayList();
		this.screencast = new ArrayList();
		this.nodeList = new ArrayList();
	}
}