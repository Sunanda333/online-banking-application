package com.blitzkrieg.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Logg {

	static final Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public static void debug(String msg) {
		Logg.logger.setLevel(Level.FINE);
		Logg.logger.info(msg);
	}
	

}
