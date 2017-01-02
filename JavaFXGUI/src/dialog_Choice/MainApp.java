package dialog_Choice;

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    // private InputDialog dialog;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Gui Demo ChoiceDialog");
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    // -------------------------------------------------------------------------

    private TextArea txaDescription;

    private void initContent(GridPane pane) {
        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);

        Label lblName = new Label("TextArea:");
        pane.add(lblName, 0, 0);

        txaDescription = new TextArea();
        pane.add(txaDescription, 0, 1);
        txaDescription.setPrefRowCount(7);
        txaDescription.setPrefWidth(270);
        txaDescription.setEditable(false);

        Button btnFill = new Button("Add textline");
        pane.add(btnFill, 1, 1);
        btnFill.setOnAction(event -> choiceAction());

    }

    // -------------------------------------------------------------------------
    // Open a choice dialog with objects of a determined type

    private void choiceAction() {

        String s1 = "Valg 1";
        String s2 = "Valg 2";
        ChoiceDialog<String> dialog = new ChoiceDialog<>();

        // add the objects to the list
        dialog.getItems().add(s1);
        dialog.getItems().add(s2);

        dialog.setTitle("Make a choice");
        dialog.setHeaderText("Choice dialog with strings:");
        Optional<String> result = dialog.showAndWait();
        // wait for the modal dialog to close
        String input = "";
        if (result.isPresent()) {
            input = result.get();
            if (input.length() > 0) {
                txaDescription.setText(txaDescription.getText() + input + "\n");
            }
        }

    }

}
