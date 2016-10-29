package opgave2;

import java.time.LocalDate;
import java.time.Period;

public class rentApp {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Rental r = new Rental(1, 7, 3000, LocalDate.of(2016, 11, 01));
        Rental r2 = new Rental(2, 14, 100, LocalDate.now().plusMonths(10));
        System.out.println("Pris per dag: " + r.getPricePrDay() * r.getDays());
        System.out.println("Skal afleveres: " + r.getEndDate());
        System.out.println("Dagen før er: " + r.getEndDate().minusDays(1));
        System.out.println("*************************************************");
        System.out.println("Pris per dag: " + r2.getPricePrDay() * r2.getDays());
        System.out.println("Skal afleveres: " + r2.getEndDate());
        System.out.println("Dagen før er: " + r2.getEndDate().minusDays(1));
        System.out.println("*************************************************");

        Period per = r.getStartDate().until(r2.getStartDate());
        System.out
            .println("Forskel mellem startdagene: " + per.getDays());
    }
    
}
