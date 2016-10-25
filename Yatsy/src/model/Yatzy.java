package model;

import java.util.Random;

public class Yatzy {
    // Face values of the 5 dice.
    // 1 <= values[i] <= 6.
    private int[] values = new int[5];
    
    // Number of times the 5 dice have been thrown.
    // 0 <= throwCount <= 3.
    private int throwCount = 0;
    
    // Random number generator.
    private Random random = new Random();
    
    public Yatzy() {
        //
    }
    
    /**
     * Returns the 5 face values of the dice.
     */
    public int[] getValues() {
        
        return values;
    }
    
    /**
     * Sets the 5 face values of the dice. Req: values contains 5 face values in
     * [1..6]. Note: This method is only meant to be used for test, and
     * therefore has package visibility.
     */
    void setValues(int[] values) {
        this.values = values;
    }
    
    /**
     * Returns the number of times the 5 dice has been thrown.
     */
    public int getThrowCount() {

        return throwCount;
    }
    
    /**
     * Resets the throw count.
     */
    public void resetThrowCount() {
        throwCount = 0;
    }
    
    /**
     * Rolls the 5 dice. Only roll dice that are not hold. Req: holds contain 5
     * boolean values.
     */
    public void throwDice(boolean[] holds) {
        for (int i = 0; i < holds.length; i++) {
            if (!holds[i]) {
                values[i] = random.nextInt(6) + 1;
            }
        }
        throwCount++;
    }
    
    // -------------------------------------------------------------------------
    
    /**
     * Returns all results possible with the current face values. The order of
     * the results is the same as on the score board. Note: This is an optional
     * method. Comment this method out, if you don't want use it.
     */
    public int[] getResults() {
        int[] results = new int[15];
        for (int i = 0; i <= 5; i++) {
            results[i] = sameValuePoints(i + 1);
        }
        results[6] = onePairPoints();
        results[7] = twoPairPoints();
        results[8] = threeSamePoints();
        results[9] = fourSamePoints();
        results[10] = fullHousePoints();
        results[11] = smallStraightPoints();
        results[12] = largeStraightPoints();
        results[13] = chancePoints();
        results[14] = yatzyPoints();
        
        return results;
    }
    
    // -------------------------------------------------------------------------
    
    // Returns an int[7] containing the frequency of face values.
    // Frequency at index v is the number of dice with the face value v, 1 <= v
    // <= 6.
    // Index 0 is not used.
    private int[] calcCounts() {
        int[] freq = new int[7];

        for (int v : values) {
            freq[v]++;
        }
        return freq;
    }
    
    /**
     * Returns same-value points for the given face value. Returns 0, if no dice
     * has the given face value. Requires: 1 <= value <= 6;
     */
    public int sameValuePoints(int value) {
        int sum = 0;

        for (int v : values) {
            if (v == value) {
                sum += value;
            }
        }
        return sum;
    }
    
    /**
     * Returns points for one pair (for the face value giving highest points).
     * Returns 0, if there aren't 2 dice with the same face value.
     */
    public int onePairPoints() {
        int highestPair = 0;
        int[] freq = calcCounts();
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] >= 2) {
                highestPair = i * 2;
            }
            
        }
        return highestPair;
    }
    
    /**
     * Returns points for two pairs (for the 2 face values giving highest
     * points). Returns 0, if there aren't 2 dice with one face value and 2 dice
     * with a different face value.
     */
    public int twoPairPoints() {
        int sum = 0;
        int paircount = 0;
        int[] freq = calcCounts();
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] >= 2) {
                paircount++;
                sum += i * 2;
            }
            
        }
        if (paircount != 2) {
            sum = 0;
        }
        return sum;
    }
    
    /**
     * Returns points for 3 of a kind. Returns 0, if there aren't 3 dice with
     * the same face value.
     */
    public int threeSamePoints() {
        int sum = 0;
        int[] freq = calcCounts();
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] >= 3) {
                sum = i * 3;
            }
            
        }
        return sum;
    }
    
    /**
     * Returns points for 4 of a kind. Returns 0, if there aren't 4 dice with
     * the same face value.
     */
    public int fourSamePoints() {
        int sum = 0;
        int[] freq = calcCounts();
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] >= 4) {
                sum = i * 4;
            }
            
        }
        return sum;
    }
    
    /**
     * Returns points for full house. Returns 0, if there aren't 3 dice with one
     * face value and 2 dice a different face value.
     */
    public int fullHousePoints() {
        int threeP = 0;
        int twoP = 0;
        int[] freq = calcCounts();
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] >= 3) {
                threeP = i * 3;
            }
            else if (freq[i] >= 2) {
                twoP = i * 2;
            }

        }
        if (threeP == 0 || twoP == 0) {
            threeP = 0;
            twoP = 0;
        }
        return threeP + twoP;
    }
    
    /**
     * Returns points for small straight. Returns 0, if the dice are not showing
     * 1,2,3,4,5.
     */
    public int smallStraightPoints() {
        int sum = 15;
        int[] freq = calcCounts();
        for (int i = 1; i < freq.length - 1; i++) {
            if (freq[i] != 1) {
                sum = 0;
            }
            
        }
        return sum;
    }
    
    /**
     * Returns points for large straight. Returns 0, if the dice is not showing
     * 2,3,4,5,6.
     */
    public int largeStraightPoints() {
        int sum = 20;
        int[] freq = calcCounts();
        for (int i = 2; i < freq.length; i++) {
            if (freq[i] != 1) {
                sum = 0;
            }
            
        }
        return sum;
    }
    
    /**
     * Returns points for chance.
     */
    public int chancePoints() {
        int sum = 0;
        for (int v : values) {
            sum += v;
        }

        return sum;
    }
    
    /**
     * Returns points for yatzy. Returns 0, if there aren't 5 dice with the same
     * face value.
     */
    public int yatzyPoints() {
        int sum = 50;
        int[] freq = calcCounts();
        for (int v : values) {
            if (freq[v] < 5) {
                sum = 0;
            }
            
        }
        return sum;
    }
    
}
