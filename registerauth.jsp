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

<%@include file="data.jsp" %>  <%// IMPORTING DUMMY DATA TO USE BY THE AUTHENTICATOR. SIMULATING WEB LAYER %>
<%@page import="sun.misc.BASE64Encoder"%>
<%@page import="java.security.MessageDigest"%>
<%--@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"--%>


    <%
    String email = request.getParameter("email");
    String name = request.getParameter("name");
    String pass = request.getParameter("password");
    String pass2 = request.getParameter("password2");
    String phone = request.getParameter("phone");
    String dep = request.getParameter("dep");




    if (pass.equals(pass2) == false) 
    {
        out.print("Passwords don't match.");    
    } 
    else if(email != null)
    {
        
        for(int i=0; i<=validUser.size(); i++)
        {
            if(validUser.get(i).email.equals(email)){
                out.print("User already exists");
                break;
            }else{
                MessageDigest setToMD5 = MessageDigest.getInstance("MD5");
                setToMD5.update(pass2.getBytes());
                BASE64Encoder encode = new BASE64Encoder();
                String encodepass = encode.encode(setToMD5.digest());

                validUser.add(new User (1,1,email,pass,name,phone,dep));

                response.sendRedirect("index.html");  
            }
        }

    }
     %>
      