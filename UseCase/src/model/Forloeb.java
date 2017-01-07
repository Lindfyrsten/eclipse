package model;

import java.util.ArrayList;

/**
 * @author Lindbjerg
 */
public class Forloeb {
    private String aktoer;
    private ArrayList<String> systembesker = new ArrayList<>();
    
    public Forloeb(String aktoer, ArrayList<String> systembeskeder) {
        this.systembesker = systembeskeder;
        this.aktoer = aktoer;

    }
    
    public String getAktoer() {
        return aktoer;
    }
    
    public void setAktoer(String aktoer) {
        this.aktoer = aktoer;
    }
    
    public ArrayList<String> getSystembesker() {
        return new ArrayList<>(systembesker);
    }

    public void addSystem(String system) {
        systembesker.add(system);
    }
    
    public void setSystembesker(ArrayList<String> systembesker) {
        this.systembesker = systembesker;
    }
    
    @Override
    public String toString() {
        return aktoer;
    }
}
