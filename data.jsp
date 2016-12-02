<%-- 
    Document   : data
    Created on : 4-Nov-2016, 4:04:45 PM
    Author     : mouadbouras
--%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>

<%@ page import="beans.Resource" %>
<%@ page import="beans.ConferenceRoom" %>
<%@ page import="beans.ITEquipment" %>
<%@ page import="beans.ReserveLog" %>
<%@ page import="beans.User" %>



<% 
    List<User> validUser = new ArrayList<User>();
    List<User> emptyUser = new ArrayList<User>();

    List<ConferenceRoom> ConferenceRooms = new ArrayList<ConferenceRoom>();
    List<ITEquipment> ITEquipments = new ArrayList<ITEquipment>();
    List<ReserveLog> ReserveLogs = new ArrayList<ReserveLog>();
    
    List<Resource> mylist = new ArrayList<Resource>();

    
    validUser.add( new User(1,1, "moeezy" , "pass" , "" , "" , "" ) );
    for (int i = 0 ; i < 65 ; i++)
    {
       mylist.add( new ConferenceRoom(  i+1 ,
                                       "Conference " + (i+1) ,
                                       (i%2 == 0) , 
                                       "Resource Description " + (i+1) +"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas nec sagittis dolor. Suspendisse ac bibendum enim. Morbi eget orci dictum, malesuada nibh et, blandit erat. Nunc tempor neque non eros egestas finibus. Nulla porttitor, sapien a volutpat tincidunt, elit magna dictum nulla, quis laoreet mi mauris a nulla. Donec quis mattis augue, at rutrum elit. Integer quis ante vitae nibh vehicula hendrerit at vitae nibh. Aliquam erat volutpat. Fusce augue erat, tincidunt non ligula non, pharetra aliquet diam. In hac habitasse platea dictumst. Maecenas vel lectus eu felis fermentum consectetur. Quisque in efficitur risus, vitae blandit metus. Nam dignissim molestie libero, eu dignissim ligula luctus sed.",
                                       "location " + (i+1) ,
                                       (i+1)*5)
                                       );    
       i++;
        mylist.add( new ITEquipment( i+1 ,
                                    "Equipment " + (i+1) ,
                                    (i%2 == 0) , 
                                    "Resource Description " + (i+1) + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas nec sagittis dolor. Suspendisse ac bibendum enim. Morbi eget orci dictum, malesuada nibh et, blandit erat. Nunc tempor neque non eros egestas finibus. Nulla porttitor, sapien a volutpat tincidunt, elit magna dictum nulla, quis laoreet mi mauris a nulla. Donec quis mattis augue, at rutrum elit. Integer quis ante vitae nibh vehicula hendrerit at vitae nibh. Aliquam erat volutpat. Fusce augue erat, tincidunt non ligula non, pharetra aliquet diam. In hac habitasse platea dictumst. Maecenas vel lectus eu felis fermentum consectetur. Quisque in efficitur risus, vitae blandit metus. Nam dignissim molestie libero, eu dignissim ligula luctus sed." ,
                                    "equipmentType " + (i+1)  )); 
       
    }
    
    for (int i = 1 ; i <= 15 ; i++)
    {
       ReserveLogs.add( new ReserveLog( i*100 , i*1000,
                                        i ,
                                        "Resource " + i ,
                                        (i%2 == 0) , 
                                        "Resource Description " + i ,
                                        new Date(), new Date()));          
    }


%>