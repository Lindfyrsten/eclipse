/**
 *
 */
package guifx;

import java.util.ArrayList;

import application.model.Hotel;
import application.model.HotelTilvalg;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
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
public class HotelWindow extends Stage {
    // ===========================================================
    // Fields
    // ===========================================================
    private Hotel hotel;

    private TextField txfNavn, txfAddresse, txfEnkelt, txfDobbelt, txfMad, txfBad, txfWiFi;
    private ArrayList<HotelTilvalg> tilvalg = new ArrayList<>();
    private Label lblError;
    private CheckBox cbMad, cbBad, cbWiFi;

    // ===========================================================
    // Constructors
    // ===========================================================
    public HotelWindow(Hotel hotel) {
        
        this.hotel = hotel;
        setTitle("Opdater Hotel");
        initContent();

    }

    public HotelWindow() {

        this(null);

        setTitle("Opret Hotel");
        initContent();
        
    }

    private void initContent() {
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        setScene(scene);
        initModality(Modality.APPLICATION_MODAL);
        pane.setPadding(new Insets(10, 10, 0, 10));
        pane.setHgap(50);
        pane.setVgap(10);
        
        Label lblTitle = new Label("Opret Hotel");
        lblTitle.setTextFill(Color.GREY);
        lblTitle.setFont(Font.font("Impact", 24));
        GridPane.setHalignment(lblTitle, HPos.CENTER);
        pane.add(lblTitle, 0, 0, 2, 1);
        Label lblName = new Label("Navn");
        Label lblAddressse = new Label("Addresse");
        Label lblEnkelt = new Label("Enkeltværelse");
        Label lblDobbelt = new Label("Dobbeltværelse");
        txfNavn = new TextField();
        txfAddresse = new TextField();
        txfEnkelt = new TextField();
        txfDobbelt = new TextField();
        VBox vbxFields = new VBox(10, lblName, txfNavn, lblAddressse, txfAddresse, lblEnkelt,
            txfEnkelt, lblDobbelt, txfDobbelt);
        pane.add(vbxFields, 0, 1, 1, 2);

        Label lblTv = new Label("Tilvalg:");
        GridPane.setHalignment(lblTv, HPos.CENTER);
        pane.add(lblTv, 1, 1);
        cbMad = new CheckBox();
        cbMad.setText("Mad");
        cbBad = new CheckBox();
        cbBad.setText("Bad");
        cbWiFi = new CheckBox();
        cbWiFi.setText("WiFi");

        txfMad = new TextField();
        txfMad.setDisable(true);
        txfMad.setMaxWidth(50);
        txfMad.setText("0");
        txfBad = new TextField();
        txfBad.setDisable(true);
        txfBad.setMaxWidth(50);
        txfBad.setText("0");
        txfWiFi = new TextField();
        txfWiFi.setDisable(true);
        txfWiFi.setMaxWidth(50);
        txfWiFi.setText("0");
        
        VBox vbxTilvalg = new VBox(10, cbMad, txfMad, cbBad, txfBad, cbWiFi, txfWiFi);
        pane.add(vbxTilvalg, 1, 2);
        vbxTilvalg.setAlignment(Pos.BASELINE_CENTER);
        vbxTilvalg
            .setStyle("-fx-padding: 10;" + "-fx-border-width: 2;" + "-fx-border-color: lightgrey");
        
        Button btnOK = new Button("OK");
        btnOK.setPrefSize(75, 50);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        GridPane.setValignment(btnOK, VPos.BOTTOM);
        btnOK.setOnAction(event -> okAction());
        
        Button btnCancel = new Button("Annuller");
        btnCancel.setPrefSize(75, 50);
        GridPane.setHalignment(btnCancel, HPos.RIGHT);
        GridPane.setValignment(btnCancel, VPos.BOTTOM);
        btnCancel.setOnAction(event -> cancelAction());

        HBox hbxBtns = new HBox(100, btnOK, btnCancel);
        hbxBtns.setPadding(new Insets(10, 10, 0, 10));
        hbxBtns.setAlignment(Pos.BASELINE_CENTER);
        pane.add(hbxBtns, 0, 3, 2, 1);

        lblError = new Label();
        pane.add(lblError, 0, 4);
        lblError.setStyle("-fx-text-fill: red");

        initControls();

    }

    // -------------------------------------------------------------------------

    // -------------------------------------------------------------------------
    private void initControls() {
        
        if (hotel != null) {
            txfNavn.setText(hotel.getNavn());
            txfAddresse.setText("" + hotel.getAddresse());
            txfEnkelt.setText("" + hotel.getDagsPrisEnkelt());
            txfDobbelt.setText("" + hotel.getDagsPrisDobbelt());
            cbMad.setSelected(false);
            cbBad.setSelected(false);
            cbWiFi.setSelected(false);
            if (!hotel.getTilvalg().isEmpty()) {
                
                for (HotelTilvalg tv : hotel.getTilvalg()) {
                    if (tv.getNavn().equals("Mad")) {
                        cbMad.setSelected(true);
                        txfMad.setText("" + tv.getPris());
                        txfMad.setDisable(false);
                    }
                    if (tv.getNavn().equals("Bad")) {
                        cbBad.setSelected(true);
                        txfBad.setText("" + tv.getPris());
                        txfBad.setDisable(false);
                    }
                    if (tv.getNavn().equals("WiFi")) {
                        cbWiFi.setSelected(true);
                        txfWiFi.setText("" + tv.getPris());
                        txfWiFi.setDisable(false);
                    }
                }
            }

        }
        else {

            txfNavn.clear();
            txfAddresse.clear();
            txfEnkelt.clear();
            txfDobbelt.clear();
            cbMad.setSelected(false);
            cbBad.setSelected(false);
            cbWiFi.setSelected(false);
            txfMad.setText("0");
            txfBad.setText("0");
            txfWiFi.setText("0");

        }

        cbMad.setOnAction(event -> {
            if (cbMad.isSelected()) {
                txfMad.setDisable(false);
            }
            else {
                txfMad.setDisable(true);
            }
        });

        cbBad.setOnAction(event -> {
            if (cbBad.isSelected()) {
                txfBad.setDisable(false);
            }
            else {
                txfBad.setDisable(true);
            }
        });
        cbWiFi.setOnAction(event -> {
            if (cbWiFi.isSelected()) {
                txfWiFi.setDisable(false);
            }
            else {
                txfWiFi.setDisable(true);
            }
        });

    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
        
        HotelWindow.this.hide();
    }

    private void okAction() {
        
        String name = txfNavn.getText().trim();
        String addresse = txfAddresse.getText().trim();

        if (name.length() == 0) {
            lblError.setText("Name is empty");
            return;
        }
        if (addresse.length() == 0) {
            lblError.setText("Addresse skal udfyldes");
            return;
        }
        
        double enkelt = -1;
        double dobbelt = -1;

        try {
            enkelt = Double.parseDouble(txfEnkelt.getText().trim());
            dobbelt = Double.parseDouble(txfDobbelt.getText().trim());
        }
        
        catch (NumberFormatException ex) {
            // do nothing
        }
        
        if (enkelt < 0) {
            lblError.setText("Enkeltpris mangler");
            return;
        }
        else
            if (dobbelt < 0) {
                lblError.setText("Dobbeltpris mangler");
                return;
            }

        if (cbMad.isSelected()) {
            
            tilvalg.add(
                Service.createTilvalg(cbMad.getText().trim(),
                    Double.parseDouble(txfMad.getText())));
        }

        if (cbBad.isSelected()) {

            tilvalg.add(
                Service.createTilvalg(cbBad.getText().trim(),
                    Double.parseDouble(txfBad.getText())));
            
        }

        if (cbWiFi.isSelected()) {

            tilvalg.add(
                Service.createTilvalg(cbWiFi.getText().trim(),
                    Double.parseDouble(txfWiFi.getText())));

        }

// Call service methods
        if (hotel != null) {
            Service.updateHotel(hotel, name, addresse, enkelt, dobbelt, tilvalg);

        }
        else {

            Service.createHotel(name, addresse, enkelt, dobbelt, tilvalg);
        }

        HotelWindow.this.hide();
    }

}
