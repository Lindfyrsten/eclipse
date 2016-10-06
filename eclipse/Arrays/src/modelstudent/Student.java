package modelstudent;

/**
 * Klasse der beskriver en studerende
 *
 * @author mad
 *
 */
public class Student {
    /*
     * Attributter der beskriver den studerendes tilstand
     */
    private String name;
    private boolean active;
    private int age;
    
    private int[] grades; // indeholder den studerendes karakterer
    private int numberOfGrades;
    
    private static final int MAX_NUMBER_OF_GRADES = 10;// det hoejeste antal
    // karakterer en studerende kan have
    
    /*
     * Constructor, naar den studerende oprettes, skal den have et navn. Ved
     * oprettelse er den studerende ikke aktiv
     */
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.active = false;
        
        numberOfGrades = 0;
        grades = new int[MAX_NUMBER_OF_GRADES];
    }
    
    /*
     * Man kan få oplyst den studerendes alder, ved at kalde metoden getAlder
     */
    public int getAge() {
        return age;
    }
    
    /*
     * Den studerendes alder kan ændres ved kald af setAlder metoden
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    /*
     * Den studerendes navn kan ændres ved kald af setNavn metoden
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /*
     * Man kan få oplyst den studerendes navn, ved at kalde metoden getNavn
     */
    public String getName() {
        return name;
    }
    
    /*
     * Den studerendes kan faa ændret aktivitets status ved at kalde metoden
     * setStatus
     */
    public void setActive(boolean active) {
        this.active = active;
    }
    
    /*
     * Man kan faa oplyst den studerendes aktivitet, ved at kalde metoden
     * isAktiv
     */
    public boolean isActive() {
        return active;
    }
    
    public void birthday() {
        age++;
    }
    
    /*
     * Tilføjer en karakter til den studerende. Hvis den studerende allerede har
     * 10 karakterer registreres intet
     */
    public void addGrade(int grade) {
        if (numberOfGrades < MAX_NUMBER_OF_GRADES) {
            grades[numberOfGrades] = grade;
            numberOfGrades++;
        }
    }
    
    /*
     * Beregner og returnerer gennemsnittet af de karakterer den studerende har
     * opnået.
     */
    public double averageGrade() {
        int sum = 0;
        double average = 0.0;
        for (int i = 0; i < numberOfGrades; i++) {
            sum = sum + grades[i];
        }
        if (numberOfGrades > 0) {
            average = (double) sum / numberOfGrades;
        }
        return average;
    }
    
    /*
     * Returnerer alle de karakterer den studerende har opnået
     */
    public int[] getGrades() {
        return grades;
    }
    
    /*
     * Returnerer antallet af karakterer den studerende har fået
     */
    public int getNumberOfGrades() {
        return numberOfGrades;
    }
    
    public int findMax(int[] grades) {
        int max = -1;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > max) {
                max = grades[i];
            }
        }
        return max;
    }

    public int findMin(int[] grades) {
        int min = grades[0];
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < min) {
                min = grades[i];
            }
        }
        return min;
    }
}
