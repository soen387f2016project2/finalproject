package Demo;
public class ProjectorWeb extends ResourcesWeb {

	private String model;
    private String resolution;
	
    public ProjectorWeb(int id, String resourcename, String description, String model, String resolution) {
		super(id, "Projector", "model:\t" +model +" resolution:\t" + resolution);
		this.model = model;
		this.resolution = resolution;
	}

    
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
        public String classAsString() {
            return "Projector";
        }
        
	public void updateDescription(){
		this.setDescription("Model:\t" +model +" Resolution:\t" +resolution);
	}
    
    
}
