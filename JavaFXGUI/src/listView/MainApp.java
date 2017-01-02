package listView;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("ListView Demo4");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private TextField txfName;
	private ListView<PersonDemo> lvwPersons;

	private final Controller controller = new Controller();

	private void initContent(GridPane pane) {

		// pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		Label lblName = new Label("Name:");
		pane.add(lblName, 0, 0);

		Label lblNames = new Label("Names:");
		pane.add(lblNames, 0, 1);
		GridPane.setValignment(lblNames, VPos.TOP);

		txfName = new TextField();
		pane.add(txfName, 1, 0);

		lvwPersons = new ListView<PersonDemo>();
		pane.add(lvwPersons, 1, 1);
		lvwPersons.setPrefWidth(200);
		lvwPersons.setPrefHeight(200);
		lvwPersons.getItems().setAll(controller.personDemos);

		ChangeListener<PersonDemo> listener = (ov, oldPerson, newPerson) -> this.controller.personsItemSelected();
		lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

		Button btnAdd = new Button("Add");
		pane.add(btnAdd, 2, 0);
		btnAdd.setOnAction(event -> this.controller.addAction());

		Button btnDelete = new Button("Delete");
		pane.add(btnDelete, 2, 1);
		btnDelete.setOnAction(event -> this.controller.deleteAction());
	}

	private class Controller {
		private ArrayList<PersonDemo> personDemos;

		public Controller() {
			initPersons();
		}

		private void initPersons() {
			personDemos = new ArrayList<PersonDemo>();
			personDemos.add(new PersonDemo("Jens", "Jensen", "jj@eaaa.dk"));
			personDemos.add(new PersonDemo("Hans", "Hansen", "hh@eaaa.dk"));
			personDemos.add(new PersonDemo("Pia", "Peters", "pp@eaaa.dk"));
		}

		// -------------------------------------------------------------------------
		// Selected item changed in lvwPersons

		private void personsItemSelected() {
			PersonDemo selected = lvwPersons.getSelectionModel().getSelectedItem();
			if (selected != null) {
				txfName.setText(selected.toString());
			} else {
				txfName.clear();
			}
		}

		// -------------------------------------------------------------------------
		// Button actions

		private void addAction() {
			String name = txfName.getText().trim();
			if (name.length() > 0) {
				PersonDemo p = new PersonDemo(name, "Hansen", "123@mail.com");
				personDemos.add(p);
				lvwPersons.getItems().setAll(personDemos);
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Add person");
				alert.setHeaderText("No named typed");
				alert.setContentText("Type the name of the person");
				alert.show();
				// wait for the modal dialog to close
			}
		}

		private void deleteAction() {
			int index = lvwPersons.getSelectionModel().getSelectedIndex();
			if (index >= 0) {
				personDemos.remove(index);
				txfName.clear();
				lvwPersons.getItems().setAll(personDemos);
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Delete person");
				alert.setHeaderText("No person selected");
				alert.setContentText("Select person to be deleted");
				alert.show();
				// wait for the modal dialog to close
			}
		}
	}

}
