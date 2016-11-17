/**
 *
 */
package guifx;

import java.time.LocalDate;
import java.util.Optional;

import application.model.Konference;
import application.model.Udflugt;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Kristian
 */
public class KonferenceWindow extends Stage {
    // ===========================================================
    // Fields
    // ===========================================================
    private Konference konference;
    private TextField txfTitel = new TextField(), txfPris = new TextField();
    private Label lblError;
    private CheckBox cbDato;
    private ListView<Udflugt> lvwUdflugter;
    private DatePicker dpStart = new DatePicker(), dpSlut = new DatePicker(),
        dpFrist = new DatePicker();
    private String titel;
    private LocalDate startDate, slutDate, fristDate;

    // ===========================================================
    // Constructors
    // ===========================================================
    public KonferenceWindow(String title, Konference konference) {
//        initStyle(StageStyle.UNDECORATED);
        initModality(Modality.APPLICATION_MODAL);
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        setScene(scene);
        this.konference = konference;
        
        setTitle(title);

        initContent(pane);
        
    }
    
    public KonferenceWindow(String title) {
        this(title, null);
        setTitle(title);
        
    }

    // ===========================================================
    // Methods
    // ===========================================================
    private void initContent(GridPane pane) {
        
//        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(10));
        pane.setHgap(20);
        pane.setVgap(20);
        
        Label lblTitle = new Label(getTitle());
        lblTitle.setTextFill(Color.GREY);
        lblTitle.setFont(Font.font("Impact", 24));
        pane.add(lblTitle, 0, 0, 2, 1);
        GridPane.setHalignment(lblTitle, HPos.CENTER);
        
        String[] str = { "Titel", "Pris", "Start dato", "Slut dato", "Tilmeldningsfrist" };
        for (int i = 0; i < str.length; i++) {

            Label lbl = new Label(str[i]);
            pane.add(lbl, 0, i + 1);
            
        }
        
        lblError = new Label();
        lblError.setStyle("-fx-text-fill: red");
        Button btnUdflugt = new Button("Tilføj udflugt");
        Button btnUpdateUdflugt = new Button("Opdater udflugt");
        Button btnSletUdflugt = new Button(" Slet udflugt");
        btnUdflugt.setPrefWidth(100);
        btnSletUdflugt.setPrefWidth(100);
        VBox vbxUdflugt = new VBox(10, lblError, btnUdflugt, btnUpdateUdflugt, btnSletUdflugt);
        btnUdflugt.setOnAction(event -> createUdflugt());
        btnUpdateUdflugt.setOnAction(event -> updateUdflugt());
        btnSletUdflugt.setOnAction(event -> sletUdflugt());
        
        pane.add(vbxUdflugt, 0, 6, 2, 2);

        lvwUdflugter = new ListView<>();
        lvwUdflugter.setPrefWidth(100);
        lvwUdflugter.setPrefHeight(100);
        lvwUdflugter.setDisable(true);

        GridPane.setHalignment(lvwUdflugter, HPos.CENTER);

        pane.add(lvwUdflugter, 1, 6, 2, 2);

        VBox txfBox = new VBox(10);
        txfBox.getChildren().addAll(txfTitel, txfPris, dpStart, dpSlut, dpFrist);
        txfTitel.setPrefWidth(165);
        dpStart.setPrefWidth(105);
        dpSlut.setPrefWidth(105);
        dpFrist.setPrefWidth(105);
        pane.add(txfBox, 1, 1, 1, 5);
        
        cbDato = new CheckBox("Dato");
        pane.add(cbDato, 1, 4);
        GridPane.setHalignment(cbDato, HPos.RIGHT);
        
        Button btnOK = new Button("OK");
        Button btnCancel = new Button("Annuller");
        btnOK.setPrefSize(75, 50);
        btnCancel.setPrefSize(75, 50);
        HBox btnBox = new HBox(20);
        pane.add(btnBox, 0, 8, 2, 1);
        btnBox.getChildren().addAll(btnOK, btnCancel);
        btnBox.setAlignment(Pos.BASELINE_CENTER);
        cbDato.setOnAction(event -> clearDato());
        
        btnCancel.setOnAction(event -> cancelAction());
        
        btnOK.setOnAction(event -> okAction());

        initControls();
        
    }

    private void clearDato() {
        if (cbDato.isSelected()) {
            dpStart.setDisable(false);
            dpSlut.setDisable(false);
            dpFrist.setDisable(false);
        }
        else {
            dpStart.setValue(null);
            dpStart.setDisable(true);
            dpSlut.setValue(null);
            dpSlut.setDisable(true);
            dpFrist.setValue(null);
            dpFrist.setDisable(true);

        }
    }

    private void createUdflugt() {
        startDate = dpStart.getValue();
        slutDate = dpSlut.getValue();
        if (startDate == null || slutDate == null) {
            lblError.setText("Konference dato skal vÃ¦re oprettet");
            return;
        }

        else {
            
            DatePicker dpDate = Service.fjernDates(new DatePicker(startDate), startDate, slutDate);
            Service.fjernDates(dpDate, startDate, slutDate);

            UdflugtPane udflugtPane = new UdflugtPane(konference, dpDate);
            setOpacity(0.1);
            udflugtPane.showAndWait();
            setOpacity(1);
            lvwUdflugter.setDisable(false);
            lvwUdflugter.getItems().setAll(Service.getUdflugter(konference));
        }
        
    }
    
    private void sletUdflugt() {
        Udflugt udflugt = lvwUdflugter.getSelectionModel().getSelectedItem();
        if (udflugt == null) {
            lblError.setText("Ingen udflugt valgt");
            return;
        }
        else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Slet Udflugt");
            alert.setContentText("Er du sikker?");
            Optional<ButtonType> result = alert.showAndWait();
            if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                Service.removeUdflugt(udflugt, konference);
                lvwUdflugter.getItems().setAll(Service.getUdflugter(konference));
            }
        }
    }

    private void updateUdflugt() {

        startDate = dpStart.getValue();
        slutDate = dpSlut.getValue();
        
        Udflugt udflugt = lvwUdflugter.getSelectionModel().getSelectedItem();

        if (udflugt == null) {
            lblError.setText("Ingen udflugt valgt");
            return;
        }
        else
            if (startDate == null || slutDate == null) {
                lblError.setText("Konference dato skal vÃ¦re oprettet");
                return;
            }
            else {
                DatePicker dpDate =
                    Service.fjernDates(new DatePicker(startDate), startDate, slutDate);

                UdflugtPane ufp = new UdflugtPane(konference, dpDate, udflugt);
                setOpacity(0.1);
                ufp.showAndWait();
                setOpacity(1);
                lvwUdflugter.getItems().setAll(Service.getUdflugter(konference));
            }

    }

    private void cancelAction() {
        hide();
    }

    private void okAction() {
        
        titel = txfTitel.getText().trim();
        startDate = dpStart.getValue();
        slutDate = dpSlut.getValue();
        fristDate = dpFrist.getValue();
        
        if (titel.length() == 0) {
            lblError.setText("Titel er tom");
            return;
        }
        if (cbDato.isSelected()) {

            if (startDate == null) {
                lblError.setText("Start dato er tom");
                return;
            }
            if (slutDate == null) {
                lblError.setText("Slut dato er tom");
                return;
            }
            if (fristDate == null) {
                lblError.setText("Tilmeldningsfrist er tom");
                return;
            }
        }
        
        double pris = -1;
        try {
            pris = Double.parseDouble(txfPris.getText().trim());
        }
        catch (NumberFormatException ex) {
            // do nothing
        }
        if (pris < 0) {
            lblError.setText("Pris er ikke et positivt nummer");
            return;
        }
        
        // Call service methods
        
        if (cbDato.isSelected()) {

            if (konference != null) {
                Service.updateKonference(konference, titel, pris, startDate, slutDate, fristDate);
            }
            else {
                Service.createKonference(titel, pris, startDate, slutDate, fristDate);
            }
        }
        else {
            if (konference != null) {
                Service.updateKonference(konference, titel, pris);
            }
            else {
                Service.createKonference(titel, pris);
            }
        }
        
        hide();
    }

    private void initControls() {
        if (konference != null) {
            txfTitel.setText(konference.getTitel());
            txfPris.setText("" + konference.getPris());

            if (konference.getStartDate() != null) {
                cbDato.setSelected(true);
                clearDato();
                dpStart.setValue(konference.getStartDate());
                dpSlut.setValue(konference.getSlutDate());
                dpFrist.setValue(konference.getTilmeldningsfrist());

            }
            else {
                cbDato.setSelected(false);
                clearDato();
            }
            if (konference.getUdflugter().size() > 0) {
                lvwUdflugter.setDisable(false);
                lvwUdflugter.getItems().setAll(konference.getUdflugter());
            }
            
        }
        else {
            
            txfTitel.clear();
            txfPris.clear();
            clearDato();
        }
    }
}
