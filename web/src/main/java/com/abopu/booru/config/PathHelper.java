package com.abopu.booru.config;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Sarah Skanes
 * @created June 06, 2016.
 */
public final class PathHelper {
	
	private static final String UPLOAD_FOLDER = "uploads";
	
	public static Path logDir() {
		return Paths.get(Configuration.getLogDir());
	}
	
	public static Path dataDir() {
		return Paths.get(Configuration.getDataDir());
	}
	
	public static Path confDir() {
		return Paths.get(Configuration.getConfDir());
	}
	
	public static Path uploadDir() {
		return dataDir().resolve(UPLOAD_FOLDER);
	}
}
