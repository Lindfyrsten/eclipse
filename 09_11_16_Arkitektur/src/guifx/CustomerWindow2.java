package guifx;

import application.model.Company;
import application.model.Customer;
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

public class CustomerWindow2 extends Stage {
	private Company company;

	public CustomerWindow2(String title, Company company) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.company = company;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public CustomerWindow2(String title) {
		this(title, null);
	}

	// -------------------------------------------------------------------------

	private TextField txfName;

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

		txfName.clear();

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
		Customer customer = Service.createCustomer(name);
		// Call Service methods
		if (company != null) {
			Service.connectCustomerToCompany(customer, company);

		}
		this.hide();
	}

	// -------------------------------------------------------------------------

}
