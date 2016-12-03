<%-- 

Project Manager: Cuong Nguyen
Team ID: 8 
Class Number: SOEN 387
Name:
Aakash Patel            27503008
Mahinthien Ratnarajah	27186517
Michael Cabana          27527489
Mouad Bouras            27671083
Razmig Houssikian	40001040

Sprint 1
--%>


<%@page import="sun.misc.BASE64Encoder"%>
<%@page import="java.security.MessageDigest"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Password Update Page</title>
    </head>
    <body>
        <%
        String uname = request.getParameter("username");
        String pass = request.getParameter("password");
        String newpass = request.getParameter("newpassword");
        
         

        Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin?"+"user=root"); 
        PreparedStatement usercheck = conn.prepareStatement("SELECT * FROM login WHERE username=?");
        usercheck.setString(1, uname);
        ResultSet resultUser  = usercheck.executeQuery();
        
         if (resultUser.next() != true ) 
         {
            out.print("<center><h3>This user <b><u>"+uname+"</u></b> does not exist in our database.<br /> Please verify your username and Try Again.</h3></center>");
         }       
         else if(pass.equals(newpass))
         {
         
            MessageDigest setToMD5 = MessageDigest.getInstance("MD5");
            //setToMD5.update(pass.getBytes());
            setToMD5.update(newpass.getBytes());
            BASE64Encoder encode = new BASE64Encoder();
            String encodepass = encode.encode(setToMD5.digest());
           
            PreparedStatement pst = conn.prepareStatement("UPDATE login SET password =? WHERE username=?");
            pst.setString(1, encodepass);
            pst.setString(2, uname);
            int updateDone = pst.executeUpdate(); 
            out.print("<center><h2>Your password has been updated! Please Login by going to the");
        
         %>
           <a href="http://localhost:8080/SOEN387Project/index.html"> Login Page </a>     
         <%
              out.print("</h2></center>");
        }
        else if(pass.equals(newpass) == false)
        {
            out.print("<center><h2>The Passwords don't match! <br />Click on the Back Button and Try Again.</h2></center>");
        
        }
        else
        {
         out.print("<center><h2>Oops, something went wrong!.Your password has not been updated!<br />Click on the Back Button and Try Again.</h2></center>");
        }

            %>
    </body>
</html>
