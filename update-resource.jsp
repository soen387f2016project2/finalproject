<%@page import="java.util.Date"%>
<%@page import="Demo.ResourcesWeb"%>
<%@page import="java.util.LinkedList"%>
<%@page import="DAO.ResourcesDAO"%>
<%@page import="java.sql.ResultSet"%> 
<%//@page import="Demo.DemoData"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
/* 
DemoData demo = new DemoData();
LinkedList<Resource> resourceList = demo.getResourcesList();
Resource selectedResource = demo.getResource(request.getParameter("id"));
Date currentDate = demo.getCurrentDate();
*/
%>

<%@include file="header.jsp"%> <!-- header and navigation bar -->




        <div class="container">
            <div class="leftaligned-content">
                  
                <h1>Update Resource ${param.ID}</h1>
                
                <form action="UpdateServlet" method="get">
                    <div class="form-group row">
                       <label for="resourceId" class="col-lg-2">ID number</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" name="resourceId" value="">
                        </div>
                    </div>  
                    <div class="form-group row">
                       <label for="resourceType" class="col-lg-2">Type</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" name="resourceType" value="Computer">
                        </div>
                    </div>  
                    <div class="form-group row">
                       <label for="computerType" class="col-lg-2">Computer type</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" name="computerType" value="1">
                        </div>
                    </div> 
                    <div class="form-group row">
                        <label for="computerModel" class="col-lg-2">Make and model</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control"  name="computerModel" value="Dell OptiPlex 7040">
                        </div>
                    </div> 
                    <div class="form-group row">
                        <label for="computerSize" class="col-lg-2">Screen size (inches)</label>
                        <div class="col-lg-4">
                            <input type="number" class="form-control"  name="computerSize" value="24">
                        </div>
                    </div>
                    <div class="form-group row">    
                        <label for="computerCPU" class="col-lg-2">CPU</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" name="computerCPU" value="Intel Core i7-6700">
                        </div>    
                    </div> 
                    <div class="form-group row">    
                        <label for="computerRAM" class="col-lg-2">RAM memory</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control"   name="computerRAM" value="8GB DDR3 1600MHz">
                        </div>
                    </div> 
                    <div class="form-group row">    
                        <label for="computerStorage" class="col-lg-2">Storage capacity</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control"  name="computerStorage" value="5.0">
                        </div>
                    </div> 
                    <div class="form-group row">
                        <div class="col-lg-2">
                            <button type="submit" name="updateResource" class="btn btn-primary" value="update" >Update Resource</button>
                        </div>
                    </div>                  
                    <div class="form-group row">
                        <label for="resourceStatus" class="col-lg-2">Status</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="resourceStatus" value="Overdue" disabled>
                        </div>
                    </div> 
                    <div class="form-group row">    
                        <label for="reservedBy" class="col-lg-2">Reserved by</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="reservedBy" value="Sebastien Charbonneau" disabled>
                        </div>
                    </div> 
                    <div class="form-group row">    
                        <label for="reservedFrom" class="col-lg-2">From</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="reservedFrom" value="October 2nd, 2016" disabled>
                        </div>
                    </div> 
                    <div class="form-group row">    
                        <label for="reservedUntil" class="col-lg-2">Until</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="reservedUntil" value="October 9th, 2016" disabled>
                        </div>
                    </div> 
                    
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
                                    <button type="submit" name="returnToInventory" class="btn btn-warning">Return</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                </div>
                            </div>
                        </div>    
                    </div> <!-- modal -->        
                <!--</form>-->
                
                <!-- split into 2 forms because action points to different pages -->
                <!--<form action="UpdateServlet">-->
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
                                        <button type="submit" name="delete" class="btn btn-danger" value="DELETE">Delete</button>
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