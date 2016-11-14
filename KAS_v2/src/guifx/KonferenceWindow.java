/**
 *
 */
package guifx;

import application.model.Konference;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Kristian
 */
public class KonferenceWindow extends Stage {
    // ===========================================================
    // Fields
    // ===========================================================
    private Konference konference;
    private TextField txfTitel, txfPris;
    private Label lblError;
    
    // ===========================================================
    // Constructors
    // ===========================================================
    public KonferenceWindow(Konference konference) {
//      initStyle(StageStyle.UNDECORATED);
        initModality(Modality.APPLICATION_MODAL);
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        setScene(scene);
        this.konference = konference;
        setTitle("Opdater konference");
        
        initContent(pane);

    }
    
    public KonferenceWindow() {
        this(null);
        setTitle("Opret konference");
//        initContent();
    }

    // ===========================================================
    // Methods
    // ===========================================================
    private void initContent(GridPane pane) {
        
        pane.setPrefSize(400, 400);
        pane.setPadding(new Insets(10));
        pane.setHgap(50);
        pane.setVgap(10);
        
        Label lblTitel = new Label("Titel");
        Label lblPris = new Label("Pris");
        txfTitel = new TextField();
        txfPris = new TextField();
        
        pane.add(lblTitel, 0, 0);
        pane.add(txfTitel, 0, 1);
        pane.add(lblPris, 0, 2);
        pane.add(txfPris, 0, 3);
        
        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 4);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 4);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> okAction());

        lblError = new Label();
        pane.add(lblError, 0, 5);
        lblError.setStyle("-fx-text-fill: red");

        initControls();
        
    }
    
    private void initControls() {
        if (konference != null) {
            txfTitel.setText(konference.getTitel());
            txfPris.setText("" + konference.getPris());
        }
        else {
            txfTitel.clear();
            txfPris.clear();
        }
    }
    
    private void cancelAction() {
        hide();
    }
    
    private void okAction() {
        String titel = txfTitel.getText().trim();
        if (titel.length() == 0) {
            lblError.setText("Titel er tom");
            return;
        }
        
        double pris = -1;
        try {
            pris = Double.parseDouble(txfPris.getText().trim());
        }
        catch (NumberFormatException ex) {
            // do nothing
        }
        if (pris < 0) {
            lblError.setText("Pris er ikke et positivt nummer");
            return;
        }
        
        // Call service methods
        if (konference != null) {
            Service.updateKonference(konference, titel, pris, null, null);
        }
        else {
            Service.createKonference(titel, pris);
        }
        
        hide();
    }
}
