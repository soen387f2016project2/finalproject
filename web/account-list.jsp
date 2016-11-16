<%@page import="java.util.Date"%>
<%@page import="Demo.Reservation"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Demo.DemoData"%>
<%@page import="Demo.Resource"%>
<%@page import="Demo.EndUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
DemoData demo = new DemoData();
LinkedList<EndUser> userList = demo.getUsersList();
%>
<%@include file="header.jsp"%> <!-- header and navigation bar -->

        <div class="container">
            <div class="centered-content" id="user-table">
                <h1>End-Users</h1>
                
                <table class="table table-hover" id="report-table">
                    <thead>
                        <tr>
                            <th>Account</th>
                            <th>Name</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            
                        </tr>
                       <% for (EndUser user : userList) { %>
                        <tr>
                            <td><a href="edit-user.jsp?id=<%out.print(user.getID());%>"><%out.print(user.getID());%></a></td>
                            <td><a href="edit-user.jsp?id=<%out.print(user.getID());%>"><%out.print(user.getFullName());%></a></td>
                        </tr>
                        <% } %>
                    </tbody>    
                </table>
 
            </div>
        </div><!-- /.container -->

<%@include file="footer.jsp"%> <!-- Bootstrap JavaScript and closing tags -->