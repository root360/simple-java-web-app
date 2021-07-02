package io.github.root360.app.server;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.StandardRoot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Class to control TomcatServer
 *
 * based on work of Julian Jupiter
 *
 * @author Andreas Ulm
 */
@SuppressWarnings("PMD.AtLeastOneConstructor")
public class TomcatServer implements Server {

	/**
	 * logger object
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(TomcatServer.class);
	/**
	 * default listen host
	 */
	private static final String DEFAULT_HOST = "localhost";
	/**
	 * default listen port
	 */
	private static final int DEFAULT_PORT = 8080;
	/**
	 * default context path to react on
	 */
	private static final String CONTEXT_PATH = "/";
	/**
	 * default document root
	 */
	private static final String DOC_BASE = ".";

	/**
	 * overwrite run() of tomcat to provide usage information
	 *
	 * @param args String... list of strings provided as arguments
	 */
	@Override
	@SuppressWarnings("PMD.LawOfDemeter")
	public void run(final String... args) {
		final int port = port(args);
		final Tomcat tomcat = new Tomcat();
		tomcat.setHostname(DEFAULT_HOST);
		tomcat.getHost().setAppBase(DOC_BASE);
		tomcat.setPort(port);
		tomcat.getConnector();
		final Context context = tomcat.addWebapp(CONTEXT_PATH, DOC_BASE);
		final WebResourceRoot resources = new StandardRoot(context);
		context.setResources(resources);

		try {
			tomcat.start();
		} catch (LifecycleException exception) {
			if (LOGGER.isErrorEnabled()) {
				LOGGER.error("Error during start: {}", exception.getMessage());
			}
			LOGGER.error("Exit...");
			return;
		}

		LOGGER.info("Application started with URL {}:{}{}.", DEFAULT_HOST, port, CONTEXT_PATH);
		LOGGER.info("Hit Ctrl + D or C to stop it...");
		tomcat.getServer().await();
	}

	/**
	 * validate given port
	 *
	 * @param args String... list of strings to derive port from
	 * @return port as integer
	 */
	private int port(final String... args) {
		int port = DEFAULT_PORT;
		if (args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException exception) {
				LOGGER.error("Invalid port number argument {}", args[0], exception);
			}
		}

		return port;
	}
}
