
public class Loekker {
    public void udskriv1_10() {
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");

    }

    public void udskriv1_10_iteration() {
        int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }
    }

    public int summer() {
        int sum = 0;
        int i = 1;
        while (i <= 10) {
            sum = sum + i;
            i++;
        }
        return sum;

    }

    public int summer(int n) {
        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum = sum + i;
            i++;
        }
        return sum;

    }

    public int multiplum(int a, int b) {
        int resultat = 0;
        int i = 0;
        while (i < a) {
            resultat = resultat + b;
            i++;
        }
        return resultat;

    }

    public int summerEven(int n) {
        int sum = 0;
        int i = 2;
        while (i <= n) {
            sum = sum + i;
            i++;
            i++;
        }
        return sum;
    }

    public int summerSquare() {
        // TODO Exercise P5.1B
        return -1;
    }

    public void allPowers() {
        // TODO Exercise P5.1C
    }

    public int sumOdd(int a, int b) {
        // TODO Exercise P51.D
        return -1;
    }

    public int sumOfOddDigits(int number) {
        // TODO Exercise P5.1E
        return -1;
    }
}
