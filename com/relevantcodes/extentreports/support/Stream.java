/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.relevantcodes.extentreports.support;

import java.io.InputStream;
import java.util.Scanner;

public class Stream {
	public static String toString(InputStream is) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(is).useDelimiter("\\A");
			return ((scanner.hasNext()) ? scanner.next() : "");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}