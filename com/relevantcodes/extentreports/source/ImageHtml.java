/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.relevantcodes.extentreports.source;

public class ImageHtml {
	public static String getSource(String imgPath) {
		return "<img class='report-img materialboxed' src='file:///" + imgPath + "' />";
	}
}