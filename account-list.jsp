<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                            <td><a href="edit-user.jsp">scharb</a></td>
                            <td><a href="edit-user.jsp">Sebastien Charbonneau</a></td>
                        </tr>
                        <tr>
                            <td>vlugara</td>
                            <td>Vincent Lugara</td>
                        </tr>
                        <tr>
                            <td>kkonieczny</td>
                            <td>Karolina Konieczny</td>
                        </tr>
                        <tr>
                            <td>vtruong</td>
                            <td>Vinh Truong</td>
                        </tr>
                        <tr>
                            <td>afallara</td>
                            <td>Alain Fallara</td>
                        </tr>
                    </tbody>    
                </table>
 
            </div>
        </div><!-- /.container -->

<%@include file="footer.jsp"%> <!-- Bootstrap JavaScript and closing tags -->