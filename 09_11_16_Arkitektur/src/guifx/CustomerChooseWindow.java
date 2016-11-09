package guifx;

import application.model.Company;
import application.model.Customer;
import application.service.Service;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CustomerChooseWindow extends Stage {
	private Company company;

	public CustomerChooseWindow(String title, Company company) {
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

	public CustomerChooseWindow(String title) {
		this(title, null);
	}

	// -------------------------------------------------------------------------

	private ListView<Customer> lvwCustomers;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblCustomers = new Label("Customers:");
		pane.add(lblCustomers, 0, 0);

		lvwCustomers = new ListView<>();
		pane.add(lvwCustomers, 0, 1, 1, 5);
		lvwCustomers.setPrefWidth(200);
		lvwCustomers.setPrefHeight(200);
		lvwCustomers.getItems().setAll(Service.getCustomers());
		lvwCustomers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 9);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 0, 9);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> this.okAction());

	}

	// -------------------------------------------------------------------------

	private void cancelAction() {
		this.hide();
	}

	private void okAction() {
		ObservableList<Customer> customers = lvwCustomers.getSelectionModel().getSelectedItems();

		if (company != null) {
			for (Customer customer : customers) {
				Service.connectCustomerToCompany(customer, company);
			}

		}
		this.hide();
	}

	// -------------------------------------------------------------------------

}
