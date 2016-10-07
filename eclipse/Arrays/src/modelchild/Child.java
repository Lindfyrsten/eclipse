package modelchild;

/**
 * Write a description of class Barn here.
 */
public class Child {
    public static int age;
    private double weight;
    
    public static String name;
    private boolean boy; // true if the child is a boy
    
    public Child(String name, int age, boolean boy) {
        Child.age = age;
        Child.name = name;
        this.boy = boy;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        Child.age = age;
    }
    
    public String getName() {
        return name;
    }

    public boolean isBoy() {
        return boy;
    }
    
    public void setBoy(boolean boy) {
        this.boy = boy;
    }
    
    /**
     * barnets vægt fra 0 til 10 fødselsår
     */
    public double getWeight(int age) {
        double[] ageWeight = { 4.2, 9.3, 12.4, 17.5, 23.2, 25.3, 28.6, 30.4, 33.9, 35.1, 37.3 };
        weight = ageWeight[age];
        return weight;
    }

    public double getIncrease() {
        double år = 0;
        double næsteÅr = 0;
        double forøgning = næsteÅr - år;
        for (int i = 0; i < age; i++) {
            næsteÅr = getWeight(i);

            if (næsteÅr - år > forøgning) {
                forøgning = næsteÅr - år;
            }
            år = getWeight(i);
        }
        return forøgning;
    }

}
