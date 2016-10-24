package multiplechoicegui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MultipleChoiceApp extends Application {
    
    MultipleChoice mc = new MultipleChoice(10);
    
    public static void main(String[] args) {
        
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        GridPane pane = new GridPane();
        initContent(pane);
        
        Scene scene = new Scene(pane);
        stage.setTitle("Student Quiz Scores");
        stage.setScene(scene);
        stage.show();
    }

    private ListView<String> lvStudents;
    private ListView<String> lvAnswers;

//    private final Controller controller = new Controller();
    
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setVgap(10);
        pane.setHgap(10);
//        pane.setGridLinesVisible(true);

        Label lblStudents = new Label("Students:");
        pane.add(lblStudents, 0, 0);
        Label lblAnswers = new Label("Answers:");
        pane.add(lblAnswers, 1, 0);
        lvStudents = new ListView<>();
        lvStudents.setEditable(false);
        lvStudents.setPrefSize(200, 200);
        pane.add(lvStudents, 0, 1);
        lvAnswers = new ListView<>();
        lvAnswers.setEditable(false);
        lvAnswers.setPrefSize(200, 200);
        pane.add(lvAnswers, 1, 1);

        lvStudents.getItems().setAll(mc.correctAnswersPrStudent());
        lvAnswers.getItems().setAll(mc.correctAnswerPrQuestion());

    }

}
