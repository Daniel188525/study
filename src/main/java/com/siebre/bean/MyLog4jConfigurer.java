package com.siebre.bean;

import java.io.FileNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Log4jConfigurer;

public class MyLog4jConfigurer extends Log4jConfigurer {

	protected final transient Log log = LogFactory.getLog(getClass());
	
	private String location;

	public MyLog4jConfigurer() {

	}

	public MyLog4jConfigurer(String location) {
		this.location = location;
		try {
			super.initLogging(this.location);
		} catch (FileNotFoundException e) {
			log.error("initLogging can not find " + this.location, e);
		}
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
