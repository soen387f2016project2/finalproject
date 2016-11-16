package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import Demo.Reservation;
import java.util.LinkedList;
import Demo.DemoData;
import Demo.Resource;
import java.util.Locale;
import java.text.SimpleDateFormat;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(4);
    _jspx_dependants.add("/login.jsp");
    _jspx_dependants.add("/footer.jsp");
    _jspx_dependants.add("/dashboard.jsp");
    _jspx_dependants.add("/header.jsp");
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

      out.write("<!--\r\n");
      out.write("For now, there's 1 hardcoded IT staff user: admin/admin.\r\n");
      out.write("I don't think IT staff need any other attribute other than a unique userID and a password.\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
 if ((session.isNew()) || (request.getParameter("account") == null)) { 
      out.write(" <!-- if it's a new session, displays the log in page -->\r\n");
      out.write("    ");
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
      out.write("\r\n");
      out.write("<!-- this block of code will be moved to a controller class that validates the log in based on data from the database -->\r\n");
 } else if (request.getParameter("account") != null) { 
    String userID = request.getParameter("account");
    String password = request.getParameter("password");   
    if ((userID.equals("admin") && password.equals("admin"))) { 
        session.setAttribute("validLogin", "true"); 
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 if (!session.getAttribute("validLogin").equals("true")) { 
      out.write("\r\n");
      out.write("    ");
 response.sendRedirect("login.jsp");
      out.write(" <!-- if the user is already logged in, displays the dashboard -->\r\n");
 } 
      out.write('\r');
      out.write('\n');
 
DemoData demo = new DemoData();
LinkedList<Resource> resourceList = demo.getOverdueResourcesList();
Date currentDate = demo.getCurrentDate();

      out.write('\r');
      out.write('\n');
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
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <nav class=\"navbar navbar-inverse navbar-fixed-top\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"navbar-header\">\r\n");
      out.write("                    <a class=\"navbar-brand\" href=\"dashboard.jsp\">ERM</a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"navbar\" class=\"collapse navbar-collapse\">\r\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-left\">\r\n");
      out.write("                        <li class=\"active\"><a href=\"dashboard.jsp\">Dashboard</a></li>\r\n");
      out.write("                        <li class=\"dropdown\">\r\n");
      out.write("                            <a href=\"#\" data-toggle=\"dropdown\" class=\"dropdown-toggle\">Resources <b class=\"caret\"></b></a>\r\n");
      out.write("                            <ul class=\"dropdown-menu\">\r\n");
      out.write("                                <li><a href=\"inventory-report.jsp\">Inventory Report</a></li>\r\n");
      out.write("                                <li><a href=\"new-resource.jsp\">New Resource</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"dropdown\">\r\n");
      out.write("                            <a href=\"#\" data-toggle=\"dropdown\" class=\"dropdown-toggle\">End-Users <b class=\"caret\"></b></a>\r\n");
      out.write("                            <ul class=\"dropdown-menu\">\r\n");
      out.write("                                <li><a href=\"account-list.jsp\">Account List</a></li>\r\n");
      out.write("                                <li><a href=\"create-account.jsp\">Create Account</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("                        <li class=\"dropdown\">\r\n");
      out.write("                            <a href=\"#\" data-toggle=\"dropdown\" class=\"dropdown-toggle\">Profile <b class=\"caret\"></b></a>\r\n");
      out.write("                            <ul class=\"dropdown-menu\">\r\n");
      out.write("                                <li><a href=\"change-password.jsp\">Change Password</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        <li><a href=\"logout.jsp\">Log Out</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                    <form class=\"navbar-form navbar-right\" method=\"post\" action=\"searchPage.jsp\">\r\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"searchValue\" placeholder=\"Search by ID or Type\">\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div><!--/.nav-collapse -->\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>");
      out.write(" <!-- header and navigation bar -->\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"centered-content\">\r\n");
      out.write("                <h1 id=\"dashboard\">Dashboard</h1>\r\n");
      out.write("                        \r\n");
      out.write("                <h2>Overdue Resources</h2>\r\n");
      out.write("                \r\n");
      out.write("                <table class=\"table table-hover\" id=\"report-table\">\r\n");
      out.write("                    <thead>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th>ID</th>\r\n");
      out.write("                            <th>Type</th>\r\n");
      out.write("                            <th>Description</th>\r\n");
      out.write("                            <th>Reserved by</th>\r\n");
      out.write("                            <th>From</th>\r\n");
      out.write("                            <th>Until</th>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                    </thead>\r\n");
      out.write("                    <tbody>\r\n");
      out.write("                        ");
 for (Resource resource : resourceList) { 
      out.write("\r\n");
      out.write("                        <tr class=\"danger\">\r\n");
      out.write("                            <td><a href=\"update-resource.jsp?id=");
out.print(resource.getID());
      out.write('"');
      out.write('>');
out.print(resource.getID());
      out.write("</a></td>\r\n");
      out.write("                            <td><a href=\"update-resource.jsp?id=");
out.print(resource.getID());
      out.write('"');
      out.write('>');
out.print(resource.classAsString());
      out.write("</a></td>\r\n");
      out.write("                            <td><a href=\"update-resource.jsp?id=");
out.print(resource.getID());
      out.write('"');
      out.write('>');
out.print(resource.descriptionString());
      out.write("</a></td>\r\n");
      out.write("                        \r\n");
      out.write("                            ");
 Reservation lastReservation = resource.getLastReservation();  
                            String reservedBy;
                            String reservedFrom;
                            String reservedUntil;
                            if (lastReservation == null) {
                                reservedBy = "";
                                reservedFrom = "";
                                reservedUntil = "";
                            } else {
                                SimpleDateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",Locale.CANADA);
                                Date parsedDate = sdf.parse(lastReservation.getStart().toString());
                                Date parsedEnd = sdf.parse(lastReservation.getEnd().toString());
                                SimpleDateFormat print = new SimpleDateFormat("MMM d, yyyy HH:mm");
                                reservedBy = lastReservation.getUser().getFullName();
                                reservedFrom = print.format(parsedDate);
                                reservedUntil = print.format(parsedDate);
                            } 
      out.write("\r\n");
      out.write("                            <td><a href=\"update-resource.jsp?id=");
out.print(resource.getID());
      out.write('"');
      out.write('>');
out.print(reservedBy);
      out.write("</a></td>\r\n");
      out.write("                            <td><a href=\"update-resource.jsp?id=");
out.print(resource.getID());
      out.write('"');
      out.write('>');
out.print(reservedFrom);
      out.write("</a></td>\r\n");
      out.write("                            <td><a href=\"update-resource.jsp?id=");
out.print(resource.getID());
      out.write('"');
      out.write('>');
out.print(reservedUntil);
      out.write("</a></td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        ");
 } 
      out.write("\r\n");
      out.write("                    </tbody>    \r\n");
      out.write("                </table>\r\n");
      out.write("                \r\n");
      out.write("            </div>\r\n");
      out.write("        </div><!-- /.container -->\r\n");
      out.write("\r\n");
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
      out.write(" <!-- if the password is correct, displays the dashboard -->\r\n");
      out.write("    ");
 } else {
        session.setAttribute("validLogin", "false"); 
      out.write("\r\n");
      out.write("        ");
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
      out.write(" <!-- if the password is incorrect, displays the log in page -->                         \r\n");
      out.write("    ");
 }
} else if (session.getAttribute("validLogin").equals("true")) {
    response.sendRedirect("dashboard.jsp"); 
      out.write(" <!-- if the user is already logged in, displays the dashboard -->\r\n");
 }
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
