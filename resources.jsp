<%-- 
    Document   : resources
    Created on : 4-Nov-2016, 7:05:52 PM
    Author     : mouadbouras
--%>
        <%@include file="data.jsp" %> <!--todelete-->
<%@include file="header3.jsp"%> <!-- header and navigation bar -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="header2.jsp" %>
        <title> Resource List</title>
    </head>
    <body>
        
       <%@include file="navbar.jsp" %>

       <div class="container" >

        <div class="resources-container whitebg">
<!--        <div class="row">
            <div class="col-lg-12 col-sm-12"><h1>Resource list : </h1></div>
        </div>-->
    
        <div class="row">
            <div class="col-lg-12 col-sm-12">
            <form name="pickup-date-search" action="resources.jsp" method="get" >
                <div class="input-group">
                    <div class="input-group-btn search-panel">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                            <span id="search_concept"> <% out.print((request.getParameter("search-resource-type") == null || request.getParameter("search-resource-type").equals("all")  ) ? "Looking for" : request.getParameter("search-resource-type")  ); %> 
                            </span> <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="Room">Room</a></li>
                          <li><a href="Equipment">Equipment</a></li>
                          <li class="divider"></li>
                          <li><a href="all">Anything</a></li>
                        </ul>
                    </div>
                    <input type="hidden" name="search-resource-type" value="all" id="search_param">         
                    <input type="text" class="form-control" name="search-text" placeholder="Search term..." <% out.print((request.getParameter("search-text") == null ) ? "" : "value='" + request.getParameter("search-text") + "'"  ); %> >
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span></button>
                    </span>
                </div>
            </form>
            </div>
        </div>
        
                <hr /> <!-- line -->

        <div class="row">
            <% 
               int pagesize = 10;
               pagesize = (pagesize > mylist.size()) ? mylist.size() : pagesize;
               int start = 0;
               int end = mylist.size();
               int activePage =  (request.getParameter("page")==null) ? -1 : Integer.parseInt(request.getParameter("page")) ;
               start = (activePage - 1) * pagesize  ; 
               end   = activePage * pagesize  ; 

               start = (start > mylist.size()) ? mylist.size() : start ;               
               start = (start < 0) ? 0 : start ; 
               end = (end > mylist.size()) ? mylist.size() : end ;               
               end = (end < 0) ? pagesize : end ;
               
               for (int i = start; i < end ; i++) { 
                                                           %>
                <!-- Individual Resource Start -->
                <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 resource-card <% if(i > (start + 5)){out.print(" wow slideInUp ");} %> "  id="ResourceCard<% out.print(mylist.get(i).resourceID); %>">
                  <div class="thumbnail">
                      <div class="caption">
                        <div class='col-lg-12 well well-add-card'>
                            <h4><% if(mylist.get(i).child.equals("ITEquipment")){ %> <span class="glyphicon glyphicon glyphicon-wrench">&nbsp;</span> <% ;}
                                   else if (mylist.get(i).child.equals("ConferenceRoom")) { %> <span class="glyphicon glyphicon-modal-window">&nbsp;</span> <% ;} %>                          
                                <% out.print(mylist.get(i).resourceName) ; %></h4>
                        </div>
                        <div class='col-lg-12'>
                            <p ><% out.print(mylist.get(i).description.substring(0,175)+"...") ; %></p>
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
                          <a class="view-resource-button" href="viewresource.jsp?id=<% out.print(mylist.get(i).resourceID); %>" ID="<% out.print(mylist.get(i).resourceID); %>" ><button type="button" class="btn btn-primary btn-xs btn-update btn-add-card view-resource-button">View</button></a>
                          <button type="button" class="btn btn-danger btn-xs btn-update btn-add-card hideButton" container="ResourceCard<% out.print(mylist.get(i).resourceID); %>">Hide</button>
                    </div>
                  </div>
                </div>
                <!-- Individual Resource End -->
                <% } %>

            </div>
                
                <div class="row wow slideInUp ">
                    <div class="col-xs-12">
                      <ul class="pagination">  
                        <li><a href="resources.jsp?page=1"><<</a></li>
                        <%                             
                            final int pages = ((mylist.size()%pagesize) == 0) ? (int)(mylist.size() / pagesize) : ((int)(mylist.size() / pagesize)) + 1  ; 
                            
                            int fp = 1;
                            int lp = pages;
                            
                            if (activePage <= 3)
                            {
                                fp = 1;
                                lp = (pages <= 5 ) ? pages : 5 ;
                            }
                            else if( activePage >= (pages - 2) )
                            {
                                fp = pages - 4;
                                fp = ( fp < 1 )? 1 : fp ;
                                lp = pages;
                            }
                            else
                            {
                                fp = activePage - 2;
                                lp = activePage + 2;
                            }
                            
                            for(int i = fp ; i <= lp; i++)
                            {
                                out.print("<li " + ((i == activePage || (activePage < 0 && i==1) ) ? "class=\"active\"" : "" ) + " ><a  href=\"resources.jsp?page=" + i + "\">" + i + "</a></li>");
                            }
                        %>
                        <li><a href="resources.jsp?page=<%out.print(pages);%>">>></a></li>

                      </ul>
                    </div>
                </div>
        </div>


        </div>  
       </div>



    </body>
</html>
