package opgave3;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainApp {

    public static void main(String[] args) {
        
        Product p1 = new Product(1, "Bog", 99);
        Product p2 = new Product(2, "DVD", 199);
        Product p3 = new Product(3, "Blyant", 5);
        Product p4 = new Product(4, "A4 Papir", 49);
        Product p5 = new Product(5, "Lineal", 29);
        
        Customer c1 = new Customer("Per", LocalDate.of(1985, 7, 15));
        Customer c2 = new Customer("Liz", LocalDate.of(1967, 11, 4));
        
        Order o1 = new Order(1);
        Order o2 = new Order(2);
        Order o3 = new Order(3);
        Order o4 = new Order(4);
        Order o5 = new Order(5);
        Order o6 = new Order(6);
//        Order o7 = new Order(7);
        c1.addOrder(o1);
        c1.addOrder(o2);
        c2.addOrder(o3);
        c2.addOrder(o4);
        c2.addOrder(o5);
        c2.addOrder(o6);
//        c2.addOrder(o7);
        
        o1.createOrderLine(5, p1);
        o1.createOrderLine(10, p5);
        o2.createOrderLine(3, p2);
        o2.createOrderLine(10, p4);
        o3.createOrderLine(25, p3);
        o3.createOrderLine(10, p1);
        o4.createOrderLine(10, p4);
        o4.createOrderLine(5, p2);
        o5.createOrderLine(5, p5);
        o5.createOrderLine(15, p4);
        o6.createOrderLine(50, p3);
        o6.createOrderLine(15, p1);
        
        Discount d1 = new PercentDiscount(15);
        Discount d2 = new FixedDiscount(100, 250);
        c1.setDiscount(d1);
        c2.setDiscount(d2);
        System.out.println(c1.getName() + "'s pris for ordre " + o1.getNumber() + " er "
            + o1.getOrderPrice() + " uden rabat og " + c1.getDiscountPrice(o1) + " med rabat.");
        System.out.println(c2.getName() + "'s pris for ordre " + o3.getNumber() + " er "
            + o3.getOrderPrice() + " uden rabat og " + c2.getDiscountPrice(o3) + " med rabat.");
        
        ArrayList<Customer> kunder = new ArrayList<>();
        kunder.add(c1);
        kunder.add(c2);
        System.out
            .println(c1.getName() + "'s rabat pris for alle ordrer: " + c1.getTotalDiscountPrice());
        System.out
            .println(c2.getName() + "'s rabat pris for alle ordrer: " + c2.getTotalDiscountPrice());
        double originalSum = 0;
        double sum = 0;
        for (Customer k : kunder) {
            sum += k.getTotalDiscountPrice();
            originalSum += k.getTotalPrice();
        }

        System.out.println("Samlet pris for alle ordrer uden rabat:" + originalSum);
        System.out.println("Samlet pris for alle ordrer med rabat:" + sum);
        System.out.println("Samlet rabat besparelse = " + (originalSum - sum));
        
    }
    
}
