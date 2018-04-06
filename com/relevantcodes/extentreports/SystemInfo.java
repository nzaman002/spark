/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.relevantcodes.extentreports;

import com.relevantcodes.extentreports.model.SystemProperties;
import java.net.InetAddress;
import java.util.Map;
import java.util.Map.Entry;

class SystemInfo {
	private SystemProperties systemProperties;

	public void clear() {
		this.systemProperties.info.clear();
	}

	public Map<String, String> getInfo() {
		if (this.systemProperties == null) {
			return null;
		}

		return this.systemProperties.info;
	}

	public void setInfo(Map<String, String> info) {
		for (Map.Entry entry : info.entrySet())
			this.systemProperties.info.put(entry.getKey(), entry.getValue());
	}

	public void setInfo(String param, String value) {
		this.systemProperties.info.put(param, value);
	}

	private void setInfo() {
		if (this.systemProperties == null) {
			this.systemProperties = new SystemProperties();
		}

		this.systemProperties.info.put("User Name", System.getProperty("user.name"));
		this.systemProperties.info.put("OS", System.getProperty("os.name"));
		this.systemProperties.info.put("Java Version", System.getProperty("java.version"));
		try {
			this.systemProperties.info.put("Host Name", InetAddress.getLocalHost().getHostName());
		} catch (Exception e) {
		}
	}

	public SystemInfo() {
		setInfo();
	}
}