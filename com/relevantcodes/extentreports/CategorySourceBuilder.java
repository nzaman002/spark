/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.relevantcodes.extentreports;

import com.relevantcodes.extentreports.source.CategoryHtml;
import com.relevantcodes.extentreports.source.ExtentFlag;
import java.util.Collections;
import java.util.List;

public class CategorySourceBuilder {
	public static String buildOptions(List<String> categories) {
		String source = "";

		categories = categories.subList(0, categories.size());
		Collections.sort(categories);

		String[] flags = { ExtentFlag.getPlaceHolder("testCategory"), ExtentFlag.getPlaceHolder("testCategoryU") };

		for (String c : categories) {
			source = source + SourceBuilder.build(CategoryHtml.getOptionSource(), flags,
					new String[] { c, c.toLowerCase().replace(" ", "") });
		}

		return source;
	}
}