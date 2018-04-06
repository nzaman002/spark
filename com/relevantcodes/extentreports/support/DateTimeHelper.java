/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.relevantcodes.extentreports.support;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeHelper {
	public static String getFormattedDateTime(Date date, String pattern) {
		SimpleDateFormat sdfDate = new SimpleDateFormat(pattern);

		return sdfDate.format(date);
	}

	public static String getFormattedDateTime(String dateTime, String pattern) {
		SimpleDateFormat sdfDate = new SimpleDateFormat(pattern);
		DateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);
		try {
			Date date = format.parse(dateTime);
			return sdfDate.format(date);
		} catch (ParseException e) {
		}
		return dateTime;
	}
}