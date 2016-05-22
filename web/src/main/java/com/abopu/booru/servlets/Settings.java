package com.abopu.booru.servlets;

/**
 * @author Sarah Skanes
 * @created April 22, 2016.
 */
public final class Settings {
	
	/***************************************************************************
	 *
	 * Fields
	 *
	 **************************************************************************/

	private String logDir;
	private String dataDir;
	private String confDir;

	/***************************************************************************
	 *
	 * Getters and Setters
	 *
	 **************************************************************************/
	
	public String getLogDir() {
		return logDir;
	}

	public void setLogDir(String logDir) {
		this.logDir = logDir;
	}

	public String getDataDir() {
		return dataDir;
	}

	public void setDataDir(String dataDir) {
		this.dataDir = dataDir;
	}

	public String getConfDir() {
		return confDir;
	}

	public void setConfDir(String confDir) {
		this.confDir = confDir;
	}
}
