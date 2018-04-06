/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.relevantcodes.extentreports.support;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Writer {
	public synchronized void write(File f, String text) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(f));
			writer.write(text);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static Writer getInstance() {
		return Instance.INSTANCE;
	}

	private static class Instance {
		static final Writer INSTANCE = new Writer(null);
	}
}