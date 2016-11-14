package guifx;

import application.model.Deltager;
import application.model.Konference;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class KonferenceAddDeltager extends Stage {

    // ===========================================================
    // Fields
    // ===========================================================
    private Konference konference;

    // ===========================================================
    // Constructors
    // ===========================================================
    public KonferenceAddDeltager(Konference konference) {
        this.konference = konference;
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        setTitle("Add participant");
        GridPane pane = new GridPane();
        initContent(pane);
        
        Scene scene = new Scene(pane);
        setScene(scene);
    }

    private ListView<Deltager> lvwDeltagere;
    
    // ===========================================================
    // Methods
    // ===========================================================
    
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        
        Label lblDeltagere = new Label("Deltagere:");
        pane.add(lblDeltagere, 0, 0);

        lvwDeltagere = new ListView<>();
        pane.add(lvwDeltagere, 0, 1, 1, 4);
        lvwDeltagere.setPrefSize(200, 200);
        lvwDeltagere.getItems().setAll(konference.getDeltagere());
        
    }
    
}
