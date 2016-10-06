package modelchild;

public class Institution {

    public String[] børn;
    public int[] alder;
    private String navn;
    private String addresse;
    private int numberOfChildren;
    private int MAX_NUMBER_OF_CHILDREN = 10;
    private int dreng = 0;
    private int pige = 0;
    private boolean[] køn;
    
    public Institution(String navn, String addresse) {
        this.navn = navn;
        this.addresse = addresse;
        
        børn = new String[MAX_NUMBER_OF_CHILDREN];
        alder = new int[MAX_NUMBER_OF_CHILDREN];
        køn = new boolean[MAX_NUMBER_OF_CHILDREN];
        numberOfChildren = 0;
        
    }
    
    public String getNavn() {
        return navn;
    }
    
    public void setNavn(String navn) {
        this.navn = navn;
    }
    
    public String getAddresse() {
        return addresse;
    }
    
    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }
    
    public void addChild(Child child) {
        
        if (numberOfChildren < MAX_NUMBER_OF_CHILDREN) {
            børn[numberOfChildren] = child.getName();
            alder[numberOfChildren] = child.getAge();
            køn[numberOfChildren] = child.isBoy();
            numberOfChildren++;
        }
        
    }
    
    public double averageAge() {
        int sum = 0;
        
        double average = 0.0;
        for (int i = 0; i < numberOfChildren; i++) {
            sum = sum + alder[i];
        }
        if (numberOfChildren > 0) {
            average = (double) sum / numberOfChildren;
        }
        return average;

    }

    public int numberOfBoys() {
        for (int i = 0; i < numberOfChildren; i++) {
            if (køn[i]) {
                dreng++;
            }
        }
        return dreng;
    }
    
    public int numberOfGirls() {
        for (int i = 0; i < numberOfChildren; i++) {
            if (!køn[i]) {
                pige++;
            }
        }
        return pige;
    }
    
    public String[] getBørn() {
        for (int i = 0; i < børn.length; i++) {
            if (børn[i] == null) {
                børn[i] = "tom plads";
            }
        }
        
        return børn;
    }

}
