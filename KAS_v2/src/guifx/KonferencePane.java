package guifx;

import java.util.Optional;

import application.model.Hotel;
import application.model.Konference;
import application.model.Tilmeldning;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import storage.Storage;

public class KonferencePane extends Stage {

    // ===========================================================
    // Fields
    // ===========================================================
    private TextField txfTitel, txfPris;
    private ListView<Konference> lvwKonferencer;
    private TextArea txaTilmeldninger, txaHotels, txaUdflugter;

    // ===========================================================
    // Constructors
    // ===========================================================
    public KonferencePane() {
        initStyle(StageStyle.UNDECORATED);
        initModality(Modality.APPLICATION_MODAL);
        GridPane pane = new GridPane();
        
        Scene scene = new Scene(pane);
        setTitle("Konference");
        setScene(scene);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblKonfs = new Label("Konferencer:");
        pane.add(lblKonfs, 0, 0);
        
        lvwKonferencer = new ListView<>();
        pane.add(lvwKonferencer, 0, 1, 1, 4);
        lvwKonferencer.setPrefSize(200, 200);
        lvwKonferencer.getItems().setAll(Storage.getKonferencer());

        ChangeListener<Konference> konferenceListener =
            (ov, oldKonf, newKonference) -> selectionChanged();
        lvwKonferencer.getSelectionModel().selectedItemProperty().addListener(konferenceListener);
        
        Label lblTitel = new Label("Navn:");
        pane.add(lblTitel, 1, 1);

        txfTitel = new TextField();
        pane.add(txfTitel, 2, 1);
        txfTitel.setEditable(false);
        
        Label lblPris = new Label("Pris:");
        pane.add(lblPris, 1, 2);
        
        txfPris = new TextField();
        pane.add(txfPris, 2, 2);
        txfPris.setEditable(false);
        
        Label lblDeltagere = new Label("Deltagere:");
        pane.add(lblDeltagere, 1, 3);
        GridPane.setValignment(lblDeltagere, VPos.BASELINE);
        
        txaTilmeldninger = new TextArea();
        pane.add(txaTilmeldninger, 2, 3);
        txaTilmeldninger.setPrefSize(200, 100);
        txaTilmeldninger.setEditable(false);
        
        Label lblHotels = new Label("Hoteller:");
        pane.add(lblHotels, 1, 4);
        GridPane.setValignment(lblHotels, VPos.BASELINE);
        txaHotels = new TextArea();
        pane.add(txaHotels, 2, 4);
        txaHotels.setEditable(false);
        txaHotels.setPrefSize(200, 100);
        
        HBox hbxButtons = new HBox(40);
        pane.add(hbxButtons, 0, 5, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreate = new Button("Opret konference");
        hbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> createAction());

        Button btnUpdate = new Button("Opdater");
        hbxButtons.getChildren().add(btnUpdate);
        btnUpdate.setOnAction(event -> updateAction());

        Button btnDelete = new Button("Slet");
        hbxButtons.getChildren().add(btnDelete);
        btnDelete.setOnAction(event -> deleteAction());

        Button btnCancel = new Button("Annuller");
        hbxButtons.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> cancelAction());

        if (lvwKonferencer.getItems().size() > 0) {
            lvwKonferencer.getSelectionModel().select(0);
        }

    }

    // ===========================================================
    // Methods
    // ===========================================================
    
    private void createAction() {
        KonferenceWindow kow = new KonferenceWindow();
        kow.showAndWait();
        
        lvwKonferencer.getItems().setAll(Service.getKonferencer());
        int index = lvwKonferencer.getItems().size() - 1;
        lvwKonferencer.getSelectionModel().select(index);
    }

    private void updateAction() {
        Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
        if (konference == null) {
            return;
        }
        else {
            KonferenceWindow kof = new KonferenceWindow(konference);
            kof.showAndWait();
            
            lvwKonferencer.getItems().setAll(Service.getKonferencer());
            lvwKonferencer.getSelectionModel().select(konference);
        }
    }

    private void deleteAction() {
        Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
        if (konference == null) {
            return;
        }
        else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Slet Konference");
            alert.setContentText("Er du sikker?");
            Optional<ButtonType> result = alert.showAndWait();

            if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                Service.deleteKonference(konference);
                lvwKonferencer.getItems().setAll(Service.getKonferencer());
            }
        }
    }
    
    private void cancelAction() {
        hide();
    }
    
    private void selectionChanged() {
        updateControls();
    }
    
    public void updateControls() {
        Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
        if (konference != null) {
            txfTitel.setText(konference.getTitel());
            txfPris.setText("" + konference.getPris());
            
            StringBuilder sb = new StringBuilder();
            for (Tilmeldning t : konference.getTilmeldninger()) {

                sb.append(t.getDeltager().toString() + "\n");
            }
            StringBuilder sb1 = new StringBuilder();
            for (Hotel h : konference.getHoteller()) {
                sb1.append(h.getNavn() + "\n");
            }
//
//            StringBuilder sb2 = new StringBuilder();
//            for (Udflugt u : konference.getUdflugter()) {
//                sb2.append(u.getNavn() + "\n");
//            }
            txaTilmeldninger.setText(sb.toString());
            txaHotels.setText(sb1.toString());
//            txaUdflugter.setText(sb2.toString());

        }
        else {
            txfTitel.clear();
            txfPris.clear();
            txaTilmeldninger.clear();
            txaHotels.clear();
//            txaUdflugter.clear();
        }
    }
}
