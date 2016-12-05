<%@page import="java.util.Iterator"%>
<%@page import="Demo.UsersWeb"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Demo.Accounts"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%> <!-- header and navigation bar -->
<%
    Accounts accountsManager = new Accounts();
    accountsManager.createEndUsersList();
    LinkedList<UsersWeb> users = accountsManager.getEndUsers();
%>

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
                        <% for(int i = 0; i < users.size(); i++) {
                                
                               UsersWeb user = (UsersWeb)users.get(i); %>
                        <tr>
                            <td><a href="edit-user.jsp?id=<%out.print(user.getUserID());%>"><%out.print(user.getEmail());%></a></td>
                            <td><a href="edit-user.jsp?id=<%out.print(user.getUserID());%>"><%out.print(user.getFullName());%></a></td>
                        </tr>
                        <% }%>
                    </tbody>    
                </table>
 
            </div>
        </div><!-- /.container -->

<%@include file="footer.jsp"%> <!-- Bootstrap JavaScript and closing tags -->