/**
 *
 */
package opgave3;

/**
 * @author Kristian
 */
public class Gift {
    // ===========================================================
    // Fields
    // ===========================================================
    private String description;
    private double price;
    private Person giver;

    // ===========================================================
    // Constructors
    // ===========================================================
    Gift(String description, Person giver) {
        this.giver = giver;
        this.description = description;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================
    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    
    public Person getGiver() {
        return giver;
    }
    
    public String getDescription() {
        return description;
    }

    // ===========================================================
    // Methods
    // ===========================================================
}
