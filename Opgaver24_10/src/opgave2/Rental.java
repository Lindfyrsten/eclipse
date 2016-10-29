package opgave2;

import java.time.LocalDate;

public class Rental {
    private int number;
    private int days;
    private LocalDate startDate;
    private double price;

    public Rental(int number, int days, double price, LocalDate startDate) {
        
        this.number = number;
        this.days = days;
        this.price = price;
        this.startDate = startDate;
    }

    public double getPricePrDay() {
        return price;

    }

    public int setDays(int days) {
        return days;
    }

    public int getDays() {
        return days;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {

        return startDate.plusDays(days);
    }
    
}
