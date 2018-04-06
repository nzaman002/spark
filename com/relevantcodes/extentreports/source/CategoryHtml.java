/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.relevantcodes.extentreports.source;

public class CategoryHtml {
	public static String getOptionSource() {
		return "<option value='<!--%%TESTCATEGORYU%%-->'><!--%%TESTCATEGORY%%--></option>";
	}

	public static String getCategoryViewSource() {
		return "<div class='col s12 m12 l12'><div class='card-panel category-view <!--%%CATEGORYVIEWNAMEL%%-->'><div class='category-header test-attributes'><span class='category'><!--%%CATEGORYVIEWNAME%%--></span><div class='category-status right'><span class='label cat-pass'>PASS: </span><span class='label cat-fail'>FAIL: </span><span class='label cat-other'>OTHER: </span></div></div><table class='bordered'><tr><th>Run Date</th><th>Test Name</th><th>Status</th></tr><!--%%CATEGORYVIEWTESTDETAILS%%--></table></div></div>";
	}

	public static String getCategoryViewTestSource() {
		return "<tr><td><!--%%CATEGORYVIEWTESTRUNTIME%%--></td><td><span class='category-link'><!--%%CATEGORYVIEWTESTNAME%%--></span></td><td><div class='label <!--%%CATEGORYVIEWTESTSTATUS%%-->'><!--%%CATEGORYVIEWTESTSTATUS%%--></div></td></tr>";
	}
}