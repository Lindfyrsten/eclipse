package opgaver;

/**
 * @author Kristian Lindbjerg
 */
public class Opgave1 {
    
    public static void main(String[] args) {
        System.out.println(factorial(0));
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        else {
            return n * factorial(n - 1);
        }

    }

}
