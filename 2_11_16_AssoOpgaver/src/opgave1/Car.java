/**
 *
 */
package opgave1;

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
    private Rental rentGroup;
    private int maxRentDays = 0;

    // ===========================================================
    // Constructors
    // ===========================================================
    /**
     * Opret ny bil
     * @param license
     * @param year
     */
    //----------------------------------------------------------
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

    public Rental getRentGroup() {
        return rentGroup;
    }

    public void setRentgroup(Rental rentGroup) {

        Rental oldGrp = this.rentGroup;
        this.rentGroup = rentGroup;

        if (oldGrp != null) {
            oldGrp.removeCar(this);
        }

        if (rentGroup != null && !rentGroup.getCars().contains(this)) {
            rentGroup.addCar(this);
        }
        
    }

    public int getMaxRentDays() {
        return maxRentDays;
    }

    public void setMaxRentDays(int days) {
        maxRentDays = days;
        
    }
    
}
