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
<%--<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Driver"%>--%>
<%
    
        String uname = request.getParameter("username");
        String pass = request.getParameter("password");
       
       
        MessageDigest setToMD5 = MessageDigest.getInstance("MD5");
        setToMD5.update(pass.getBytes());
      
        BASE64Encoder encode = new BASE64Encoder();
        String encodedpass = pass;//encode.encode(setToMD5.digest());
    
        
        //TO ADD : QUERY THE DATABASE FOR USER. 
        //         RETURNS EMPTY ARRAY LIST IF NOTHING FOUND.
        
                
        //validUser.get(0); // DUMMY DATA, TO BE REPLACED BY RETURNED ARRAY LIST
        //validUser = emptyUser; // TESTING FALSE CREDENTIALS
       
        if( request.getParameter("nojs") == null)
        {
            if(validUser != null && validUser.size() == 1 ) 
            {
               session.setAttribute("User", validUser.get(0));
               out.println("true");
            }
            else{
               out.println("false");
            }
        }
        else{
            if(validUser != null && validUser.size() == 1) 
            {
               session.setAttribute("User", validUser.get(0));
               response.sendRedirect("resources.jsp");  
            }
            else{
               out.println(validUser.size() );
               response.sendRedirect("index.html?invalid=1");
            }
        }
        
//-----------------------------------------------------------------------------------        
//-------------------------------OLD-------------------------------------------------    
//-----------------------------------------------------------------------------------    
//        String uname = request.getParameter("username");
//        String pass = request.getParameter("password");
//       
//       
//        //MessageDigest setToMD5 = MessageDigest.getInstance("MD5");
//        //setToMD5.update(pass.getBytes());
//      
//        //BASE64Encoder encode = new BASE64Encoder();
//        String encodedpass = pass;//encode.encode(setToMD5.digest());
//        
//            
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin?"+"user=root");    
//            PreparedStatement query = connection.prepareStatement("SELECT username, password FROM login WHERE username=? and password=?");
//            query.setString(1, uname);
//            query.setString(2, encodedpass);
//            ResultSet result = query.executeQuery();                        
//            if(result.next())
//            {
//               session.setAttribute("User", uname);
//               out.println("true");
//
//            }
//            else
//            {
//               out.print("false");       
//               //response.sendRedirect("http://localhost:8080/SOEN387Project/incorrectlogin.html");
////               out.println(uname);                      
////               out.println(pass);       
//               //out.print(encodedpass);
//            }    
        
            %>