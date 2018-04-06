/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.relevantcodes.extentreports.source;

public class TestHtml {
	public static String getSource(int cols) {
		String colStepName = "";

		if (cols == 4) {
			colStepName = "<th>StepName</th>";
		}

		return "<div class='test-section'><div class='col s12'><div class='test card-panel displayed <!--%%TESTSTATUS%%-->'><div class='test-head'><div class='right test-info'><span alt='Test started time' title='Test started time' class='test-started-time label'><!--%%TESTSTARTTIME%%--></span><span alt='Test ended time' title='Test ended time' class='test-ended-time label'><!--%%TESTENDTIME%%--></span><span alt='Time taken to finish' title='Time taken to finish' class='test-time-taken label'><!--%%TESTTIMETAKEN%%--></span><span class='test-status label <!--%%TESTSTATUS%%-->'><!--%%TESTSTATUS%%--></span></div><div class='test-name'><!--%%TESTNAME%%--><!--%%TESTWARNINGS%%--></div><div class='test-desc' <!--%%DESCVIS%%-->><span><!--%%TESTDESCRIPTION%%--></span></div></div><div class='test-attributes'><div class='categories'><!--%%TESTCATEGORY%%--></div></div><div class='test-body'><table class='bordered table-results'><thead><tr><th>Timestamp</th><th>Status</th>"
				+ colStepName + "<th>Details</th>" + "</tr>" + "</thead>" + "<tbody>" + "<!--%%STEP%%-->" + "</tbody>"
				+ "</table>" + "<ul class='collapsible' data-collapsible='accordion'>" + "<!--%%NODELIST%%-->" + "</ul>"
				+ "</div>" + "</div>" + "</div>" + "</div>";
	}

	public static String getSourceQuickView() {
		return "<tr><td><span class='quick-view-test'><!--%%TESTNAME%%--></span><!--%%TESTWARNINGS%%--></td><td><!--%%CURRENTTESTPASSEDCOUNT%%--></td><td><!--%%CURRENTTESTFAILEDCOUNT%%--></td><td><!--%%CURRENTTESTFATALCOUNT%%--></td><td><!--%%CURRENTTESTERRORCOUNT%%--></td><td><!--%%CURRENTTESTWARNINGCOUNT%%--></td><td><!--%%CURRENTTESTINFOCOUNT%%--></td><td><!--%%CURRENTTESTSKIPPEDCOUNT%%--></td><td><!--%%CURRENTTESTUNKNOWNCOUNT%%--></td><td><div class='status <!--%%CURRENTTESTRUNSTATUS%%--> label'><!--%%CURRENTTESTRUNSTATUSU%%--></div></td></tr>";
	}

	public static String getNodeSource(int cols) {
		String colStepName = "";

		if (cols == 4) {
			colStepName = "<th>StepName</th>";
		}

		return "<li class='<!--%%NODELEVEL%%-->'><div class='collapsible-header test-node <!--%%NODESTATUS%%-->'><div class='right test-info'><span alt='Test started time' title='Test started time' class='test-started-time label'><!--%%NODESTARTTIME%%--></span><span alt='Test ended time' title='Test ended time' class='test-ended-time label'><!--%%NODEENDTIME%%--></span><span alt='Time taken to finish' title='Time taken to finish' class='test-time-taken label'><!--%%NODETIMETAKEN%%--></span><span class='test-status label <!--%%NODESTATUS%%-->'><!--%%NODESTATUS%%--></span></div><div class='test-node-name'><!--%%NODENAME%%--></div></div><div class='collapsible-body'><div class='test-body'><table class='bordered table-results'><thead><tr><th>Timestamp</th><th>Status</th>"
				+ colStepName + "<th>Details</th>" + "</tr>" + "</thead>" + "<tbody>" + "<!--%%NODESTEP%%-->"
				+ "</tbody>" + "</table>" + "</div>" + "</div>" + "</li>";
	}

	public static String getCategorySource() {
		return "<span class='category'><!--%%CATEGORY%%--></span>";
	}

	public static String getWarningSource(String warning) {
		if (warning == "") {
			return "";
		}

		return "<span class='test-warning tooltipped' data-tooltip='" + warning
				+ "' data-position='top'><i class='fa fa-info' alt='" + warning + "' title='" + warning
				+ "'></i></span>";
	}
}