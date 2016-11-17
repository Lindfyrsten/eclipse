package guifx;

import java.util.ArrayList;
import java.util.Optional;

import application.model.Deltager;
import application.model.Firma;
import application.model.Hotel;
import application.model.HotelTilvalg;
import application.model.Konference;
import application.model.Tilmeldning;
import application.model.Udflugt;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceDialog;
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
        txfLedsager = new TextField(), txfFirma = new TextField();
    private CheckBox cbLedsager, cbForedragsholder, cbFirma;
    private Deltager deltager;
    private Label lblDate, lblError;
    private ComboBox<Konference> comboKonf;
    private Button btnHotel, btnUdflugt, btnTilvalg;
    private Hotel hotelValg;
    private ArrayList<Udflugt> udflugtValg = new ArrayList<>();
    private ArrayList<HotelTilvalg> tilvalgsValg = new ArrayList<>();
    private Konference konference;
    private boolean foredragsholder = false, ledsager = false;

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

        VBox vbTxfs =
            new VBox(13, txfNr, txfNavn, txfAlder, txfAddresse, txfLand, txfLedsager, txfFirma);
        vbTxfs.getChildren().addAll();
        pane.add(vbTxfs, 1, 1, 1, 7);
        txfNr.setMaxWidth(150);
        txfLedsager.setDisable(true);
        txfFirma.setDisable(true);

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
        pane.add(lblTilmeld, 0, 9);
        comboKonf = new ComboBox<>();
        comboKonf.prefWidth(100);

        comboKonf.getItems().addAll(Service.tilgængeligeKonferencer());
        pane.add(comboKonf, 1, 9);
        
        cbFirma = new CheckBox("Firma");
        pane.add(cbFirma, 0, 7);
        cbFirma.setOnAction(evetn -> firmaOnOff());

        ChangeListener<Konference> konferenceListener =
            (ov, oldKonf, newKonference) -> selectionChanged();
        comboKonf.getSelectionModel().selectedItemProperty().addListener(konferenceListener);

        lblDate = new Label();

        pane.add(lblDate, 1, 11);
        GridPane.setHalignment(lblDate, HPos.RIGHT);
        lblDate.setDisable(true);

        btnTilvalg = new Button("Tilvalg");
        btnTilvalg.setOnAction(event -> addTilvalg());
        btnTilvalg.setDisable(true);
        btnHotel = new Button("Book Hotel");
        btnHotel.setOnAction(event -> bookHotel());
        btnHotel.setDisable(true);
        btnUdflugt = new Button("Tilmeld Udflugt");
        
        btnUdflugt.setOnAction(event -> tilmeldUdflugt());
        btnUdflugt.setDisable(true);
        
        HBox hbxValg = new HBox(5, btnUdflugt, btnHotel, btnTilvalg);
        pane.add(hbxValg, 0, 10, 2, 1);
        hbxValg.setAlignment(Pos.BASELINE_CENTER);
        
        cbForedragsholder = new CheckBox("Foredagsholder");
        pane.add(cbForedragsholder, 0, 12);
        cbForedragsholder.setOnAction(event -> foredragsholderOnOff());

        Button btnTilmeld = new Button("TILMELD");
        btnTilmeld.setFont(Font.font("Tahoma", FontWeight.BOLD, 16));
        btnTilmeld.setPrefWidth(100);
        btnTilmeld.setPrefHeight(40);
        pane.add(btnTilmeld, 1, 12);
        btnTilmeld.setOnAction(event -> bekræftTilmeldning());

        Button btnAnnuller = new Button("Annuller");
        pane.add(btnAnnuller, 1, 12);
        GridPane.setHalignment(btnAnnuller, HPos.RIGHT);
        GridPane.setValignment(btnAnnuller, VPos.BOTTOM);
        btnAnnuller.setOnAction(event -> cancelAction());
        
        lblError = new Label();
        pane.add(lblError, 1, 8, 1, 1);
        lblError.setStyle("-fx-text-fill: red");

    }

    private void selectionChanged() {
        updateControls();
    }

    private void updateControls() {
        Konference konference = comboKonf.getSelectionModel().getSelectedItem();
        if (konference != null) {

            btnHotel.setDisable(false);
            lblDate.setDisable(false);
            lblDate.setText(Service.printKonferencePeriod(konference));
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
            btnUdflugt.setDisable(false);
            ledsager = true;
        }
        else {
            txfLedsager.setDisable(true);
            ledsager = false;
            btnUdflugt.setDisable(true);
        }
    }

    private void foredragsholderOnOff() {
        if (cbForedragsholder.isSelected()) {
            foredragsholder = true;
        }
        else {
            foredragsholder = false;
        }
    }
    
    private void firmaOnOff() {
        if (cbFirma.isSelected()) {
            txfFirma.setDisable(false);
        }
        else {
            txfFirma.setDisable(true);
        }
    }

    private void addTilvalg() {
        konference = comboKonf.getSelectionModel().getSelectedItem();

        if (hotelValg == null) {
            return;
        }
        ArrayList<String> arrTilvalg = new ArrayList<>();

        for (HotelTilvalg t : hotelValg.getTilvalg()) {
            arrTilvalg.add(t.getNavn());
        }
        ChoiceDialog<String> chTilvalg = new ChoiceDialog<>("Hotel Tilvalg", arrTilvalg);
        chTilvalg.setTitle("Tilvalg");
        chTilvalg.setHeaderText("Tilgængelige tilvalg");
        chTilvalg.setContentText("Vælg tilvalg:");
        Optional<String> result = chTilvalg.showAndWait();
        
        if (result.isPresent()) {
            for (HotelTilvalg u : hotelValg.getTilvalg()) {
                if (u.getNavn().equals(result.get())) {
                    if (!tilvalgsValg.contains(u)) {
                        tilvalgsValg.add(u);
                    }
                }
            }
        }
    }

    private void bookHotel() {
        ArrayList<String> arrHotels = new ArrayList<>();
        
        for (Hotel h : Service.getHotels()) {
            arrHotels.add(h.toString());
        }
        
        ChoiceDialog<String> chHotel = new ChoiceDialog<>("Hotelvalg", arrHotels);
        chHotel.setTitle("Hotel Valg");
        chHotel.setHeaderText("Tilgængelige hoteller");
        chHotel.setContentText("Vælg dit hotel:");
        Optional<String> result = chHotel.showAndWait();

        if (result.isPresent()) {

            for (Hotel h : Service.getHotels()) {

                if (h.getNavn().equals(result.get())) {
                    hotelValg = h;
                    btnTilvalg.setDisable(false);

                }
            }
        }
        
    }

    private void tilmeldUdflugt() {
        konference = comboKonf.getSelectionModel().getSelectedItem();
        ArrayList<String> arrUdflugter = new ArrayList<>();

        for (Udflugt u : Service.getUdflugter(konference)) {
            arrUdflugter.add(u.getNavn());
        }
        ChoiceDialog<String> chUdflugt = new ChoiceDialog<>("Udflugtvalg", arrUdflugter);
        chUdflugt.setTitle("Udflugt valg");
        chUdflugt.setHeaderText("Tilgængelige udflugter");
        chUdflugt.setContentText("Vælg udflugt:");
        Optional<String> result = chUdflugt.showAndWait();
        
        if (result.isPresent()) {

            for (Udflugt u : Service.getUdflugter(konference)) {
                
                if (u.getNavn().equals(result.get())) {
                    udflugtValg.add(u);
                }
            }
        }
    }

    private void bekræftTilmeldning() {

        if (comboKonf.getSelectionModel().getSelectedItem() == null) {
            return;
        }
        String navn = txfNavn.getText().trim();
        String addresse = txfAddresse.getText().trim();
        String land = txfLand.getText().trim();
        String ledsagerNavn = txfLedsager.getText().trim();
        String firmaNavn = txfFirma.getText().trim();
        double alder = -1;
        double nr = -1;
        try {
            nr = Double.parseDouble(txfNr.getText().trim());
            alder = Double.parseDouble(txfAlder.getText().trim());
        }
        catch (NumberFormatException ex) {
            // do nothing
        }
        if (nr < 0) {
            lblError.setText("Nummer er ikke et positivt nummer");
            return;
        }
        if (alder < 0) {
            lblError.setText("Alder er ikke et positivt nummer");
            return;
        }
        
        if (navn.length() == 0) {
            lblError.setText("Navn er tom");
            return;
        }
        if (addresse.length() == 0) {
            lblError.setText("Addresse er tom");
            return;
        }
        if (land.length() == 0) {
            lblError.setText("Land er tom");
            return;
        }
        if (cbLedsager.isSelected() && ledsagerNavn.length() == 0) {
            lblError.setText("Ledsagernavn er tom");
            return;
        }
        if (cbFirma.isSelected() && firmaNavn.length() == 0) {
            lblError.setText("Firmanavn er tom");
            return;
        }
        konference = comboKonf.getSelectionModel().getSelectedItem();
        double pris =
            Service.samletPris(foredragsholder, konference, hotelValg, ledsager, tilvalgsValg,
                udflugtValg);
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Godkend Tilmeldelse");
        alert.setHeaderText("Samlet pris : " + pris);

        Optional<ButtonType> result = alert.showAndWait();
        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
            tilmeldAction();
        }
    }

    private void tilmeldAction() {
        
        Firma firma = Service.createFirma(txfFirma.getText());

        Tilmeldning t =
            new Tilmeldning(txfNavn.getText(), Integer.parseInt(txfAlder.getText().toString()),
                txfAddresse.getText(), txfLand.getText(), Integer.parseInt(txfNr.getText()),
                konference, hotelValg, tilvalgsValg, udflugtValg, firma);
        konference = comboKonf.getSelectionModel().getSelectedItem();
        konference.addTilmeldning(t);
        Service.addTilmedning(t);
        if (cbLedsager.isSelected() && txfLedsager.getText().length() > 0) {
            t.setLedsagernavn(txfLedsager.getText());
        }

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Tillykke!");
        alert.setHeaderText("Du er nu tilmeldt " + konference.getTitel());
        Optional<ButtonType> result = alert.showAndWait();
        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
            cancelAction();
        }
    }

    private void cancelAction() {
        hide();
    }

}
