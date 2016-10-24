package opgaver;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BoysAndGirls extends Application {
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Boys and Girls");
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
    private ListView<Person> lvNames;
    private ToggleGroup group;

    private RadioButton radBoys, radGirls;
    private ArrayList<Person> aBoys = new ArrayList<>();
    private ArrayList<Person> aGirls = new ArrayList<>();

    private final Controller controller = new Controller();

    // ===========================================================
    // Methods
    // ===========================================================
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setVgap(10);
        pane.setHgap(10);
        pane.setGridLinesVisible(false);

        Label lblNames = new Label("Names: ");
        GridPane.setValignment(lblNames, VPos.TOP);
        pane.add(lblNames, 0, 0);

        Label lblName = new Label("Name: ");
        pane.add(lblName, 0, 1);

        lvNames = new ListView<>();
        lvNames.setEditable(false);
        lvNames.setPrefHeight(200);
        lvNames.setPrefWidth(200);
        pane.add(lvNames, 1, 0);

        group = new ToggleGroup();

        radBoys = new RadioButton("Boy");
        radBoys.setToggleGroup(group);
        radGirls = new RadioButton("Girl");
        radGirls.setToggleGroup(group);
        radBoys.setSelected(true);
        HBox box = new HBox();
        box.getChildren().addAll(radGirls, radBoys);
        pane.add(box, 0, 4);
        group.getToggles().get(0).setSelected(true);
        
        group.selectedToggleProperty().addListener(event -> toggleRadioButton());

        txfName = new TextField();
        pane.add(txfName, 1, 1);

        Button add = new Button("Add");
        pane.add(add, 2, 1);
        add.setOnAction(event -> controller.addPerson());

    }

    private void toggleRadioButton() {
        if (radBoys.isSelected()) {
            lvNames.getItems().setAll(aBoys);
        }

        else {
            lvNames.getItems().setAll(aGirls);
        }
        
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
    private class Controller {
        
        public void addPerson() {
            
            String name = txfName.getText().toString();
            if (name.length() > 0 && radBoys.isSelected()) {
                Person p = new Person(name);
                aBoys.add(p);
                lvNames.getItems().setAll(aBoys);
                
            }
            else if (name.length() > 0 && radGirls.isSelected()) {
                Person p = new Person(name);
                aGirls.add(p);
                lvNames.getItems().setAll(aGirls);
            }
            
            else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Please enter a name");
                alert.show();
            }
            txfName.clear();
        }
    }
}
