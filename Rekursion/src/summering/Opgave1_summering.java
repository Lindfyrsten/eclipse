package summering;

import java.util.ArrayList;

public class Opgave1_summering {
    
    public static int sum(ArrayList<Integer> list) {
        return summering(list, 0, list.size() - 1);
    }
    
    public static int summering(ArrayList<Integer> list, int l, int h) {
        if (l == h) {
            return list.get(l);
        }
        else {
            int m = (l + h) / 2;
            int sum1 = summering(list, l, m);
            int sum2 = summering(list, m + 1, h);
            return sum1 + sum2;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(sum(list));
    }
}
