/**
 *
 */
package guifx;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import application.model.Bil;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * @author Kristian
 */
public class AfleverPane extends GridPane {
    private Button btnAflever, btnCancel;
    private ListView<Bil> lvwBiler = new ListView<>();
    private DatePicker dpStart, dpSlut;
    
    public AfleverPane() {
        
        setPadding(new Insets(20));
        setHgap(10);
        setVgap(10);
        
        Label lblTitel = new Label("Udlej/reserver Bil");
        lblTitel.setTextFill(Color.GREY);
        lblTitel.setFont(Font.font("Impact", 24));
        this.add(lblTitel, 0, 0, 4, 1);
        GridPane.setHalignment(lblTitel, HPos.CENTER);

        btnAflever = new Button("Udlej");
        btnCancel = new Button("Annuller");

        Label lblStart = new Label("Fra Dato:");
        Label lblSlut = new Label("Til Dato:");
        dpStart = new DatePicker(LocalDate.now());
        dpSlut = new DatePicker(LocalDate.now());
        
        VBox vbxLbls = new VBox(20, lblStart, lblSlut);
        VBox vbxTxfs = new VBox(10, dpStart, dpSlut);
        HBox hbxBtns = new HBox(40, btnAflever, btnCancel);
        hbxBtns.setAlignment(Pos.BASELINE_CENTER);
        
        lvwBiler.setPrefSize(200, 120);
        lvwBiler.getItems().setAll(initAllBilList());
        ChangeListener<Bil> listener =
            (ov, oldBil, newBil) -> selectedBilChanged();
        lvwBiler.getSelectionModel().selectedItemProperty().addListener(listener);
        
        btnAflever.setOnAction(event -> udlejAction());
        this.add(vbxLbls, 0, 1);
        this.add(vbxTxfs, 1, 1);
        this.add(hbxBtns, 0, 2, 4, 1);
        this.add(lvwBiler, 2, 1);
        
        if (lvwBiler.getItems().size() > 0) {
            lvwBiler.getSelectionModel().select(0);
        }
        
    }
    
    private ArrayList<Bil> initAllBilList() {
        ArrayList<Bil> list = new ArrayList<>();
        for (Bil bil : Service.getBiler()) {
            if (!bil.isUdlejet()) {

                list.add(bil);
            }
        }
        Collections.sort(list);
        return list;
    }
    
    private void udlejAction() {

        Bil bil = lvwBiler.getSelectionModel().getSelectedItem();
//        Service.afleverBil(udlejning);(bil, dpStart.getValue(), dpSlut.getValue());

        // Wait for the modal dialog to close

        lvwBiler.getItems().setAll(initAllBilList());
        int index = lvwBiler.getItems().size() - 1;
        lvwBiler.getSelectionModel().select(index);
//            updateControls();
    }
    
    private void selectedBilChanged() {
        updateControls();
    }
    
    public void updateControls() {
        Bil bil = lvwBiler.getSelectionModel().getSelectedItem();
        if (bil != null) {

        }
        else {

        }
    }
}
