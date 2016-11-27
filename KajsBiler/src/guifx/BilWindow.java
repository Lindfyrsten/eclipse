package guifx;

import application.model.Bil;
import application.model.PrisGruppe;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BilWindow extends Stage {
    private Bil bil;
    
    public BilWindow(String title, Bil bil) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        
        this.bil = bil;
        
        setTitle(title);
        GridPane pane = new GridPane();
        initContent(pane);
        
        Scene scene = new Scene(pane);
        setScene(scene);
    }
    
    public BilWindow(String title) {
        this(title, null);
    }
    
    private TextField txfRegNr, txfMærke, txfModel, txfKmKørt;
    
    private ComboBox<PrisGruppe> cbbPrisGruppe;
    
    private Label lblError;
    
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);
        
        Label lblRegNr = new Label("Registreringsnummer");
        pane.add(lblRegNr, 0, 0);
        
        txfRegNr = new TextField();
        pane.add(txfRegNr, 0, 1);
        txfRegNr.setPrefWidth(200);
        
        Label lblMærke = new Label("Mærke");
        pane.add(lblMærke, 0, 2);
        
        txfMærke = new TextField();
        pane.add(txfMærke, 0, 3);
        
        Label lblModel = new Label("Model");
        pane.add(lblModel, 0, 4);
        txfModel = new TextField();
        pane.add(txfModel, 0, 5);
        txfModel.setDisable(true);
        
        Label lblKmKørt = new Label("Km kørt");
        pane.add(lblKmKørt, 0, 5);
        txfKmKørt = new TextField();
        pane.add(txfKmKørt, 0, 6);
        
//        cbbPrisGruppe = new ComboBox<>();
//        pane.add(cbbPrisGruppe, 0, 5);
//        cbbPrisGruppe.getItems().addAll(Service.getPrisGrupper());
//        cbbPrisGruppe.setDisable(true);
        
        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 7);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> cancelAction());
        
        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 7);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> okAction());
        
        lblError = new Label();
        pane.add(lblError, 0, 9);
        lblError.setStyle("-fx-text-fill: red");
        
        initControls();
    }
    
    private void initControls() {
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
//            cbbPrisGruppe.getSelectionModel().select(0);
        }
    }
    
    // -------------------------------------------------------------------------
    
    private void cancelAction() {
        hide();
    }
    
    private void okAction() {
        
        String regNr = txfRegNr.getText().trim();
        String mærkeNr = txfMærke.getText().trim();
        String modelNr = txfModel.getText().trim();
        if (regNr.length() == 0) {
            lblError.setText("Registreringsnummer skal udfyldes");
            return;
        }
        if (mærkeNr.length() == 0) {
            lblError.setText("Mærke skal udfyldes");
            return;
        }
        if (modelNr.length() == 0) {
            lblError.setText("Model skal udfyldes");
            return;
        }
        int kmKørt = -1;
        try {
            kmKørt = Integer.parseInt(txfKmKørt.getText().trim());
        }
        catch (NumberFormatException ex) {
            // do nothing
        }
        if (kmKørt < 0) {
            lblError.setText("Km kørt er ikke et positivt nummer");
            return;
        }
        
        // Call Service methods
        if (bil != null) {
            Service.updateBil(bil, regNr, mærkeNr, modelNr, kmKørt);
        }
        else {
            
            Service.createBil(regNr, mærkeNr, modelNr, kmKørt);
        }
        hide();
    }
    
    // -------------------------------------------------------------------------
    
}
