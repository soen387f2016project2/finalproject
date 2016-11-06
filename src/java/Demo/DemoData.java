
package Demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class DemoData {

    // these should probably be HashMaps in our final version for performance reasons
    // I used LinkedLists for the demo data for simplicity (easier iteration)
    private LinkedList<Resource> resources;
    private LinkedList<EndUser> users;
    
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public Date currentDate;
    
    public DemoData() {
        // create some resources
        Computer dellPC = new Computer("DTPC0104", Computer.Type.DESKTOP, "Dell OptiPlex 7040", 24, "Intel Core i7-6700", "8GB DDR3 1600MHz", "500GB HDD");
        Projector epsonProjector = new Projector("PROJ0054", "Epson EX9200 Pro", "1920 x 1200");
        ConferenceRoom room503 = new ConferenceRoom("ROOM0503", 12, true, true);
        Misc dellMonitor = new Misc("MNTR0089", "Dell U2417H 24-inch IPS monitor with 1920 x 1200 resolution");
        resources = new LinkedList<>();
        resources.add(dellPC);
        resources.add(epsonProjector);
        resources.add(room503);
        resources.add(dellMonitor);
        
        // create some end users
        EndUser seb = new EndUser("scharb", "Sebastien", "Charbonneau", "password");
        EndUser vince = new EndUser("vlugara", "Vincent", "Lugara", "password");
        EndUser karolina = new EndUser("kkonieczny", "Karolina", "Konieczny", "password");
        EndUser vinh = new EndUser("vtruong", "Vinh", "Truong", "password");
        EndUser alain = new EndUser("afallara", "Alain", "Fallara", "password");
        users = new LinkedList<>();
        users.add(seb);
        users.add(vince);
        users.add(karolina);
        users.add(vinh);
        users.add(alain);
        
        
        try {
            // set up current date
            currentDate = dateFormat.parse("2016-10-26");
            
            // create some reservations
            dellPC.reserve(dateFormat.parse("2016-10-02"), dateFormat.parse("2016-10-09"), seb, currentDate);
            epsonProjector.reserve(dateFormat.parse("2016-10-24"), dateFormat.parse("2016-10-31"), vince, currentDate);
            room503.reserve(dateFormat.parse("2016-10-22"), dateFormat.parse("2016-10-25"), seb, currentDate);   
            room503.setStatus(Resource.Status.RESERVED); // in order to make it overdue
            
        } catch (ParseException e) {
            e.printStackTrace();
        }  
    }
    
    public LinkedList<Resource> getResourcesList() {
        return resources;
    }
    
    public LinkedList<EndUser> getUsersList() {
        return users;
    }
    
    /**
     * 
     * @param resourceID
     * @return The matching Resource object or null if there's no match for the specified ID
     */
    public Resource getResource(String resourceID) {
        for (Resource resource : resources) {
            if (resource.getID().equals(resourceID)) {
                return resource;
            }
        }
        return null;
    }
    
    public Date getCurrentDate() {
        return currentDate;
    }
}
