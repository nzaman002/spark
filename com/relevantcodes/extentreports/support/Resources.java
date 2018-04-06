/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.relevantcodes.extentreports.support;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Resources {
	public static String getText(String resourcePath) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream(resourcePath);

		return Stream.toString(input);
	}

	public static void moveResource(String resourcePath, String copyPath) {
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream in = classLoader.getResourceAsStream(resourcePath);

			FileOutputStream out = new FileOutputStream(copyPath);

			byte[] b = new byte[1024];
			int noOfBytes = 0;

			while ((noOfBytes = in.read(b)) != -1) {
				out.write(b, 0, noOfBytes);
			}

			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}