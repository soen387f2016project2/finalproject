<%@page import="Demo.UsersWeb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%> <!-- header and navigation bar -->
<%
    UsersWeb user = new UsersWeb(Integer.parseInt(request.getParameter("id")));
%>

        <div class="container">
            <div class="leftaligned-content">
                <h1>End-User Account: <%out.print(user.getEmail());%></h1>
                
                <form action="ChangePasswordServlet" method="POST">
                    <div class="form-group row">
                        <label for="endUserEmail" class="col-lg-2">Email</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="endUserEmail" value="<%out.print(user.getEmail());%>" disabled>
                        </div>
                    </div>  
                    <div class="form-group row">
                        <label for="endUserFirstName" class="col-lg-2">Name</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="endUserFirstName" value="<%out.print(user.getFullName());%>" disabled>
                        </div>
                    </div>  
                    <div class="form-group row">
                        <label for="endUserPhone" class="col-lg-2">Phone number</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="endUserPhone" value="<%out.print(user.getPhoneNumber());%>" disabled>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="endUserDepartment" class="col-lg-2">Department</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="endUserDepartment" value="<%out.print(user.getDepartment());%>" disabled>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="newPassword" class="col-lg-2">New password</label>
                        <div class="col-lg-4">
                            <input type="password" class="form-control" id="newPassword" name="newPassword">
                        </div>
                    </div> 
                    <div class="form-group row">
                        <label for="newPasswordConfirm" class="col-lg-2">Confirm new password</label>
                        <div class="col-lg-4">
                            <input type="password" class="form-control" id="newPasswordConfirm" name="newPasswordConfirm">
                        </div>
                    </div> 
                    <div class="form-group row">
                        <div class="col-lg-2">
                        	 <input type="hidden" name="editID" value="<%out.print(user.getUserID());%>">
                            <button type="submit" class="btn btn-primary" name="whichUser" value="editUser">Change Password</button>
                        </div>
                    </div>
                </form>
                
                <!-- split into 2 forms because action points to different pages -->
                <form action="EditUserServlet" method="POST">
                <input type="hidden" name="deleteID" value="<%out.print(user.getUserID());%>">
                    <div class="form-group row">
                            <div class="col-lg-2">
                                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#confirmDelete">Delete Account</button>
                            </div>
                            <!-- Delete Account confirmation modal -->
                            <div id="confirmDelete" class="modal fade" role="dialog">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Delete Account</h4>
                                        </div>
                                    <div class="modal-body">
                                        <p>You're about to permanently delete this end-user's account. Do you want to continue?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" name="delete" class="btn btn-danger" value="DELETE">Delete</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                    </div>
                                </div>
                            </div> <!-- modal -->        
                        </div>    
                    </div>        
                </form>
                
                <div class="form-messages">                		
                      <div class="<%=  request.getAttribute("alert") %>" role="alert"><%  if(request.getAttribute("message") != null) out.print(request.getAttribute("message"));%></div>
                </div>
                   
            </div>
        </div><!-- /.container -->

<%@include file="footer.jsp"%> <!-- Bootstrap JavaScript and closing tags -->