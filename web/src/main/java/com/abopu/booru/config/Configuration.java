package com.abopu.booru.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * @author Sarah Skanes
 * @created April 22, 2016.
 */
public final class Configuration {

	/***************************************************************************
	 * 
	 * Static Members
	 * 
	 **************************************************************************/

	private static final Logger LOG = LoggerFactory.getLogger(Configuration.class);
	
	private static final Path DEFAULT_CONF_DIR = Paths.get(System.getProperty("user.home"), ".mylittlebooru", "conf");
	private static final Path DEFAULT_LOG_DIR = Paths.get(System.getProperty("user.home"), ".mylittlebooru", "logs");
	private static final Path DEFAULT_DATA_DIR = Paths.get(System.getProperty("user.home"), ".mylittlebooru", "data");
	private static final String CONFIG_FILENAME = "config.yaml";

	private static final Configuration config;

	static {
		Yaml yaml = new Yaml();

		// Load default settings
		config = yaml.loadAs(Configuration.class.getResourceAsStream("config-default.yaml"), Configuration.class);
		getSystemDirectories();



		try {
			Files.createDirectories(PathHelper.logDir());
			Files.createDirectories(PathHelper.dataDir());
			Files.createDirectories(PathHelper.confDir());
		} catch (IOException e) {
			LOG.error("Error creating one or more system directories.", e);
		}
	}

	/**
	 * Start by assuming defaults, and progressively substitute for user-defined
	 * values in the following order of precedence:
	 * <ol>
	 * <li>Values stored in existing config files</li>
	 * <li>Properties passed in via command-line</li>
	 * </ol>
	 */
	private static void getSystemDirectories() {
		String logDir, dataDir;
		String confDir = DEFAULT_CONF_DIR.toString();
//		String logDir = DEFAULT_LOG_DIR.toString();
//		String dataDir = DEFAULT_DATA_DIR.toString();

		String confDirProperty = System.getProperty("com.abopu.booru.conf.LOCATION");
		if (confDirProperty != null && !confDirProperty.isEmpty()) {
			confDir = confDirProperty;
		}

		// Read from existing config file if exists
		Path configPath = Paths.get(confDir, CONFIG_FILENAME);
		if (Files.exists(configPath)) {
			try {
				Yaml yaml = new Yaml();
				InputStream inputStream = Files.newInputStream(configPath);
				Map<String, Object> map = (Map<String, Object>) yaml.load(inputStream);
				dataDir = (String) map.get("dataDir");
				logDir = (String) map.get("logDir");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		{
			String logDirProperty = System.getProperty("com.abopu.booru.log.LOCATION");
			String dataDirProperty = System.getProperty("com.abopu.booru.data.LOCATION");

			if (logDirProperty != null && !logDirProperty.isEmpty()) {
				logDir = logDirProperty;
			}

			if (dataDirProperty != null && !dataDirProperty.isEmpty()) {
				dataDir = dataDirProperty;
			}
		}
	}

	public static Configuration instance() {
		return config;
	}

	

	/***************************************************************************
	 * 
	 * Fields
	 * 
	 **************************************************************************/

	private Path logDir;
	private Path dataDir;
	private Path confDir;



	/***************************************************************************
	 * 
	 * Constructors
	 * 
	 **************************************************************************/

	private Configuration() {}



	/***************************************************************************
	 * 
	 * Getters and Setters
	 * 
	 **************************************************************************/

	public Path getLogDir() {
		return logDir;
	}

	protected void setLogDir(Path logDir) {
		this.logDir = logDir;
	}

	public Path getDataDir() {
		return dataDir;
	}

	protected void setDataDir(Path dataDir) {
		this.dataDir = dataDir;
	}

	public Path getConfDir() {
		return confDir;
	}

	protected void setConfDir(Path confDir) {
		this.confDir = confDir;
	}
}
