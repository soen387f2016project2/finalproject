<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Demo.Reservation"%>
<%@page import="java.util.LinkedList"%>
<%@page import="DAO.ResourcesDAO"%>
<%@page import="Demo.ResourcesWeb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
LinkedList<ResourcesWeb> resourceList = ResourcesWeb.getAllResources();
Date currentDate = new Date();
%>

<%@include file="header.jsp"%> <!-- header and navigation bar -->

        <div class="container">
            <div class="centered-content">
                <h1>Inventory Report</h1>
                
                <table class="table table-hover" id="report-table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Status</th>
                            <th>Reserved by</th>
                            <th>From</th>
                            <th>Until</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (ResourcesWeb resource : resourceList) { %>
                        <tr>
                            <td><a href="update-resource.jsp?id=<%out.print(resource.getResourceID());%>"><%out.print(resource.getResourceID());%></a></td>
                            <td><a href="update-resource.jsp"><%out.print(resource.getResourceName());%></a></td>
                            <td><a href="update-resource.jsp"><%out.print(resource.descriptionString());%></a></td>
                            
                            <% Reservation lastReservation = resource.getLastReservation();
                            
                            if (ResourcesWeb.isAvailable()) { %> 
                            <td><a href="update-resource.jsp"><h4><span class="label label-success">Available</span></h4></a></td>    
                            <% } else if (lastReservation.getEnd().before(currentDate)) { %>
                            <td><a href="update-resource.jsp"><h4><span class="label label-danger">Overdue</span></h4></a></td>
                            <% } else { %>
                            <td><a href="update-resource.jsp"><h4><span class="label label-warning">Reserved</span></h4></a></td>
                            <% } 
                            
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
                            } %>
                            <td><a href="update-resource.jsp"><%out.print(reservedBy);%></a></td>
                            <td><a href="update-resource.jsp"><%out.print(reservedFrom);%></a></td>
                            <td><a href="update-resource.jsp"><%out.print(reservedUntil);%></a></td>
                        </tr>
                        <% } %>
                    </tbody>    
                </table>

            </div>
        </div><!-- /.container -->

<%@include file="footer.jsp"%> <!-- Bootstrap JavaScript and closing tags --> 