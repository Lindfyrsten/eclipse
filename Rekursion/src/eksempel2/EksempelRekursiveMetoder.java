package eksempel2;

public class EksempelRekursiveMetoder {
    
    public static int arealTrekant(int bredde) {
        int result;
        if (bredde == 1) {
            result = 1;
        }
        else {
            result = bredde + arealTrekant(bredde - 1);
        }
        return result;
    }
    
    public static int fib(int n) {
        int result = 0;
        if (n <= 1) {
            result = n;
        }
        else {
            result = fib(n - 1) + fib(n - 2);
        }
        return result;
    }
    
    public static int g(int n) {
        int result;
        if (n == 1) {
            result = 1;
        }
        else if (n == 2) {
            result = 5;
        }
        else {
            result = 5 * g(n - 1) - 6 * g(n - 2);
        }
        return result;
    }
    
    public static void main(String[] args) {
        
        // System.out.println("TrekantAreal(4) " + arealTrekant(4));
        
        // System.out.println("fib(7) " + fib(7));

        // System.out.println("g(4) " + g(4));
        
    }
    
}
