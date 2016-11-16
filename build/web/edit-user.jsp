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
LinkedList<Resource> resourceList = demo.getResourcesList();
Date currentDate = demo.getCurrentDate();
%>
<%@include file="header.jsp"%> <!-- header and navigation bar -->

        <div class="container">
            <div class="leftaligned-content">
                <h1>End-User Account: <%out.print(request.getParameter("id"));%></h1>
                
                <form>
                    <div class="form-group row">
                        <label for="endUserAccount" class="col-lg-2">Account name</label>
                        <div class="col-lg-4">
<% for (EndUser user : userList) 
   { 
      if(user.getID().equals(request.getParameter("id")))
              { %>
                         <input type="text" class="form-control" id="endUserAccount" name="id" value="<%out.print(user.getID());%>" readonly>
                         </div>
                    </div>  
                    <div class="form-group row">
                        <label for="endUserFirstName" class="col-lg-2">First name</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="endUserFirstName" value="<%out.print(user.getFirstName());%>" readonly>
                        </div>
                    </div>  
                    <div class="form-group row">
                        <label for="endUserLastName" class="col-lg-2">Last name</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="endUserLastName" value="<%out.print(user.getLastName());%>" readonly>
                        </div>
                    </div>
            <% }
    }%>
    				<div class="form-group row">
                       <label for="currentPassword" class="col-lg-2">Current password</label>
                        <div class="col-lg-4">
                            <input type="password" class="form-control" id="currentPassword" name="currentPassword">
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
                            <button type="button" class="btn btn-primary">Change Password</button>
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
                    <div class="<%=  request.getAttribute("alert") %>" role="alert"><%  if(request.getAttribute("msg") != null) out.print(request.getAttribute("msg"));%></div>
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
                  <%-- <% for (Resource resource : resourceList) 
                    {   Reservation lastReservation = resource.getLastReservation();
                        if(lastReservation.getUser().getID().equals(request.getParameter("id")))
                         { %>
                        <tr>
                            <td><%out.print(resource.classAsString());%></td>
                            <td><%out.print(resource.descriptionString());%></td>
                            
                            <% 
                                                     
                            String reservedFrom;
                            String reservedUntil;
                            if (lastReservation == null) {
                                reservedFrom = "";
                                reservedUntil = "";
                            } else {
                                 reservedFrom = lastReservation.getStart().toString();
                                reservedUntil = lastReservation.getEnd().toString();
                            } %>
                            <td><%out.print(reservedFrom);%></td>
                            <td><%out.print(reservedUntil);%></td>
                        </tr>
                        <% } 
                    }   %>
                    --%>
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