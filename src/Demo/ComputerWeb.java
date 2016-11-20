package Demo;

public class ComputerWeb extends ResourcesWeb {
	
    private String resourceName;
    private String model;
    private int screenSize;
    private String cpu;
    private String ram;
    private String storage;
	
    public ComputerWeb(int id, String resourceName, String model, int screenSize, String cpu, String ram, String storage) {
        super(id,resourceName,"Mode:\t" + model + "Screensize:\t" + screenSize + " cpu:\t" + cpu + " ram:\t" + ram +
                        " storage:\t"+ storage);
        this.model = model;
        this.screenSize = screenSize;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
    }

    //getters
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

    // Other methods       
    public void updateDescription(){
        this.setDescription("Type:\t" + resourceName + "Model:\t" + model + "Screensize:\t" + screenSize + " cpu:\t" + cpu + " ram:\t" + ram +
                            " storage:\t"+ storage);
    }
    
    
}
