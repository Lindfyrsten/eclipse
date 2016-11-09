package guifx;

import application.model.Company;
import application.model.Employee;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class EmployeeWindow extends Stage {
    private Employee employee;

    public EmployeeWindow(String title, Employee employee) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        this.employee = employee;

        setTitle(title);
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }

    public EmployeeWindow(String title) {
        this(title, null);
    }

    // -------------------------------------------------------------------------

    private TextField txfName, txfWage, txfYear;
    private CheckBox chbCompany;
    private ComboBox<Company> cbbCompany;
    private Label lblError;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Name");
        pane.add(lblName, 0, 0);

        txfName = new TextField();
        pane.add(txfName, 0, 1);
        txfName.setPrefWidth(200);

        Label lblHours = new Label("Hourly Wage");
        pane.add(lblHours, 0, 2);

        txfWage = new TextField();
        pane.add(txfWage, 0, 3);

        chbCompany = new CheckBox("Company");
        pane.add(chbCompany, 0, 4);
        ChangeListener<Boolean> listener =
            (ov, oldValue, newValue) -> selectedCompanyChanged(newValue);
        chbCompany.selectedProperty().addListener(listener);

        cbbCompany = new ComboBox<>();
        pane.add(cbbCompany, 0, 5);
        cbbCompany.getItems().addAll(Service.getCompanies());
        cbbCompany.setDisable(true);

        Label lblYear = new Label("Employment year");
        pane.add(lblYear, 0, 6);
        txfYear = new TextField();
        pane.add(txfYear, 0, 7);
        txfYear.setDisable(true);
        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 8);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 8);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> okAction());

        lblError = new Label();
        pane.add(lblError, 0, 9);
        lblError.setStyle("-fx-text-fill: red");

        initControls();
    }

    private void initControls() {
        if (employee != null) {
            txfName.setText(employee.getName());
            txfWage.setText("" + employee.getWage());
            if (employee.getCompany() != null) {
                chbCompany.setSelected(true);
                cbbCompany.getSelectionModel().select(employee.getCompany());
                txfYear.setText("" + employee.getEmployeeYear());
            }
            else {
                cbbCompany.getSelectionModel().select(0);
            }
        }
        else {
            txfName.clear();
            txfWage.clear();
            txfYear.clear();
            cbbCompany.getSelectionModel().select(0);
        }
    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
        hide();
    }

    private void okAction() {

        String name = txfName.getText().trim();
        if (name.length() == 0) {
            lblError.setText("Name is empty");
            return;
        }
        int employeeYear = -1;
        int wage = -1;
        try {
            wage = Integer.parseInt(txfWage.getText().trim());
        }
        catch (NumberFormatException ex) {
            // do nothing
        }
        if (wage < 0) {
            lblError.setText("Wage is not a positive number");
            return;
        }
        
        try {
            employeeYear = Integer.parseInt(txfYear.getText().trim());
        }
        catch (NumberFormatException ex) {
            // do nothing
        }
        if (employeeYear < 0) {
            lblError.setText("Year is not a positive number");
            return;
        }

        boolean companyIsSelected = chbCompany.isSelected();
        Company newCompany = cbbCompany.getSelectionModel().getSelectedItem();

        // Call Service methods
        if (employee != null) {
            if (companyIsSelected) {
                Service.updateEmployee(employee, name, wage, employeeYear, newCompany);
            }
            else {
                Service.updateEmployee(employee, name, wage, employeeYear, null);
            }
        }
        else {
            if (companyIsSelected) {
                Service.createEmployee(name, wage, employeeYear, newCompany);
            }
            else {
                Service.createEmployee(name, wage, employeeYear);
            }
        }
        hide();
    }

    // -------------------------------------------------------------------------

    private void selectedCompanyChanged(boolean checked) {
        cbbCompany.setDisable(!checked);
        txfYear.setDisable(!checked);
    }

}
