package merge;

import java.util.ArrayList;

/**
 * @author Kristian Lindbjerg
 */
public class TotalFletning {
    /**
    * Returnerer en sorteret ArrayList der indeholder alle
    * elementer fra både s1 og s2
    * Krav: s1 og s2 er sorterede og indeholder Integer
    */
    public static ArrayList<Integer> flet(ArrayList<Integer> s1,
        ArrayList<Integer> s2) {
        ArrayList<Integer> result = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        // flet sålænge der er noget i begge lister
        while (i1 < s1.size() && i2 < s2.size()) {
            if (s1.get(i1).compareTo((s2.get(i2))) <= 0) {
                // s1's første tal er mindst
                result.add(s1.get(i1));
                i1++;
            }
            else { // s2's første tal er mindst
                result.add(s2.get(i2));
                i2++;
            }
        }
        // tøm den liste der ikke er tom
        while (i1 < s1.size()) {
            result.add(s1.get(i1));
            i1++;
        }
        while (i2 < s2.size()) {
            result.add(s2.get(i2));
            i2++;
        }
        return result;
    }
    
    /**
     * Returnerer et sorteret array der indeholder de
     * elementer, der findes både i s1 og s2
     * Krav: s1 og s2 er sorterede
     */
    // total fletning arrays
    public int[] fletArray(int[] s1, int[] s2) {
        int[] result = new int[s1.length + s2.length];
        int i1 = 0;
        int i2 = 0;
        int j = 0;
        // flet sålænge der er noget i begge lister
        while (i1 < s1.length && i2 < s2.length) {
            if (s1[i1] < s2[i2]) { // s1's første tal er mindst
                result[j] = s1[i1];
                i1++;
            }
            else { // s2's første tal er mindst
                result[j] = s2[i2];
                i2++;
                j++;
            }
        }
        // tøm den liste der ikke er tom
        while (i1 < s1.length) {
            result[j] = s1[i1];
            i1++;
            j++;
        }
        while (i2 < s2.length) {
            result[j] = s2[i2];
            i2++;
            j++;
        }
        return result;
    }
}
