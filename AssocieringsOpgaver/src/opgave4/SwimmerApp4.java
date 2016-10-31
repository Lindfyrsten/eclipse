package opgave4;

import java.util.ArrayList;

public class SwimmerApp4 {

    public static void main(String[] args) {
        
        TrainingPlan4 pA = new TrainingPlan4('A', 16, 10);
        TrainingPlan4 pB = new TrainingPlan4('B', 10, 6);
        
        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        Swimmer4 s1 = new Swimmer4("Jan", 1994, lapTimes, "AGF");
        
        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        Swimmer4 s2 = new Swimmer4("Bo", 1995, lapTimes, "Lyseng");
        
        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);
        Swimmer4 s3 = new Swimmer4("Mikkel", 1993, lapTimes, "AIA-Tranbjerg");

        ArrayList<Swimmer4> swimmer4s = new ArrayList<>();
        swimmer4s.add(s1);
        swimmer4s.add(s2);
        swimmer4s.add(s3);
        s1.setPlan(pA);
        s2.setPlan(pA);
        s3.setPlan(pB);
        
        System.out.println("Plan A:");
        for (Swimmer4 s : pA.getSwimmers()) {
            System.out.println(s.getName() + ", " + s.getYearGroup() + ", " + s.getClub());
        }
        System.out.println("Plan B:");
        for (Swimmer4 s : pB.getSwimmers()) {
            System.out.println(s.getName() + ", " + s.getYearGroup() + ", " + s.getClub());
        }
        s1.setPlan(pB);
        
        System.out.println("Plan A:");

        for (Swimmer4 s : pA.getSwimmers()) {
            System.out.println(s.getName() + ", " + s.getYearGroup() + ", " + s.getClub());
        }
        System.out.println("Plan B:");
        for (Swimmer4 s : pB.getSwimmers()) {
            System.out.println(s.getName() + ", " + s.getYearGroup() + ", " + s.getClub());
        }
        pB.removeSwimmer(s1);
        System.out.println("Plan B:");
        for (Swimmer4 s : pB.getSwimmers()) {
            System.out.println(s.getName() + ", " + s.getYearGroup() + ", " + s.getClub());
        }

    }

}
