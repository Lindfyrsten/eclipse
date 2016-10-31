package opgave1;

import java.util.ArrayList;

public class SwimmerApp1 {
    
    public static void main(String[] args) {

        TrainingPlan1 pA = new TrainingPlan1('A', 16, 10);
        TrainingPlan1 pB = new TrainingPlan1('B', 10, 6);

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        Swimmer1 s1 = new Swimmer1("Jan", 1994, lapTimes, "AGF");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        Swimmer1 s2 = new Swimmer1("Bo", 1995, lapTimes, "Lyseng");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);
        Swimmer1 s3 = new Swimmer1("Mikkel", 1993, lapTimes, "AIA-Tranbjerg");
        
        ArrayList<Swimmer1> swimmer1s = new ArrayList<>();
        swimmer1s.add(s1);
        swimmer1s.add(s2);
        swimmer1s.add(s3);
        s1.setPlan(pA);
        s2.setPlan(pA);
        s3.setPlan(pB);
        
        int sum = 0;
        for (Swimmer1 s : swimmer1s) {
            sum += s.allTrainingHours();
            System.out.println(s.getName() + " bedste tid: " + s.bestLapTime());
        }
        System.out.println("Training hours total: " + sum);

    }
    
}
