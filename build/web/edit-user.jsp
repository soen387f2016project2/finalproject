<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%> <!-- header and navigation bar -->

        <div class="container">
            <div class="leftaligned-content">
                <h1>End-User Account: scharb</h1>
                
                <form action="edit-user.jsp">
                    <div class="form-group row">
                        <label for="endUserAccount" class="col-lg-2">Account name</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="endUserAccount" value="scharb" disabled>
                        </div>
                    </div>  
                    <div class="form-group row">
                        <label for="endUserFirstName" class="col-lg-2">First name</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="endUserFirstName" value="Sebastien" disabled>
                        </div>
                    </div>  
                    <div class="form-group row">
                        <label for="endUserLastName" class="col-lg-2">Last name</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="endUserLastName" value="Charbonneau" disabled>
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
                
                <!-- split into 2 forms because action points to different pages -->
                <form action="account-list.jsp">
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
                                        <button type="submit" name="delete" class="btn btn-danger">Delete</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                    </div>
                                </div>
                            </div> <!-- modal -->        
                        </div>    
                    </div>        
                </form>
                
                <div class="form-messages">
                    <div class="alert alert-success" role="alert">Password changed successfully.</div>
                    <div class="alert alert-warning" role="alert">New passwords don't match.</div>
                </div>
                        
                <div id="reservation-history">
                    <h2>Reservation History (optional feature)</h2>
                    <table class="table" id="resource-history-table">
                        <thead>
                            <tr>
                                <th>Resource</th>
                                <th>Description</th>
                                <th>From</th>
                                <th>Until</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>DTPC0104</td>
                                <td>Dell OptiPlex 7040 desktop PC (Intel Core i7-6700, 8GB RAM, 500GB HDD)</td>
                                <td>October 2nd, 2016</td>
                                <td>October 9th, 2016</td>
                            </tr>
                            <tr>
                                <td>MNTR0089</td>
                                <td>Dell U2417H (24 inch IPS monitor, 1920 x 1200)</td>
                                <td>October 2nd, 2016</td>
                                <td>October 9th, 2016</td>
                            </tr>
                        </tbody>    
                    </table>
                </div>
                    
            </div>
        </div><!-- /.container -->

<%@include file="footer.jsp"%> <!-- Bootstrap JavaScript and closing tags -->