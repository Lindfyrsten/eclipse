package summering;

import java.util.ArrayList;

public class Opgave2_antalEns {
    public static int antalNul(ArrayList<Integer> list) {
        return count2(list, 0, list.size() - 1);
    }

    public static int count(ArrayList<Integer> list, int l, int h, int count) {
        if (h < l) {
            return count;
        }
        else {
            if (list.get(l) == 0 && list.get(h) == 0 && l != h) {
                return count(list, l + 1, h - 1, count + 2);

            }
            else if (list.get(l) == 0 || list.get(h) == 0) {
                return count(list, l + 1, h - 1, count + 1);
            }
            else {
                return count(list, l + 1, h - 1, count);
            }
        }
    }
    
    public static int count2(ArrayList<Integer> list, int l, int h) {
        int result = 0;
        if (l == h && list.get(l) == 0) {
            result++;
        }
        if (l < h) {
            int m = (l + h) / 2;
            int tal1 = count2(list, l, m);
            int tal2 = count2(list, m + 1, h);
            result += tal1 + tal2;
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        System.out.println(antalNul(list));
    }
    
}
