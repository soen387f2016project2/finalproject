<!DOCTYPE html>
<!--
Project Manager: Cuong Nguyen
Team ID: 8
Class Number: SOEN 387
Name:
Aakash Patel            27503008
Mahinthien Ratnarajah	27186517
Michael Cabana          27527489
Mouad Bouras            27671083
Razmig Houssikian	40001040

Sprint 1
-->

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="Demo.ResourcesWeb" %>
<%@ page import="Demo.ComputerWeb"%>
<%@page import="Demo.MiscWeb"%>
<%@page import="Demo.ProjectorWeb"%>
<%@page import="Demo.ConferenceRoomWeb"%>
<%@include file="header3.jsp"%> <!-- header and navigation bar -->       
<%
            int id = 0;
            
            if(request.getParameter("id") == null){
                id = 0;
            }
            else{
                id = Integer.parseInt(request.getParameter("id"));
            }
                   
            
            ResourcesWeb rw = new ResourcesWeb();
            String type = "";
            try{
                type = rw.getResourceType(id);
            }
            catch(Exception e){
                type = null;
            }
            
            if(type == null) out.println("ID not found");
            
    if(type != null){
        
            String description = "";
            String name = "";
            boolean isMaintained = false;
            
            if(type.equals("Computer")){
                ComputerWeb cw = new ComputerWeb().getResourceById(id);
                name = cw.getResourceName();
                description = cw.getDescription();
                isMaintained = cw.getMaintained();
            }
            else if(type.equals("Projector")){
                ProjectorWeb pw = new ProjectorWeb().getResourceById(id);
                name = pw.getResourceName();
                description = pw.getDescription();
                isMaintained = pw.getMaintained();               
            }
            else if(type.equals("Miscellaneous")){
                MiscWeb pw = new MiscWeb().getResourceById(id);
                name = pw.getResourceName();
                description = pw.getDescription();
                isMaintained = pw.getMaintained();               
            }
        
%>
<html>
    <head>
        <%@include file="header2.jsp" %>
        <title>Resource Details</title>
    </head>
    <body>

        <%@include file="navbar.jsp" %>

       <div class="container " >

        <div class="resources-container whitebg">
        <div class="row">
            <div class="col-lg-12 col-sm-12"><h1>Resource Details : </h1></div>
            <!--<div class="col-lg-6 col-sm-12">
                <span class="pull-right resource-date">
                    <form >
                        <b>Pickup Date </b>
                          <input type="date" name="bday" min="2016-10-28">
                    </form>
                </span>
            </div>-->
        </div>
        
        <hr /> <!-- line -->
                        <form>

        <div class="row">
            
            <% int i = Integer.parseInt(request.getParameter("id"));
                //get the resourse whose id is ID 
               int oldi = i ; i--;
            %>
                <!-- Individual Resource Start -->
                <div class="col-xs-10 col-xs-offset-1 animated fadeIn">
                  <div class="thumbnail">
                      <div class="caption">
                        <div class='col-lg-12 well well-add-card'>
                            <h4><% if(type.equals("Computer") || type.equals("Projector") || type.equals("Miscellaneous")) { %> <span class="glyphicon glyphicon glyphicon-wrench">&nbsp;</span> <% ;}
                               else if(type.equals("Conference")) { %> <span class="glyphicon glyphicon-modal-window">&nbsp;</span> <% ;} %>                          
                            <% out.print(name) ; %></h4>
                        </div>
                        <div class='col-lg-6 col-sm-12'>
                            <p><% out.print(description) ; %></p>
                        </div>
                        <div class='col-lg-6 col-sm-12'>
                            <p class="text-muted"> Additional details</p>
                            <p>Maintained : <% out.print((isMaintained) ? "Yes" : "No" )  ; %></p>
                            <% if(type.equals("Computer") || type.equals("Projector") || type.equals("Miscellaneous")) { %>
                                    <ul>
                                        <li><b>Equipment Type : </b><% out.print(type); %></li>                                       
                                        <br /> <!-- keeping the boxes even -->
                                    </ul>                                
                                <% } 
                                else if (type.equals("Conference")){ 
                                    ConferenceRoomWeb crw = new ConferenceRoomWeb().getResourceById(id);
                                %>
                                     <ul>
                                         <li><b>Location : </b><% out.print(crw.getLocation()) ; %></li>   
                                         <li><b>Capacity : </b><% out.print(crw.getCapacity()); %></li>                                                                                                                      
                                    </ul>                
                                
                                 <% } %>
                        </div>                        
                        
                        <div class='col-lg-12 well well-add-card'>
                            <h4>Reservation Form</h4>
                        </div>                        
                        <div class='col-lg-4'>
                                <b>Pickup Date </b>
                                <input type="date" name="pickup" min="2016-10-28">
                        </div>
                        <div class='col-lg-8'>
                               <b>Return Date </b>
                               <input type="date" name="return" min="2016-10-28">                           
                        </div>
                        <div class='col-lg-12'>
                            <input type="submit" class="btn btn-primary btn-sm reservation-btn " value="Reserve" >
                        </div>
                        <input type="hidden" value="<% out.print(id); %>" name="id" />
                        <div class="clearfix"></div>
                    </div>
                  </div>
                </div>
                <!-- Individual Resource End -->

            </div>
                                    </form>

        </div>


        </div>  
       </div>



    </body>
</html>

<%
    }//if(!type.equals("")){
        
%>
