/**
 *
 */
package guifx;

import application.model.Hotel;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Kristian
 */
public class HotelWindow extends Stage {
    // ===========================================================
    // Fields
    // ===========================================================
    private Hotel hotel;
    
    // ===========================================================
    // Constructors
    // ===========================================================
    public HotelWindow(Hotel hotel) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        
        this.hotel = hotel;

        setTitle("Opret Hotel");
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);

    }

    public HotelWindow() {
        this(null);
    }

    private TextField txfNavn, txfAddresse, txfEnkelt, txfDobbelt, txfMad, txfBad, txfWiFi;
    private ListView tilvalg;
    private Label lblError;
    private CheckBox cbMad, cbBad, cbWiFi;
    
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(50);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);
        
        Label lblName = new Label("Navn");
        pane.add(lblName, 0, 0);
        
        txfNavn = new TextField();
        pane.add(txfNavn, 0, 1);

        Label lblAddressse = new Label("Addresse");
        pane.add(lblAddressse, 0, 2);
        
        txfAddresse = new TextField();
        pane.add(txfAddresse, 0, 3);
        
        Label lblEnkelt = new Label("Enkeltværelse");
        pane.add(lblEnkelt, 0, 4);
        txfEnkelt = new TextField();
        pane.add(txfEnkelt, 0, 5);
        
        Label lblDobbelt = new Label("Dobbeltværelse");
        pane.add(lblDobbelt, 0, 6);
        txfDobbelt = new TextField();
        pane.add(txfDobbelt, 0, 7);

        Label lblTv = new Label("Tilvalg:");
        cbMad = new CheckBox();
        cbMad.setText("Mad");
        cbBad = new CheckBox();
        cbBad.setText("Bad");
        cbWiFi = new CheckBox();
        cbWiFi.setText("WiFi");

        txfMad = new TextField();
        txfMad.setDisable(true);
        txfMad.setMaxWidth(50);
        txfBad = new TextField();
        txfBad.setDisable(true);
        txfBad.setMaxWidth(50);
        txfWiFi = new TextField();
        txfWiFi.setDisable(true);
        txfWiFi.setMaxWidth(50);
        pane.add(lblTv, 1, 0);
        pane.add(cbMad, 1, 1);
        pane.add(txfMad, 1, 2);
        pane.add(cbBad, 1, 3);
        pane.add(txfBad, 1, 4);
        pane.add(cbWiFi, 1, 5);
        pane.add(txfWiFi, 1, 6);

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 8);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 8);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> okAction());

        lblError = new Label();
        pane.add(lblError, 0, 9);
        lblError.setStyle("-fx-text-fill: red");

        initControls();
    }
    
    private void initControls() {

        if (hotel != null) {
            txfNavn.setText(hotel.getNavn());
            txfAddresse.setText("" + hotel.getAddresse());
            txfEnkelt.setText("" + hotel.getDagsPrisEnkelt());
            txfDobbelt.setText("" + hotel.getDagsPrisDobbelt());

        }
        else {
            
            txfNavn.clear();
            txfAddresse.clear();
            txfEnkelt.clear();
            txfDobbelt.clear();

        }
    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
        hide();
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
        else if (dobbelt < 0) {
            lblError.setText("Dobbeltpris mangler");
            return;
        }

        // Call service methods
        if (hotel != null) {
            Service.updateHotel(hotel, name, addresse, enkelt, dobbelt);
        }
        else {
            Service.createHotel(name, addresse, enkelt, dobbelt);
        }

        hide();
    }

}
