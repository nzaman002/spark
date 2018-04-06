/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.relevantcodes.extentreports;

import com.relevantcodes.extentreports.model.ScreenCapture;
import com.relevantcodes.extentreports.model.Screencast;
import com.relevantcodes.extentreports.source.ExtentFlag;
import com.relevantcodes.extentreports.source.ObjectEmbedHtml;
import java.util.ArrayList;
import java.util.Iterator;

class MediaViewBuilder {
	public static String getSource(ArrayList<?> mediaList, String type) {
		String source = "";

		String[] flags = { ExtentFlag.getPlaceHolder("objectViewValue"), ExtentFlag.getPlaceHolder("objectViewNull") };

		if ((mediaList == null) || (mediaList.size() == 0)) {
			String[] values = { "No media was embedded for the tests in this report.",
					ExtentFlag.getPlaceHolder("objectViewNull" + type) };

			source = SourceBuilder.build(ObjectEmbedHtml.getFullWidth(), flags, values);

			return source;
		}

		flags = new String[] { ExtentFlag.getPlaceHolder("objectViewParam"),
				ExtentFlag.getPlaceHolder("objectViewValue") };

		for (Iterator localIterator = mediaList.iterator(); localIterator.hasNext();) {
			Object sc = localIterator.next();
			source = source + ObjectEmbedHtml.getColumn();

			if (sc instanceof ScreenCapture) {
				String[] values = { ((ScreenCapture) sc).testName, ((ScreenCapture) sc).src };

				source = SourceBuilder.build(source, flags, values);
			}

			if (sc instanceof Screencast) {
				String[] values = { ((Screencast) sc).testName, ((Screencast) sc).src };

				source = SourceBuilder.build(source, flags, values);
			}
		}

		return source;
	}
}