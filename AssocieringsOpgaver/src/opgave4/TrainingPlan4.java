package opgave4;

import java.util.ArrayList;

/**
 * Models a training plan for a Swimmer
 */
public class TrainingPlan4 {
    private char level;
    private int weeklyWaterHours;
    private int weeklyStrengthHours;
    private ArrayList<Swimmer4> swimmers = new ArrayList<>();

    public TrainingPlan4(char level, int weeklyWaterHours, int weeklyStrengthHours) {
        this.level = level;
        this.weeklyWaterHours = weeklyWaterHours;
        this.weeklyStrengthHours = weeklyStrengthHours;
    }

    public char getLevel() {
        return level;
    }

    public void setLevel(char niveau) {
        this.level = niveau;
    }

    public int getWeeklyStrengthHours() {
        return weeklyStrengthHours;
    }

    public void setWeeklyStrengthHours(int weeklyStrengthHours) {
        this.weeklyStrengthHours = weeklyStrengthHours;
    }

    public int getWeeklyWaterHours() {
        return weeklyWaterHours;
    }

    public void setWeeklyWaterHours(int weeklyWaterHours) {
        this.weeklyWaterHours = weeklyWaterHours;
    }

    public ArrayList<Swimmer4> getSwimmers() {
        return new ArrayList<>(swimmers);
    }

    public void addSwimmer(Swimmer4 swimmer) {
        swimmers.add(swimmer);

        if (swimmer.getPlan() != this) {
            swimmer.setPlan(this);
        }
    }

    public void removeSwimmer(Swimmer4 swimmer) {
        swimmers.remove(swimmer);
        if (swimmer.getPlan() == this) {
            swimmer.setPlan(null);
        }
    }

}
