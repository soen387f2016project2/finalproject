package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import Demo.Reservation;
import java.util.LinkedList;
import Demo.DemoData;
import Demo.Resource;

public final class inventory_002dreport_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 
DemoData demo = new DemoData();
LinkedList<Resource> resourceList = demo.getResourcesList();
Date currentDate = demo.getCurrentDate();

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n");
      out.write("        <meta name=\"description\" content=\"Enterprise resource management system IT staff portal\">\n");
      out.write("        <meta name=\"author\" content=\"SOEN 387 team #5\">\n");
      out.write("        <link rel=\"icon\" href=\"images/favicon.ico\"> <!-- downloaded from freefavicon.com -->\n");
      out.write("\n");
      out.write("        <title>ERM</title>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Custom styles for this page -->\n");
      out.write("        <link href=\"css/custom.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-inverse navbar-fixed-top\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"index.jsp\">ERM</a>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"navbar\" class=\"collapse navbar-collapse\">\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-left\">\n");
      out.write("                        <li class=\"active\"><a href=\"index.jsp\">Dashboard</a></li>\n");
      out.write("                        <li class=\"dropdown\">\n");
      out.write("                            <a href=\"#\" data-toggle=\"dropdown\" class=\"dropdown-toggle\">Resources <b class=\"caret\"></b></a>\n");
      out.write("                            <ul class=\"dropdown-menu\">\n");
      out.write("                                <li><a href=\"inventory-report.jsp\">Inventory Report</a></li>\n");
      out.write("                                <li><a href=\"new-resource.jsp\">New Resource</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"dropdown\">\n");
      out.write("                            <a href=\"#\" data-toggle=\"dropdown\" class=\"dropdown-toggle\">End-Users <b class=\"caret\"></b></a>\n");
      out.write("                            <ul class=\"dropdown-menu\">\n");
      out.write("                                <li><a href=\"account-list.jsp\">Account List</a></li>\n");
      out.write("                                <li><a href=\"create-account.jsp\">Create Account</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        <li class=\"dropdown\">\n");
      out.write("                            <a href=\"#\" data-toggle=\"dropdown\" class=\"dropdown-toggle\">Profile <b class=\"caret\"></b></a>\n");
      out.write("                            <ul class=\"dropdown-menu\">\n");
      out.write("                                <li><a href=\"change-password.jsp\">Change Password</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        <li><a href=\"logout.jsp\">Log Out</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                    <form class=\"navbar-form navbar-right\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" placeholder=\"Search Inventory\">\n");
      out.write("                    </form>\n");
      out.write("                </div><!--/.nav-collapse -->\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write(" <!-- header and navigation bar -->\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"centered-content\">\n");
      out.write("                <h1>Inventory Report</h1>\n");
      out.write("                \n");
      out.write("                <table class=\"table table-hover\" id=\"report-table\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>ID</th>\n");
      out.write("                            <th>Type</th>\n");
      out.write("                            <th>Description</th>\n");
      out.write("                            <th>Status</th>\n");
      out.write("                            <th>Reserved by</th>\n");
      out.write("                            <th>From</th>\n");
      out.write("                            <th>Until</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");
 for (Resource resource : resourceList) { 
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td><a href=\"update-resource.jsp\">");
out.print(resource.getID());
      out.write("</a></td>\n");
      out.write("                            <td><a href=\"update-resource.jsp\">");
out.print(resource.classAsString());
      out.write("</a></td>\n");
      out.write("                            <td><a href=\"update-resource.jsp\">");
out.print(resource.descriptionString());
      out.write("</a></td>\n");
      out.write("                            \n");
      out.write("                            ");
 Reservation lastReservation = resource.getLastReservation();
                            
                            if (resource.getStatus().equals(Resource.Status.AVAILABLE)) { 
      out.write(" \n");
      out.write("                            <td><a href=\"update-resource.jsp\"><h4><span class=\"label label-success\">Available</span></h4></a></td>    \n");
      out.write("                            ");
 } else if (lastReservation.getEnd().before(currentDate)) { 
      out.write("\n");
      out.write("                            <td><a href=\"update-resource.jsp\"><h4><span class=\"label label-danger\">Overdue</span></h4></a></td>\n");
      out.write("                            ");
 } else { 
      out.write("\n");
      out.write("                            <td><a href=\"update-resource.jsp\"><h4><span class=\"label label-warning\">Reserved</span></h4></a></td>\n");
      out.write("                            ");
 } 
                            
                            String reservedBy;
                            String reservedFrom;
                            String reservedUntil;
                            if (lastReservation == null) {
                                reservedBy = "";
                                reservedFrom = "";
                                reservedUntil = "";
                            } else {
                                reservedBy = lastReservation.getUser().getFullName();
                                reservedFrom = lastReservation.getStart().toString();
                                reservedUntil = lastReservation.getEnd().toString();
                            } 
      out.write("\n");
      out.write("                            <td><a href=\"update-resource.jsp\">");
out.print(reservedBy);
      out.write("</a></td>\n");
      out.write("                            <td><a href=\"update-resource.jsp\">");
out.print(reservedFrom);
      out.write("</a></td>\n");
      out.write("                            <td><a href=\"update-resource.jsp\">");
out.print(reservedUntil);
      out.write("</a></td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </tbody>    \n");
      out.write("                </table>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div><!-- /.container -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core JavaScript\n");
      out.write("        ================================================== -->\n");
      out.write("        <!-- Placed at the end of the document so the pages load faster -->\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
      out.write(" <!-- Bootstrap JavaScript and closing tags --> ");
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
