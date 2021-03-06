/**
 *
 */
package guifx;

import java.util.Optional;

import application.model.Hotel;
import application.model.HotelTilvalg;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HotelPane extends Stage {
    // ===========================================================
    // Fields
    // ===========================================================
    private TextField txfName, txfAddresse, txfEnkelt, txfDobbelt;
    private ListView<Hotel> lvwHotels;
    private CheckBox cbMad, cbBad, cbWiFi;
    private TextArea txaGæster;

    // ===========================================================
    // Constructors
    // ===========================================================
    public HotelPane() {
        initStyle(StageStyle.UNDECORATED);
        initModality(Modality.APPLICATION_MODAL);
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        setTitle("Hotel");
        setScene(scene);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        
        initContent(pane);

    }

    private void initContent(GridPane pane) {
        
//        pane.setGridLinesVisible(true);
        lvwHotels = new ListView<>();
        lvwHotels.setPrefSize(200, 200);
        lvwHotels.getItems().setAll(Service.getHotels());
        
        ChangeListener<Hotel> listener = (ov, oldHotel, newHotel) -> selectedHotelChanged();
        lvwHotels.getSelectionModel().selectedItemProperty().addListener(listener);
        
        Label lblTitle = new Label("Hotel Management:");
        lblTitle.setTextFill(Color.GREY);
        lblTitle.setFont(Font.font("Impact", 24));
        GridPane.setHalignment(lblTitle, HPos.CENTER);
        Label lblNavn = new Label("Navn:");
        Label lblAddresse = new Label("Addresse");
        Label lblEnkelt = new Label("Enkelt værelse");
        Label lblDobbelt = new Label("Dobbelt værelse");
        Label lblGæster = new Label("Gæste liste:");

        txfName = new TextField();
        txfName.setPrefWidth(200);
        txfName.setEditable(false);
        txfAddresse = new TextField();
        txfAddresse.setEditable(false);
        txfEnkelt = new TextField();
        txfEnkelt.setEditable(false);
        txfDobbelt = new TextField();
        txfDobbelt.setEditable(false);
        
        txaGæster = new TextArea();
        txaGæster.setPrefSize(200, 100);

        cbMad = new CheckBox();
        cbMad.setText("Mad");
        cbMad.setMouseTransparent(true);
        cbBad = new CheckBox();
        cbBad.setText("Bad");
        cbBad.setMouseTransparent(true);
        cbWiFi = new CheckBox();
        cbWiFi.setText("WiFi");
        cbWiFi.setMouseTransparent(true);

        HBox hbxCheckBox = new HBox(40);
        hbxCheckBox.setPadding(new Insets(10));
        hbxCheckBox.setAlignment(Pos.BASELINE_CENTER);
        hbxCheckBox.getChildren().addAll(cbMad, cbBad, cbWiFi);

        Button btnCreate = new Button("Opret");
        btnCreate.setPrefSize(75, 50);
        Button btnUpdate = new Button("Opdater");
        btnUpdate.setPrefSize(75, 50);
        Button btnDelete = new Button("Slet");
        btnDelete.setPrefSize(75, 50);
        Button btnCancel = new Button("Annuller");
        GridPane.setHalignment(btnCancel, HPos.RIGHT);
        GridPane.setValignment(btnCancel, VPos.BOTTOM);

        VBox vbxGæste = new VBox(10, lblGæster, txaGæster);
        
        HBox hbxButtons = new HBox(40);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.TOP_CENTER);
        hbxButtons.getChildren().addAll(btnCreate, btnUpdate, btnDelete);
        btnCreate.setOnAction(event -> createAction());
        btnUpdate.setOnAction(event -> updateAction());
        btnDelete.setOnAction(event -> deleteAction());
        btnCancel.setOnAction(event -> cancelAction());
        
        pane.add(lblTitle, 0, 0, 5, 1);
        pane.add(lvwHotels, 0, 1, 1, 5);
        pane.add(vbxGæste, 0, 6, 1, 2);
        pane.add(lblNavn, 1, 1);
        pane.add(txfName, 2, 1);
        pane.add(lblAddresse, 1, 2);
        pane.add(txfAddresse, 2, 2);
        pane.add(lblEnkelt, 1, 3);
        pane.add(txfEnkelt, 2, 3);
        pane.add(lblDobbelt, 1, 4);
        pane.add(txfDobbelt, 2, 4);
        pane.add(hbxCheckBox, 1, 5, 2, 1);
        pane.add(hbxButtons, 1, 6, 3, 1);
        pane.add(btnCancel, 2, 7);

        if (lvwHotels.getItems().size() > 0) {
            lvwHotels.getSelectionModel().select(0);
        }
    }

    private void createAction() {

        HotelWindow hot = new HotelWindow();
        hot.showAndWait();
        
        lvwHotels.getItems().setAll(Service.getHotels());
        int index = lvwHotels.getItems().size() - 1;
        lvwHotels.getSelectionModel().select(index);
    }
    
    private void updateAction() {

        int index = lvwHotels.getSelectionModel().getSelectedIndex();
        Hotel hotel = lvwHotels.getSelectionModel().getSelectedItem();
        if (hotel == null) {
            return;
        }

        HotelWindow hot = new HotelWindow(hotel);
        hot.showAndWait();
        
        lvwHotels.getItems().setAll(Service.getHotels());
        lvwHotels.getSelectionModel().select(index);

    }
    
    private void deleteAction() {
        Hotel hotel = lvwHotels.getSelectionModel().getSelectedItem();
        if (hotel == null) {
            return;
        }

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Slet Hotel");
        alert.setContentText("Er du sikker?");
        Optional<ButtonType> result = alert.showAndWait();

        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
            Service.deleteHotel(hotel);
            lvwHotels.getItems().setAll(Service.getHotels());
        }
    }
    
    private void cancelAction() {
        hide();
    }
    
    private void selectedHotelChanged() {

        updateControls();
    }
    
    public void updateControls() {
        cbMad.setSelected(false);
        cbBad.setSelected(false);
        cbWiFi.setSelected(false);
        Hotel hotel = lvwHotels.getSelectionModel().getSelectedItem();
        if (hotel != null) {
            txfName.setText(hotel.getNavn());
            txfAddresse.setText(hotel.getAddresse());
            txfEnkelt.setText("" + hotel.getDagsPrisEnkelt());
            txfDobbelt.setText("" + hotel.getDagsPrisDobbelt());
            txaGæster.setText(Service.getOvernatninger(hotel));

            for (HotelTilvalg tv : hotel.getTilvalg()) {
                if (tv.getNavn().equals("Mad")) {
                    cbMad.setSelected(true);
                }
                if (tv.getNavn().equals("Bad")) {
                    cbBad.setSelected(true);
                }
                if (tv.getNavn().equals("WiFi")) {
                    cbWiFi.setSelected(true);
                }
            }

        }
        else {
            txfName.clear();
            txfAddresse.clear();
            txfEnkelt.clear();
            txfDobbelt.clear();
            cbMad.setSelected(false);
            cbBad.setSelected(false);
            cbWiFi.setSelected(false);
            txaGæster.clear();
        }

    }
    
}
