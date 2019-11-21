package com.abopu.booru.servlets.listeners;

import com.abopu.booru.servlets.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Sarah Skanes
 * @created April 22, 2016.
 */
@WebListener
public class InitializeListener implements ServletContextListener {

	private static Logger LOG = LoggerFactory.getLogger(InitializeListener.class);

	@Override
	public final void contextInitialized(final ServletContextEvent event) {
		String logDir = System.getenv("com.abopu.booru.log.LOCATION");
		String dataDir = System.getenv("com.abopu.booru.data.LOCATION");
		String confDir = System.getenv("com.abopu.booru.conf.LOCATION");

		Settings settings = new Settings();
		settings.setLogDir(logDir);
		settings.setDataDir(dataDir);
		settings.setConfDir(confDir);

		try {
			Files.createDirectories(Paths.get(logDir));
			Files.createDirectories(Paths.get(dataDir));
			Files.createDirectories(Paths.get(confDir));
		} catch (IOException e) {
			LOG.error("Error creating one or more system directories.", e);
		}
	}

	@Override
	public final void contextDestroyed(final ServletContextEvent event) {}
}