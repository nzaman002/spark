/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.relevantcodes.extentreports.model;

public abstract class TestAttribute {
	protected String name;

	public String getName() {
		return this.name;
	}

	protected TestAttribute(String name) {
		this.name = name;
	}
}