package merge;

import java.util.ArrayList;

/**
 * @author Kristian Lindbjerg
 */
public class FællesFletning {
    /**
     * Returnerer en sorteret ArrayList der KUN indeholder de
     * elementer, der findes både i s1 og s2
     * Krav: f1 og f2 er sorterede og indeholder Integer
     */
    public ArrayList<Integer> intersection(
        ArrayList<Integer> s1, ArrayList<Integer> s2) {
        ArrayList<Integer> result = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < s1.size() && i2 < s2.size()) {
            if (s1.get(i1) < s2.get(i2)) {
                i1++;
            }
            else
                if (s1.get(i1) > s2.get(i2)) {
                    i2++;
                }
                else {
                    result.add(s1.get(i1));
                    i1++;
                    i2++;
                }
        }
        return result;
    }

}
