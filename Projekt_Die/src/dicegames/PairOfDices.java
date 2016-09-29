package dicegames;

/**
 * This class models one pair of dices.
 *
 */
public class PairOfDices {
    /**
     * The first die in the pair.
     */
    private Die die1;
    /**
     * The second die in the pair.
     */
    private Die die2;

    /**
     * attribute that saves the rolls with the dice
     */
    public int totalRolls;
    
    /**
     * saves the record of the dice rolls
     */
    private int rekord;
    
    /**
     * dice side number
     */
    private int one;
    private int two;
    private int three;
    private int four;
    private int five;
    private int six;
    private int pair;
    private int reset;

    /**
     * Constructor that creates two new dies. die1 and die2.
     */
    
    public PairOfDices() {
        this.die1 = new Die();
        this.die2 = new Die();
    }
    
    /** Another constructor with a parameter for the number of sides you want your dice to have.
     *
     */
    
    public PairOfDices(int Sides) {
        this.die1 = new Die(Sides);
        this.die2 = new Die(Sides);
    }
    
    /**
     * the method rollBothDices rolls both dice and counts the number of rolls you do. It  remembers the record of the dice
     * and saves th number of times you rolled ones, two, threes, fours, fives and six and how many times you rolled pairs.
     *
    
     */
    
    public void rollBothDices() {
        die1.roll();
        die2.roll();
        totalRolls++;
        
        if (rekord < getSumOfDices()) {
            rekord = getSumOfDices();
        }
        
        if (die1.getFaceValue() == 1 || die1.getFaceValue() == 1) {
            one++;
            
        }
        else if (die1.getFaceValue() == 1 && die1.getFaceValue() == 1) {
            one = one + 2;
            
        }
        
        if (die1.getFaceValue() == 2 || die1.getFaceValue() == 2) {
            two++;
        }
        
        else if (die1.getFaceValue() == 2 && die1.getFaceValue() == 2) {
            two = two + 2;
            
        }
        
        if (die1.getFaceValue() == 3 || die1.getFaceValue() == 3) {
            three++;
        }
        
        else if (die1.getFaceValue() == 3 && die1.getFaceValue() == 3) {
            three = three + 2;
            
        }
        
        if (die1.getFaceValue() == 4 || die1.getFaceValue() == 4) {
            two++;
        }
        
        else if (die1.getFaceValue() == 4 && die1.getFaceValue() == 4) {
            four = four + 2;
            
        }
        
        if (die1.getFaceValue() == 5 || die1.getFaceValue() == 5) {
            five++;
        }
        
        else if (die1.getFaceValue() == 5 && die1.getFaceValue() == 5) {
            five = five + 2;
            
        }
        
        if (die1.getFaceValue() == 6 || die1.getFaceValue() == 6) {
            six++;
        }
        
        else if (die1.getFaceValue() == 6 && die1.getFaceValue() == 6) {
            six = six + 2;
            
        }
        
        if (die1.getFaceValue() == (die2.getFaceValue())) {
            pair++;
        }
        
    }

    /**
    * method that returns the value of both dice
    * @return
    */
    public int getSumOfDices() {
        return die1.getFaceValue() + die2.getFaceValue();
        
    }

    /**
    * A method where you can reset you game and start over. Sets all the variables to 0.
    */
    public void resetPairOfDice() {
        totalRolls = 0;
        pair = 0;
        rekord = 0;
        one = 0;
        two = 0;
        three = 0;
        four = 0;
        five = 0;
        six = 0;
        
    }

    /**
     * methods returning, pairs, the record and the number of the sides of the dice.
     * @return
     */
    public int getPair() {
        return pair;
    }
    
    public int getRekord() {
        return rekord;
    }
    
    public int getOne() {
        return one;
    }
    
    public int getTwo() {
        return two;
    }
    
    public int getThree() {
        return three;
    }
    
    public int getFour() {
        return four;
    }
    
    public int getFive() {
        return five;
    }
    
    public int getSix() {
        return six;
    }

    public int totalRolls() {
        return totalRolls;
    }

    public int getResetPairOfDice() {
        return reset;
    }
    
}
