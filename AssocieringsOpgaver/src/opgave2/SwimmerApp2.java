package opgave2;

import java.util.ArrayList;

public class SwimmerApp2 {
    
    public static void main(String[] args) {

        TrainingPlan2 pA = new TrainingPlan2('A', 16, 10);

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        Swimmer2 s1 = new Swimmer2("Jan", 1994, lapTimes, "AGF");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        Swimmer2 s2 = new Swimmer2("Bo", 1995, lapTimes, "Lyseng");

        ArrayList<Swimmer2> swimmer2s = new ArrayList<>();
        swimmer2s.add(s1);
        swimmer2s.add(s2);
        pA.addSwimmer(s1);
        pA.addSwimmer(s2);

        for (Swimmer2 s : pA.getSwimmers()) {
            System.out.println(s.getName() + ", " + s.getYearGroup() + ", " + s.getClub());
        }
        
    }
    
}
