<%@page import="java.util.Date"%>
<%@page import="Demo.Reservation"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Demo.ResourcesWeb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%> <!-- header and navigation bar -->
<%
    ResourcesWeb rw = new ResourcesWeb();
    LinkedList<ResourcesWeb> resourceList = rw.getAllUnavailableResources();
    Date currentDate = new Date();
%>
<div class="container">
    <div class="centered-content">
        <h1 id="dashboard">Dashboard</h1>

        <h2>Overdue Resources</h2>

        <table class="table table-hover" id="report-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Reserved by</th>
                    <th>From</th>
                    <th>Until</th>
                </tr>
            </thead>
            <tbody>
                <% for (ResourcesWeb resource : resourceList) { %>
                <% Reservation lastReservation = resource.getLastReservation(); %>
                <%

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
                <tr class="danger">
                    <td><a href="update-resource.jsp?id=<%out.print(resource.getResourceID());%>"><%out.print(resource.getResourceID());%></a></td>
                    <td><a href="update-resource.jsp?id=<%out.print(resource.getResourceID());%>"><%out.print(resource.getResourceName());%></a></td>
                    <td><a href="update-resource.jsp?id=<%out.print(resource.getResourceID());%>"><%out.print(resource.descriptionString());%></a></td>
                    <td><a href="update-resource.jsp?id=<%out.print(resource.getResourceID());%>"><%out.print(reservedBy);%></a></td>
                    <td><a href="update-resource.jsp?id=<%out.print(resource.getResourceID());%>"><%out.print(reservedFrom);%></a></td>
                    <td><a href="update-resource.jsp?id=<%out.print(resource.getResourceID());%>"><%out.print(reservedUntil);%></a></td>
                </tr>
                <% }%>
            </tbody>    
        </table>

    </div>
</div><!-- /.container -->

<%@include file="footer.jsp"%> <!-- Bootstrap JavaScript and closing tags -->