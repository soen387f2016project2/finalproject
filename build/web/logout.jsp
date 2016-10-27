<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% session.invalidate(); %> <!-- deletes the user's session -->
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
            <div id="logout-page-content">
                <h3>You have been logged out of the Enterprise Resource Management IT Staff portal.</h3>
                <h4>Click <a href="index.jsp">here</a> to return to the log in page</h4>

            </div>
        </div><!-- /.container -->

<%@include file="footer.jsp"%> <!-- Bootstrap JavaScript and closing tags -->