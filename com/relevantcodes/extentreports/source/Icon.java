/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.relevantcodes.extentreports.source;

import com.relevantcodes.extentreports.LogStatus;
import java.util.HashMap;

public class Icon {
	private static HashMap<LogStatus, String> map = new HashMap();

	public static void override(LogStatus status, String icon) {
		map.put(status, icon);
	}

	public static String getIcon(LogStatus status) {
		if (map.containsKey(status)) {
			return ((String) map.get(status));
		}
		String s = status.toString().toLowerCase();

		if (s.equals("fail"))
			return "times-circle-o";
		if (s.equals("error"))
			return "exclamation-circle";
		if (s.equals("fatal"))
			return "exclamation-circle";
		if (s.equals("pass"))
			return "check-circle-o";
		if (s.equals("info"))
			return "info-circle";
		if (s.equals("warning"))
			return "warning";
		if (s.equals("skip"))
			return "chevron-circle-right";

		return "question";
	}
}