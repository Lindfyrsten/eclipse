package arrrayList;

import java.util.ArrayList;
import java.util.Random;

public class ListGenerator {
    private static final String chars = "abcdefghijklmnopqrstuvwxyzæøå";
    private static Random random = new Random(42);
    
    public static ArrayList<String> generateString(int listSize, int maxWordSize) {
        ArrayList<String> result = new ArrayList<String>();
        
        for (int j = 0; j < listSize; j++) {
            StringBuilder sb = new StringBuilder();
            int wordSize = random.nextInt(maxWordSize - 5) + 5;
            for (int i = 0; i < wordSize; i++) {
                sb.append(chars.charAt(random.nextInt(chars.length())));
            }
            result.add(sb.toString());
        }
        
        return result;
    }
}
