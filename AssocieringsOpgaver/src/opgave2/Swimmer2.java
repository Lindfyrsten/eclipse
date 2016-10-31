package opgave2;

import java.util.ArrayList;

/**
 * Modeling a Swimmer
 */
public class Swimmer2 {
    private String name;
    private String club;
    private int yearGroup;
    private ArrayList<Double> lapTimes;
    private TrainingPlan2 plan;
    
    /**
     * Initialize a new swimmer with name, club, yearGroup, and lap times.
     */

    public Swimmer2(String name, int yearGroup, ArrayList<Double> lapTimes, String club) {
        this.name = name;
        this.yearGroup = yearGroup;
        this.lapTimes = lapTimes;
        this.club = club;
    }

    /**
     * Return the name of the swimmer
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return the yearGroup of the swimmer
     */
    public int getYearGroup() {
        return this.yearGroup;
    }

    /**
     * Return the club of the swimmer
     */
    public String getClub() {
        return this.club;
    }

    /**
     * Register the club of the swimmer
     * @param club
     */
    public void setClub(String club) {
        this.club = club;
    }
    
    /**
     * Return the fastest lap time
     */
    public double bestLapTime() {
        double bestTime = lapTimes.get(0);
        for (Double l : lapTimes) {
            bestTime = Math.min(bestTime, l);
        }

        return bestTime;
    }

    /**
     * Returns the group of this person. Note: Returns null, if this person has
     * no group.
     */
    public TrainingPlan2 getPlan() {
        return this.plan;
    }
    
    /**
     * Sets the group of this person. Note group might be null.
     */
    public void setPlan(TrainingPlan2 plan) {

        this.plan = plan;
        
    }
    
    /**
    * Return how many training hours the swimmer has each week.
    */
    public int allTrainingHours() {
        int hours = 0;
        if (plan != null) {
            hours = plan.getWeeklyStrengthHours() + plan.getWeeklyWaterHours();
        }
        
        return hours;
    }
}
