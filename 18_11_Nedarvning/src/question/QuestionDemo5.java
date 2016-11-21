package question;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class QuestionDemo5 extends Application {
    private TextField txfAnswer;
    private Question q = new AnyCorrectChoiceQuestion();
    private Label lblAnswer = new Label("");

    public static void main(String[] args) {
        Application.launch(args);

    }
    
    @Override
    public void start(Stage stage) {

        q.setText("What is the color of the famous");
        q.setAnswer("Black");
        q.setAnswer("Blue");
        q.setAnswer("Sort");
        q.setAnswer("Blå");

        GridPane pane = new GridPane();

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

//        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(10, 10, 10, 150));
        pane.setVgap(10);
        pane.setHgap(50);
        Image i = new Image("blueandblack.jpg");
        ImageView img = new ImageView();
//        img.setFitWidth(400);
//        img.setFitHeight(800);
//        pane.setPrefWidth(800);
        img.setImage(i);
        img.setFitHeight(500);
        img.setFitWidth(350);
        Label lblQuestion = new Label("Name one of the colors in this dress");
        lblQuestion.setTextFill(Color.GREY);
        lblQuestion.setFont(Font.font("Impact", 24));
        
        lblAnswer.setFont(Font.font("Impact", 24));

        txfAnswer = new TextField();
        Button btnOK = new Button("Answer");
        btnOK.setOnAction(event -> answer());
        
        VBox vbx = new VBox(20, lblQuestion, txfAnswer, btnOK, lblAnswer);
        pane.add(img, 0, 0);
        pane.add(vbx, 1, 0);
        vbx.setAlignment(Pos.CENTER);

    }
    
    private void answer() {
        String response = txfAnswer.getText();
        if (q.checkAnswer(response) == true) {
            lblAnswer.setText("Correct!");
            lblAnswer.setTextFill(Color.GREEN);
        }
        else {
            lblAnswer.setText("False!");
            lblAnswer.setTextFill(Color.RED);
        }

    }
}
