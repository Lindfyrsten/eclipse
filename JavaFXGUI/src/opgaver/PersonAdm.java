package opgaver;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PersonAdm extends Application {

    public static void main(String[] args) {
        Application.launch(args);
        
    }
    // ===========================================================
    // Constants
    // ===========================================================
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Persom Administrator");
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    // ===========================================================
    // Fields
    // ===========================================================
    private TextField txfName;
    private TextField txfTitle;
    private ListView<Person> lvwPersons;
    private CheckBox checkBox;
    
    private final Controller controller = new Controller();

    // ===========================================================
    // Constructors
    // ===========================================================
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        
        checkBox = new CheckBox();
        checkBox.setText("Senior");
        pane.add(checkBox, 1, 2);
        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);
        Label lblTitle = new Label("Title:");
        pane.add(lblTitle, 0, 1);
        
        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 3);
        GridPane.setValignment(lblNames, VPos.TOP);
        
        txfName = new TextField();
        pane.add(txfName, 1, 0);
        txfTitle = new TextField();
        pane.add(txfTitle, 1, 1);
        
        lvwPersons = new ListView<>();
        pane.add(lvwPersons, 1, 3);

        lvwPersons.setPrefSize(300, 200);
        lvwPersons.getItems().setAll(controller.persons);

        ChangeListener<Person> listener =
            (ov, oldPerson, newPerson) -> this.controller.personsItemSelected();
        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 2, 0);
        btnAdd.setOnAction(event -> controller.addAction());

        Button btnDelete = new Button("Delete");
        pane.add(btnDelete, 2, 1);
        btnDelete.setOnAction(event -> controller.deleteAction());
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
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
    private class Controller {
        private ArrayList<Person> persons;

        public Controller() {
            initPersons();
        }

        private void initPersons() {
            persons = new ArrayList<>();
            persons.add(new Person("Jens", "Jensen", "jj@eaaa.dk"));
            persons.add(new Person("Knud", "Mogensen", "km@eaaa.dk"));
            persons.add(new Person("Suzi", "Toft", "st@eaaa.dk"));
        }

        private void personsItemSelected() {
            Person selected = lvwPersons.getSelectionModel().getSelectedItem();
            if (selected != null) {
                txfName.setText(selected.toString());
            }
            else {
                txfName.clear();
            }
        }

        private void addAction() {
            String name = txfName.getText().trim();
            if (name.length() > 0) {
                Person p = new Person(name, "Hansen", "123@mail.com");
                if (checkBox.isSelected()) {
                    p.setSenior(true);
                }
                
                persons.add(p);
                lvwPersons.getItems().setAll(persons);

            }
            else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Add person");
                alert.setHeaderText("No name typed");
                alert.setContentText("Type the name of the person");
                alert.show();
            }
        }

        private void deleteAction() {
            int index = lvwPersons.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                persons.remove(index);
                txfName.clear();
                lvwPersons.getItems().setAll(persons);
            }
            else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Delete person");
                alert.setHeaderText("No person detected");
                alert.setContentText("Select person to be deleted");
                alert.show();
            }

        }
        
    }
}
