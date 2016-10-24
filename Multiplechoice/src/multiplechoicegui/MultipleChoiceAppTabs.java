package multiplechoicegui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class MultipleChoiceAppTabs extends Application {

    MultipleChoice mc = new MultipleChoice(10);
    private ListView<String> lvStudents;
    private ListView<String> lvAnswers;

    public static void main(String[] args) {

        Application.launch(args);
    }
    
    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override
    public void start(Stage stage) throws Exception {
        
        stage.setTitle("Student Quiz Scores");
        TabPane tabPane = new TabPane();
        initContent(tabPane);
        
        Scene scene = new Scene(tabPane);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();
    }

    private void initContent(TabPane tabPane) {

        Tab studentTab = new Tab();
        tabPane.setPrefSize(350, 260);

        studentTab.setText("Student scores");
        lvStudents = new ListView<>();
        lvStudents.setEditable(false);
        lvStudents.setPrefSize(200, 200);
        lvStudents.getItems().setAll(mc.correctAnswersPrStudent());
        studentTab.setContent(lvStudents);

        Tab questionTab = new Tab();
        questionTab.setText("Questions");
        lvAnswers = new ListView<>();
        lvAnswers.setEditable(false);
        lvAnswers.setPrefSize(200, 200);
        lvAnswers.getItems().setAll(mc.correctAnswerPrQuestion());
        questionTab.setContent(lvAnswers);
        
        tabPane.getTabs().addAll(studentTab, questionTab);

    }
    
}
