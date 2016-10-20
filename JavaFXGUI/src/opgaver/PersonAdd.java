package opgaver;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonAdd extends Stage {
    public PersonAdd(String title, Stage owner) {
        initOwner(owner);
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setMinHeight(100);
        setMinWidth(200);
        setResizable(false);
        
        setTitle(title);
        GridPane pane = new GridPane();
        initContent(pane);
        Scene scene = new Scene(pane);
        setScene(scene);
    }

    // ===========================================================
    // Constants
    // ===========================================================

    private TextField txfName;
    private TextField txfTitle;
    private CheckBox checkBox;
    private Person actualPerson = null;
    
    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================
    private void initContent(GridPane pane) {
        
        pane.setPadding(new Insets(20));
        pane.setVgap(10);
        pane.setHgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);
        Label lblTitle = new Label("Title:");
        pane.add(lblTitle, 0, 1);
        
        txfName = new TextField();
        pane.add(txfName, 1, 0, 2, 1);
        txfTitle = new TextField();
        pane.add(txfTitle, 1, 1, 2, 1);
        
        checkBox = new CheckBox();
        checkBox.setText("Senior");
        pane.add(checkBox, 1, 2);

        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 3);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.TOP_RIGHT);
        
        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> cancelAction());

        Button btnOk = new Button("OK");
        buttonBox.getChildren().add(btnOk);
        btnOk.setOnAction(event -> okAction());
        
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================
    
    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    
    // ===========================================================
    // Methods
    // ===========================================================
    private void cancelAction() {
        txfName.clear();
        txfName.requestFocus();
        txfTitle.clear();
        actualPerson = null;
        PersonAdd.this.hide();
    }
    
    private void okAction() {
        
        String name = txfName.getText().trim();
        String title = txfTitle.getText().trim();
        if (name.length() == 0) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Add person");
            alert.setHeaderText("No name typed");
            alert.setContentText("Type the name of the person");
            alert.show();
        }
        else if (title.length() == 0) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Add title");
            alert.setHeaderText("No title set");
            alert.setContentText("Type the title of the person");
            alert.show();
        }
        else {
            actualPerson = new Person(name, title, false);
            PersonAdd.this.hide();
            if (checkBox.isSelected()) {
                actualPerson.setSenior(true);
            }

        }
    }

    public Person getActualPerson() {
        return actualPerson;
    }

    public void clearActualPerson() {
        actualPerson = null;
    }
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
