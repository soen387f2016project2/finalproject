<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%> <!-- header and navigation bar -->

        <div class="container">
            <div class="leftaligned-content">
                <h1>Change Password</h1>
                
                <form action="change-password.jsp">
                    <div class="form-group row">
                       <label for="currentPassword" class="col-lg-2">Current password</label>
                        <div class="col-lg-4">
                            <input type="password" class="form-control" id="currentPassword">
                        </div>
                    </div>  
                    <div class="form-group row">
                       <label for="newPassword" class="col-lg-2">New password</label>
                        <div class="col-lg-4">
                            <input type="password" class="form-control" id="newPassword">
                        </div>
                    </div>  
                                        <div class="form-group row">
                       <label for="newPasswordConfirm" class="col-lg-2">Confirm new password</label>
                        <div class="col-lg-4">
                            <input type="password" class="form-control" id="newPasswordConfirm">
                        </div>
                    </div> 
                    <div class="form-group row">
                        <div class="col-lg-2">
                            <button type="submit" class="btn btn-primary">Change Password</button>
                        </div>
                    </div>
                </form>
                <div class="form-messages">
                    <div class="alert alert-success" role="alert">Password changed successfully.</div>
                    <div class="alert alert-warning" role="alert">New passwords don't match.</div>
                    <div class="alert alert-danger" role="alert">Incorrect password.</div>
                </div>
                
            </div>
        </div><!-- /.container -->

<%@include file="footer.jsp"%> <!-- Bootstrap JavaScript and closing tags -->