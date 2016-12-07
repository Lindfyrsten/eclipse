package guifx;

import application.model.Kunde;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UdlejWindow extends Stage {
    public UdlejWindow() {
        initModality(Modality.APPLICATION_MODAL);
        setMinHeight(100);
        setMinWidth(200);
        setResizable(false);
        
        GridPane pane = new GridPane();
        initContent(pane);
        Scene scene = new Scene(pane);
        setScene(scene);
    }
    
    private TextField txfName, txfAddresse, txfTlfNr, txfKørekortNr, txfAlder;
    private Kunde actualKunde = null;
    private Label lblError;
    
    private void initContent(GridPane pane) {
        
        pane.setPadding(new Insets(10));
        pane.setVgap(20);
        pane.setHgap(10);

        Label lblTitle = new Label("Reserver Bil");
        lblTitle.setTextFill(Color.GREY);
        lblTitle.setFont(Font.font("Impact", 24));
        GridPane.setHalignment(lblTitle, HPos.CENTER);
        pane.add(lblTitle, 0, 0, 3, 1);
        String[] str = { "Telefonnummer:", "Navn:", "Alder:", "Addresse:", "Kørekortnummer:" };

        for (int i = 0; i < str.length; i++) {
            Label lbl = new Label(str[i]);
            pane.add(lbl, 0, i + 1);
        }
        
        txfTlfNr = new TextField();
        txfName = new TextField();
        txfAlder = new TextField();
        txfAddresse = new TextField();
        txfKørekortNr = new TextField();
        VBox vbTxfs =
            new VBox(12, txfTlfNr, txfName, txfAlder, txfAddresse, txfKørekortNr);
        vbTxfs.getChildren().addAll();
        pane.add(vbTxfs, 1, 1, 1, 5);
        txfTlfNr.setMaxWidth(150);

        Button btnSearch = new Button("SØG");
        btnSearch.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.ITALIC, 13));
        btnSearch.setPrefHeight(txfTlfNr.getHeight());
        pane.add(btnSearch, 1, 1);
        GridPane.setHalignment(btnSearch, HPos.RIGHT);
        btnSearch.setOnAction(event -> findPerson(txfTlfNr.getText()));
        
        Button btnOk = new Button("OK");
        btnOk.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        btnOk.setPrefSize(80, 30);
        btnOk.setOnAction(event -> okAction());

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 1, 7);
        GridPane.setHalignment(btnCancel, HPos.CENTER);
        btnCancel.setOnAction(event -> cancelAction());
        HBox hbxBtns = new HBox(40, btnOk, btnCancel);
        hbxBtns.setAlignment(Pos.BASELINE_CENTER);
        pane.add(hbxBtns, 0, 7, 2, 1);
        lblError = new Label("");
        pane.add(lblError, 0, 6, 2, 1);
        lblError.setStyle("-fx-text-fill: red");
        
    }
    
    // ===========================================================
    // Methods
    // ===========================================================
    private void cancelAction() {

        actualKunde = null;
        UdlejWindow.this.hide();
    }
    
    private void okAction() {
        String name = txfName.getText().trim();
        String addresse = txfAddresse.getText().trim();
        String kørekortNr = txfKørekortNr.getText().trim();
        int tlfNr = -1;
        int alder = -1;
        try {
            tlfNr = Integer.parseInt(txfTlfNr.getText().trim());
            alder = Integer.parseInt(txfAlder.getText().trim());
        }

        catch (NumberFormatException ex) {
            // do nothing
        }

        if (tlfNr < 0) {
            lblError.setText("Telefonnummer mangler");
            return;
        }
        
        if (name.length() == 0) {
            lblError.setText("Navn skal udfyldes");
            return;
        }
        if (alder < 0) {
            lblError.setText("Alder mangler");
            return;
        }
        if (addresse.length() == 0) {
            lblError.setText("Addresse skal udfyldes");
            return;
        }
        if (kørekortNr.length() == 0) {
            lblError.setText("Kørekort skal udfyldes");
            return;
        }
        
        else {
            actualKunde = new Kunde(name, addresse, alder, tlfNr, kørekortNr);
            UdlejWindow.this.hide();

        }
    }

    public Kunde getActualKunde() {
        return actualKunde;
    }

    public void clearActualKunde() {
        actualKunde = null;
        txfName.clear();
        txfAddresse.clear();
        txfAlder.clear();
        txfTlfNr.clear();
        txfKørekortNr.clear();
    }
    
    private void findPerson(String tlfNr) {
        
        Kunde kunde = Service.findKunde(tlfNr);
        
        if (kunde != null) {

            txfName.setText(kunde.getNavn());
            txfAlder.setText("" + kunde.getAlder());
            txfAddresse.setText(kunde.getAddresse());
            txfKørekortNr.setText(kunde.getKørekortnr());
        }
        else {
            lblError.setText("Ingen kunde fundet på nummer");
        }
        
    }
}
