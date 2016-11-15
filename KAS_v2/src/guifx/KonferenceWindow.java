/**
 *
 */
package guifx;

import java.time.LocalDate;

import application.model.Konference;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
    private TextField txfTitel = new TextField(), txfPris = new TextField(),
        txfStart = new TextField(), txfSlut = new TextField(), txfFrist = new TextField();
    private Label lblError;
    private CheckBox cbDato;

    // ===========================================================
    // Constructors
    // ===========================================================
    public KonferenceWindow(String title, Konference konference) {
//        initStyle(StageStyle.UNDECORATED);
        initModality(Modality.APPLICATION_MODAL);
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        setScene(scene);
        this.konference = konference;
        
        setTitle(title);

        initContent(pane);
        
    }
    
    public KonferenceWindow(String title) {
        this(title, null);
        setTitle(title);
        
    }

    // ===========================================================
    // Methods
    // ===========================================================
    private void initContent(GridPane pane) {
        
//        pane.setGridLinesVisible(true);
//        pane.setPrefSize(400, 400);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(20);
        
        Label lblTitle = new Label(getTitle());
        lblTitle.setTextFill(Color.GREY);
        lblTitle.setFont(Font.font("Impact", 24));
        pane.add(lblTitle, 0, 0, 2, 1);
        GridPane.setHalignment(lblTitle, HPos.CENTER);
        
        String[] str = { "Titel", "Pris", "Start dato", "Slut dato", "Tilmeldningsfrist" };
        for (int i = 0; i < str.length; i++) {

            Label lbl = new Label(str[i]);
            pane.add(lbl, 0, i + 1);
            
        }

        cbDato = new CheckBox("Dato (YYYY-MM-DD)");
        pane.add(cbDato, 1, 6);
        GridPane.setHalignment(cbDato, HPos.RIGHT);
        VBox txfBox = new VBox(10);
        txfBox.getChildren().addAll(txfTitel, txfPris, txfStart, txfSlut, txfFrist);
        pane.add(txfBox, 1, 1, 1, 5);
        Button btnOK = new Button("OK");
        Button btnCancel = new Button("Annuller");
        btnOK.setPrefSize(75, 50);
        btnCancel.setPrefSize(75, 50);
        HBox btnBox = new HBox(20);
        pane.add(btnBox, 0, 7, 2, 1);
        btnBox.getChildren().addAll(btnOK, btnCancel);
        btnBox.setAlignment(Pos.BASELINE_CENTER);
        cbDato.setOnAction(event -> cbDato());
        
        btnCancel.setOnAction(event -> cancelAction());
        
        btnOK.setOnAction(event -> okAction());

        lblError = new Label();
        pane.add(lblError, 0, 8);
        lblError.setStyle("-fx-text-fill: red");
        
        initControls();
        
    }

    private void cbDato() {
        if (cbDato.isSelected()) {
            txfStart.setDisable(false);
            txfSlut.setDisable(false);
            txfFrist.setDisable(false);
        }
        else {
            txfStart.clear();
            txfStart.setDisable(true);
            txfSlut.clear();
            txfSlut.setDisable(true);
            txfFrist.clear();
            txfFrist.setDisable(true);

        }
    }

    private void initControls() {
        if (konference != null) {
            txfTitel.setText(konference.getTitel());
            txfPris.setText("" + konference.getPris());
            if (konference.getStartDate() != null) {
                cbDato.setSelected(true);
                cbDato();
                txfStart.setText("" + konference.getStartDate());
                txfSlut.setText("" + konference.getSlutDate());
                txfFrist.setText("" + konference.getTilmeldningsfrist());
                
            }
            else {
                cbDato.setSelected(false);
                cbDato();
            }
        }
        else {
            
            txfTitel.clear();
            txfPris.clear();
            cbDato();
        }
    }
    
    private void cancelAction() {
        hide();
    }
    
    private void okAction() {
        
        String titel = txfTitel.getText().trim();
        String start = txfStart.getText().trim();
        String slut = txfSlut.getText().trim();
        String frist = txfFrist.getText().trim();

        if (cbDato.isSelected()) {
            if (titel.length() == 0) {
                lblError.setText("Titel er tom");
                return;
            }
            if (start.length() == 0) {
                lblError.setText("Start dato er tom");
                return;
            }
            if (slut.length() == 0) {
                lblError.setText("Slut dato er tom");
                return;
            }
            if (frist.length() == 0) {
                lblError.setText("Tilmeldningsfrist er tom");
                return;
            }
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
        
        if (cbDato.isSelected()) {

            if (konference != null) {
                Service.updateKonference(konference, titel, pris,
                    LocalDate.parse(start),
                    LocalDate.parse(slut),
                    LocalDate.parse(frist));
            }
            else {
                Service.createKonference(titel, pris, LocalDate.parse(start),
                    LocalDate.parse(slut),
                    LocalDate.parse(frist));
            }
        }
        else {
            if (konference != null) {
                Service.updateKonference(konference, titel, pris);
            }
            else {
                Service.createKonference(titel, pris);
            }
        }
        
        hide();
    }
}
