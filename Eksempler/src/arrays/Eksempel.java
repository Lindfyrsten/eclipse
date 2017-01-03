package arrays;

import java.util.Arrays;

/**
 * @author Kristian Lindbjerg
 */
public class Eksempel {

    public static void main(String[] args) {

        final int MAX_SIZE = 10;
        int[] array = new int[MAX_SIZE];

        // kopier array

        int[] kopi = Arrays.copyOfRange(array, 0, array.length);
        System.out.println(Arrays.toString(kopi));

    }
}
