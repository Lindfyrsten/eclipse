package guifx;

import application.model.Bane;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import service.Service;

public class CreateBanePane extends Stage {
    private Button btnCancel, btnOk;
    private TextField txfNummer = new TextField();
    private TextField txfInfo = new TextField();
    private Label lblError;
    
    public CreateBanePane() {
        setTitle("Opret bane");
        initModality(Modality.APPLICATION_MODAL);
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane, 300, 120);
        setScene(scene);

        pane.setPadding(new Insets(10));
        pane.setVgap(10);
        pane.setHgap(10);

        Label lblNummer = new Label("Nummer");
        lblNummer.setPrefWidth(120);
        Label lblInfo = new Label("Info:");
        pane.add(lblNummer, 0, 0);
        pane.add(lblInfo, 0, 1);
        
        pane.add(txfNummer, 1, 0);
        pane.add(txfInfo, 1, 1);
        btnCancel = new Button("Cancel");
        btnOk = new Button("OK");
        pane.add(btnCancel, 0, 2);
        pane.add(btnOk, 0, 2);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        GridPane.setHalignment(btnOk, HPos.RIGHT);
        lblError = new Label();
        pane.add(lblError, 1, 2);
        lblError.setStyle("-fx-text-fill: red");
        
        btnCancel.setOnAction(event -> cancelAction());
        btnOk.setOnAction(event -> okayAction());
        
    }
    
    private void cancelAction() {
        hide();
    }
    
    private void okayAction() {
        int nummer = -1;
        try {

            nummer = Integer.parseInt(txfNummer.getText());
        }
        catch (NumberFormatException ex) {
            //do nothing
        }
        if (nummer < 0) {
            lblError.setText("Nummer mangler");
            return;
        }
        String info = txfInfo.getText();

        if (info.length() == 0) {
            lblError.setText("Info er tom");
            return;
        }

        //call service

        Service.addBane(new Bane(nummer, info));
        hide();

    }
    
}
