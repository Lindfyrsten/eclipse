package opgaver;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CelciusFahrenheit extends Application {
    
    public static void main(String[] args) {
        
        Application.launch(args);
    }
    // ===========================================================
    // Constants
    // ===========================================================
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Degree converter");
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
    // ===========================================================
    // Fields
    // ===========================================================
    
    private TextField txfC;
    private TextField txfF;
    private TextField txf;
    private Button convert;
    private double num;
    
    // ===========================================================
    // Constructors
    // ===========================================================
    private void initContent(GridPane pane) {
//        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        
        txfC = new TextField();

        Label c = new Label("Celsius");
        pane.add(txfC, 1, 0, 1, 1);
        pane.add(c, 0, 0);
        txfF = new TextField();
        Label f = new Label("Fahrenheit");
        pane.add(txfF, 1, 3, 1, 1);
        pane.add(f, 0, 3);
        txf = new TextField();
        txf.setEditable(false);
        pane.add(txf, 3, 2, 1, 1);
        
        convert = new Button("Convert");
        pane.add(convert, 2, 2);

        convert.setOnAction(event -> converter());
        
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================
    
    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    private void converter() {
        txf.clear();
        
        if (txfF.getText().isEmpty()) {
            num = Double.parseDouble(txfC.getText().trim().toString());
            txf.setText(Double.toString(1.8 * num + 32) + " °F");
        }
        else if (txfC.getText().isEmpty()) {
            num = Double.parseDouble(txfF.getText().trim().toString());
            txf.setText(Double.toString((num - 32) * 5 / 9) + " °C");
        }

        else {
            txf.setText("Indtast et tal");
        }
        
        txfC.clear();
        txfF.clear();
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
