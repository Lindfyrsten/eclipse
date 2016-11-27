
public class Data implements Filter {
    public static Measurable max(Measurable[] objects) {
        double max = 0;
        Measurable objMax = null;

        for (Measurable obj : objects) {
            if (obj.getMeasure() > max) {
                max = obj.getMeasure();
                objMax = obj;
            }
        }
        return objMax;
    }

    public static double avg(Measurable[] objects) {
        double sum = 0;

        for (Measurable obj : objects) {
            sum += obj.getMeasure();
        }
        if (objects.length > 0) {
            return sum / objects.length;
        }
        else {
            return 0;
        }
    }
    
    public static double avg(Measurable[] objects, double styrke) {
        double sum = 0;
        double filterNr = 0;
        for (Measurable obj : objects) {
            if (Filter.accept(obj, styrke)) {

                sum += obj.getMeasure();
                filterNr++;
            }
        }
        if (objects.length > 0) {
            return sum / filterNr;
        }
        else {
            return 0;
        }
    }
    
    public static Measurable max(Measurable[] objects, double styrke) {
        double max = 0;
        Measurable objMax = null;

        for (Measurable obj : objects) {
            if (Filter.accept(obj, styrke)) {

                if (obj.getMeasure() > max) {
                    max = obj.getMeasure();
                    objMax = obj;
                }
            }
        }
        
        return objMax;
    }

}
