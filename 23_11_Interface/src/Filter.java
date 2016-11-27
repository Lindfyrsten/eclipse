
public interface Filter {
    public static boolean accept(Measurable x, Double styrke) {
        if (x.getMeasure() > styrke) {
            return true;
        }
        else {
            return false;
        }
        
    }
}
