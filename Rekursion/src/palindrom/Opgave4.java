package palindrom;

public class Opgave4 {
    public static int binomial(int m, int n) {
        if (m < 0 || n > m) {
            return 0;
        }
        if ((m == n) || (m == 0)) {
            return 1;
        }
        return binomial(m, n - 1) + binomial(m - 1, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(binomial(5, 3));
    }
    
}
