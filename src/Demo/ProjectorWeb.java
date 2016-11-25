package Demo;
public class ProjectorWeb extends ResourcesWeb {

    // Attributes
    private String model;
    private String resolution;
	
    // Constructor
    public ProjectorWeb(int id, String resourcename, String description, String model, String resolution) {
	super(id, "Projector", "model:\t" +model +" resolution:\t" + resolution);
	this.model = model;
	this.resolution = resolution;
    }

    // Getters and setters
    public String getModel() {
        return model;
    }

    public String getResolution() {
        return resolution;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    // Other methods
    public void updateDescription(){
        this.setDescription("Model:\t" +model +" Resolution:\t" +resolution);
    }
    
    
}
