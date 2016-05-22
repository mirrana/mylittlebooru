package com.abopu.booru;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.IOException;

/**
 * Entry point for application.
 * 
 * @author Sarah Skanes
 * @created April 09, 2016.
 */
public class MyLittleBooru {
	
	public static void main(String[] args) throws IOException {
		String warDir = System.getenv("com.abopu.booru.war.LOCATION");

		WebAppContext context = new WebAppContext();
		context.setContextPath("/");
		context.setDescriptor(warDir + "/WEB-INF/web.xml");
		context.setDefaultsDescriptor(warDir + "/WEB-INF/jetty-defaults.xml");
		context.setResourceBase(warDir);
		
		Server server = new Server(8112);
		server.setHandler(context);
		server.setDumpAfterStart(false);

		try {
			server.start();
			server.join();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
