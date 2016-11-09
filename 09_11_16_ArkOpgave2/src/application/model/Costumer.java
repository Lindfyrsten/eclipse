package application.model;

public class Costumer {
    private String name;
    
    public Costumer(String name) {
        this.name = name;
    }
    
    private void setName(String name) {
        this.name = name;
        
    }

    private String getName() {
        return name;
    }
}
