package guifx;

import java.util.Optional;

import application.model.Konference;
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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
    private TextArea txaTilmeldninger;
    private Label lblDatePeriod, lblFrist;

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
        
//      pane.setGridLinesVisible(true);
        
        lvwKonferencer = new ListView<>();
        lvwKonferencer.setPrefSize(200, 200);
        lvwKonferencer.getItems().setAll(Storage.getKonferencer());

        ChangeListener<Konference> konferenceListener =
            (ov, oldKonf, newKonference) -> selectionChanged();
        lvwKonferencer.getSelectionModel().selectedItemProperty().addListener(konferenceListener);
        
        Label lblTitle = new Label("Konference Management:");
        lblTitle.setTextFill(Color.GREY);
        lblTitle.setFont(Font.font("Impact", 24));
        Label lblTitel = new Label("Navn:");
        Label lblPris = new Label("Pris:");
        Label lblDeltagere = new Label("Deltagere:");
        Label lblFristLabel = new Label("Tilmeldningsfrist: ");
        Label lblDateLabel = new Label("Dato: ");
        lblFrist = new Label();
        lblDatePeriod = new Label();

        Button btnCreate = new Button("Opret konference");
        Button btnUpdate = new Button("Opdater");
        Button btnDelete = new Button("Slet");
        Button btnCancel = new Button("Annuller");

        txfTitel = new TextField();
        txfTitel.setEditable(false);
        txfPris = new TextField();
        txfPris.setEditable(false);
        txaTilmeldninger = new TextArea();
        txaTilmeldninger.setEditable(false);
        txaTilmeldninger.setPrefSize(200, 100);

        HBox hbxButtons = new HBox(40);
        pane.add(hbxButtons, 0, 6, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);
        hbxButtons.getChildren().addAll(btnCreate, btnUpdate, btnDelete, btnCancel);
        
        pane.add(lblTitle, 0, 0, 3, 1);
        pane.add(lvwKonferencer, 0, 1, 1, 5);
        pane.add(lblTitel, 1, 1);
        pane.add(txfTitel, 2, 1);
        pane.add(lblPris, 1, 2);
        pane.add(txfPris, 2, 2);
        pane.add(lblDeltagere, 1, 3);
        pane.add(txaTilmeldninger, 2, 3);
        pane.add(lblDateLabel, 1, 4);
        pane.add(lblDatePeriod, 2, 4);
        pane.add(lblFristLabel, 1, 5);
        pane.add(lblFrist, 2, 5);
        
        GridPane.setHalignment(lblTitle, HPos.CENTER);
        GridPane.setValignment(lblDeltagere, VPos.BASELINE);

        btnCreate.setOnAction(event -> createAction());

        btnUpdate.setOnAction(event -> updateAction());

        btnDelete.setOnAction(event -> deleteAction());

        btnCancel.setOnAction(event -> cancelAction());

        if (lvwKonferencer.getItems().size() > 0) {
            lvwKonferencer.getSelectionModel().select(0);
        }

    }

    // ===========================================================
    // Methods
    // ===========================================================
    
    private void createAction() {
        KonferenceWindow kow = new KonferenceWindow("Opret Konference");
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
            KonferenceWindow kof = new KonferenceWindow("Opdater Konference", konference);
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
            
            if (konference.getTilmeldninger() != null) {
                txaTilmeldninger.setText(konference.printTilmeldninger());
            }
            else {
                txaTilmeldninger.clear();
            }
            if (konference.getStartDate() != null) {
                
                lblDatePeriod.setText(Service.printKonferencePeriod(konference));
                lblFrist.setText(Service.printTilmeldningsfrist(konference));
            }

            else {

                lblDatePeriod.setText("");
                lblFrist.setText("");
                
            }
//            if (konference.getUdflugter().size() > 0){
//                lvwKonferencer
//            }
        
        }
    }
}
