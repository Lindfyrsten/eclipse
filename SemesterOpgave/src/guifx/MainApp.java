package guifx;

import application.model.Område;
import application.model.Plads;
import application.service.Service;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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

    private ListView<Plads> lvwPladser;
    private Button btnOpretStdPlads, btnFindPlads;
    private TextField txfNummer, txfFundetPlads;
    private ToggleGroup group;
    private Område område = null;
    private Label lblError;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setVgap(10);
        pane.setHgap(10);
        
        Label lblPladser = new Label("Pladser:");
        pane.add(lblPladser, 0, 0);
        
        lvwPladser = new ListView<>();
        pane.add(lvwPladser, 0, 1, 2, 4);
        lvwPladser.setPrefWidth(200);
        lvwPladser.setPrefHeight(200);
        lvwPladser.getItems().setAll(Service.getPladser());
        
        btnOpretStdPlads = new Button("Opret standard plads");
        pane.add(btnOpretStdPlads, 2, 1);
        btnOpretStdPlads.setOnAction(event -> createAction());
        
        Label lblOmråde = new Label("Område:");
        pane.add(lblOmråde, 0, 5);
        VBox box = new VBox();
        group = new ToggleGroup();
        RadioButton rb;
        
        Område[] list = { Område.STANDARD, Område.VIP, Område.BØRNE, Område.TURNERING };
        for (Område o : list) {
            rb = new RadioButton();
            rb.setToggleGroup(group);
            rb.setText(o.toString());
            rb.setUserData(o);
            box.getChildren().add(rb);
        }
        pane.add(box, 1, 5);
        
        group.selectedToggleProperty().addListener(event -> toggleRadioButton());

        Label lblNummer = new Label("Nummer:");
        pane.add(lblNummer, 0, 6);
        txfNummer = new TextField();
        pane.add(txfNummer, 1, 6);
        Label lblFundet = new Label("Fundet plads:");
        pane.add(lblFundet, 0, 7);
        txfFundetPlads = new TextField();
        txfFundetPlads.setDisable(true);
        pane.add(txfFundetPlads, 1, 7);
        btnFindPlads = new Button("Find plads");
        pane.add(btnFindPlads, 2, 6);
        btnFindPlads.setOnAction(event -> findAction());
        
        lblError = new Label("");
        pane.add(lblError, 2, 7, 2, 1);
        lblError.setStyle("-fx-text-fill: red");

    }
    
    private void toggleRadioButton() {
        område = (Område) group.getSelectedToggle().getUserData();
    }

    private void createAction() {
        if (område != null) {

            PladsWindow w = new PladsWindow(område);
            w.showAndWait();
            lvwPladser.getItems().setAll(Service.getPladser());
        }
        else {
            lblError.setText("Vælg et område");
        }
    }

    private void findAction() {
        int num = -1;
        try {
            num = Integer.parseInt(txfNummer.getText());
        }
        catch (NumberFormatException ex) {
            //do nothing
        }
        if (område == null) {
            lblError.setText("Vælg et område");
            return;
        }
        else if (num < 0) {
            lblError.setText("Nummer mangler");
            return;
        }
        else {
            
            Plads p = Service.findPlads(område, Integer.parseInt(txfNummer.getText()));
            if (p != null) {
                txfFundetPlads.setText(p.toString());
                
            }
            else {
                txfFundetPlads.setText("Ingen plads fundet");
            }
            
        }
    }

}
