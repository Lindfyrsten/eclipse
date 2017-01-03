package interfaces;
public class MainApp {

    public static void main(String[] args) {
        Measurable m1 = new Chili("Black python", 5005);
        Measurable m2 = new Chili("Ghost chili", 8000);
        Measurable m3 = new Chili("Granny pepper", 1000);

        Measurable[] chilis = { m1, m2, m3 };

        System.out.print("Avg styrke: ");
        System.out.println(Data.avg(chilis));
        System.out.print("Max styrke: ");
        System.out.println(Data.max(chilis).getMeasure());
        
        //opgave 3 - filter
        System.out.print("Avg med filter på 5000: ");
        System.out.println(Data.avg(chilis, 5000));
        System.out.print("Max med filter på 5000: ");
        System.out.println(Data.max(chilis, 5000).toString());
    }
    
}
