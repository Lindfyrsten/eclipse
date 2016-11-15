/**
 *
 */
package guifx;

import application.model.Deltager;
import application.model.Konference;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
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

/**
 * @author Kristian
 */
public class TilmeldningsPane extends Stage {
    // ===========================================================
    // Fields
    // ===========================================================
    private TextField txfNr = new TextField(), txfNavn = new TextField(),
        txfAlder = new TextField(), txfAddresse = new TextField(), txfLand = new TextField(),
        txfLedsager = new TextField(), txfStartDate = new TextField(),
        txfSlutDate = new TextField(), txfFrist = new TextField();
    private CheckBox cbLedsager, cbMad, cbBad, cbWiFi;
    private HBox hbxDates;
    private Deltager deltager;
    private String start, slut, frist;
    private Label lblStart, lblSlut;
    ComboBox<Konference> comboKonf;
    
    // ===========================================================
    // Constructors
    // ===========================================================
    public TilmeldningsPane() {
//        initStyle(StageStyle.UNDECORATED);
        initModality(Modality.APPLICATION_MODAL);
        GridPane pane = new GridPane();
        
        Scene scene = new Scene(pane);
        setTitle("Tilmeld Konference");
        setScene(scene);

        initContent(pane);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(20);
//        pane.setGridLinesVisible(true);

        Label lblTitle = new Label("Tilmeldning");
        lblTitle.setTextFill(Color.GREY);
        lblTitle.setFont(Font.font("Impact", 24));
        GridPane.setHalignment(lblTitle, HPos.CENTER);
        pane.add(lblTitle, 0, 0, 3, 1);

        String[] str = { "Telefonnummer:", "Navn:", "Alder:", "Addresse:", "Land:" };
        
        for (int i = 0; i < str.length; i++) {
            Label lbl = new Label(str[i]);
            pane.add(lbl, 0, i + 1);
        }
        
        VBox vbTxfs = new VBox(13);
        vbTxfs.getChildren().addAll(txfNr, txfNavn, txfAlder, txfAddresse, txfLand, txfLedsager);
        pane.add(vbTxfs, 1, 1, 1, 7);
        txfNr.setMaxWidth(135);
        txfLedsager.setDisable(true);
        
        Button btnSearch = new Button("SØG");
        btnSearch.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.ITALIC, 13));
        btnSearch.setPrefHeight(txfNr.getHeight());
        pane.add(btnSearch, 1, 1);
        GridPane.setHalignment(btnSearch, HPos.RIGHT);
        btnSearch.setOnAction(event -> findPerson(txfNr.getText()));

        cbLedsager = new CheckBox("Ledsager");
        pane.add(cbLedsager, 0, 6);
        cbLedsager.setOnAction(event -> ledsagerOnOff());
        
        Label lblTilmeld = new Label("Vælg konference");
        lblTilmeld.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
        pane.add(lblTilmeld, 0, 8);
        comboKonf = new ComboBox<>();
        comboKonf.prefWidth(100);

        comboKonf.getItems().addAll(Service.tilgængeligeKonferencer());
        pane.add(comboKonf, 1, 8);
        
        ChangeListener<Konference> konferenceListener =
            (ov, oldKonf, newKonference) -> selectionChanged();
        comboKonf.getSelectionModel().selectedItemProperty().addListener(konferenceListener);
        
        Label lblStart = new Label("Start date: ");
        Label lblSlut = new Label("Start date: ");
        
        hbxDates = new HBox(10, lblStart, txfStartDate, lblSlut, txfSlutDate);
        txfStartDate.setMaxWidth(80);
        txfSlutDate.setMaxWidth(80);
        pane.add(hbxDates, 0, 9, 2, 1);
        hbxDates.setDisable(true);
        Button btnTilmeld = new Button("TILMELD");
        btnTilmeld.setFont(Font.font("Tahoma", FontWeight.BOLD, 12));
        pane.add(btnTilmeld, 1, 10);
        btnTilmeld.setOnAction(event -> tilmeldAction());
        
        Button btnAnnuller = new Button("Annuller");
        pane.add(btnAnnuller, 1, 10);
        GridPane.setHalignment(btnAnnuller, HPos.RIGHT);
        btnAnnuller.setOnAction(event -> cancelAction());
    }

    private void selectionChanged() {
        updateControls();
    }
    
    private void updateControls() {
        Konference konference = comboKonf.getSelectionModel().getSelectedItem();
        if (konference != null && konference.getStartDate() != null) {

            hbxDates.setDisable(false);
            start = konference.getStartDate().toString();
            slut = konference.getSlutDate().toString();
            frist = konference.getTilmeldningsfrist().toString();
            
            txfStartDate.setText(start);
            txfSlutDate.setText(slut);
            txfFrist.setText(frist);
        }

    }

    private void findPerson(String tlfNr) {
        deltager = Service.findDeltager(tlfNr);
        txfNavn.setText(deltager.getNavn());
        txfAlder.setText("" + deltager.getAlder());
        txfAddresse.setText(deltager.getAddresse());
        txfLand.setText(deltager.getLand());

    }

    private void ledsagerOnOff() {
        if (cbLedsager.isSelected()) {
            txfLedsager.setDisable(false);
        }
        else {
            txfLedsager.setDisable(true);
        }
    }
    
    private void tilmeldAction() {
//        Tilmeldning t =
//            new Tilmeldning(deltager, comboKonf.getSelectionModel().getSelectedItem(), start, slut);
//        if (Service.findDeltager(txfNr.getText()) != null) {
//            Service.addTilmeldning(this, comboKonf.getSelectionModel().getSelectedItem());
//        }
    }
    
    private void cancelAction() {
        hide();
    }

}
