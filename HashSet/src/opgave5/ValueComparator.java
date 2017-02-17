package opgave5;

import java.util.Comparator;
import java.util.Map;

public class ValueComparator implements Comparator<String> {
    Map map;
    
    public ValueComparator(Map map) {
        this.map = map;
    }
    
    @Override
    public int compare(String o1, String o2) {
        return (int) map.get(o2) - (int) map.get(o1);
    }
    
}