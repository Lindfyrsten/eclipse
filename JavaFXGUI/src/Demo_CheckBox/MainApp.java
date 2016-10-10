package Demo_CheckBox;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("CheckBox Demo");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------
	private TextField txfName;
	
	private void initContent(GridPane pane) {
		// enable this to show grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		// add a label to the pane (at col=0, row=0)
		Label lblName = new Label("Name:");
		pane.add(lblName, 0, 0);

		// add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
		txfName = new TextField();
		pane.add(txfName, 1, 0, 2, 1);

		// CheckBox to indicate upper / lower case
		CheckBox checkBox = new CheckBox();
		checkBox.setText("Upper case");
		pane.add(checkBox, 0, 1);
		
		checkBox.setOnAction(event -> {
			if (checkBox.isSelected()) {
				upperCaseAction();
			} else {
				lowerCaseAction();
			}
		});
	}

	// Button actions
	private void upperCaseAction() {
		String name = txfName.getText().trim();
		txfName.setText(name.toUpperCase());
	}

	private void lowerCaseAction() {
		String name = txfName.getText().trim();
		txfName.setText(name.toLowerCase());
	}

}
