<%-- 
    Document   : data
    Created on : 4-Nov-2016, 4:04:45 PM
    Author     : mouadbouras
--%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>

<%@ page import="java.util.LinkedList" %>



<%@ page import="Demo.ResourcesWeb" %>
<%@ page import="Demo.ProjectorWeb" %>
<%@ page import="Demo.ComputerWeb" %> 
<%@ page import="Demo.ConferenceRoomWeb" %> 
<%@ page import="Demo.MiscWeb" %> 




<% 
    
    LinkedList<ResourcesWeb> mylist;
    
    if( request.getAttribute("mylist") != null)
    {
          mylist = (LinkedList<ResourcesWeb>)request.getAttribute("mylist");
    }
    else
    {
        mylist  =  ResourcesWeb.getAllAvailableResources();
    }
    
    
    //LinkedList<ResourcesWeb> mylist =  ResourcesWeb.getAllResources();

    // LinkedList<ResourcesWeb> mylist = new LinkedList<ResourcesWeb>();
   
   

    
    
//    for (int i = 0 ; i < initList.size(); i++)
//    {
//        ResourcesWeb item = initList.get(i);
//       // System.out.println(initList.size());
//        if(item.getResourceType(item.getResourceID()).equals("Computer")){ 
//                mylist.add( new ComputerWeb().getResourceById(item.getResourceID()));
//            }
//        else if (item.getResourceType(item.getResourceID()).equals("Conference")) { 
//                mylist.add( new ConferenceRoomWeb().getResourceById(item.getResourceID()));    
//        }                           
//        else if (item.getResourceType(item.getResourceID()).equals("Projector")) {  
//                mylist.add( new ProjectorWeb().getResourceById(item.getResourceID()));
//        }                          
//        else if (item.getResourceType(item.getResourceID()).equals("Miscellaneous")) { 
//                mylist.add( new MiscWeb().getResourceById(item.getResourceID()));
//        }                         
//        else if (item.getResourceType(item.getResourceID()).equals("Unknown")) {
//                mylist.add( item);
//        }
//    }
    //system.out.println(mylist.get(1));

    // List<User> validUser = new ArrayList<User>();
    // List<User> emptyUser = new ArrayList<User>();

    // List<ConferenceRoom> ConferenceRooms = new ArrayList<ConferenceRoom>();
    // List<ITEquipment> ITEquipments = new ArrayList<ITEquipment>();
    // List<ReserveLog> ReserveLogs = new ArrayList<ReserveLog>();
    


    // List<Resource> mylist = new ArrayList<Resource>();

    
    // validUser.add( new User(1,1, "moeezy" , "pass" , "" , "" , "" ) );
    // for (int i = 0 ; i < 65 ; i++)
    // {
    //    mylist.add( new ConferenceRoom(  i+1 ,
    //                                    "Conference " + (i+1) ,
    //                                    (i%2 == 0) , 
    //                                    "Resource Description " + (i+1) +"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas nec sagittis dolor. Suspendisse ac bibendum enim. Morbi eget orci dictum, malesuada nibh et, blandit erat. Nunc tempor neque non eros egestas finibus. Nulla porttitor, sapien a volutpat tincidunt, elit magna dictum nulla, quis laoreet mi mauris a nulla. Donec quis mattis augue, at rutrum elit. Integer quis ante vitae nibh vehicula hendrerit at vitae nibh. Aliquam erat volutpat. Fusce augue erat, tincidunt non ligula non, pharetra aliquet diam. In hac habitasse platea dictumst. Maecenas vel lectus eu felis fermentum consectetur. Quisque in efficitur risus, vitae blandit metus. Nam dignissim molestie libero, eu dignissim ligula luctus sed.",
    //                                    "location " + (i+1) ,
    //                                    (i+1)*5)
    //                                    );    
    //    i++;
    //     mylist.add( new ITEquipment( i+1 ,
    //                                 "Equipment " + (i+1) ,
    //                                 (i%2 == 0) , 
    //                                 "Resource Description " + (i+1) + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas nec sagittis dolor. Suspendisse ac bibendum enim. Morbi eget orci dictum, malesuada nibh et, blandit erat. Nunc tempor neque non eros egestas finibus. Nulla porttitor, sapien a volutpat tincidunt, elit magna dictum nulla, quis laoreet mi mauris a nulla. Donec quis mattis augue, at rutrum elit. Integer quis ante vitae nibh vehicula hendrerit at vitae nibh. Aliquam erat volutpat. Fusce augue erat, tincidunt non ligula non, pharetra aliquet diam. In hac habitasse platea dictumst. Maecenas vel lectus eu felis fermentum consectetur. Quisque in efficitur risus, vitae blandit metus. Nam dignissim molestie libero, eu dignissim ligula luctus sed." ,
    //                                 "equipmentType " + (i+1)  )); 
       
    // }
    
    // for (int i = 1 ; i <= 15 ; i++)
    // {
    //    ReserveLogs.add( new ReserveLog( i*100 , i*1000,
    //                                     i ,
    //                                     "Resource " + i ,
    //                                     (i%2 == 0) , 
    //                                     "Resource Description " + i ,
    //                                     new Date(), new Date()));          
    // }


%>