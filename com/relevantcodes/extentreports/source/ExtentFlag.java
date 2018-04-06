/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.relevantcodes.extentreports.source;

import com.relevantcodes.extentreports.support.RegexMatcher;

public class ExtentFlag {
	public static String getPlaceHolder(String flag) {
		return "<!--%%" + flag.toUpperCase() + "%%-->";
	}

	public static String clearStringWithinPlaceHolder(String source, String flag) {
		String pattern = getPlaceHolder(flag) + ".*" + getPlaceHolder(flag);
		String res = RegexMatcher.getNthMatch(source, pattern, Integer.valueOf(0));

		if (res == null) {
			return source;
		}

		source = source.replace(res, getPlaceHolder(flag) + getPlaceHolder(flag));

		return source;
	}

	public static String insertStringWithinPlaceHolder(String source, String flag, String newString) {
		String pattern = getPlaceHolder(flag) + ".*" + getPlaceHolder(flag);
		String res = RegexMatcher.getNthMatch(source, pattern, Integer.valueOf(0));

		source = source.replace(res, getPlaceHolder(flag) + newString + getPlaceHolder(flag));

		return source;
	}
}