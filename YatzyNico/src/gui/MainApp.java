package gui;

import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.Yatzy;

/**
*
* @author Kristian Lindbjerg, Nicolaj Lundtoft Jørgensen, Sutha Jesuthasan
*
*/
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
    //private TextField[] txfValues;
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

    private Image[] images;
    private ImageView[] imageViews;

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
        dicePane.setVgap(5);
        dicePane.setStyle("-fx-border-color: black");
        
        // initialize txfValues, chbHolds, btnRoll and lblRolled
        
        chbHolds = new CheckBox[5];
        btnRoll = new Button("Roll");
        btnRoll.setPrefSize(80, 50);

        lblRolled = new Label("Rolled: 0");
        
        images = new Image[7];
        imageViews = new ImageView[5];

        String[] imageNames = { "tomlille.png", "1lille.png", "2lille.png", "3lille.png",
            "4lille.png", "5lille.png", "6lille.png" };

        for (int i = 0; i < images.length; i++) {
            
            images[i] = new Image("/dice/" + imageNames[i]);
        }
        
        for (int i = 0; i < 5; i++) {
            imageViews[i] = new ImageView();
            imageViews[i].setFitWidth(100);
            imageViews[i].setFitHeight(100);
            imageViews[i].setImage(images[0]);
            dicePane.add(imageViews[i], i, 0);
            
            chbHolds[i] = new CheckBox("Hold");
            GridPane.setHalignment(chbHolds[i], HPos.CENTER); //align center
            chbHolds[i].setDisable(true);
            dicePane.add(chbHolds[i], i, 1);
        }
        
        dicePane.add(btnRoll, 3, 3);
        dicePane.add(lblRolled, 4, 3);
        GridPane.setHalignment(btnRoll, HPos.CENTER); //align center
        GridPane.setHalignment(lblRolled, HPos.CENTER); //align center
        
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
        
        //--------------------- Combo box theme stuff --------------
        String[] styles = {
            "",
            "-fx-background-color: red;",
            "-fx-background-color: linear-gradient(to bottom right, hotpink, orchid);",
            "-fx-background-color: linear-gradient(to bottom right, red, dodgerblue);",
            "-fx-background-color: linear-gradient(to bottom right, hotpink, lawngreen );",
        };
        
        ObservableList<String> options = FXCollections.observableArrayList(
            "Default",
            "Red",
            "Pink",
            "RedBlue",
            "PinkGrøn");
        
        ComboBox<String> comboBox = new ComboBox<>(options);
        comboBox.setPromptText("Theme");
        comboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                String defaultStyle = "-fx-border-color: black;";
                
                int index = 0;
                //find index:
                for (int i = 0; i < options.size(); i++) {
                    if (t1.equals(options.get(i))) {
                        index = i;
                    }
                }
                
                scorePane.setStyle(defaultStyle + styles[index]);
                dicePane.setStyle(defaultStyle + styles[index]);
            }
        });
        
        scorePane.add(comboBox, 7, 0);
        //--------------------- Combobox theme stuff --------------
        
        // Initialize labels for results, txfResults,
        // labels and text fields for sums, bonus and total.
        txfResults = new TextField[15];
        txfSumSame = new TextField();
        txfBonus = new TextField();
        txfSumOther = new TextField();
        txfTotal = new TextField();
        
        String[] scoresText =
            { "1-s", "2-s", "3-s", "4-s", "5-s", "6-s", "One pair", "Two pairs",
                "Three of a kind", "Four of a kind", "Full house", "Small Straight",
                "Large Straight",
                "Chance", "Yatzy" };
        
        Label[] scoreLabel = new Label[15];
        
        for (int i = 0; i < 15; i++) {
            
            scoreLabel[i] = new Label();
            scoreLabel[i].setText(scoresText[i]);
            txfResults[i] = new TextField();
            txfResults[i].setPrefWidth(w);
            txfResults[i].setEditable(false);
            txfResults[i].setOnMouseClicked(event -> chooseFieldAction(event));
            txfResults[i].setStyle("-fx-text-fill: black;");
            scorePane.add(txfResults[i], 1, i);
            scorePane.add(scoreLabel[i], 0, i);
            
        }
        
        Label lblSumSame = new Label("Sum:");
        Label lblBonus = new Label("Bonus:");
        Label lblSumOther = new Label("Sum:");
        Label lblTotal = new Label("Total:");
        
        txfSumSame.setText("0");
        txfSumSame.setEditable(false);
        txfSumSame.setStyle("-fx-text-fill: blue;");
        txfSumSame.setPrefWidth(w);
        
        txfBonus.setText("0");
        txfBonus.setEditable(false);
        txfBonus.setStyle("-fx-text-fill: blue;");
        txfBonus.setPrefWidth(w);
        
        txfSumOther.setText("0");
        txfSumOther.setEditable(false);
        txfSumOther.setStyle("-fx-text-fill: blue;");
        txfSumOther.setPrefWidth(w);
        
        txfTotal.setText("0");
        txfTotal.setEditable(false);
        txfTotal.setStyle("-fx-text-fill: blue;");
        txfTotal.setPrefWidth(w);
        
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

        playSound("src/dice/Roll.mp3");
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
            setImage(i, values[i]);
        }
        
        //if throw count is 3 disable the roll button and all the checkboxes
        if (dice.getThrowCount() == 3) {
            //disable roll btn and holds
            btnRoll.setDisable(true);

            //disable all the checkboxes
            setAllChbHolds(true);

//            setResults();
        }
        setResults();
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
        
        for (int i = 0; i < imageViews.length; i++) {
            chbHolds[i].setSelected(false);
            imageViews[i].setImage(images[0]);
//            txfValues[i].setText("");
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
    
    private void setImage(int diceNumber, int value) {
        imageViews[diceNumber].setImage(images[value]);
    }
    
    // mediaplayer to play dice roll sound
    public static void playSound(String fileName) {
        Media m = new Media(
            "file:///" + System.getProperty("user.dir").replace('\\', '/') + "/" + fileName);
        MediaPlayer player = new MediaPlayer(m);
        player.play();
    }

    // ends the game when all results choices have been used
    private void gameFinished() {
        int i = 0;
        boolean KeepPlaying = false;
        
        while (!KeepPlaying && i < 15) {
            if (txfResults[i].getStyle().equals("-fx-text-fill: black;")) {
                KeepPlaying = true;
            }
            i++;
        }
        if (!KeepPlaying) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Game Finished");
            alert.setHeaderText("The Game has finished!");
            alert.setContentText(
                "You scored " + txfTotal.getText()
                    + " points in total!\n Do you want to play again?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                //restart game if user presses ok
                restartGame();
            }
            else {
                //else exit the game
                Platform.exit();
            }
        }
    }

    //restarts the scores and sets the color of alle the textfields to black
    private void restartGame() {
        prepareForNewRound();
        
        for (int i = 0; i < txfResults.length; i++) {
            txfResults[i].setText("0");
            txfResults[i].setStyle("-fx-text-fill: black;");
        }
    }
    
    // -------------------------------------------------------------------------

    private void chooseFieldAction(Event event) {
        TextField txt = (TextField) event.getSource();
        //disables the picked score
        txt.setDisable(true);
        //sets text color to blue
        txt.setStyle("-fx-text-fill: blue;");
        gameFinished();
        
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
