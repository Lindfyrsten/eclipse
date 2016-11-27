package guifx;

import java.util.ArrayList;
import java.util.Optional;

import application.model.Bil;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BilPane extends GridPane {
    private TextField txfRegNr, txfMærke, txfModel, txfKmKørt;
    private Button btnCreate, btnUpdate, btnDelete, btnPrisGruppe;
    private ListView<Bil> lvwBiler = new ListView<>();

    public BilPane() {
        setPadding(new Insets(20));
        setHgap(10);
        setVgap(10);
        
        Label lblTitel = new Label("Opret Bil");
        lblTitel.setTextFill(Color.GREY);
        lblTitel.setFont(Font.font("Impact", 24));
        this.add(lblTitel, 0, 0, 3, 1);
        GridPane.setHalignment(lblTitel, HPos.CENTER);
        
        Label lblRegNr = new Label("Registreringsnummer");
        Label lblMærke = new Label("Mærke");
        Label lblModel = new Label("Model");
        Label lblKmKørt = new Label("Km kørt");
        txfRegNr = new TextField();
        txfMærke = new TextField();
        txfModel = new TextField();
        txfKmKørt = new TextField();
        btnCreate = new Button("Opret Bil");
        btnUpdate = new Button("Opdater Bil");
        btnDelete = new Button("Slet Bil");
        btnPrisGruppe = new Button("Tildel Prisgruppe");
        
        VBox vbxLbls = new VBox(20, lblRegNr, lblMærke, lblModel, lblKmKørt);
        VBox vbxTxfs = new VBox(10, txfRegNr, txfMærke, txfModel, txfKmKørt);
        HBox hbxBtns = new HBox(40, btnCreate, btnUpdate, btnDelete, btnPrisGruppe);

        lvwBiler.setPrefSize(200, 100);
        lvwBiler.getItems().setAll(initAllBilList());
        ChangeListener<Bil> listener =
            (ov, oldBil, newBil) -> selectedEmployeeChanged();
        lvwBiler.getSelectionModel().selectedItemProperty().addListener(listener);

        btnDelete.setOnAction(event -> deleteAction());
        btnUpdate.setOnAction(event -> updateAction());
        btnCreate.setOnAction(event -> createAction());
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
        updateControls();
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
        alert.setTitle("Delete Car");
        // alert.setContentText("Are you sure?");
        alert.setHeaderText("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();

        // Wait for the modal dialog to close

        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
            Service.deleteBil(bil);
            lvwBiler.getItems().setAll(Service.getBiler());
            updateControls();
        }

    }

    private void selectedEmployeeChanged() {
        updateControls();
    }
    
    public void updateControls() {
        Bil bil = lvwBiler.getSelectionModel().getSelectedItem();
        if (bil != null) {
            txfRegNr.setText(bil.getRegNr());
            txfMærke.setText(bil.getMærke());
            txfModel.setText(bil.getModel());
            txfKmKørt.setText("" + bil.getKmKørt());

        }
        else {
            txfRegNr.clear();
            txfMærke.clear();
            txfModel.clear();
            txfKmKørt.clear();
        }
    }
}
