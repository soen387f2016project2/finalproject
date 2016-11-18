package Demo;

public class ComputerWeb extends ResourcesWeb {

	public enum Type {DESKTOP,LAPTOP}
	
	private Type type;
    private String model;
    private int screenSize;
    private String cpu;
    private String ram;
    private String storage;
	
    public ComputerWeb(int id, Type type, String model, int screenSize, String cpu, String ram, String storage) {
		super(id,"Computer","Mode:\t" + model + "Screensize:\t" + screenSize + " cpu:\t" + cpu + " ram:\t" + ram +
				" storage:\t"+ storage);
		this.type = type;
		this.model = model;
		this.screenSize = screenSize;
		this.cpu = cpu;
		this.ram = ram;
		this.storage = storage;
	}

    //getters
    
	public Type getType() {
		return type;
	}

	public String getModel() {
		return model;
	}

	public int getScreenSize() {
		return screenSize;
	}

	public String getCpu() {
		return cpu;
	}

	public String getRam() {
		return ram;
	}

	public String getStorage() {
		return storage;
	}
	
	
	
	//setters

	public void setType(Type type) {
		this.type = type;
		this.updateDescription();
	}

	public void setModel(String model) {
		this.model = model;
		this.updateDescription();
	}

	public void setScreenSize(int screenSize) {
		this.screenSize = screenSize;
		this.updateDescription();
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
		this.updateDescription();
	}

	public void setRam(String ram) {
		this.ram = ram;
		this.updateDescription();
	}

	public void setStorage(String storage) {
		this.storage = storage;
		this.updateDescription();
	}
	
	public void updateDescription(){
		this.setDescription("Mode:\t" + model + "Screensize:\t" + screenSize + " cpu:\t" + cpu + " ram:\t" + ram +
				" storage:\t"+ storage);
	}
    
    
    
}
