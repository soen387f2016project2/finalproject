<%@page import="java.util.Iterator"%>
<%@page import="Demo.UsersWeb"%>
<%@page import="java.util.HashMap"%>
<%@page import="Demo.Accounts"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%> <!-- header and navigation bar -->
<%
    Accounts accountsManager = new Accounts();
    accountsManager.createEndUsersList();
    HashMap users = accountsManager.getEndUsers();
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
                        <% Iterator it = users.entrySet().iterator();
                           while (it.hasNext()) {
                               HashMap.Entry pair = (HashMap.Entry)it.next(); 
                               UsersWeb user = (UsersWeb)pair.getValue(); %>
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