package opgaverSetKopi;

import java.util.Set;
import java.util.TreeSet;

public class Skole {
    private String navn;
    private TreeSet<Studerende> studentList;
    
    public Skole(String navn) {
        this.navn = navn;
        studentList = new TreeSet<>();
    }
    
    public String getNavn() {
        return navn;
    }

    public void addStuderende(Studerende studerende) {
        studentList.add(studerende);
    }
    
    public void removeStuderende(Studerende studerende) {
        studentList.remove(studerende);
    }

    public Set<Studerende> getStudentList() {
        return studentList;
    }
    
    public Studerende findStuderende(int studieNr) {
        for (Studerende s : studentList) {
            if (s.getStudieNr() == studieNr) {
                return s;
            }
        }
        return null;
    }
    
    public double gennemsnit() {
        int count = 0;
        for (Studerende s : studentList) {
            int karakter = 0;
            for (Integer i : s.getKarakterer()) {
                karakter += i;
            }
            count += karakter / s.getKarakterer().size();
        }
        return count / studentList.size();
    }

}
