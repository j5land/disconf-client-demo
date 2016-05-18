package com.test.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;



public class CallbackUtil {
	static Logger log = Logger.getLogger(CallbackUtil.class);

	public static Properties getProperties(String filename) {
		String path = CallbackUtil.class.getResource("/").getPath();
		path = path.substring(1, path.length()) + "/" + filename;
		if (FileHelper.exists(path)) {
			log.info("configurepay.properties loaded");
			try {
				return FileHelper.readPropertiesFile(path);
			} catch (IOException e) {
				log.info("configurepay.properties  loaded error");
			}

		} else {
			log.info("configurepay.properties not loaded");
		}
		return null;
	}
}
