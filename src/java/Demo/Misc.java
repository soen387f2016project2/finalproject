
package Demo;

/*
For resources that don't fit into any of the other categories.
*/
public class Misc extends Resource {
    
    private String description;
    
    public Misc(String id, String description) {
        super(id);
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String classAsString() {
        return "Miscellaneous";
    }
    
    public String descriptionString() {
        return description;
    }
}
