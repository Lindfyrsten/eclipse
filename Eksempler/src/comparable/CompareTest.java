package comparable;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Kristian Lindbjerg
 */
public class CompareTest {
    
    public static void main(String[] args) {

        ArrayList<ComparePersonExample> personer = new ArrayList<>();
        ComparePersonExample p1 = new ComparePersonExample("Per", 16);
        ComparePersonExample p2 = new ComparePersonExample("Allan", 16);
        ComparePersonExample p3 = new ComparePersonExample("Ole", 14);
        
        //Usorteret liste
        personer.add(p1);
        personer.add(p2);
        personer.add(p3);
        System.out.println(personer);
        
        //Sorteret liste
        Collections.sort(personer);
        System.out.println(personer);
    }
    
}
