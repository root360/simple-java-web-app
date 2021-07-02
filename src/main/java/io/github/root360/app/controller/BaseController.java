package io.github.root360.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class to handle requests
 *
 * <p>based on work of Julian Jupiter
 *
 * @author Andreas Ulm
 */
@SuppressWarnings("PMD.AtLeastOneConstructor")
public class BaseController extends HttpServlet {

  /** define serial version for HttpServlet */
  private static final long serialVersionUID = 632349127293785744L;
  /** default prefix for templates */
  private static final String VIEW_PREFIX = "/WEB-INF/templates/";
  /** default suffix for templates */
  private static final String VIEW_SUFFIX = ".jsp";

  /**
   * return action based on request
   *
   * @param request HttpServletRequest request given by Tomcat
   * @return String action to be called
   */
  protected String getAction(final HttpServletRequest request) {
    final String action = new String(request.getParameter("action"));

    return (request.getParameter("action") == null) || action.isEmpty() ? "" : action;
  }

  /**
   * render template based on request
   *
   * @param request HttpServletRequest request given by Tomcat
   * @param response HttpServletResponse reponse to be sent by Tomcat
   * @param template String template to render
   */
  @SuppressWarnings("PMD.LawOfDemeter")
  protected void render(
      final HttpServletRequest request, final HttpServletResponse response, final String template)
      throws ServletException, IOException {
    getServletContext()
        .getRequestDispatcher(VIEW_PREFIX + template + VIEW_SUFFIX)
        .forward(request, response);
  }

  /**
   * send redirect link based on given path
   *
   * @param response HttpServletResponse response to be sent by Tomcat
   * @param path String path to sent as redirct link
   */
  public void redirect(final HttpServletResponse response, final String path) throws IOException {
    response.sendRedirect(path);
  }
}
