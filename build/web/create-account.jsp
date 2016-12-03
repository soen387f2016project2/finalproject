<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%> <!-- header and navigation bar -->

        <div class="container">
            <div class="leftaligned-content">
                <h1>New End-User Account</h1>
                
                <form action="CreateAccountServlet" method="POST"> 
                    <div class="form-group row">
                       <label for="endUserEmail" class="col-lg-2">End-user email</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="endUserEmail" name="endUserEmail">
                        </div>
                    </div>  
                    <div class="form-group row">
                        <label for="endUserFirstName" class="col-lg-2">First name</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="endUserFirstName" name="endUserFirstName">
                        </div>
                    </div>  
                    <div class="form-group row">
                        <label for="endUserLastName" class="col-lg-2">Last name</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="endUserLastName" name="endUserLastName">
                        </div>
                    </div>  
                    <div class="form-group row">
                        <label for="endUserPhone" class="col-lg-2">Phone number</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="endUserPhone" name="endUserPhone">
                        </div>
                    </div>  
                    <div class="form-group row">
                        <label for="endUserDepartment" class="col-lg-2">Department</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="endUserDepartment" name="endUserDepartment">
                        </div>
                    </div>  
                    <div class="form-group row">
                        <label for="endUserPassword" class="col-lg-2">Password</label>
                        <div class="col-lg-4">
                            <input type="password" class="form-control" id="endUserPassword" name="endUserPassword">
                        </div>
                    </div>
                    <div class="form-group row">    
                        <label for="endUserPasswordConfirm" class="col-lg-2">Confirm password</label>
                        <div class="col-lg-4">
                            <input type="password" class="form-control" id="endUserPasswordConfirm" name="endUserPasswordConfirm">
                        </div>
                    </div> 
                    <div class="form-group row">
                        <div class="col-lg-2">
                            <button type="submit" class="btn btn-primary">Create Account</button>
                        </div>
                    </div>
                </form>
                <div class="form-messages">
                	 <%
                        if (request.getAttribute("error") != null) {
                              String messageClass = "danger";                            
                            String message = (String) request.getAttribute("message");
                    %>
                    <div class="alert alert-<%= messageClass %>" role="alert"><%= message %></div>
                    <%                            
                        }
                    %>
                </div>
                
            </div>
        </div><!-- /.container -->

<%@include file="footer.jsp"%> <!-- Bootstrap JavaScript and closing tags -->