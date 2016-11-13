/**
 *
 */
package guifx;

import java.util.ArrayList;

import application.model.Deltager;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * @author Kristian
 */
public class DeltagerPane extends GridPane {

    // ===========================================================
    // Fields
    // ===========================================================
    private TextField txfName, txfAge, txfAddresse, txfNationalitet, txfFirma;
    private ListView<Deltager> lvwDeltagere;

    // ===========================================================
    // Constructors
    // ===========================================================
    public DeltagerPane() {
        setPadding(new Insets(20));
        setHgap(10);
        setVgap(10);

        Label lblDeltagere = new Label("Deltagere");
        this.add(lblDeltagere, 0, 0);

        lvwDeltagere = new ListView<>();
        this.add(lvwDeltagere, 0, 1, 1, 5);
        lvwDeltagere.setPrefSize(200, 200);
        lvwDeltagere.getItems().setAll(initAllDeltList());

        ChangeListener<Deltager> listener =
            (ov, oldDeltager, newDeltager) -> selectedDeltagerChanged();
        lvwDeltagere.getSelectionModel().selectedItemProperty().addListener(listener);
        
        Label lblName = new Label("Navn:");
        this.add(lblName, 1, 1);

        txfName = new TextField();
        this.add(txfName, 2, 1);
        txfName.setPrefWidth(200);
        txfName.setEditable(false);

        Label lblAge = new Label("Alder:");
        this.add(lblAge, 1, 2);

        txfAge = new TextField();
        this.add(txfAge, 2, 2);
        txfAge.setEditable(false);

        Label lblAddresse = new Label("Addresse:");
        this.add(lblAddresse, 1, 3);

        txfAddresse = new TextField();
        this.add(txfAddresse, 2, 3);
        txfAddresse.setEditable(false);

        Label lblNationalitet = new Label("Nationalitet:");
        this.add(lblNationalitet, 1, 4);

        txfNationalitet = new TextField();
        this.add(txfNationalitet, 2, 4);
        txfNationalitet.setEditable(false);

        Label lblFirma = new Label("Firma:");
        this.add(lblFirma, 1, 5);
        txfFirma = new TextField();
        this.add(txfFirma, 2, 5);
        txfFirma.setEditable(false);

        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons, 0, 6, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreate = new Button("Create");
        hbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> createAction());

        Button btnUpdate = new Button("Update");
        hbxButtons.getChildren().add(btnUpdate);
        btnUpdate.setOnAction(event -> updateAction());

        Button btnDelete = new Button("Delete");
        hbxButtons.getChildren().add(btnDelete);
        btnDelete.setOnAction(event -> deleteAction());

        if (lvwDeltagere.getItems().size() > 0) {
            lvwDeltagere.getSelectionModel().select(0);
        }
    }

    private ArrayList<Deltager> initAllDeltList() {
        ArrayList<Deltager> list = new ArrayList<>();
        for (Deltager d : Service.getDeltagere()) {
            list.add(d);

        }

        return list;
    }

    private void createAction() {
//        DeltagerWindow dw = new DeltagerWindow();
    
    }
    
    private void updateAction() {
        
    }
    
    private void deleteAction() {
        
    }
    
    private void selectedDeltagerChanged() {
        updateControls();
    }

    public void updateControls() {
        Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();
        if (deltager != null) {
            txfName.setText(deltager.getNavn());
            txfAge.setText("" + deltager.getAlder());
            txfAddresse.setText(deltager.getAddresse());
            txfNationalitet.setText(deltager.getNationalitet());
            
            if (deltager.getFirma() != null) {
                txfFirma.setText(deltager.getFirma().getNavn());
            }
            else {
                txfFirma.clear();
            }

        }
        else {
            txfName.clear();
            txfAge.clear();
            txfAddresse.clear();
            txfNationalitet.clear();
            txfFirma.clear();
        }
    }
}
