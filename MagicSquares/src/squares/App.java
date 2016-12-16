package squares;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    //side 365 / 368
    public static void main(String[] args) {
        
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        
//        System.out.println("Input n: ");
//        int n = in.nextInt();
//
//        for (int i = 0; i < n * n; i++) {
//            System.out.println(i + " number:");
//            numbers.add(in.nextInt());
//        }
        in.close();

        //test
        int n = 4;
        numbers.add(16);
        numbers.add(3);
        numbers.add(2);
        numbers.add(13);
        numbers.add(5);
        numbers.add(10);
        numbers.add(11);
        numbers.add(8);
        numbers.add(9);
        numbers.add(6);
        numbers.add(7);
        numbers.add(12);
        numbers.add(4);
        numbers.add(15);
        numbers.add(14);
        numbers.add(1);

        System.out.println(doesContainAllNumbers(n, numbers));
        System.out.println(isMagicCube(n, numbers));
    }

    //opg 1
    public static boolean doesContainAllNumbers(int n, ArrayList<Integer> numbers) {
        boolean containsNumbers = true;

        int i = 1;
        while (containsNumbers && i <= n * n) {
            if (!numbers.contains(i)) {
                containsNumbers = false;
            }
            i++;
        }

        return containsNumbers;
    }

    //opg 2
    public static boolean isMagicCube(int n, ArrayList<Integer> numbers) {
        boolean isMagicCube = true;
        int lineResult = (n * (n * n + 1)) / 2;
//        int[][] cube = createCube(n, numbers);
        
        int index = 0;
        for (int row = 0; row < n && isMagicCube; row++) {
            int sum = 0;
            for (int col = 0; col < n; col++) {
                sum += numbers.get(index);
                index++;
            }
            if (sum != lineResult) {
                isMagicCube = false;
            }
        }
        
//        for (int i = 0; i < numbers.size() && isMagicCube; i++) {
//
//        }
        
        return isMagicCube;
    }

//    public static int[][] createCube(int n, ArrayList<Integer> numbers) {
//        int[][] cube = new int[n][n];
//        int index = 0;
//
//        for (int row = 0; row < n; row++) {
//            for (int col = 0; col < n; col++) {
//                cube[row][col] = numbers.get(index);
//                index++;
//            }
//        }
//
//        return cube;
//    }
}
