package io.github.root360.app.util;

import java.time.ZonedDateTime;

/**
 * Class to handle errors DataClass most likely required for Tomcat.
 *
 * <p>based on work of Julian Jupiter
 *
 * @author Andreas Ulm
 */
@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.DataClass"})
public class Error {
  /** string to store error message. */
  private String message;
  /** datetime object storing time error was created. */
  private ZonedDateTime createdAt;

  /**
   * return error message.
   *
   * @return String error message
   */
  public String getMessage() {
    return message;
  }

  /**
   * store error message.
   *
   * @param message error message to store
   */
  public void setMessage(final String message) {
    this.message = message;
  }

  /**
   * return object containing the datetime the error was stored.
   *
   * @return ZonedDateTime datetime of the error message
   */
  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  /**
   * store datetime of error message.
   *
   * @param createdAt datetime object to store
   */
  public void setCreatedAt(final ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }
}
