public class Teacher extends Person {

    private double yearlySalary;
    private double monthlySalary;

    public Teacher(String name, String address, String qualification, double monthlySalary) {
        super(name, address, qualification); // kalder constructoren i
        // superklassen, dette kald skal ske som det første i metoden

        this.monthlySalary = monthlySalary;
    }
    
    public void udskrivAdresse() {
        System.out.println("Adresseoplysninger: " + address);

    }
    
    public double yearlySalary() {
        
        yearlySalary = monthlySalary * 12 * 1.125;
        return yearlySalary;

    }

    @Override
    public void udskrivPerson() { // løsning på udskriv, hvor vi
        // udnytter, at der er en udskriv i superklassen
        super.udskrivPerson(); // nødvendigt med super for ikke at kalde sig
        // selv.
        System.out.println("Månedsløn: " + monthlySalary);
        System.out.printf("Årlig løn: " + "%.2f", yearlySalary());

    }

}
