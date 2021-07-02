package io.github.root360.app;

import io.github.root360.app.server.Server;
import io.github.root360.app.server.TomcatServer;

/**
 * Class to start the app
 *
 * <p>based on work of Julian Jupiter
 *
 * @author Andreas Ulm
 */
public final class AppStarter {
  /** prevent instantiation */
  private AppStarter() {}

  /**
   * main function to start app
   *
   * @param args String... arguments given via CLI
   */
  public static void main(final String... args) {
    final Server app = new TomcatServer();
    app.run(args);
  }
}
