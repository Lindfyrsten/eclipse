package nedarvning;
public class NedarvningTest {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Person:");
        
        Teacher teacher = new Teacher("Hanne", "Sydbakken 27", "Datalog", 35000);
        
        Student student = new Student("Margrethe", "Ringvej 7", "STX", 9.5, "DMU01");
        
        teacher.udskrivPerson();
        
        System.out.println();
        
        System.out.println("Student:");
        
        student.udskrivPerson();// kalder overrided metode
        
        System.out.println();
        
        student.udskrivAdresse(); // kalder egen metode
        
        System.out.println(student.getName()); // kalder nedarvet metode
        
    }
    
}
