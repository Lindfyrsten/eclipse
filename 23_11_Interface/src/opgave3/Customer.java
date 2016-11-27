package opgave3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Models a Customer with Orders.
 */
public class Customer {
    private String name;
    private LocalDate birthday;
    private List<Order> orders = new ArrayList<>();
    private Discount discount;
    
    /**
     * Create a new Customer.
     * @param name the name.
     * @param birthday birthday of the customer.
     */
    public Customer(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public LocalDate getBirthday() {
        return this.birthday;
    }
    
    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getDiscountPrice(Order order) {

        return discount.getDiscountPrice(order.getOrderPrice());
    }
    
    public double getTotalDiscountPrice() {
        double sum = 0;
        for (Order o : orders) {
            sum += getDiscountPrice(o);
        }
        return sum;
    }

    public double getTotalPrice() {
        double sum = 0;
        for (Order o : orders) {
            sum += o.getOrderPrice();
        }
        return sum;
    }

}
