/*
 * Servlet (controller) that handles user login
 */
package Controllers;

import DAO.ReservesLogDAO;
import DAO.ResourcesDAO;
import DAO.UsersDAO;
import Demo.EndUser;
import Models.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Samantha Graham
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the username and password from the request
        String username = request.getParameter("account");
        String password = request.getParameter("password");        
        
        // Instantiate the model that will authenticate the user
        LoginDao dao = new LoginDao();

        // For testing purposes
        ReservesLogDAO logDAO = new ReservesLogDAO();
        logDAO.getAllReservationsForUser(1);
        logDAO.getAllReservationsForResource(2);
        logDAO.makeReservation(1, 3, "2016-11-09 23:32:23.0", "2016-11-09 23:32:23.0");
        logDAO.getAllReservationsForResource(3);

        UsersDAO usersDAO = new UsersDAO();
        usersDAO.addUser(0, "aa1@b.com", "password", "Alice", "123456789", "IEEE"); //change email
        usersDAO.addUser(0, "ba1@c.com", "password123", "Bob", "12999999", "MECH"); //change email
        usersDAO.addUser(1, "d1@ae.com", "p123", "Carol", "12777999", "COMPSCI"); //change email
        usersDAO.deleteUser(2);
        usersDAO.updatePassword(1, "beta123");
        usersDAO.getAllAdmin();
        usersDAO.getAllEmployee();
        usersDAO.login("a@b.com", "password");

        ResourcesDAO resDAO = new ResourcesDAO();
        System.out.println("Getters");
        resDAO.getAllResources();
        resDAO.getResourceById(2);
        resDAO.getAllITEquipment();
        resDAO.getAllConferenceRooms();
        resDAO.getAllUnavailableResources();
        resDAO.getAllAvailableResources();
        System.out.println("Updates");
        resDAO.updateResourcesIsMaintained(2, 1);
        resDAO.getAllResources();
        resDAO.updateResourcesDescription(2, "HELLO");
        resDAO.getAllResources();
        resDAO.updateResourcesName(2, "NewResource2"); // Make sure new resourceName is unique
        resDAO.getAllResources();
        resDAO.updateITEquipmentType(2, "NewEquipmentType");
        resDAO.getAllITEquipment();
        resDAO.updateConferenceRoomLocation(4, "HALLO");
        resDAO.getAllConferenceRooms();
        resDAO.updateConferenceRoomCapacity(4, 9500);
        resDAO.getAllConferenceRooms();
        System.out.println("Delete");
        resDAO.deleteResourceById(1); // Change to existing id
        resDAO.getAllResources();
        System.out.println("Add");
        resDAO.addResourceITEquipment(0, "AddDesc1", "AddIT3", "AddType"); // Change resourceName to something unique
        resDAO.getAllITEquipment();
        resDAO.addResourceConferenceRoom(0, "AddDesc2", "AddCR3", "AddLoca", 9999); // Change resourceName to something unique
        resDAO.getAllConferenceRooms();

        // Authenticate the user
        EndUser user = dao.authenticate(username, password);
        
        // Prepare to return
        RequestDispatcher rd;
        
        // If the authentication failed
        if(user == null) {
            System.out.println("butts");
            // Send back to login form
            rd = request.getRequestDispatcher("login.jsp");
            
            // Give them a message
            request.setAttribute("message", "Your login details were incorrect; please try again");
        } else {
            System.out.println("here");
            // Set the session things
            HttpSession session = request.getSession();
            session.setAttribute("user_id", user.getID());

            // Redirect to the dashboard
            rd = request.getRequestDispatcher("dashboard.jsp");            
            request.setAttribute("user", user.getFullName());
        }
        
        // Return
        rd.forward(request, response);
    }
}
