package opgaver;

public class Person {
    private final String name;
    private String title;
    
    private String email;
    private boolean senior;
    
    public Person(String name) {
        this.name = name;
    }
    
    public Person(String name, String title, boolean senior) {
        this.name = name;
        this.title = title;
        this.senior = senior;
    }
    
    public String getName() {
        return name;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public boolean isSenior() {
        return senior;
    }
    
    public void setSenior(boolean senior) {
        this.senior = senior;
    }
    
    @Override
    public String toString() {
        String s = name;
        if (title != null) {
            s = title + " " + name;
        }
        
        if (senior) {
            s = s + " (senior)";
        }
        return s;
    }
    
}
