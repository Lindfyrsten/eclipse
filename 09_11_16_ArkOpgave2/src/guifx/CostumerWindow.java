/**
 *
 */
package guifx;

import application.model.Company;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Kristian
 */
public class CostumerWindow extends Stage {
    // ===========================================================
    // Fields
    // ===========================================================
    private Company company;
    
    // ==========================================================
    // Constructors=
    // ===========================================================
    public CostumerWindow(String title, Company company) {
        
        this.company = company;
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        setTitle(title);
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);

    }

    private TextField txfFirstName, txfLastName, txfAge;
    private Label lblError;
    
    // ===========================================================
    // Methods
    // ===========================================================
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblFirstName = new Label("First name");
        pane.add(lblFirstName, 0, 0);
        
        txfFirstName = new TextField();
        pane.add(txfFirstName, 0, 1);
        txfFirstName.setPrefWidth(200);

        Label lblLastName = new Label("Last name");
        pane.add(lblLastName, 0, 2);
        txfLastName = new TextField();
        pane.add(txfLastName, 0, 3);
        txfLastName.setPrefWidth(200);
        
        Label lblAge = new Label("Age");
        pane.add(lblAge, 0, 4);

        txfAge = new TextField();
        pane.add(txfAge, 0, 5);
        
        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 6);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> cancelAction());
        
        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 6);
        GridPane.setHalignment(btnCancel, HPos.RIGHT);
        btnOK.setOnAction(event -> okAction());
        
        lblError = new Label();
        pane.add(lblError, 0, 7);
        lblError.setStyle("-fx-text-fill: red");

        initControls();

    }

    private void initControls() {
        
        txfFirstName.clear();
        txfLastName.clear();
        txfAge.clear();
    }

    private void cancelAction() {
        hide();
    }
    
    private void okAction() {
        String firstName = txfFirstName.getText().trim();
        String lastName = txfLastName.getText().trim();
        if (firstName.length() == 0 || lastName.length() == 0) {
            lblError.setText("First or last name is missing");
            return;
        }
        int age = -1;

        try {
            age = Integer.parseInt(txfAge.getText().trim());
        }
        catch (NumberFormatException ex) {
            //do nothing
        }
        if (age < 0) {
            lblError.setText("Age is not valid");
            return;
        }
        
        //Call service methods
        
        Service.addCostumerToCompany(firstName, lastName, age, company);
        hide();

    }

}
