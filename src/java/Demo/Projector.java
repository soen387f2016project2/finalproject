
package Demo;

public class Projector extends Resource {

    private String model;
    private String resolution;
    
    public Projector(String id, String model, String resolution) {
        super(id);
        this.model = model;
        this.resolution = resolution;
    }
    
    public String getModel() {
        return model;
    }
    
    public String getResolution() {
        return resolution;
    }
    
    public String classAsString() {
        return "Projector";
    }
    
    public String descriptionString() {
        return (model + ", " + resolution);
    }
}
