package io.github.root360.app;

import io.github.root360.app.server.Server;
import io.github.root360.app.server.TomcatServer;

public class Main {
	public static void main(String[] args) {
		Server app = new TomcatServer();
		app.run(args);
	}
}
