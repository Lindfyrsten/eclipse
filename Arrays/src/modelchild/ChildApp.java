package modelchild;

import java.util.Arrays;

public class ChildApp {
    
    public static void main(String[] args) {
        Institution Huset = new Institution("Haven", "Langenæs");
        Child Kristian = new Child("Kristian", 4, true);// boy 4 years old
        Huset.addChild(Kristian);
        Child Per = new Child("Per", 7, true);
        Huset.addChild(Per);
        Child Inger = new Child("Inger", 1, false);
        Huset.addChild(Inger);
        
//        System.out.print("Et barn på " + Kristian.getAge() + " år ");
//        System.out.println("vejer " + Kristian.getWeight(Kristian.getAge()));
//        System.out
//            .println(
//                "Største årlige vægtforøgning var " + String.format("%.2f", Kristian.getIncrease())
//                    + "kg.");

        System.out
            .println("Børn i " + Huset.getNavn() + ", " + Huset.getAddresse()
                + ": " + Arrays.toString(Huset.getBørn()));
        System.out.println("Gennemsnitlige alder er: " + Huset.averageAge());
        System.out.println("Antal piger: " + Huset.numberOfGirls());
        System.out.println("Antal drenge: " + Huset.numberOfBoys());

    }
    
}
