package guifx;

import java.util.Optional;

import application.model.Område;
import application.service.Service;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() {
        Service.init();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Sønderhøj Netcafé reservation");
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private ListView<Område> lvwOmråder;
    private Button btnOpretOmråde, btnDeleteOmråde;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setVgap(10);
        pane.setHgap(10);
        
        Label lblOmråde = new Label("Område");
        pane.add(lblOmråde, 0, 0);
        
        lvwOmråder = new ListView<>();
        pane.add(lvwOmråder, 0, 1, 1, 4);
        lvwOmråder.setPrefWidth(200);
        lvwOmråder.setPrefHeight(200);
        lvwOmråder.getItems().setAll(Service.getOmråder());

        ChangeListener<Område> listener = (ov, oldOmråde, newOmråde) -> selectedOmrådeChanged();
        lvwOmråder.getSelectionModel().selectedItemProperty().addListener(listener);

        btnOpretOmråde = new Button("Opret område");
        btnDeleteOmråde = new Button("Slet område");
        pane.add(btnOpretOmråde, 0, 5);
        pane.add(btnDeleteOmråde, 0, 5);
        GridPane.setHalignment(btnDeleteOmråde, HPos.RIGHT);
    }

    private void selectedOmrådeChanged() {
        updateControls();
    }
    
    public void updateControls() {
        Område område = lvwOmråder.getSelectionModel().getSelectedItem();
    }
    
    private void deleteAction() {
        Område område = lvwOmråder.getSelectionModel().getSelectedItem();
        if (område == null) {
            return;
        }
        if (område.getLedigePladser() == område.getAntalPladser()) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Slet Område");
            alert.setHeaderText("Er du sikker?");
            Optional<ButtonType> result = alert.showAndWait();
            if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                Service.deleteOmråde(område);
                lvwOmråder.getItems().setAll(Service.getOmråder());
                updateControls();
            }
        }
        else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Slet Område");
            alert.setHeaderText("Kan ikke slette et område med aktive reservationer");
            alert.show();
        }
    }

}
