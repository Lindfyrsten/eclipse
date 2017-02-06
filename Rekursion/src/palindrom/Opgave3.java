package palindrom;

public class Opgave3 {

    public static int ackermann(int x, int y) {
        if (x == 0) {
            return y + 1;
        }
        if (y == 0) {
            return ackermann(x - 1, 1);
        }
        return ackermann(x - 1, ackermann(x, y - 1));
    }

    public static void main(String[] args) {
        System.out.println(ackermann(1, 0));
    }
    
}
