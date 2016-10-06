import java.util.Scanner;

public class CopierTest {

    private int paper;
    boolean paperStuck;
    boolean isOn;
    private int result;
    
    Scanner scan = new Scanner(System.in);

    public CopierTest(int paper) {
        isOn = true;
        this.paper = paper;
        paperStuck = false;
    }

    public void greeting() {
        System.out.println("");
        System.out.println("Welcome to ");
        System.out.println("\u001b[1;35mCOPY-O 3000!\u001b[0m");
        System.out.println("");
        
    }

//    // option to jam paper
//    public void makePaperJam() {
//
//        paperStuck = true;
//
//    }
//
//    // fixed jam
//
//    public void fixJam() {
//        paperStuck = false;
//        System.out.println("\u001B[32mJam fixed!\u001b[0m");
//    }
//
    public int getPaper() {
        
        return paper;
        
    }

    // looping menu after each action until app closed
    
    public void menu() {
        
        if (getPaper() == 0) {
            
            System.out.println("*************************");
            System.out.println("\u001b[1;31mWarning\u001b[1;0m: No paper left!");
            System.out.println("*************************");
            result = 2;
            
        }
        
        else {

            System.out.println("*************************");
            System.out.println("\u001b[1;31mPaper remaining\u001b[1;0m: " + getPaper());
            System.out.println("*************************");
            System.out.println("Press 1 to make copies.");
            System.out.println("Press 2 if you wish to add paper.");
            System.out.println("Press 3 to quit.");
            result = scan.nextInt();
        }
    }

    public void menuRepeat() {
        
        result = scan.nextInt();
    }
    
    public int getResult() {
        return result;

    }
    
    // make a copy and reduce paper by amount of copies
    // can not make more copies than available paper
    // if no paper left do nothing and tell user to add more paper
    
    public void makeCopy() throws InterruptedException {
        
        System.out.println("How many copies would you like to make?");
        int copies = scan.nextInt();
        if (paperStuck == true) {
            
            System.out.println(
                "\u001b[1;31mPaper Jammed :(\u001b[0m");
            
        }
        else if (paper > 0 && paper >= copies && copies > 1) {
            paper = paper - copies;
            System.out.println("Making " + copies + " copies...");
            System.out.println("Estimated time remaining: "
                + copies / 2 + " seconds.");
            try {
                Thread.sleep(copies * 500);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\u001B[32mCopies completed!\u001B[0m");
            System.out.println("Returning to menu:");
            Thread.sleep(1000);
        }
        
        else if (paper > 0 && paper >= copies && copies == 1) {
            paper = paper - copies;
            System.out.println("Making " + copies + " copy.");
            
            System.out.println("Copy completed!");
            System.out.println("Returning to menu:");
            Thread.sleep(1000);
        }
        else if (paper > 0 && paper < copies) {
            System.out.println(
                "\u001b[1;31mError\u001b[1;0m: Not enough paper to make " + copies
                    + " copies. Please add more paper or lower the amount of copies. ");
        }
        
        else if (copies == 0) {
            System.out.println(
                "\u001b[1;31mHuman error\u001b[1;0m: Making 0 copies would make no sense.");
            System.out.println(
                "As a super intelligent copier, this would be illogical to me, since making 0 copies would just leave you with the original, making me redundant technology.");
            System.out.println("Returning to menu:");
            Thread.sleep(1000);
        }
        
        else {
            
            System.out.println(
                "\u001b[1;31mOut of paper, please insert more!\u001b[0m");
        }
    }

    // add paper and print new value
    // error if exceeding 500 papers and prints how much paper can be added

    public void insertPaper() throws InterruptedException {

        System.out.println("How much paper would you like to add?");
        System.out.println("Press 0 to close app.");
        
        int addPaper = scan.nextInt();
        int maxPaper = 500 - paper;

        paper = addPaper + paper;

        if (addPaper == 0) {

            quit();
        }

        else if (paper > 500) {

            System.out
                .print("\u001b[1;31mError\u001b[0m: Could not add " + addPaper + " paper. ");
            System.out.println(
                "\u001b[1;31mError\u001b[1;0m: Max amount of paper you can add is: " + maxPaper);
            paper = paper - addPaper;
        }

        else {
            System.out.println("Adding paper: " + addPaper);
            System.out.println("Estimated time remaining: " + addPaper / 10 + " seconds.");
            try {
                Thread.sleep(addPaper * 100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\u001B[32mPaper succesfully added!\u001B[0m");
            System.out.println("Returning to menu:");
            Thread.sleep(1000);
        }

    }

    public void quit() throws InterruptedException {
        System.out
            .println(
                "\u001b[1;35mThank you for using Copy-O 3000! Have a nice day.\u001b[0m");
        scan.close();
        isOn = false;
        Thread.sleep(3000);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

    }

}
