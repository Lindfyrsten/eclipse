package opgaver;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    public void start(Stage stage) throws Exception {
        stage.setTitle("Persom Administrator");
        GridPane pane = new GridPane();
        initContent(pane);

        addPerson = new PersonAdd("Add a person", stage);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        
    }
    
    // ===========================================================
    // Fields
    // ===========================================================

    private ListView<Person> lvwPersons;
    private PersonAdd addPerson;

    private final Controller controller = new Controller();
    
    // ===========================================================
    // Constructors
    // ===========================================================
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 3);
        GridPane.setValignment(lblNames, VPos.TOP);

        lvwPersons = new ListView<>();
        pane.add(lvwPersons, 0, 3);

        lvwPersons.setPrefSize(300, 200);
        lvwPersons.getItems().setAll(controller.persons);
        
//        ChangeListener<Person> listener =
//            (ov, oldPerson, newPerson) -> this.controller.personsItemSelected();
//        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);
        
        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 2, 0);
        btnAdd.setOnAction(event -> controller.addAction());
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
            persons.add(new Person("Jens Madsen", "Hr", true));
            
        }
        
//        private void personsItemSelected() {
//            Person selected = lvwPersons.getSelectionModel().getSelectedItem();
//            if (selected != null) {
//                txfName.setText(selected.toString());
//            }
//            else {
//                txfName.clear();
//            }
//        }
//
        private void addAction() {

            addPerson.showAndWait();
            if (addPerson.getActualPerson() != null) {
                persons.add(addPerson.getActualPerson());
                lvwPersons.getItems().setAll(persons);
            }
            
        }
        
    }
}
