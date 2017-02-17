package opgaverMapKopi;

import java.util.HashMap;
import java.util.Map;

public class Skole {
    private String navn;
    private Map<Integer, Studerende> studentList;

    public Skole(String navn) {
        this.navn = navn;
        studentList = new HashMap<>();
    }

    public String getNavn() {
        return navn;
    }
    
    public void addStuderende(Studerende studerende) {
        studentList.put(studerende.getStudieNr(), studerende);
    }

    public void removeStuderende(Studerende studerende) {
        studentList.remove(studerende.getStudieNr());
    }
    
    public Map<Integer, Studerende> getStudentList() {
        return studentList;
    }

    public Studerende findStuderende(int studieNr) {
        return studentList.get(studieNr);
    }

    public double gennemsnit() {
        int count = 0;
        for (Studerende s : studentList.values()) {
            int karakter = 0;
            for (Integer i : s.getKarakterer()) {
                karakter += i;
            }
            count += karakter / s.getKarakterer().size();
        }
        return count / studentList.size();
    }

}
