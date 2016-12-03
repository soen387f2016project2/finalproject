<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%> <!-- header and navigation bar -->

        <div class="container">
            <div class="leftaligned-content">
                <h1>Change Password</h1>
                
                <form method="post" action="ChangePasswordServlet">
                    <div class="form-group row">
                       <label for="currentPassword" class="col-lg-2">Current password</label>
                        <div class="col-lg-4">
                            <input type="password" class="form-control" name="currentPassword">
                        </div>
                    </div>  
                    <div class="form-group row">
                       <label for="newPassword" class="col-lg-2">New password</label>
                        <div class="col-lg-4">
                            <input type="password" class="form-control" name="newPassword">
                        </div>
                    </div>  
                                        <div class="form-group row">
                       <label for="newPasswordConfirm" class="col-lg-2">Confirm new password</label>
                        <div class="col-lg-4">
                            <input type="password" class="form-control" name="newPasswordConfirm">
                        </div>
                    </div> 
                    <div class="form-group row">
                        <div class="col-lg-2">
                            <button type="submit" class="btn btn-primary" name="whichUser" value="loginUser">Change Password</button>
                        </div>
                    </div>
                </form>
                <div class="form-messages">
                    <!-- if we got an error, show it -->
                    <div class="<%=  request.getAttribute("alert") %>" role="alert"><%  if(request.getAttribute("message") != null) out.print(request.getAttribute("message"));%></div>
                </div>
            </div>
        </div><!-- /.container -->

<%@include file="footer.jsp"%> <!-- Bootstrap JavaScript and closing tags -->