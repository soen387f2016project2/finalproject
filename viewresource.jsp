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

        <%@include file="data.jsp" %> <!--todelete-->


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
                            <h4><% if(mylist.get(i).child.equals("ITEquipment")){ %> <span class="glyphicon glyphicon glyphicon-wrench">&nbsp;</span> <% ;}
                               else if (mylist.get(i).child.equals("ConferenceRoom")) { %> <span class="glyphicon glyphicon-modal-window">&nbsp;</span> <% ;} %>                          
                            <% out.print(mylist.get(i).resourceName) ; %></h4>
                        </div>
                        <div class='col-lg-6 col-sm-12'>
                            <p><% out.print(mylist.get(i).description) ; %></p>
                        </div>
                        <div class='col-lg-6 col-sm-12'>
                            <p class="text-muted"> Additional details</p>
                            <p>Maintained : <% out.print((mylist.get(i).isMaintained) ? "Yes" : "No" )  ; %></p>
                            <% if(mylist.get(i).child.equals("ITEquipment")) { %>
                                    <ul>
                                        <li><b>Equipment Type : </b><% out.print(((ITEquipment)mylist.get(i)).equipmentType) ; %></li>                                       
                                        <br /> <!-- keeping the boxes even -->
                                    </ul>                                
                                <% } 
                                else if (mylist.get(i).child.equals("ConferenceRoom")){ %>
                                     <ul>
                                         <li><b>Location : </b><% out.print(((ConferenceRoom)mylist.get(i)).location) ; %></li>   
                                         <li><b>Capacity : </b><% out.print(((ConferenceRoom)mylist.get(i)).capacity) ; %></li>                                                                                                                      
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
                        <input type="hidden" value="<% out.print(oldi); %>" name="id" />
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
