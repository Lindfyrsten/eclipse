/**
 *
 */
package yatsy;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author Kristian
 */
public class Test {
    
    Test() {
        Stage subStage = new Stage();
        subStage.setTitle("Test");
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 300, 300);
        root.getChildren().add(new Button("New Stage"));
        subStage.setScene(scene);
        subStage.show();
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
}
