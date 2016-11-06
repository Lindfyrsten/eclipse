/**
 *
 */
package opgave1;

/**
 * @author Kristian
 */
public class CarRentApp {
    
    public static void main(String[] args) {

        Car c1 = new Car("AYD-15", 1995);
        Car c2 = new Car("BLARW-71", 2010);
        Car c3 = new Car("GJEGOssY", 2016);
        Car c4 = new Car("IRHJRH", 1990);
        Car c5 = new Car("59GHGWJO", 1987);
        c1.setDayPrice(50);
        c2.setDayPrice(75);
        c3.setDayPrice(60);
        c4.setDayPrice(100);
        c5.setDayPrice(30);

        Rental r1 = new Rental(1, "10/31/2016", 14);
        r1.addCar(c1);

        Rental r2 = new Rental(4, "10/31/2016", 7);

        r2.addCar(c2);
        r2.addCar(c3);
        r2.addCar(c4);
        r2.addCar(c5);
        
        System.out.println("Pris for rental 1: " + r1.getPrice() + " kr.");
        System.out.println("Pris for rental 2: " + r2.getPrice() + " kr.");

        System.out.print("Biler i rental 1: ");
        for (int i = 0; i < r1.getCars().size(); i++) {
            System.out.print(r1.getCars().get(i).getLicense() + ", ");
        }
        System.out.println();
        
        System.out.print("Biler i rental 2: ");
        for (int i = 0; i < r2.getCars().size(); i++) {
            System.out.print(r2.getCars().get(i).getLicense() + ", ");
        }
        System.out.println();
        
        c2.setRentgroup(r1);
        
        System.out.print("Biler i rental 1: ");
        for (int i = 0; i < r1.getCars().size(); i++) {
            System.out.print(r1.getCars().get(i).getLicense() + ", ");
        }
        System.out.println();

        System.out.print("Biler i rental 2: ");
        for (int i = 0; i < r2.getCars().size(); i++) {
            System.out.print(r2.getCars().get(i).getLicense() + ", ");
        }
        System.out.println();
        
        System.out.println("Flest antal dage lejet ud for bil c2: " + c2.getMaxRentDays());
    }

}
