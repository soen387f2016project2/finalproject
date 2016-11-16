<%@page import="Demo.Reservation"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="Demo.Resource"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Demo.DemoData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
DemoData demo = new DemoData();
LinkedList<Resource> resourceList = demo.getResourcesList();
Resource selectedResource = demo.getResource(request.getParameter("id"));
Date currentDate = demo.getCurrentDate();
%>

<%@include file="header.jsp"%> <!-- header and navigation bar -->

        <div class="container">
            <div class="leftaligned-content">
                <h1>Update Resource <%out.print(selectedResource.getID());%></h1>
                
                <form>
                    <div class="form-group row">
                       <label for="resourceId" class="col-lg-2">ID number</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="resourceId" value=
                                   "<%out.print(selectedResource.getID());%>" disabled>
                        </div>
                    </div>  
                    <div class="form-group row">
                       <label for="resourceType" class="col-lg-2">Type</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="resourceType" value="<%out.print(selectedResource.classAsString());%>" disabled>
                        </div>
                    </div>
                        <%  String res = selectedResource.descriptionString();
                            String[] resArray=(res.split(","));
                            if(selectedResource.classAsString().equals("Computer"))
                            {  %>
                                            <div class="form-group row">
                                               <label for="computerType" class="col-lg-2">Computer type</label>
                                                <div class="col-lg-4">
                                                    
                                                    <input type="text" class="form-control" id="computerType" value="<% out.print(resArray[0]);%>" disabled>
                                                </div>
                                            </div> 
                                            <div class="form-group row">
                                                <label for="computerModel" class="col-lg-2">Make and model</label>
                                                <div class="col-lg-4">
                                                    <input type="text" class="form-control" id="computerModel" value="<% out.print(resArray[1]);%>" disabled>
                                                </div>
                                            </div> 
                                            <div class="form-group row">
                                                <label for="computerSize" class="col-lg-2">Screen size (inches)</label>
                                                <div class="col-lg-4">
                                                    <input type="text" class="form-control" id="computerSize" value="<% out.print(resArray[2]);%>">
                                                </div>
                                            </div>
                                            <div class="form-group row">    
                                                <label for="computerCPU" class="col-lg-2">CPU</label>
                                                <div class="col-lg-4">
                                                    <input type="text" class="form-control" id="computerCPU" value="<% out.print(resArray[3]);%>">
                                                </div>    
                                            </div> 
                                            <div class="form-group row">    
                                                <label for="computerRAM" class="col-lg-2">RAM memory</label>
                                                <div class="col-lg-4">
                                                    <input type="text" class="form-control" id="computerRAM" value="<% out.print(resArray[4]);%>">
                                                </div>
                                            </div> 
                                            <div class="form-group row">    
                                                <label for="computerStorage" class="col-lg-2">Storage capacity</label>
                                                <div class="col-lg-4">
                                                    <input type="text" class="form-control" id="computerStorage" value="<% out.print(resArray[5]);%>">
                                                </div>
                                            </div>
                    <% }
                        else if(selectedResource.classAsString().equals("Projector"))
                            {%>
                                            <div class="form-group row">
                                               <label for="projectorModel" class="col-lg-2">Model</label>
                                                <div class="col-lg-4">
                                                    
                                                    <input type="text" class="form-control" id="projectorModel" value="<% out.print(resArray[0]);%>" disabled>
                                                </div>
                                            </div> 
                                            <div class="form-group row">
                                                <label for="projectorResolution" class="col-lg-2">Resolution</label>
                                                <div class="col-lg-4">
                                                    <input type="text" class="form-control" id="projectorResolution" value="<% out.print(resArray[1]);%>" disabled>
                                                </div>
                                            </div>
                    <% }
                        else if(selectedResource.classAsString().equals("Conference room"))
                        { %>
                                            <div class="form-group row">
                                               <label for="confRoomCapacity" class="col-lg-2">Capacity</label>
                                                <div class="col-lg-4">
                                                    
                                                    <input type="text" class="form-control" id="confRoomCapacity" value="<% out.print(resArray[0]);%>" disabled>
                                                </div>
                                            </div> 
                                            <div class="form-group row">
                                                <label for="confRoomWhiteboard" class="col-lg-2">Whiteboard</label>
                                                <div class="col-lg-4">
                                                    <input type="text" class="form-control" id="confRoomWhiteboard" value="<% out.print(resArray[1]);%>" disabled>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="confRoomPhone" class="col-lg-2">Phone</label>
                                                <div class="col-lg-4">
                                                    <input type="text" class="form-control" id="confRoomPhone" value="<% out.print(resArray[2]);%>" disabled>
                                                </div>
                                            </div>
                    <% }
                        else if(selectedResource.classAsString().equals("Miscellaneous"))
                        { %>
                                             <div class="form-group row">
                                                <label for="miscDescription" class="col-lg-2">Description</label>
                                                <div class="col-lg-4">
                                                    <input type="text" class="form-control" id="miscDescription" value="<% out.print(resArray[0]);%>" disabled>
                                                </div>
                                            </div>
                    <% } %>
                        
                    <div class="form-group row">
                        <div class="col-lg-2">
                            <button type="button" name="updateResource" class="btn btn-primary">Update Resource</button>
                        </div>
                    </div>   
                     <%     Reservation lastReservation = selectedResource.getLastReservation(); 
                            
                            String reservedBy;
                            String reservedFrom;
                            String reservedUntil;
                            if (lastReservation == null) {
                                reservedBy = "";
                                reservedFrom = "";
                                reservedUntil = "";
                            } else {
                                reservedBy = lastReservation.getUser().getFullName();
                                reservedFrom = lastReservation.getStart().toString();
                                reservedUntil = lastReservation.getEnd().toString();
                            }
                         
                            if (selectedResource.getStatus().equals(Resource.Status.AVAILABLE))
                            { %>
                                
                                     <div class="form-group row">
                                    <label for="resourceStatus" class="col-lg-2">Status</label>
                                    <div class="col-lg-4">
                                        <h4><span class="label label-success">Available</span></h4>
                                    </div>
                                     </div>
                    <%      } 
                            else if (selectedResource.getStatus().equals(Resource.Status.RESERVED))
                            {
                                        if (lastReservation.getEnd().before(currentDate)) 
                                        { %>
                                            <div class="form-group row">
                                            <label for="resourceStatus" class="col-lg-2">Status</label>
                                            <div class="col-lg-4">
                                                <h4><span class="label label-danger">Overdue</span></h4>
                                            </div>
                                            </div>
                                         <% }
                                            else
                                            { %>       
                                            <div class="form-group row">
                                            <label for="resourceStatus" class="col-lg-2">Status</label>
                                            <div class="col-lg-4">
                                                <h4><span class="label label-warning">Reserved</span></h4>
                                            </div>
                                            </div> 
                                            <% } %>
                                        <div class="form-group row">    
                                            <label for="reservedBy" class="col-lg-2">Reserved by</label>
                                            <div class="col-lg-4">
                                                <input type="text" class="form-control" id="reservedBy" value="<% out.print(reservedBy);%>" disabled>
                                            </div>
                                        </div> 
                                        <div class="form-group row">    
                                            <label for="reservedFrom" class="col-lg-2">From</label>
                                            <div class="col-lg-4">
                                                <input type="text" class="form-control" id="reservedFrom" value="<% out.print(reservedFrom);%>" disabled>
                                            </div>
                                        </div> 
                                        <div class="form-group row">    
                                            <label for="reservedUntil" class="col-lg-2">Until</label>
                                            <div class="col-lg-4">
                                                <input type="text" class="form-control" id="reservedUntil" value="<% out.print(reservedUntil);%>" disabled>
                                            </div>
                                        </div> 
                    <% } %>
                    
                    <div class="form-group row">
                        <div class="col-lg-2">
                            <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#confirmReturn">Return to Inventory</button>
                        </div>
                    </div>    
                    <!-- Return to Inventory confirmation modal -->
                    <div id="confirmReturn" class="modal fade" role="dialog">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Return to Inventory</h4>
                                </div>
                                <div class="modal-body">
                                    <p>This will remove the reservation on this resource and return to available status. Do you want to continue?</p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" name="returnToInventory" class="btn btn-warning">Return</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                </div>
                            </div>
                        </div>    
                    </div> <!-- modal -->        
                </form>
                
                <!-- split into 2 forms because action points to different pages -->
                <form action="inventory-report.jsp">
                    <div class="form-group row">
                        <div class="col-lg-2">
                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#confirmDelete">Delete Resource</button>
                        </div>
                        <!-- Delete Resource confirmation modal -->
                        <div id="confirmDelete" class="modal fade" role="dialog">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Delete Resource</h4>
                                    </div>
                                    <div class="modal-body">
                                        <p>You're about to permanently delete this resource. Do you want to continue?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" name="delete" class="btn btn-danger">Delete</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                    </div>
                                </div>
                            </div>    
                        </div> <!-- modal -->        
                    </div>    
                </form>
                
                <div id="reservation-history">
                    <h2>Reservation History (optional feature)</h2>
                    <table class="table" id="resource-history-table">
                        <thead>
                            <tr>
                                <th>From</th>
                                <th>Until</th>
                                <th>End-User</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>October 2nd, 2016</td>
                                <td>October 9th, 2016</td>
                                <td>Sebastien Charbonneau</td>
                            </tr>   
                            <tr>
                                <td>September 8th, 2016</td>
                                <td>September 14th, 2016</td>
                                <td>Vincent Lugara</td>
                            </tr>
                        </tbody>    
                    </table>
                </div>    
                                               
            </div>
        </div><!-- /.container -->

<%@include file="footer.jsp"%> <!-- Bootstrap JavaScript and closing tags -->