package gui;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Yatzy;

public class MainApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        initContent(pane);
        
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    // -------------------------------------------------------------------------
    
    // Shows the face values of the 5 dice.
    private TextField[] txfValues;
    // Shows the hold status of the 5 dice.
    private CheckBox[] chbHolds;
    // Shows the results previously selected .
    // For free results (results not set yet), the results
    // corresponding to the actual face values of the 5 dice are shown.
    private TextField[] txfResults;
    // Shows points in sums, bonus and total.
    private TextField txfSumSame, txfBonus, txfSumOther, txfTotal;
    // Shows the number of times the dice has been rolled.
    private Label lblRolled;
    
    private Button btnRoll;
    
    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        
        // ---------------------------------------------------------------------
        
        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");
        
        // initialize txfValues, chbHolds, btnRoll and lblRolled
        txfValues = new TextField[5];
        chbHolds = new CheckBox[5];
        btnRoll = new Button("Roll");
        lblRolled = new Label("Rolled: 0");

        for (int i = 0; i < 5; i++) {
            txfValues[i] = new TextField();
            txfValues[i].setPrefSize(100, 100);
            txfValues[i].setEditable(false);
            txfValues[i].setAlignment(Pos.CENTER);
            txfValues[i].setFont(Font.font(35));
            dicePane.add(txfValues[i], i, 0);

            chbHolds[i] = new CheckBox();
            chbHolds[i].setText("Hold");
            chbHolds[i].setDisable(true);
            dicePane.add(chbHolds[i], i, 1);
        }
        
        dicePane.add(btnRoll, 3, 3);
        dicePane.add(lblRolled, 4, 3);
        
        btnRoll.setOnAction(event -> rollDice());
        
        // ---------------------------------------------------------------------
        
        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int w = 50; // width of the text fields
        
        // Initialize labels for results, txfResults,
        // labels and text fields for sums, bonus and total.
        txfResults = new TextField[15];
        txfSumSame = new TextField();
        txfBonus = new TextField();
        txfSumOther = new TextField();
        txfTotal = new TextField();
        Label[] lblScoreNames = new Label[15];
        
        for (int i = 0; i < txfResults.length; i++) {
            txfResults[i] = new TextField();
            txfResults[i].setPrefWidth(w);
            txfResults[i].setPrefHeight(25);
            txfResults[i].setOnMouseClicked(event -> chooseFieldAction(event));
            txfResults[i].setEditable(false);
            txfResults[i].setText("0");
            txfResults[i].setDisable(true);
            txfResults[i].setStyle("-fx-text-fill: black;");
            scorePane.add(txfResults[i], 2, i);
            
            lblScoreNames[i] = new Label();
        }
        
        for (int i = 0; i <= 6; i++) {
            lblScoreNames[i].setText((i + 1) + "-s");
        }
        
        lblScoreNames[6].setText("One pair");
        lblScoreNames[7].setText("Two pairs");
        lblScoreNames[8].setText("Three same");
        lblScoreNames[9].setText("Four same");
        lblScoreNames[10].setText("Full house");
        lblScoreNames[11].setText("Small straight");
        lblScoreNames[12].setText("Large straight");
        lblScoreNames[13].setText("Chance");
        lblScoreNames[14].setText("Yatzy");

        for (int i = 0; i < 15; i++) {
            scorePane.add(lblScoreNames[i], 0, i);
        }

        Label lblSumSame = new Label("Sum:");
        Label lblBonus = new Label("Bonus:");
        Label lblSumOther = new Label("Sum:");
        Label lblTotal = new Label("Total:");

        txfSumSame.setText("0");
        txfSumSame.setEditable(false);
        txfSumSame.setStyle("-fx-text-fill: blue;");
        txfBonus.setText("0");
        txfBonus.setEditable(false);
        txfBonus.setStyle("-fx-text-fill: blue;");
        txfSumOther.setText("0");
        txfSumOther.setEditable(false);
        txfSumOther.setStyle("-fx-text-fill: blue;");
        txfTotal.setText("0");
        txfTotal.setEditable(false);
        txfTotal.setStyle("-fx-text-fill: blue;");

        scorePane.add(lblSumSame, 3, 5);
        scorePane.add(txfSumSame, 4, 5);
        scorePane.add(lblBonus, 5, 5);
        scorePane.add(txfBonus, 6, 5);
        scorePane.add(lblSumOther, 3, 14);
        scorePane.add(txfSumOther, 4, 14);
        scorePane.add(lblTotal, 5, 14);
        scorePane.add(txfTotal, 6, 14);
    }
    
    // -------------------------------------------------------------------------
    
    private Yatzy dice = new Yatzy();
    
    private void rollDice() {
        if (dice.getThrowCount() == 0) {
            //enable check boxes
            setAllChbHolds(false);
        }
        
        //rolls dice
        dice.throwDice(getHolds());
        
        lblRolled.setText("Rolled: " + (dice.getThrowCount()));
        disableCheckedHolds();

        int[] values = dice.getValues();

        //sets value of the textfields
        for (int i = 0; i < values.length; i++) {
            txfValues[i].setText(values[i] + "");
        }

        //if throw count is 3 disable the roll button and all the checkboxes
        if (dice.getThrowCount() == 3) {
            //disable roll btn and holds
            btnRoll.setDisable(true);
            
            //disable all the checkboxes
            setAllChbHolds(true);
            
            setResults();
        }
    }

    //returns which checkboxes are checked
    private boolean[] getHolds() {
        boolean[] holds = new boolean[5];

        for (int i = 0; i < chbHolds.length; i++) {
            holds[i] = chbHolds[i].isSelected();
        }

        return holds;
    }
    
    //disables all the checkboxes
    private void disableCheckedHolds() {
        boolean[] holds = getHolds();
        for (int i = 0; i < holds.length; i++) {
            if (holds[i]) {
                chbHolds[i].setDisable(true);
            }
        }
    }
    
    //enable roll button, reset throwcount, set label to "Rolled: 0" and remove numbers from txfValues
    private void prepareForNewRound() {
        btnRoll.setDisable(false);
        lblRolled.setText("Rolled: 0");
        dice.resetThrowCount();

        for (int i = 0; i < txfValues.length; i++) {
            chbHolds[i].setSelected(false);
            txfValues[i].setText("");
        }
    }

    //disables or enables all the checkboxes depending on the boolean parameter
    //true = disable all
    //false = enable all
    private void setAllChbHolds(boolean disableAll) {
        for (CheckBox chb : chbHolds) {
            chb.setDisable(disableAll);
        }
    }
    
    //sets the results for all the scores.
    //notice that if the text is blue its already picked therefore it will
    //only change the text of textfields with black text
    private void setResults() {
        int[] results = dice.getResults();
        
        for (int i = 0; i < results.length; i++) {
            if (txfResults[i].getStyle().equals("-fx-text-fill: black;")) {
                txfResults[i].setText(results[i] + "");
                txfResults[i].setDisable(false);
            }
        }
    }

    //disable the scores so you can't click them
    private void disableAllScores() {
        for (TextField txt : txfResults) {
            txt.setDisable(true);
        }
    }

    //calculate the sums, bonus and total and sets the text
    private void calcSums() {
        int sumSame = 0;
        //calculate sum for 1s, 2s, 3s, 4s, 5s and 6s
        for (int i = 0; i < 6; i++) {
            sumSame += Integer.parseInt(txfResults[i].getText());
        }
        txfSumSame.setText(sumSame + "");
        
        int bonus = 0;
        //check for bonus (minimum 63 points)
        if (sumSame >= 63) {
            bonus = 50;
            txfBonus.setText("50");
        }
        
        int sumOther = 0;
        //calculate sum for the rest
        for (int i = 6; i < 15; i++) {
            sumOther += Integer.parseInt(txfResults[i].getText());
        }
        txfSumOther.setText(sumOther + "");

        //calculate total
        txfTotal.setText((sumSame + sumOther + bonus) + "");
    }

    // -------------------------------------------------------------------------
    
    private void chooseFieldAction(Event event) {
        TextField txt = (TextField) event.getSource();
        //disables the picked score
        txt.setDisable(true);
        //sets text color to blue
        txt.setStyle("-fx-text-fill: blue;");

        //gets ready for a new round
        disableAllScores();
        prepareForNewRound();

        //set scores that haven't been picked back to 0
        for (TextField txf : txfResults) {
            if (txf.getStyle().equals("-fx-text-fill: black;")) {
                txf.setText("0");
            }
        }
        calcSums();
    }
    
}
