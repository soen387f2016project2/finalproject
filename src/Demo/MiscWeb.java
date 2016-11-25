package Demo;
public class MiscWeb extends ResourcesWeb {

        // Attributes
        private int id;
        private String description;
        
        // Constructor
	public MiscWeb(int id, String description){
            super(id,"Misc",description);
	}
	
        // Other methods
	public void updateDescription(){
            this.setDescription("Description:\t" + description);
	}
	
}
