package guifx;

import application.model.Område;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PladsWindow extends Stage {
    
    private TextField txfNummer, txfType;
    private Button btnCancel, btnOK;
    private CheckBox cbxKonsol;
    private Label lblType, lblError;
    private Område område;

    public PladsWindow(Område område) {
        setTitle("Opret standard plads");
        this.område = område;
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        setScene(scene);
        
        pane.setPadding(new Insets(10));
        pane.setVgap(10);
        pane.setHgap(10);

        Label lblNummer = new Label("Nummer:");
        pane.add(lblNummer, 0, 0);
        
        txfNummer = new TextField();
        pane.add(txfNummer, 1, 0);
        
        cbxKonsol = new CheckBox("Med spillekonsol");
        pane.add(cbxKonsol, 1, 1);
        
        lblType = new Label("Konsol type:");
        pane.add(lblType, 1, 2);
        lblType.setDisable(true);
        txfType = new TextField();
        txfType.setDisable(true);
        pane.add(txfType, 1, 2);
        GridPane.setHalignment(txfType, HPos.RIGHT);

        btnCancel = new Button("Cancel");
        btnCancel.setOnAction(event -> cancelAction());
        btnOK = new Button("OK");
        btnOK.setOnAction(event -> OKAction());
        HBox box = new HBox(20, btnCancel, btnOK);
        pane.add(box, 1, 3);
        GridPane.setHalignment(box, HPos.RIGHT);
        
        lblError = new Label("");
        pane.add(lblError, 0, 3, 2, 1);
        lblError.setStyle("-fx-text-fill: red");
        cbxKonsol.setOnAction(event -> konsolChanged());

    }
    
    private void konsolChanged() {
        if (cbxKonsol.isSelected()) {
            txfType.setDisable(false);
        }
        else {
            txfType.setDisable(true);
        }
    }

    private void cancelAction() {
        hide();
    }

    private void OKAction() {
        int num = -1;
        try {
            num = Integer.parseInt(txfNummer.getText());
        }
        catch (NumberFormatException ex) {
            //do nothing
        }
        if (num < 0) {
            lblError.setText("Nummer mangler");
            return;
        }

        if (cbxKonsol.isSelected()) {
            String type = txfType.getText();

            if (type.length() == 0) {
                lblError.setText("Type skal udfyldes");
                return;
            }
            else {
                Service.createKonsolPlads(num, område, type);
            }
        }
        else {
            Service.createPlads(num, område);
        }
        hide();
    }
    
}
