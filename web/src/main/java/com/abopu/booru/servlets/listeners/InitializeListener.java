package com.abopu.booru.servlets.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Sarah Skanes
 * @created April 22, 2016.
 */
public class InitializeListener implements ServletContextListener {

	private static Logger LOG = LoggerFactory.getLogger(InitializeListener.class);

	@Override
	public final void contextInitialized(final ServletContextEvent event) {

	}

	@Override
	public final void contextDestroyed(final ServletContextEvent event) {}
}