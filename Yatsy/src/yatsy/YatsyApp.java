package yatsy;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Kristian
 */
public class YatsyApp extends Application {

    public static void main(String[] args) {

        Application.launch(args);
    }
    
    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override
    public void start(Stage stage) {
        
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("MyFXML.fxml"));
//        Controller controller = loader.getController();
//        controller.setStage(this.stage);
        stage.setTitle("Yatsy");
        GridPane pane = new GridPane();
        GridPane menuPane = new GridPane();
        welcomeScreen(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        menu = new Menu("Menu", stage);
        
    }
    
// ===========================================================
// Constants
// ===========================================================
// ===========================================================
// Fields
// ===========================================================

// ===========================================================
// Constructors
// ===========================================================
    private final Controller controller = new Controller();
    private Menu menu;

    public void welcomeScreen(GridPane pane) {
//        pane.setGridLinesVisible(true);
        
        pane.setPadding(new Insets(20));
        pane.setVgap(-40);
//        pane.setStyle("-fx-background-color: darkgrey");
        
        Image welcome = new Image("yatzy_om_penge.jpg");
        
        ImageView welcomeScreen = new ImageView(welcome);
        welcomeScreen.autosize();
        pane.add(welcomeScreen, 0, 1);
        GridPane.setHalignment(welcomeScreen, HPos.CENTER);
        
        Text txfWelcome = new Text("Welcome to Yatsy!");
        txfWelcome.setFont(Font.font("Always forever", FontWeight.BOLD, 100));
        txfWelcome.setFill(Color.BLACK);
        txfWelcome.setStroke(Color.web("#7080A0"));
        pane.add(txfWelcome, 0, 0);
        GridPane.setHalignment(txfWelcome, HPos.CENTER);
        
        Button btnPlay = new Button("Play");
        
        btnPlay.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        pane.add(btnPlay, 0, 2);
        GridPane.setHalignment(btnPlay, HPos.CENTER);
        
        btnPlay.setOnAction(event -> controller.StartMenu());
        
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

// ===========================================================
// Inner and Anonymous Classes
// ===========================================================

    public class Controller {

        private void StartMenu() {
            
            menu.show();
            
        }
    }
    
}
