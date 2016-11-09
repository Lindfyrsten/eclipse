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
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.employee = employee;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public EmployeeWindow(String title) {
		this(title, null);
	}

	// -------------------------------------------------------------------------

	private TextField txfName, txfWage;
	private TextField txfemployeeYear;
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

		Label lblEmployeYear = new Label("Employment year");
		pane.add(lblEmployeYear, 0, 4);

		txfemployeeYear = new TextField();
		pane.add(txfemployeeYear, 0, 5);

		chbCompany = new CheckBox("Company");
		pane.add(chbCompany, 0, 6);
		ChangeListener<Boolean> listener = (ov, oldValue, newValue) -> this.selectedCompanyChanged(newValue);
		chbCompany.selectedProperty().addListener(listener);

		cbbCompany = new ComboBox<>();
		pane.add(cbbCompany, 0, 7);
		cbbCompany.getItems().addAll(Service.getCompanies());
		cbbCompany.setDisable(true);

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 9);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 0, 9);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> this.okAction());

		lblError = new Label();
		pane.add(lblError, 0, 10);
		lblError.setStyle("-fx-text-fill: red");

		this.initControls();
	}

	private void initControls() {
		if (employee != null) {
			txfName.setText(employee.getName());
			txfWage.setText("" + employee.getWage());
			txfemployeeYear.setText("" + employee.getEmploymentYear());
			if (employee.getCompany() != null) {
				chbCompany.setSelected(true);
				cbbCompany.getSelectionModel().select(employee.getCompany());
			} else {
				cbbCompany.getSelectionModel().select(0);
			}
		} else {
			txfName.clear();
			txfWage.clear();
			cbbCompany.getSelectionModel().select(0);
		}
	}

	// -------------------------------------------------------------------------

	private void cancelAction() {
		this.hide();
	}

	private void okAction() {
		String name = txfName.getText().trim();
		if (name.length() == 0) {
			lblError.setText("Name is empty");
			return;
		}

		int wage = -1;
		try {
			wage = Integer.parseInt(txfWage.getText().trim());
		} catch (NumberFormatException ex) {
			// do nothing
		}
		if (wage < 0) {
			lblError.setText("Wage is not a positive number");
			return;
		}

		int year = -1;
		try {
			year = Integer.parseInt(txfemployeeYear.getText().trim());
		} catch (NumberFormatException ex) {
			// do nothing
		}
		if (year < 0) {
			lblError.setText("Year is not a positive number");
			return;
		}

		boolean companyIsSelected = chbCompany.isSelected();
		Company newCompany = cbbCompany.getSelectionModel().getSelectedItem();

		// Call Service methods
		if (employee != null) {
			Service.updateEmployee(employee, name, wage, year);
			if (companyIsSelected) {
				Service.connectEmployeeToCompany(employee, newCompany);
			} else {
				Service.clearCompanyOfEmployee(employee);
			}
		} else {
			if (companyIsSelected) {
				Service.createEmployee(name, wage, year, newCompany);
			} else {
				Service.createEmployee(name, wage, year);
			}
		}
		this.hide();
	}

	// -------------------------------------------------------------------------

	private void selectedCompanyChanged(boolean checked) {
		cbbCompany.setDisable(!checked);
	}

}
