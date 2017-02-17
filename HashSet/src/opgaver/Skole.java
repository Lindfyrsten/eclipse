package opgaver;

import java.util.ArrayList;
import java.util.List;

public class Skole {
    private String navn;
    private List<Studerende> studentList;
    
    public Skole(String navn) {
        this.navn = navn;
        studentList = new ArrayList<>();
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

    public List<Studerende> getStudentList() {
        return studentList;
    }
    
    public Studerende findStuderende(int studieNr) {
        Studerende student = null;
        boolean found = false;
        int i = 0;
        while (!found && i < studentList.size()) {
            if (studentList.get(i).getStudieNr() == studieNr) {
                student = studentList.get(i);
                found = true;
            }
            else {
                i++;
            }
            
        }
        return student;
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
