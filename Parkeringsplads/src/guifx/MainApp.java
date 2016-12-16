package guifx;

import java.time.LocalTime;

import application.model.Parkeringshus;
import application.model.Parkeringsplads;
import application.service.Service;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainApp extends Application {

    private ListView<Parkeringshus> lvwParkeringshuse;
    private ListView<Parkeringsplads> lvwOptagnePladser;
    private Button btnNyParkering, btnAfleverBil, btnOpretHus, btnOpetplads;
    private TextField txfRegNr, txfMærke;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() {
        Service.init();
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Parkeringshuse og pladser");
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        initContent(pane);

        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblParkeringshus = new Label("Parkering App.");
        lblParkeringshus.setTextFill(Color.GREY);
        lblParkeringshus.setFont(Font.font("Impact", 36));
        lblParkeringshus.setPrefSize(250, 50);

        pane.add(lblParkeringshus, 0, 0, 3, 1);
        GridPane.setHalignment(lblParkeringshus, HPos.CENTER);

        Label lblPark = new Label("Parkeringshuse");
        Label lblPlads = new Label("Optagne pladser");
        Label lblOpret = new Label("Opret ny parkering");
        Label lblRegNr = new Label("Reg. Nr");
        Label lblMærke = new Label("Mærke");

        txfRegNr = new TextField();
        txfRegNr.setPrefWidth(120);
        txfMærke = new TextField();
        txfMærke.setPrefWidth(120);

        btnNyParkering = new Button("Opret bil og parker");
        btnNyParkering.setOnAction(event -> nyParkering());
        btnAfleverBil = new Button("Aflever Bil");
        btnAfleverBil.setOnAction(event -> afleverBil());
        btnOpretHus = new Button("Opret Parkeringshus");
        btnOpretHus.setOnAction(event -> opretParkeringshus());
        btnOpetplads = new Button("Opret Pladser");
        btnOpetplads.setOnAction(event -> opretPlads());
        HBox parkBox = new HBox(20, lblRegNr, txfRegNr, lblMærke, txfMærke, btnNyParkering);
        HBox btnBox = new HBox(20, btnAfleverBil, btnOpretHus, btnOpetplads);
        btnBox.setAlignment(Pos.BASELINE_CENTER);
        GridPane.setHalignment(btnNyParkering, HPos.RIGHT);

        lvwParkeringshuse = new ListView<>();
        lvwParkeringshuse.setPrefSize(250, 200);
        lvwParkeringshuse.getItems().setAll(Service.getParkeringshuse());
        lvwOptagnePladser = new ListView<>();
        lvwOptagnePladser.setPrefSize(200, 200);

        ChangeListener<Parkeringshus> parkListener =
            (ov, oldPark, newPark) -> selectionChanged();
        lvwParkeringshuse.getSelectionModel().selectedItemProperty().addListener(parkListener);

        pane.add(lblPark, 0, 1);
        pane.add(lvwParkeringshuse, 0, 2);
        pane.add(lblPlads, 1, 1);
        pane.add(lvwOptagnePladser, 1, 2);
        pane.add(lblOpret, 0, 3, 2, 1);
        GridPane.setHalignment(lblOpret, HPos.CENTER);
        pane.add(parkBox, 0, 4, 2, 1);
        pane.add(btnBox, 0, 5, 2, 1);

        if (lvwParkeringshuse.getItems().size() > 0) {
            lvwParkeringshuse.getSelectionModel().select(0);
        }

    }

    private void selectionChanged() {
        Parkeringshus hus = lvwParkeringshuse.getSelectionModel().getSelectedItem();
        lvwOptagnePladser.getItems().setAll(Service.getOptagnePladser(hus));
    }

    private void nyParkering() {
        
        String regNr = txfRegNr.getText().trim();
        String mærke = txfMærke.getText().trim();
        Parkeringshus h = lvwParkeringshuse.getSelectionModel().getSelectedItem();
        
        ChoiceDialog<Parkeringsplads> cp = new ChoiceDialog<>();
        cp.setSelectedItem(h.getLedigePladser().get(0));
        cp.getItems().setAll(h.getLedigePladser());
        cp.setContentText("Vælg plads");
        cp.setHeaderText(regNr + " " + mærke);
        cp.showAndWait();

        Parkeringsplads result = cp.getResult();
        if (result != null) {
            Service.nyParkering(result, Service.opretBil(regNr, mærke), LocalTime.now());

        }
        lvwOptagnePladser.getItems().setAll(Service.getOptagnePladser(h));
    }
    
    private void afleverBil() {
        Parkeringsplads p = lvwOptagnePladser.getSelectionModel().getSelectedItem();
        Parkeringshus hus = lvwParkeringshuse.getSelectionModel().getSelectedItem();
        if (p != null) {
            
            hus.addSaldo(Service.afleverBil(p, LocalTime.now()));
            lvwOptagnePladser.getItems().setAll(Service.getOptagnePladser(hus));
            lvwParkeringshuse.getItems().setAll(Service.getParkeringshuse());
        }
    }
    
    private void opretParkeringshus() {
        
    }
    
    private void opretPlads() {
        
    }
}
