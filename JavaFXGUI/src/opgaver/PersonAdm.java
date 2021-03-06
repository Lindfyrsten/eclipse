package opgaver;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PersonAdm extends Application {
    
    Stage window = new Stage();

    public static void main(String[] args) {
        Application.launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {

        window.setTitle("Persom Administrator");
        GridPane pane = new GridPane();
        initContent(pane);
        
        addPerson = new PersonAdd("Add a person", window);
        Scene innerScene = new Scene(pane);
        window.setScene(innerScene);
        window.show();

    }

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
        
        lvwPersons = new ListView<>();
        GridPane.setValignment(lvwPersons, VPos.CENTER);
        pane.add(lvwPersons, 0, 0);

        lvwPersons.setPrefSize(300, 200);
        lvwPersons.getItems().setAll(controller.persons);

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 2, 0);
        btnAdd.setOnAction(event -> controller.addAction());

    }
    
    private class Controller {
        private ArrayList<Person> persons;

        public Controller() {
            initPersons();
        }

        private void initPersons() {
            persons = new ArrayList<>();
            persons.add(new Person("Jens Madsen", "Hr", true));

        }

        private void addAction() {

            window.hide();
            addPerson.showAndWait();
            if (addPerson.getActualPerson() != null) {
                persons.add(addPerson.getActualPerson());
                lvwPersons.getItems().setAll(persons);
            }

            window.show();
            addPerson.clearActualPerson();

        }

    }
}
