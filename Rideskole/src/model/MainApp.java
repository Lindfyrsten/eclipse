package model;

public class MainApp {
    
    public static void main(String[] args) {
        
        Rideskole skole = new Rideskole("Rideskolen");
        Hest h1 = new Hest("Samson", 1998);
        Hoppe h2 = new Hoppe("Suzi", 2006);
        Hest h3 = new Hest("Blackie", 1999);
        Hoppe h4 = new Hoppe("Flicka", 2010);

        h2.setAntalFoel(3);
        h4.setAntalFoel(1);

        skole.addHest(h1);
        skole.addHest(h2);
        skole.addHest(h3);
        skole.addHest(h4);

        System.out.println(skole.getHeste());
        System.out.println(skole.getYngsteHest());
    }
    
}
