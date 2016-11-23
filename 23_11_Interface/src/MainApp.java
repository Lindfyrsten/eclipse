public class MainApp {
    
    public static void main(String[] args) {
        Measurable m1 = new Chili("Black python", 500);
        Measurable m2 = new Chili("Ghost chili", 1000);
        Measurable m3 = new Chili("Granny pepper", 45.5);
        
        Measurable[] chilis = { m1, m2, m3 };
        
        System.out.println(Data.avg(chilis));
        System.out.println(Data.max(chilis).getMeasure());
    }
    
}
