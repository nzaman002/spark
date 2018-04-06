/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.relevantcodes.extentreports.model;

import java.util.ArrayList;

public class MediaList {
	public ArrayList<ScreenCapture> screenCapture;
	public ArrayList<Screencast> screencast;

	public MediaList() {
		this.screenCapture = new ArrayList();
		this.screencast = new ArrayList();
	}
}