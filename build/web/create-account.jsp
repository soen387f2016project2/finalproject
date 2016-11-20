<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%> <!-- header and navigation bar -->

        <div class="container">
            <div class="leftaligned-content">
                <h1>New End-User Account</h1>
                
                <form action="account-list.jsp">
                    <div class="form-group row">
                       <label for="endUserName" class="col-lg-2">End-user ID</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="endUserName">
                        </div>
                    </div>  
                    <div class="form-group row">
                        <label for="endUserFirstName" class="col-lg-2">First name</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="endUserFirstName">
                        </div>
                    </div>  
                    <div class="form-group row">
                        <label for="endUserLastName" class="col-lg-2">Last name</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="endUserLastName">
                        </div>
                    </div>  
                    <div class="form-group row">
                        <label for="endUserPassword" class="col-lg-2">Password</label>
                        <div class="col-lg-4">
                            <input type="password" class="form-control" id="endUserPassword">
                        </div>
                    </div>
                    <div class="form-group row">    
                        <label for="endUserPasswordConfirm" class="col-lg-2">Confirm password</label>
                        <div class="col-lg-4">
                            <input type="password" class="form-control" id="endUserPasswordConfirm">
                        </div>
                    </div> 
                    <div class="form-group row">
                        <div class="col-lg-2">
                            <button type="submit" class="btn btn-primary">Create Account</button>
                        </div>
                    </div>
                </form>
                <div class="form-messages">
                    <div class="alert alert-danger" role="alert">That ID is already taken.</div>
                    <div class="alert alert-warning" role="alert">Passwords don't match.</div>
                    <div class="alert alert-warning" role="alert">Empty fields.</div>
                </div>
                
            </div>
        </div><!-- /.container -->

<%@include file="footer.jsp"%> <!-- Bootstrap JavaScript and closing tags -->