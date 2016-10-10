package opgaver;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NameApp extends Application {

    public static void main(String[] args) {
        Application.launch(args);
        
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Name combiner");
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private TextField txfFirstName;
    private TextField txfLastName;
    private TextField txAInf;
    
    private Button btnKombi;
    
    private Controller controller = new Controller();

    //private Controller controller = new Controller();

    private void initContent(GridPane pane) {

        //show or hide grid lines
        pane.setGridLinesVisible(false);
        //set padding
        pane.setPadding(new Insets(20));
        //horizontal gap between components
        pane.setHgap(10);
        //vertical gap between components
        pane.setVgap(10);
        
        Label lblFirstName = new Label("Fornavn");
        pane.add(lblFirstName, 0, 0);
        
        Label lvlLastName = new Label("Efternavn");
        pane.add(lvlLastName, 4, 0);
        
        txfFirstName = new TextField();
        pane.add(txfFirstName, 0, 1, 2, 1);
        
        txfLastName = new TextField();
        pane.add(txfLastName, 4, 1, 2, 1);

        txAInf = new TextField();
        pane.add(txAInf, 1, 5, 6, 1);
        txAInf.setMaxSize(200, 10);
        
        //add button
        
        btnKombi = new Button("Kombiner");
        pane.add(btnKombi, 2, 3);
        GridPane.setMargin(btnKombi, new Insets(10, 10, 0, 10));
        
        // connect methods to button
        
        btnKombi.setOnAction(event -> this.controller.combineAction());
        
    }
    
    private class Controller {

        private void combineAction() {
            txAInf.setText(txfFirstName.getText().trim() + " " + txfLastName.getText().trim());
            clearFields();
        }

        private void clearFields() {
            txfFirstName.clear();
            txfLastName.clear();
        }
    }

}
