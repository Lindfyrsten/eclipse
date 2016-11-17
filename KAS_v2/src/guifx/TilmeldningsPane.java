package guifx;

import application.model.Deltager;
import application.model.Konference;
import application.model.Udflugt;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Kristian
 */
public class TilmeldningsPane extends Stage {
    // ===========================================================
    // Fields
    // ===========================================================
    private TextField txfNr = new TextField(), txfNavn = new TextField(),
        txfAlder = new TextField(), txfAddresse = new TextField(), txfLand = new TextField(),
        txfLedsager = new TextField(), txfFrist = new TextField();
    private CheckBox cbLedsager, cbForedragsholder;
    private Deltager deltager;
    private Label lblDate;
    private ComboBox<Konference> comboKonf;
    private ComboBox<Udflugt> comboUdflugt;

    // ===========================================================
    // Constructors
    // ===========================================================
    public TilmeldningsPane() {
        initStyle(StageStyle.UNDECORATED);
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
        txfNr.setMaxWidth(150);
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

        lblDate = new Label();

        pane.add(lblDate, 1, 7);
        GridPane.setValignment(lblDate, VPos.BOTTOM);
        lblDate.setDisable(true);
        
        cbForedragsholder = new CheckBox("Foredagsholder");
        pane.add(cbForedragsholder, 0, 10);
        
        Button btnTilmeld = new Button("TILMELD");
        btnTilmeld.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
        btnTilmeld.setPrefWidth(120);
        btnTilmeld.setPrefHeight(40);
        pane.add(btnTilmeld, 1, 10);
        btnTilmeld.setOnAction(event -> tilmeldAction());

        Button btnAnnuller = new Button("Annuller");
        pane.add(btnAnnuller, 1, 10);
        GridPane.setHalignment(btnAnnuller, HPos.RIGHT);
        GridPane.setValignment(btnAnnuller, VPos.BOTTOM);
        btnAnnuller.setOnAction(event -> cancelAction());
    }
    
    private void selectionChanged() {
        updateControls();
    }
    
    private void updateControls() {
        Konference konference = comboKonf.getSelectionModel().getSelectedItem();
        if (konference != null) {
            
            lblDate.setDisable(false);
            lblDate.setText(Service.printKonferencePeriod(konference));
            txfFrist.setText(konference.getTilmeldningsfrist().toString());
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
//        Alert confirmation = new Alert(AlertType.CONFIRMATION);
    
    }
    
    private void cancelAction() {
        hide();
    }
    
}
