package opgaver;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ombyt extends Application {
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Ombytter");
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        
        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        
        TextField txf1 = new TextField();
        pane.add(txf1, 1, 1, 2, 1);
        TextField txf2 = new TextField();
        pane.add(txf2, 1, 2, 2, 1);

        Button btnSwap = new Button("Ombyt");
        pane.add(btnSwap, 2, 3);

    }

    public void ombyt() {
        TextField temp = new TextField();
        temp = txf1;
    }
}
