package measure;

public class SortMethods {
    
    private static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void bubbleSort(String[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
    
    public static void insertionSort(String[] array) {
        for (int i = 1; i < array.length; i++) {
            String next = array[i];
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.compareTo(array[j - 1]) > 0) {
                    found = true;
                }
                else {
                    array[j] = array[j - 1];
                    j--;
                }
            }
            array[j] = next;
        }
    }
    
    public static void selectionSort(String[] array) {
        for (int i = 0; i < array.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minPos]) < 0) {
                    minPos = j;
                }

            }
            swap(array, i, minPos);
        }
    }

    public static boolean findEnsIRække(String s, int k) {
        boolean same = false;
        int i = 0;
        while (i < s.length() - k) {
            same = true;
            char compare = s.charAt(i);
            int j = 1;
            while (same && j < k) {
                
                if (s.charAt(i + j) == compare) {
                    j++;
                }
                else {
                    same = false;
                }

            }
            i++;
        }
        return same;

    }
    
}
