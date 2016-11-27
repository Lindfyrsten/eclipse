package guifx;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import application.model.Bil;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class UdlejPane extends GridPane {
    private Button btnUdlej, btnReserver, btnCancel;
    private ListView<Bil> lvwBiler = new ListView<>();
    private DatePicker dpStart, dpSlut;
    
    public UdlejPane() {
        
        setPadding(new Insets(20));
        setHgap(10);
        setVgap(10);
        
        Label lblTitel = new Label("Udlej/reserver Bil");
        lblTitel.setTextFill(Color.GREY);
        lblTitel.setFont(Font.font("Impact", 24));
        this.add(lblTitel, 0, 0, 3, 1);
        GridPane.setHalignment(lblTitel, HPos.CENTER);

        btnUdlej = new Button("Udlej");
        btnReserver = new Button("Reserver");
        btnCancel = new Button("Annuller");

        Label lblStart = new Label("Fra Dato:");
        Label lblSlut = new Label("Til Dato:");
        dpStart = new DatePicker(LocalDate.now());
        dpSlut = new DatePicker(LocalDate.now());
        
        VBox vbxLbls = new VBox(20, lblStart, lblSlut);
        VBox vbxTxfs = new VBox(10, dpStart, dpSlut);
        HBox hbxBtns = new HBox(40, btnUdlej, btnReserver, btnCancel);
        hbxBtns.setAlignment(Pos.BASELINE_CENTER);
        
        lvwBiler.setPrefSize(200, 100);
        lvwBiler.getItems().setAll(initAllBilList());
        ChangeListener<Bil> listener =
            (ov, oldBil, newBil) -> selectedBilChanged();
        lvwBiler.getSelectionModel().selectedItemProperty().addListener(listener);
        
        btnCancel.setOnAction(event -> deleteAction());
        btnReserver.setOnAction(event -> updateAction());
        btnUdlej.setOnAction(event -> createAction());
        this.add(vbxLbls, 0, 1);
        this.add(vbxTxfs, 1, 1);
        this.add(hbxBtns, 0, 2, 3, 1);
        this.add(lvwBiler, 2, 1);
        
        if (lvwBiler.getItems().size() > 0) {
            lvwBiler.getSelectionModel().select(0);
        }
        
    }
    
    private ArrayList<Bil> initAllBilList() {
        ArrayList<Bil> list = new ArrayList<>();
        for (Bil bil : Service.getBiler()) {
            list.add(bil);
        }
        return list;
    }
    
    private void createAction() {
        BilWindow dia = new BilWindow("Opret Bil");
        dia.showAndWait();
        
        // Wait for the modal dialog to close
        
        lvwBiler.getItems().setAll(initAllBilList());
        int index = lvwBiler.getItems().size() - 1;
        lvwBiler.getSelectionModel().select(index);
//            updateControls();
    }
    
    private void updateAction() {
        Bil bil = lvwBiler.getSelectionModel().getSelectedItem();
        if (bil == null) {
            return;
        }
        
        BilWindow dia = new BilWindow("Opdater Bil", bil);
        dia.showAndWait();
        
        // Wait for the modal dialog to close
        
        int selectIndex = lvwBiler.getSelectionModel().getSelectedIndex();
        lvwBiler.getItems().setAll(initAllBilList());
        lvwBiler.getSelectionModel().select(selectIndex);
    }
    
    private void deleteAction() {
        Bil bil = lvwBiler.getSelectionModel().getSelectedItem();
        if (bil == null) {
            return;
        }
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Slet Bil");
        // alert.setContentText("Are you sure?");
        alert.setHeaderText("Er du sikker på at du vil slette bilen?");
        Optional<ButtonType> result = alert.showAndWait();
        
        // Wait for the modal dialog to close
        
        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
            Service.deleteBil(bil);
            lvwBiler.getItems().setAll(Service.getBiler());
            updateControls();
        }
        
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
