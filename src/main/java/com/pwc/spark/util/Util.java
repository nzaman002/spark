package com.pwc.spark.util;

public class Util {
	public static void sleep(int milisec){
		try {
			Thread.sleep(milisec);
		} catch (InterruptedException e) {
		}
	}
}
