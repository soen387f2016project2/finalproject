
package Demo;

import java.util.Date;

public class Reservation {
    
    private Date start;
    private Date end;
    private EndUser user;
    
    public Reservation(Date start, Date end, EndUser user) {
        this.start = start;
        this.end = end;
        this.user = user;
    }
    
    public Date getStart() {
        return start;
    }
    
    public Date getEnd() {
        return end;
    }
    
    public EndUser getUser() {
        return user;
    }
}
