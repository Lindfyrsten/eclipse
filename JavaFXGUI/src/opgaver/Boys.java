package opgaver;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Boys extends Application {
    
    public static void main(String[] args) {
        Application.launch(args);
        
    }

    @Override
    public void start(Stage stage) {
        
        stage.setTitle("Boys");
        GridPane pane = new GridPane();
        initContent(pane);
        
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        
    }

    // ===========================================================
    // Constants
    // ===========================================================
    private TextField txfName;
    private ListView<Person> lvBoys;
    // ===========================================================
    // Fields
    // ===========================================================
    
    // ===========================================================
    // Constructors
    // ===========================================================
    private final Controller controller = new Controller();
    // ===========================================================
    // Getter & Setter
    // ===========================================================
    
    // ===========================================================
    // Methods
    // ===========================================================
    
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setVgap(10);
        pane.setHgap(10);
        pane.setGridLinesVisible(false);
        txfName = new TextField();
        pane.add(txfName, 1, 1);
        
        Label lblNames = new Label("Names: ");
        GridPane.setValignment(lblNames, VPos.TOP);
        pane.add(lblNames, 0, 0);
        
        Label lblName = new Label("Name: ");
        pane.add(lblName, 0, 1);
        
        lvBoys = new ListView<>();
        lvBoys.setEditable(false);
        lvBoys.setPrefHeight(200);
        lvBoys.setPrefWidth(200);
        pane.add(lvBoys, 1, 0);
        
        ChangeListener<Person> listener =
            (ov, oldPerson, newPerson) -> this.controller.personsItemSelected();
        lvBoys.getSelectionModel().selectedItemProperty().addListener(listener);
        
        Button add = new Button("Add");
        pane.add(add, 2, 1);
        add.setOnAction(event -> controller.addPerson());
        
    }
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

    private class Controller {

        private ArrayList<Person> persons = new ArrayList<>();

        private void personsItemSelected() {
            Person selected = lvBoys.getSelectionModel().getSelectedItem();
            if (selected != null) {
                txfName.setText(selected.toString());
            }
            else {
                txfName.clear();
            }
        }

        public void addPerson() {

            String name = txfName.getText().toString();
            if (name.length() > 0) {
                Person p = new Person(name);
                persons.add(p);
                lvBoys.getItems().setAll(persons);
                
            }
            txfName.clear();
        }

    }

}
