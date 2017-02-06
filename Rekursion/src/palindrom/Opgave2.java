package palindrom;

import java.util.ArrayList;

public class Opgave2 {

    public static boolean rekSearch(ArrayList<Integer> list, int target) {
        return rekSearch(list, 0, list.size(), target);
    }
    
    public static boolean rekSearch(ArrayList<Integer> list, int left, int right, int target) {
        int middle = (left + right) / 2;
        int k = list.get(middle);
        if (k == target) {
            return true;
        }
        if (middle == left || middle == right) {
            return false;
        }
        else if (k > target) {
            return rekSearch(list, left, middle - 1, target);
        }
        else {
            return rekSearch(list, middle + 1, right, target);
        }

    }
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(10);
        
        System.out.println(rekSearch(list, 10));
    }
    
}
