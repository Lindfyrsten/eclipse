package opgave3;

public class PercentDiscount extends Discount {
    // ===========================================================
    // Fields
    // ===========================================================
    private double percent;

    // ===========================================================
    // Constructors
    // ===========================================================
    public PercentDiscount(double percent) {
        this.percent = percent;
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================
    @Override
    public double getDiscountPrice(double originalPrice) {
        double discount = originalPrice / 100 * percent;
        return originalPrice - discount;
    }
}
