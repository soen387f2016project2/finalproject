package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');

    // If user is already logged in, bring them to the dashboard
    if (session.getAttribute("user_id") != null) {
        response.sendRedirect("dashboard.jsp");
    }

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\r\n");
      out.write("        <meta name=\"description\" content=\"Enterprise resource management system IT staff portal\">\r\n");
      out.write("        <meta name=\"author\" content=\"SOEN 387 team #5\">\r\n");
      out.write("        <link rel=\"icon\" href=\"images/favicon.ico\"> <!-- downloaded from freefavicon.com -->\r\n");
      out.write("\r\n");
      out.write("        <title>ERM</title>\r\n");
      out.write("\r\n");
      out.write("        <!-- Bootstrap core CSS -->\r\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Custom styles for this page -->\r\n");
      out.write("        <link href=\"css/custom.css\" rel=\"stylesheet\">\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body id=\"login-page\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div id=\"login-page-content\">\r\n");
      out.write("                <h1 id=\"dashboard\">ERM IT Staff Log In</h1>\r\n");
      out.write("\r\n");
      out.write("                <form method=\"post\" action=\"LoginServlet\">\r\n");
      out.write("                    <div class=\"form-group row\">\r\n");
      out.write("                        <label for=\"ITstaffAccount\" class=\"col-lg-3\">Account</label>\r\n");
      out.write("                        <div class=\"col-lg-8\">\r\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"ITstaffAccount\" name=\"account\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>  \r\n");
      out.write("                    <div class=\"form-group row\">\r\n");
      out.write("                        <label for=\"ITstaffPassword\" class=\"col-lg-3\">Password</label>\r\n");
      out.write("                        <div class=\"col-lg-8\">\r\n");
      out.write("                            <input type=\"password\" class=\"form-control\" id=\"ITstaffPassword\" name=\"password\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div> \r\n");
      out.write("                    <div class=\"form-group row\">\r\n");
      out.write("                        <div class=\"col-lg-2\">\r\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-primary\" name=\"login\">Log In</button> \r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- if the user or password were incorrect, an error message is displayed -->\r\n");
      out.write("                    ");

                        if (request.getAttribute("message") != null) {
                            String errorMessage = (String) request.getAttribute("message");

                            if (!errorMessage.isEmpty()) {
                    
      out.write("\r\n");
      out.write("                    <div id=\"login-messages\">\r\n");
      out.write("                        <div class=\"alert alert-danger\" role=\"alert\">Invalid user or password.</div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    ");

                            }
                        }
                    
      out.write("\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div><!-- /.container -->\r\n");
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <!-- Bootstrap core JavaScript\r\n");
      out.write("        ================================================== -->\r\n");
      out.write("        <!-- Placed at the end of the document so the pages load faster -->\r\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
      out.write(" <!-- Bootstrap JavaScript and closing tags -->");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
