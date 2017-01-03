package sortering;

import java.util.ArrayList;

public class SelectionSort {
    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
    
    private static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    private static void swap(ArrayList<Customer> arrayList, int i, int j) {
        Customer toMove = arrayList.get(i);
        arrayList.set(i, arrayList.get(j));
        arrayList.set(j, toMove);
    }
    
    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[minPos]) {
                    minPos = j;
                }
                
            }
            swap(list, i, minPos);
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

    public static void selectionSortCustomer(ArrayList<Customer> array) {

        for (int i = 0; i < array.size(); i++) {
            int minPos = i;
            for (int j = i + 1; j < array.size(); j++) {
                if ((array.get(j)).compareTo(array.get(minPos)) < 0) {
                    minPos = j;
                }

            }
            
            swap(array, i, minPos);
        }
    }

}
