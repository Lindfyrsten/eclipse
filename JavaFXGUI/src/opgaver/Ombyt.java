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

    private TextField txf1;
    private TextField txf2;

    private void initContent(GridPane pane) {
        
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        txf1 = new TextField();
        txf2 = new TextField();
        pane.add(txf1, 1, 1, 2, 1);
        pane.add(txf2, 1, 2, 2, 1);

        Button btnSwap = new Button("Ombyt");
        pane.add(btnSwap, 2, 3);

        btnSwap.setOnAction(event -> ombyt());
    }

    public void ombyt() {
        String value1 = txf1.getText();
        String value2 = txf2.getText();
        txf1.setText(value2);
        txf2.setText(value1);
    }

}
