package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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
//        dicePane.setPrefSize(500, 150);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");
        txfValues = new TextField[5];
        chbHolds = new CheckBox[5];
        
        for (int i = 0; i < txfValues.length; i++) {
            txfValues[i] = new TextField();
            txfValues[i].setPrefSize(75, 75);
            txfValues[i].setEditable(false);
            txfValues[i].setMouseTransparent(true);
            txfValues[i].setFocusTraversable(false);
            pane.add(txfValues[i], i, 0);
            chbHolds[i] = new CheckBox();
            pane.add(chbHolds[i], i, 1);
            
        }
        
        // initialize txfValues, chbHolds, btnRoll and lblRolled
        // TODO
        
        // ---------------------------------------------------------------------
        
        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 3);
//        scorePane.setPrefSize(600, 400);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        scorePane.resize(200, 200);
        int w = 50; // width of the text fields
        
        // Initialize labels for results, txfResults,
        // labels and text fields for sums, bonus and total.
        // TODO
        
    }

    // -------------------------------------------------------------------------

    private Yatzy dice = new Yatzy();

    // Create a method for btnRoll's action.
    // Hint: Create small helper methods to be used in the action method.
    // TODO

    // -------------------------------------------------------------------------

    // Create a method for mouse click on one of the text fields in txfResults.
    // Hint: Create small helper methods to be used in the mouse click method.
    // TODO

}
