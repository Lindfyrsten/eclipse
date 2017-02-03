package opgaver;

/**
 * @author Kristian Lindbjerg
 */
public class Opgave2 {

    public static int power(int n, int p) {
        int result = 0;
        if (p == 0) {
            result = 1;
        }
        else {
            result = power(n, p - 1) * n;
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(power(3, 7));
    }

}
