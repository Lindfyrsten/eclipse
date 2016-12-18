package guifx;

import java.time.LocalDate;
import java.time.LocalTime;

import application.model.Bane;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import service.Service;

public class MainApp extends Application {
    private ListView<Bane> lvwBaner;
    private ListView<LocalTime> lvwTider;
    private DatePicker dp;

    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Booking af tennisbaner");
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane, 400, 400);
        stage.setScene(scene);
        stage.show();

        Service.initStorage();

        pane.setPadding(new Insets(10));
        pane.setVgap(10);
        pane.setHgap(10);
        
        Label lblDato = new Label("Dato:");
        pane.add(lblDato, 0, 0);
        Label lblLedig = new Label("Ledige tider:");
        pane.add(lblLedig, 1, 0);
//        txfDato = new TextField();
//        pane.add(txfDato, 0, 1);
        dp = new DatePicker();
        pane.add(dp, 0, 1);
        lvwTider = new ListView<>();
        pane.add(lvwTider, 1, 1, 1, 3);
        Label lblBaner = new Label("Baner");
        pane.add(lblBaner, 0, 2);
        lvwBaner = new ListView<>();
        lvwBaner.getItems().setAll(Service.getBaner());
        pane.add(lvwBaner, 0, 3);
        Button btnOpret = new Button("Opret bane");
        pane.add(btnOpret, 0, 4);
        btnOpret.setOnAction(event -> createBane());
        ChangeListener<Bane> baneListener =
            (ov, oldBane, newBane) -> selectionChange();
        lvwBaner.getSelectionModel().selectedItemProperty().addListener(baneListener);
        dp.setOnAction(event -> selectionChange());
        if (lvwBaner.getItems().size() > 0) {
            lvwBaner.getSelectionModel().select(0);
        }
    }

    private void selectionChange() {
        LocalDate dato = dp.getValue();
        Bane bane = lvwBaner.getSelectionModel().getSelectedItem();
        if (bane != null && dato != null) {

            lvwTider.getItems().setAll(bane.getLedigeTiderPaaDag(dato));
        }
    }

    private void createBane() {

        CreateBanePane bp = new CreateBanePane();
        bp.showAndWait();
        lvwBaner.getItems().setAll(Service.getBaner());

    }

}
