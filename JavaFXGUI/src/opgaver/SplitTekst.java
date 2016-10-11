package opgaver;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SplitTekst extends Application {
    
    public static void main(String[] args) {
        Application.launch(args);
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Splitter");
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    private TextField firstName;
    private TextField lastName;
    private TextField splitName;
    private Button btnSplit;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        
        splitName = new TextField();
        pane.add(splitName, 1, 1, 2, 1);
        firstName = new TextField();
        firstName.setEditable(false);
        firstName.setMaxSize(150, .5);
        pane.add(firstName, 1, 3);
        lastName = new TextField();
        lastName.setEditable(false);
        lastName.setMaxSize(150, 5);
        pane.add(lastName, 2, 3);
        btnSplit = new Button("Split");
        btnSplit.setPrefSize(50, 20);
        pane.add(btnSplit, 1, 5);
        
        btnSplit.setOnAction(event -> split());

    }
    
    private void split() {
        String str = splitName.getText();
        String[] splitStr = str.split("\\s+");
        firstName.setText(splitStr[0]);
        lastName.setText(splitStr[1]);
        splitName.clear();
        
    }
    
}
