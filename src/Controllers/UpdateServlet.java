/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;



import DAO.ResourcesDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Adrian
 */

@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
          
        String Update = request.getParameter("updateResource");
        String Delete = request.getParameter("delete");
        String Add = request.getParameter("AddResource");
        
        if(Update!= null && Delete==null && Add == null )
        {
             GetByID(request);
        }
         if (Delete!=null && Update ==null && Add == null)
        {
          DeleteByID(request);
          RequestDispatcher rd = request.getRequestDispatcher("inventory-report.jsp");  
          rd.forward(request, response);
          return;
        }
        if (Delete==null && Update ==null && Add != null)
        {
          AddByID(request);
        }
       
        RequestDispatcher rd = request.getRequestDispatcher("update-resource.jsp");  
        rd.forward(request, response);
    }
    
    public void GetByID(HttpServletRequest request)
    {
       // Create the Resource Object
        ResourcesDAO e = new ResourcesDAO();
        
        int ID = Integer.parseInt(request.getParameter("id")); 
        String type = request.getParameter("resourceType");
        
        if(type.equals("Computer")){        
            String ComputerModel = request.getParameter("computerModel");
            float ScreenSize = Float.parseFloat(request.getParameter("computerSize"));   
            String CPU = request.getParameter("computerCPU");
            String RAM = request.getParameter("computerRAM");  
            String Storage = request.getParameter("computerStorage"); 


            int isDesktop = 1;
            if(request.getParameter("computerType").equals("Laptop")){
                isDesktop = 0;
            }


            // Update the ID
            e.updateComputerType(ID, isDesktop);
            e.updateComputerModel(ID,ComputerModel);
            e.updateComputerScreenSize(ID,ScreenSize);
            e.updateComputerCPU(ID,CPU);
            e.updateComputerRAM(ID,RAM);
            e.updateComputerStorage(ID, Storage);
        }
        else if(type.equals("Projector")){ 
   
            String projectorName = request.getParameter("projectorName"); 
            String projectorModel = request.getParameter("projectorModel"); 
            String projectorResolution = request.getParameter("projectorResolution"); 
            
            // Update the ID
            e.updateResourcesName(ID, projectorName);
            e.updateProjectorModel(ID, projectorModel);
            e.updateProjectorMaxRes(ID, projectorResolution);   
        }
        else if(type.equals("Conference")){
            
            String conferenceName = request.getParameter("conferenceName"); 
            String conferenceLocation = request.getParameter("conferenceLocation");
            int conferenceCapacity = Integer.parseInt(request.getParameter("conferenceCapacity"));
            String whiteboard = request.getParameter("whiteboard");
            String telephone = request.getParameter("telephone");
            
                int hasWhiteboard = 0;
                if(whiteboard.equals("hasWhiteboard"))
                    hasWhiteboard = 1;
                
                int hasPhone = 0;
                if(telephone.equals("hasTelephone"))
                    hasPhone = 1;            
            
            // Update the ID
            e.updateResourcesName(ID, conferenceName);
            e.updateConferenceRoomLocation(ID, conferenceLocation);
            e.updateConferenceRoomCapacity(ID, conferenceCapacity);
            e.updateConferenceRoomHasWhiteboard(ID, hasWhiteboard);
            e.updateConferenceRoomHasPhone(ID, hasPhone);                           
        }
        else if(type.equals("Miscellaneous")){
            
            String miscName = request.getParameter("miscName");  

            // Update the ID
            e.updateResourcesName(ID, miscName);
        }
    }
    
    private void DeleteByID(HttpServletRequest request)
    {
       // Create the Resource Object
        ResourcesDAO e = new ResourcesDAO();
        
        int ID = Integer.parseInt(request.getParameter("resourceId"));
        
        
        // Update the ID
       e.deleteResourceById(ID);
       
    }
    
     private void AddByID(HttpServletRequest request)
    {
       // Create the Resource Object
        ResourcesDAO e = new ResourcesDAO();
        
        int ID = Integer.parseInt(request.getParameter("resourceId"));
        int ComputerType = Integer.parseInt(request.getParameter("computerType"));   
        String ComputerModel = request.getParameter("computerModel");
        float ScreenSize = Float.parseFloat(request.getParameter("computerSize"));   
        String CPU = request.getParameter("computerCPU");
        String RAM = request.getParameter("computerRAM");  
        String Storage = request.getParameter("computerStorage"); 
        
        // Update the ID
       e.addResourceComputer(0, "Name"+ID ,ComputerType ,ComputerModel,ScreenSize,CPU,RAM, Storage);
       
    }
    
    
}
