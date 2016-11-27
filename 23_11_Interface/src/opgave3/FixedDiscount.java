/**
 *
 */
package opgave3;

/**
 * @author Kristian
 */
public class FixedDiscount implements Discount {

    // ===========================================================
    // Fields
    // ===========================================================
    private double priceLoft, rabat;

    // ===========================================================
    // Constructors
    // ===========================================================
    public FixedDiscount(double priceLoft, double rabat) {
        this.priceLoft = priceLoft;
        this.rabat = rabat;
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================
    @Override
    public double getDiscountPrice(double originalPrice) {
        double discountPrice = originalPrice;
        if (originalPrice >= priceLoft) {
            discountPrice -= rabat;
        }
        return discountPrice;
    }
}
