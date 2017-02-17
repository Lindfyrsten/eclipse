package opgave5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LaesFilTilTreeMap {
    
//    private static Map<Integer, String> newMap = new TreeMap<>();
    private static Map<String, Integer> output;
    
    public static void main(String[] args) throws FileNotFoundException {
        output = new TreeMap<>();
        File file = new File("Gjøngehøvdingen.txt");
        Scanner scan = new Scanner(file);
        scan.useDelimiter("(\\p{javaWhitespace}|\\.|,|:|;|\\?|\"|!|-)+");
        while (scan.hasNext()) {
            String s = scan.next().toLowerCase();
            if (!output.containsKey(s)) {
                output.put(s, 1);
            }
            else {
                int i = output.get(s).intValue();
                output.remove(s);
                output.put(s, i + 1);
            }
        }
        scan.close();
        System.out.println(output);
        System.out.println("Unikke ord: " + output.size());
//        Map<String, Integer> sortedMap = new TreeMap<>(new ValueComparator(output));
//        sortedMap.putAll(output);
//        System.out.println(sortedMap);

//        String[] str = new String[output.size()];
//        int i = 0;
//        for (String s : output.keySet()) {
//            str[i] = s;
//            i++;
//        }
//        i = 0;
//        for (int j : output.values()) {
//            newMap.put(j, str[i]);
//            i++;
//        }
//
//        System.out.println(newMap);

    }
    
}
