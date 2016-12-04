<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // If user is already logged in, bring them to the dashboard
    if (session.getAttribute("user_id") != null) {
        response.sendRedirect("dashboard.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="Enterprise resource management system IT staff portal">
        <meta name="author" content="SOEN 387 team #5">
        <link rel="icon" href="images/favicon.ico"> <!-- downloaded from freefavicon.com -->

        <title>ERM</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this page -->
        <link href="css/custom.css" rel="stylesheet">
    </head>

    <body id="login-page">
        <div class="container">
            <div id="login-page-content">
                <h1 id="dashboard">ERM Log In</h1>

                <form method="post" action="LoginServlet">
                    <div class="form-group row">
                        <label for="ITstaffAccount" class="col-lg-3">Account</label>
                        <div class="col-lg-8">
                            <input type="text" class="form-control" id="ITstaffAccount" name="account">
                        </div>
                    </div>  
                    <div class="form-group row">
                        <label for="ITstaffPassword" class="col-lg-3">Password</label>
                        <div class="col-lg-8">
                            <input type="password" class="form-control" id="ITstaffPassword" name="password">
                        </div>
                    </div> 
                    <div class="form-group row">
                        <div class="col-lg-2">
                            <button type="submit" class="btn btn-primary" name="login">Log In</button> 
                        </div>
                    </div>
                    <!-- if the user or password were incorrect, an error message is displayed -->
                    <%
                        if (request.getAttribute("message") != null) {
                            String errorMessage = (String) request.getAttribute("message");

                            if (!errorMessage.isEmpty()) {
                    %>
                    <div id="login-messages">
                        <div class="alert alert-danger" role="alert">Invalid user or password.</div>
                    </div>
                    <%
                            }
                        }
                    %>
                </form>
            </div>
        </div><!-- /.container -->

        <%@include file="footer.jsp"%> <!-- Bootstrap JavaScript and closing tags -->