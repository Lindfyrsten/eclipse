/**
 *
 */
package opgave1;

import java.util.ArrayList;

/**
 * @author Kristian
 */
public class Rental {
    // ===========================================================
    // Fields
    // ===========================================================
    private int days;
    private ArrayList<Car> cars = new ArrayList<>();

    // ===========================================================
    // Constructors
    // ===========================================================
    public Rental(int number, String date, int days) {
//        this.number = number;
//        this.date = date;
        this.days = days;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================
    public double getPrice() {
        double sum = 0;
        for (Car c : cars) {
            sum += c.getDayPrice() * days;
        }
        return sum;
    }
    
    public void setDays(int days) {
        this.days = days;
    }
    
    public int getDays() {
        return days;
    }

    public ArrayList<Car> getCars() {
        return new ArrayList<>(cars);
    }
    
    public void addCar(Car car) {
        cars.add(car);
        if (car.getMaxRentDays() < this.days) {
            car.setMaxRentDays(days);
        }
        if (car.getRentGroup() != this) {
            car.setRentgroup(this);
        }
    }

    public void removeCar(Car car) {
        cars.remove(car);
        if (car.getRentGroup() == this) {
            car.setRentgroup(null);
        }
    }
    // ===========================================================
    // Methods
    // ===========================================================
}
