package guifx;

import java.time.LocalDate;

import application.model.Konference;
import application.model.Udflugt;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UdflugtPane extends Stage {

    // ===========================================================
    // Fields
    // ===========================================================
    private TextField txfNavn = new TextField(), txfPris = new TextField();
    private DatePicker dpDate;
    private Button btnOK, btnCancel;
    private String navn;
    private LocalDate date;
    private Label lblError;
    private Konference konference;
    private Udflugt udflugt;
    
    // ===========================================================
    // Constructors
    // ===========================================================
    public UdflugtPane(Konference konference, DatePicker dpDate, Udflugt udflugt) {
        this.konference = konference;
        this.dpDate = dpDate;
        this.udflugt = udflugt;
        initModality(Modality.APPLICATION_MODAL);
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        setTitle("Opdater udflugt");
        setScene(scene);

        initContent(pane);
    }
    
    public UdflugtPane(Konference konference, DatePicker dpDate) {

        this(konference, dpDate, null);
        setTitle("Tilføj Udflugt");
        
    }
    
    //----------------------------------------------------------

    private void initContent(GridPane pane) {
//      pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20, 10, 20, 10));
        pane.setHgap(10);
        pane.setVgap(10);
        Label lblTitle = new Label("Tilføj Udflugt");
        if (udflugt != null) {
            lblTitle.setText("Opdater Udflugt");
        }
        lblTitle.setTextFill(Color.GREY);
        lblTitle.setFont(Font.font("Impact", 24));
        GridPane.setHalignment(lblTitle, HPos.CENTER);
        Label lblNavn = new Label("Navn:");
        lblNavn.setPrefWidth(40);
        Label lblPris = new Label("Pris:");
        Label lblDate = new Label("Dato");
        lblError = new Label();
        
        lblError.setStyle("-fx-text-fill: red");
        
        btnOK = new Button("OK");
        btnCancel = new Button("Annuller");
        HBox hbxButtons = new HBox(40, btnOK, btnCancel);
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);
        
        btnOK.setOnAction(event -> okAction());
        btnCancel.setOnAction(event -> cancelAction());
        
        pane.add(lblTitle, 0, 0, 2, 1);
        pane.add(lblNavn, 0, 1);
        pane.add(txfNavn, 1, 1);
        pane.add(lblPris, 0, 2);
        pane.add(txfPris, 1, 2);
        pane.add(lblDate, 0, 3);
        pane.add(dpDate, 1, 3);
        pane.add(lblError, 0, 4, 2, 1);
        pane.add(hbxButtons, 0, 5, 2, 1);
        
        initControls();
    }

    private void okAction() {
        
        navn = txfNavn.getText().trim();
        date = dpDate.getValue();
        
        if (navn.length() == 0) {
            lblError.setText("Titel er tom");
            return;
        }
        if (date == null) {
            lblError.setText("Dato er tom");
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
        
        if (udflugt != null) {
            Service.updateUdflugt(udflugt, navn, pris, date);
        }
        else {

            Service.createUdflugt(konference, navn, pris, date);
        }
        hide();
        
    }
    
    private void cancelAction() {
        hide();
    }
    
    private void initControls() {
        if (udflugt != null) {
            txfNavn.setText(udflugt.getNavn());
            txfPris.setText("" + udflugt.getPris());
            dpDate.setValue(udflugt.getDato());
            
        }
//        else {
//
//            txfNavn.clear();
//            txfPris.clear();
//
//        }
    }
    
}
