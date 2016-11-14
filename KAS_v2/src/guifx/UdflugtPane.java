package guifx;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UdflugtPane extends Stage {
    
    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================
    public UdflugtPane() {
//        initStyle(StageStyle.UNDECORATED);
        initModality(Modality.APPLICATION_MODAL);
        GridPane pane = new GridPane();
        
        Scene scene = new Scene(pane);
        setTitle("Udflugt");
        setScene(scene);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================
}
