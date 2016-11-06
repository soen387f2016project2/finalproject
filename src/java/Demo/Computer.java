
package Demo;

public class Computer extends Resource {
    
    public enum Type {DESKTOP, LAPTOP};
    
    private Type type;
    private String model;
    private int screenSize;
    private String cpu;
    private String ram;
    private String storage;
    
    public Computer(String id, Type type, String model, int screenSize, String cpu, String ram, String storage) {
        super(id);
        this.type = type;
        this.model = model;
        this.screenSize = screenSize;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
    }
    
    public String getType() {
        if (type.equals(Type.DESKTOP)) {
            return "Desktop";
        } else {
            return "Laptop";
        }
    }
    
    public String getModel() {
        return model;
    }
    
    public int getScreenSize() {
        return screenSize;
    }
    
    public String getCPU() {
        return cpu;
    }
    
    public String getRAM() {
        return ram;
    }
    
    public String getStorage() {
        return storage;
    }
    
    public String classAsString() {
        return "Computer";
    }
    
    public String descriptionString() {
        return (model + ", " + screenSize + " inch screen, " + cpu + " CPU, " + ram + " RAM, " + storage);
    }
}
