<%-- 
    Document   : header.jsp
    Created on : 4-Nov-2016, 7:09:51 PM
    Author     : mouadbouras
--%>

        <% if ( session.getAttribute("User") == null){
            response.sendRedirect("index.html?sessionUser=null");
        }
         %>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="css/vendor/bootstrap.min.css" >
        <!-- Optional theme -->
        <link rel="stylesheet" href="css/vendor/bootstrap-theme.min.css" >
        <link rel="stylesheet" href="css/vendor/animate.css" >

        <link rel="stylesheet" href="css/style.css" >

         
        <script src="js/vendor/jquery-3.1.1.min.js" ></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="js/vendor/bootstrap.min.js" ></script>
        <script src="js/vendor/wow.min.js" ></script>

        <script src="js/script.js" ></script>
