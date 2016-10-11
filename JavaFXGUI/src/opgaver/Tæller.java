package opgaver;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Tæller extends Application {

    public static void main(String[] args) {
        Application.launch(args);

    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tæller");
        GridPane pane = new GridPane();
        initContent(pane);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    private TextField txtf;
    private Button btnPlus;
    private Button btnMinus;
    private int number = 50;
    private String num = "50";
    
    private Controller controller = new Controller();

    private void initContent(GridPane pane) {

        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);

        txtf = new TextField();
        txtf.setEditable(false);
        txtf.setText(num);
        pane.add(txtf, 2, 1, 2, 1);

        Label lblName = new Label("Nummer: ");
        pane.add(lblName, 1, 1);

        btnPlus = new Button("+");
        btnPlus.setMinWidth(30);
        pane.add(btnPlus, 4, 0);
        btnMinus = new Button("-");
        btnMinus.setMinWidth(30);
        pane.add(btnMinus, 4, 4);

        btnPlus.setOnAction(event -> controller.countUp());
        btnMinus.setOnAction(event -> controller.countDown());

    }
    
    private class Controller {
        
//        private void clearField() {
//            txtf.clear();
//        }
        
        private void countUp() {
            
            number++;
            num = Integer.toString(number);
            txtf.clear();
            txtf.setText(num);
            
        }
        
        private void countDown() {
            
            number--;
            num = Integer.toString(number);
            txtf.clear();
            txtf.setText(num);
            
        }
    }
    
}
