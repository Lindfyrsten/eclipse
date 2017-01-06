package model;

import java.util.ArrayList;

/**
 * @author Lindbjerg
 */
public class Forloeb {
    private String aktoer;
    private ArrayList<String> systembesker = new ArrayList<>();

    public Forloeb(ArrayList<String> systembeskeder) {
        this.systembesker = systembeskeder;
        
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
    
    @Override
    public String toString() {
        return aktoer;
    }
}
