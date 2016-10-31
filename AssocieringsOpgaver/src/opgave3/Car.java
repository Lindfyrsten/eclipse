/**
 *
 */
package opgave3;

/**
 * @author Kristian
 */
public class Car {
    // ===========================================================
    // Fields
    // ===========================================================
    private String license;
    private double pricePerDay;
    private int purchaseYear;

    // ===========================================================
    // Constructors
    // ===========================================================
    /**
     * Opret ny bil
     * @param license
     * @param year
     */
    public Car(String license, int year) {
        this.license = license;
        this.purchaseYear = year;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================
    public void setDayPrice(double price) {
        this.pricePerDay = price;
    }

    public double getDayPrice() {
        return pricePerDay;
    }

    public String getLicense() {
        return license;
    }
    
    public int getPurchaseYear() {
        return purchaseYear;
    }
    // ===========================================================
    // Methods
    // ===========================================================
}
