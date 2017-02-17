package opgaver;

public class TestApp {

    public static void main(String[] args) {
        Skole sk1 = new Skole("Langenæs Skolen");
        Skole sk2 = new Skole("EAA");
        Skole sk3 = new Skole("UNI");

        Studerende s1 = new Studerende(1, "Kristian Lindbjerg");
        Studerende s2 = new Studerende(2, "Anders Andersen");
        Studerende s3 = new Studerende(3, "Bent Bentsen");
        Studerende s4 = new Studerende(4, "Kurt Kurtsen");

        sk2.addStuderende(s1);
        sk2.addStuderende(s2);
        sk2.addStuderende(s3);
        sk2.addStuderende(s4);

        System.out.println(sk2.getStudentList());
    }

}
