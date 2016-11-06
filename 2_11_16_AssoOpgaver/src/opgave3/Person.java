package opgave3;

import java.util.ArrayList;

/**
 * @author Kristian
 */
public class Person {
    // ===========================================================
    // Fields
    // ===========================================================
    private String name;
    private int age;
    private ArrayList<Gift> gifts = new ArrayList<>();
    private ArrayList<Person> givers = new ArrayList<>();

    // ===========================================================
    // Constructors
    // ===========================================================
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================
    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Gift> getGifts() {
        return gifts;
    }
    
    public ArrayList<Person> getGivers() {
        
        return givers;
        
    }

    // ===========================================================
    // Methods
    // ===========================================================
    
    @Override
    public String toString() {
        
        return name + " " + age;
    }
    
    public void recieves(Gift gift) {
        gifts.add(gift);
        givers.add(gift.getGiver());
    }
    
//    public void gives(Gift gift, Person person) {
//        person.recieves(gift);
//        person.getGivers().add(this);
//
//    }
    
    public double getGiftPrices() {
        double sum = 0;

        for (Gift g : gifts) {
            sum += g.getPrice();
        }
        return sum;
    }
    
    public Gift mostExpensiveGift() {
        Gift gMax = null;
        double max = 0;
        for (Gift g : gifts) {
            if (g.getPrice() > max) {
                max = g.getPrice();
                gMax = g;

            }
        }
        return gMax;
    }

}
