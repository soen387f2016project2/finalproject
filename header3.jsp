<%-- 
    Document   : header3
    Created on : 4-Dec-2016, 6:09:55 AM
    Author     : mimi
--%>

<!-- UI -->
<% //session.getAttribute("isAdmin").equals("true");%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">ERM</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left">
                        <li class="active"><a href="resources.jsp"> View Resources </a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="logout.jsp">Log Out</a></li>
                    </ul>

                </div><!--/.nav-collapse -->
            </div>
        </nav>
