<!--
For now, there's 1 hardcoded IT staff user: admin/admin.
I don't think IT staff need any other attribute other than a unique userID and a password.
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if (session.isNew()) { %> <!-- if it's a new session, displays the log in page -->
    <%@include file="login.jsp"%>
<!-- this block of code will be moved to a controller class that validates the log in based on data from the database -->
<% } else if (request.getParameter("account") != null) { 
    String userID = request.getParameter("account");
    String password = request.getParameter("password");   
    if (userID.equals("admin") && password.equals("admin")) { 
        session.setAttribute("validLogin", "true"); %>
        <%@include file="dashboard.jsp"%> <!-- if the password is correct, displays the dashboard -->
    <% } else {
        session.setAttribute("validLogin", "false"); %>
        <%@include file="login.jsp"%> <!-- if the password is incorrect, displays the log in page -->                         
    <% }
} else if (session.getAttribute("validLogin").equals("true")) { %>
    <%@include file="dashboard.jsp"%> <!-- if the user is already logged in, displays the dashboard -->
<% } %>
