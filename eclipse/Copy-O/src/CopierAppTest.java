public class CopierAppTest {

    public static void main(String[] args) throws InterruptedException {

        CopierTest c1 = new CopierTest(0);
        
        c1.greeting();

        Thread.sleep(3000);

        while (c1.isOn == true) {

            c1.menu();

            if (c1.getResult() == 1) {
                c1.makeCopy();
            }

            else if (c1.getResult() == 2) {
                c1.insertPaper();
            }

            else if (c1.getResult() == 3) {

                c1.quit();
            }

            else {
                System.out.println("Please press a valid number.");
                c1.menuRepeat();
            }

        }
    }
}
