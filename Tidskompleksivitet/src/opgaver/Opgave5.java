package opgaver;

/**
 * @author Kristian Lindbjerg
 */
public class Opgave5 {
    
    private static char[] numbers;
    private static char[] helper;
    
    public static void sort(char[] values) {
        numbers = values;
        helper = new char[values.length];
        mergesort(0, values.length - 1);
    }
    
    private static void mergesort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergesort(low, middle);
            mergesort(middle + 1, high);
            merge(low, middle, high);
        }
    }
    
    private static void merge(int low, int middle, int high) {
        
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }
        
        int i = low;
        int j = middle + 1;
        int k = low;
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
