package io.github.root360.app.util;

/**
 * Class to handle error responses.
 *
 * <p>based on work of Julian Jupiter
 *
 * @author Andreas Ulm
 */
@SuppressWarnings("PMD.AtLeastOneConstructor")
public class ErrorResponse {
  /** error object */
  private Error error;

  /**
   * return error object.
   *
   * @return Error current error object
   */
  public Error getError() {
    return error;
  }

  /**
   * stores error object.
   *
   * @param error object to be stored as error
   */
  public void setError(final Error error) {
    this.error = error;
  }
}
