<%@page import="Demo.Reservation"%>
<%@page import="Demo.ConferenceRoomWeb"%>
<%@page import="Demo.ProjectorWeb"%>
<%@page import="Demo.ComputerWeb"%>
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

<%ResourcesWeb rw = new ResourcesWeb();
LinkedList<ResourcesWeb> resourceList = rw.getAllResources();
String type = rw.getResourceType(Integer.parseInt(request.getParameter("id")));
String resName = null;
String resDesc = null;
for (ResourcesWeb resource : resourceList) {
    if(resource.getResourceID() == Integer.parseInt(request.getParameter("id")))
    {
        resName = resource.getResourceName();
        resDesc = resource.getDescription();
        break;
    }
}

%>


        <div class="container">
            <div class="leftaligned-content">
                  
                <h1>Update Resource <%out.print(request.getParameter("id"));%></h1>
                
                <form action="UpdateServlet" method="get">
                    <div class="form-group row">
                       <label for="resourceId" class="col-lg-2">ID number</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" name="id" value="<%out.print(request.getParameter("id"));%>" readonly="readonly">
                        </div>
                    </div>
<%
if(type.equals("Computer"))
{ ComputerWeb c = new ComputerWeb().getResourceById(Integer.parseInt(request.getParameter("id")));%>
                    <div class="form-group row">
                       <label for="resourceType" class="col-lg-2">Type</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" name="resourceType" value="Computer" readonly="readonly">
                        </div>
                    </div> 
                    <fieldset class="form-group row">
                        <label class="col-lg-2">Computer type</label>
                        <div class="col-sm-10">
                            <div class="radio">
                                <label><input type="radio" name="computerType" id="computerType1" value="Desktop" checked>Desktop</label>
                            </div>
                            <div class="radio">
                                <label><input type="radio" name="computerType" id="computerType2" value="Laptop">Laptop</label>
                            </div>
                        </div>
                    </fieldset>
                    <div class="form-group row">
                        <label for="computerModel" class="col-lg-2">Make and model</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control"  name="computerModel" value="<%out.print(c.getModel());%>">
                        </div>
                    </div> 
                    <div class="form-group row">
                        <label for="computerSize" class="col-lg-2">Screen size (inches)</label>
                        <div class="col-lg-4">
                            <input type="number" class="form-control"  name="computerSize" value="<%out.print(c.getScreenSize());%>">
                        </div>
                    </div>
                    <div class="form-group row">    
                        <label for="computerCPU" class="col-lg-2">CPU</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" name="computerCPU" value="<%out.print(c.getCpu());%>">
                        </div>    
                    </div> 
                    <div class="form-group row">    
                        <label for="computerRAM" class="col-lg-2">RAM memory</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control"   name="computerRAM" value="<%out.print(c.getRam());%>">
                        </div>
                    </div> 
                    <div class="form-group row">    
                        <label for="computerStorage" class="col-lg-2">Storage capacity</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control"  name="computerStorage" value="<%out.print(c.getStorage());%>">
                        </div>
                    </div> 
<% }
else if(type.equals("Projector"))
{  ProjectorWeb p = new ProjectorWeb().getResourceById(Integer.parseInt(request.getParameter("id")));%>
                    <div class="form-group row">
                       <label for="resourceType" class="col-lg-2">Type</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" name="resourceType" value="Projector" readonly="readonly">
                        </div>
                    </div>  
                    <div class="form-group row">
                       <label for="projectorName" class="col-lg-2">Name</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" name="projectorName" value="<%out.print(resName);%>">
                        </div>
                    </div> 
                    <div class="form-group row">
                        <label for="projectorModel" class="col-lg-2">Make and model</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control"  name="projectorModel" value="<%out.print(p.getModel());%>">
                        </div>
                    </div> 
                    <div class="form-group row">
                        <label for="projectorResolution" class="col-lg-2">Projector Resolution</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control"  name="projectorResolution" value="<%out.print(p.getResolution());%>">
                        </div>
                    </div> 
<%}
else if(type.equals("Conference"))
{ConferenceRoomWeb crw = new ConferenceRoomWeb().getResourceById(Integer.parseInt(request.getParameter("id")));%>
                    <div class="form-group row">
                       <label for="resourceType" class="col-lg-2">Type</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" name="resourceType" value="Conference" readonly="readonly">
                        </div>
                    </div>  
                    <div class="form-group row">
                       <label for="roomName" class="col-lg-2">Name</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" name="conferenceName" value="<%out.print(resName);%>">
                        </div>
                    </div> 
                    <div class="form-group row">
                        <label for="roomLocation" class="col-lg-2">Location</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control"  name="conferenceLocation" value="<%out.print(crw.getLocation());%>">
                        </div>
                    </div> 
                    <div class="form-group row">
                        <label for="roomCapacity" class="col-lg-2">Capacity</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control"  name="conferenceCapacity" value="<%out.print(crw.getCapacity());%>">
                        </div>
                    </div> 
                         <div class="form-group row">
                <label for="whiteboard" class="col-lg-2">Has a whiteboard?</label>
                <div class="col-lg-4">
                    <select class="form-control" name="whiteboard">
                        <%if(crw.hasWhiteboard()) { %>
                        <option value="hasWhiteboard" selected>Yes</option>
                        <option value="noWhiteboard">No</option>
                        <%}
                            else { %>
                            <option value="hasWhiteboard">Yes</option>
                            <option value="noWhiteboard" selected>No</option>
                        <% } %>
                    </select>    
                </div>
            </div> 
            <div class="form-group row">
                <label for="telephone" class="col-lg-2">Has a telephone?</label>
                <div class="col-lg-4">
                    <select class="form-control" name="telephone">
                        <%if(crw.hasPhone()) { %>
                        <option value="hasTelephone" selected>Yes</option>
                        <option value="noTelephone">No</option>
                        <%}
                          else{ %>
                          <option value="hasTelephone">Yes</option>
                        <option value="noTelephone" selected>No</option>
                          <% } %>
                    </select>    
                </div>
            </div> 
 <% } 
 else if(type.equals("Miscellaneous"))
{ %>
                    <div class="form-group row">
                       <label for="resourceType" class="col-lg-2">Type</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" name="resourceType" value="Miscellaneous" readonly="readonly">
                        </div>
                    </div>  
                    <div class="form-group row">
                       <label for="miscName" class="col-lg-2">Name</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" name="miscName" value="<%out.print(resName);%>">
                        </div>
                    </div>
<% } %>
                    <div class="form-group row">
                        <div class="col-lg-2">
                            <button type="submit" name="updateResource" class="btn btn-primary" value="update" >Update Resource</button>
                        </div>
                    </div> 
                    
                   <% /* <div class="form-group row">
                        <label for="resourceStatus" class="col-lg-2">Status</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="resourceStatus" value="Overdue" disabled>
                        </div>
                    </div> */
                   Reservation res = new Reservation(null, null, null);
                   LinkedList<ResourcesWeb> resources = new LinkedList<ResourcesWeb>();
                   resources = rw.getAllUnavailableResources();
                   if(resources != null)
                   {
                        for (int i = 0; i < resources.size(); i++) {
                            res = null;
                             if(resources.get(i).getResourceID() == Integer.parseInt(request.getParameter("id"))){
                                 res = resources.get(i).getLastReservation();
                                 break;
                            }
                        }
                   }
                   if(res == null) {%>
                    <div class="form-group row">
                        <label for="resourceStatus" class="col-lg-2">Status</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="resourceStatus" value="Unreserved" disabled>
                        </div>
                    </div>
                    <%}
                    else {%>
                    <div class="form-group row">    
                        <label for="reservedBy" class="col-lg-2">Reserved by</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="reservedBy" value="<%out.print(res.getUser().getFullName());%>" disabled>
                        </div>
                    </div> 
                    <div class="form-group row">    
                        <label for="reservedFrom" class="col-lg-2">From</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="reservedFrom" value="<%out.print(res.getStart());%>" disabled>
                        </div>
                    </div> 
                    <div class="form-group row">    
                        <label for="reservedUntil" class="col-lg-2">Until</label>
                        <div class="col-lg-4">
                            <input type="text" class="form-control" id="reservedUntil" value="<%out.print(res.getEnd());%>" disabled>
                        </div>
                    </div>
<% } %>            
                </form>
                
                <!-- split into 2 forms because action points to different pages -->
                <form action="UpdateServlet">
                	<input type="hidden" name="resourceId" value="<%out.print(request.getParameter("id"));%>">
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
                
            </div>
        </div><!-- /.container -->

<%@include file="footer.jsp"%> <!-- Bootstrap JavaScript and closing tags -->