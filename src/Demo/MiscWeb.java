package Demo;
public class MiscWeb extends ResourcesWeb {

	public MiscWeb(int id, String description){
		
		super(id,"Misc",description);
	}
	
	public String getDescription(){
		return this.getDescription();
	}
	
	public void setDescription(String description){
		this.setDescription(description);
	}
	
	// Other methods
        public String classAsString() {
            return "Misc";
        }
}
