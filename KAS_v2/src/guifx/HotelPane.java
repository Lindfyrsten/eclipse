/**
 *
 */
package guifx;

import java.util.ArrayList;

import application.model.Hotel;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Kristian
 */
public class HotelPane extends Stage {
    // ===========================================================
    // Fields
    // ===========================================================
    private TextField txfName, txfAddresse, txfEnkelt, txfDobbelt;
    private ListView<Hotel> lvwHotels;

    // ===========================================================
    // Constructors
    // ===========================================================
    public HotelPane() {
//        initStyle(StageStyle.UNDECORATED);
        initModality(Modality.APPLICATION_MODAL);
        GridPane pane = new GridPane();

        Scene scene = new Scene(pane);
        setTitle("Hotel");
        setScene(scene);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        
        Label lblHoteller = new Label("Hoteller");
        pane.add(lblHoteller, 0, 0);

        lvwHotels = new ListView<>();
        pane.add(lvwHotels, 0, 1, 1, 5);
        lvwHotels.setPrefSize(200, 200);
        lvwHotels.getItems().setAll(initAllHotelList());

        ChangeListener<Hotel> listener = (ov, oldHotel, newHotel) -> selectedHotelChanged();
        lvwHotels.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblNavn = new Label("Navn:");
        pane.add(lblNavn, 1, 1);

        txfName = new TextField();
        pane.add(txfName, 2, 1);
        txfName.setPrefWidth(200);
        txfName.setEditable(false);

        Label lblAddresse = new Label("Addresse");
        pane.add(lblAddresse, 1, 2);

        txfAddresse = new TextField();
        pane.add(txfAddresse, 2, 2);
        txfAddresse.setEditable(false);

        Label lblEnkelt = new Label("Enkelt værelse");
        pane.add(lblEnkelt, 1, 3);
        
        txfEnkelt = new TextField();
        pane.add(txfEnkelt, 2, 3);
        txfEnkelt.setEditable(false);

        Label lblDobbelt = new Label("Dobbelt værelse");
        pane.add(lblDobbelt, 1, 4);

        txfDobbelt = new TextField();
        pane.add(txfDobbelt, 2, 4);
        txfDobbelt.setEditable(false);
        
        HBox hbxButtons = new HBox(40);
        pane.add(hbxButtons, 0, 6, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreate = new Button("Create");
        hbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> createAction());

        Button btnUpdate = new Button("Update");
        hbxButtons.getChildren().add(btnUpdate);
        btnUpdate.setOnAction(event -> updateAction());

        Button btnDelete = new Button("Delete");
        hbxButtons.getChildren().add(btnDelete);
        btnDelete.setOnAction(event -> deleteAction());

        if (lvwHotels.getItems().size() > 0) {
            lvwHotels.getSelectionModel().select(0);
        }
        
    }
    
    private ArrayList<Hotel> initAllHotelList() {
        ArrayList<Hotel> list = new ArrayList<>();
        for (Hotel h : Service.getHotels()) {
            list.add(h);
        }
        return list;
    }

    private void createAction() {

    }
    
    private void updateAction() {

    }
    
    private void deleteAction() {

    }

    private void selectedHotelChanged() {
        updateControls();
    }

    public void updateControls() {
        Hotel hotel = lvwHotels.getSelectionModel().getSelectedItem();
        if (hotel != null) {
            txfName.setText(hotel.getNavn());
            txfAddresse.setText(hotel.getAddresse());
            txfEnkelt.setText("" + hotel.getDagsPrisEnkelt());
            txfDobbelt.setText("" + hotel.getDagsPrisDobbelt());

        }
        else {
            txfName.clear();
            txfAddresse.clear();
            txfEnkelt.clear();
            txfDobbelt.clear();
        }
    }
    
}
