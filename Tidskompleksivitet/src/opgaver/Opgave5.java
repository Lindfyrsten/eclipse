package opgaver;

/**
 * @author Kristian Lindbjerg
 */
public class Opgave5 {

    private static char[] numbers;
    private static char[] helper;

    private static int number;

    public static void sort(char[] values) {
        numbers = values;
        helper = new char[number];
        mergesort(0, values.length - 1);
    }

    private static void mergesort(int low, int high) {
        // check if low is smaller then high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private static void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            }
            else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }

    }
    
    public static void main(String[] args) {
        char[] italiensk_flag = { 'H', 'R', 'G', 'H', 'H', 'R', 'G', 'R', 'H', 'H', 'R', 'G', 'H' };
        System.out.println((italiensk_flag));
        sort(italiensk_flag);
        System.out.println(italiensk_flag);

    }

}
