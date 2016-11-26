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
                    <a class="navbar-brand" href=".">ERM</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left">
                        <li class="active"><a href=".">Dashboard</a></li>
                        <li class="dropdown">
                            <a href="#" data-toggle="dropdown" class="dropdown-toggle">Resources <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="inventory-report.jsp">Inventory Report</a></li>
                                <li><a href="new-resource.jsp">New Resource</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" data-toggle="dropdown" class="dropdown-toggle">End-Users <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="account-list.jsp">Account List</a></li>
                                <li><a href="create-account.jsp">Create Account</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" data-toggle="dropdown" class="dropdown-toggle">Profile <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="change-password.jsp">Change Password</a></li>
                            </ul>
                        <li><a href="logout.jsp">Log Out</a></li>
                    </ul>
                    <form class="navbar-form navbar-right">
                        <input type="text" class="form-control" placeholder="Search Inventory">
                    </form>
                </div><!--/.nav-collapse -->
            </div>
        </nav>
