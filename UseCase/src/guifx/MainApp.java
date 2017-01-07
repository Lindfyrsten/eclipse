package guifx;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Forloeb;
import model.UseCase;

/**
 * @author Lindbjerg
 */
public class MainApp extends Application {
    private TextField txfNavn, txfTrigger, txfBeskrivelse, txfAktør, txfRelUseCase,
        txfInteressenter, txfPreB, txfPostB, txfAlternativt, txfAktørForløb, txfSystem,
        txfSystem2, txfSystem3, txfSystem4, txfSystem5;
    private Button btnSystem, btnSystem2, btnSystem3, btnSystem4, btnSystem5, btnAddForløb,
        btnGenerate, btnReset;
    private UseCase uCase;
    private ListView<Forloeb> lvwForløb = new ListView<>();
    private ArrayList<String> systemList = new ArrayList<>();
    private ArrayList<Forloeb> forloebList = new ArrayList<>();
    
    public static void main(String[] args) {
        Application.launch(args);
        
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Use Case Generator");
        stage.show();
        
        pane.setVgap(10);
        pane.setHgap(30);
        pane.setPadding(new Insets(20, 10, 10, 10));
//        pane.setGridLinesVisible(true);
        
        Label lblNavn = new Label("Use case id og navn:");
        Label lblTrigger = new Label("Trigger hændelse:");
        Label lblBeskrivelse = new Label("Beskrivelse:");
        Label lblAktører = new Label("Aktører");
        Label lblRelUseCase = new Label("Rel. use cases:");
        Label lblInteres = new Label("Interessenter:");
        Label lblPreb = new Label("Præbetingelse:");
        Label lblPostB = new Label("Postbetingelse");
        Label lblForløb = new Label("Hovedforløb");
        lblForløb.setTextFill(Color.GREY);
        lblForløb.setFont(Font.font("Impact", 24));
        Label lblAktørForløb = new Label("            Aktør");
        Label lblSystem = new Label("System");
        Label lbLAlternativt = new Label("Alternativt forløb:");

        txfNavn = new TextField();
        txfNavn.setMinWidth(200);
        txfTrigger = new TextField();
        txfBeskrivelse = new TextField();
        txfAktør = new TextField();
        txfRelUseCase = new TextField();
        txfInteressenter = new TextField();
        txfPreB = new TextField();
        txfPostB = new TextField();
        txfAktørForløb = new TextField();
        txfSystem = new TextField();
        txfSystem2 = new TextField();
//        txfSystem2.setDisable(true);
        txfSystem2.setVisible(false);
        txfSystem3 = new TextField();
        txfSystem3.setVisible(false);
        txfSystem4 = new TextField();
        txfSystem4.setVisible(false);
        txfSystem5 = new TextField();
        txfSystem5.setVisible(false);
        txfAlternativt = new TextField();
        
        VBox lblBox =
            new VBox(29, lblNavn, lblTrigger, lblBeskrivelse, lblAktører, lblRelUseCase, lblInteres,
                lblPreb, lblPostB);
        VBox txfBox = new VBox(20, txfNavn, txfTrigger, txfBeskrivelse, txfAktør, txfRelUseCase,
            txfInteressenter, txfPreB, txfPostB);
        
        btnSystem = new Button("+");
        btnSystem.setOnAction(event -> addSystem());
        btnSystem2 = new Button("+");
        btnSystem2.setVisible(false);
        btnSystem3 = new Button("+");
        btnSystem3.setVisible(false);
        btnSystem4 = new Button("+");
        btnSystem4.setVisible(false);
        btnSystem5 = new Button("+");
        btnSystem5.setVisible(false);
        
        btnGenerate = new Button("Print til fil");
        btnReset = new Button("Reset");
        btnAddForløb = new Button("Tilføj forløb");
        
        pane.add(lblBox, 0, 2, 1, 10);
        pane.add(txfBox, 1, 2, 1, 10);
        pane.add(lblForløb, 2, 0, 2, 1);
        pane.add(lblAktørForløb, 2, 1);
        pane.add(lblSystem, 3, 1);
        pane.add(txfAktørForløb, 2, 2);
        pane.add(txfSystem, 3, 2);
        pane.add(btnSystem, 4, 2);
        pane.add(txfSystem2, 3, 4);
        pane.add(btnSystem2, 4, 4);
        pane.add(txfSystem3, 3, 5);
        pane.add(btnSystem3, 4, 5);
        pane.add(txfSystem4, 3, 6);
        pane.add(btnSystem4, 4, 6);
        pane.add(txfSystem5, 3, 7);
        pane.add(btnSystem5, 4, 7);
        GridPane.setHalignment(lblForløb, HPos.CENTER);
        GridPane.setHalignment(lblSystem, HPos.CENTER);

    }
    
    public void startUp() {
        uCase = null;
    }
    
    public void addSystem() {
        systemList.add(txfSystem.getText());
        txfSystem.setDisable(true);
        btnSystem.setDisable(true);
        txfSystem2.setVisible(true);
        btnSystem2.setVisible(true);
        
    }

    public void addSystem2() {
        systemList.add(txfSystem.getText());
        txfSystem2.setDisable(true);
        btnSystem2.setDisable(true);
        txfSystem3.setVisible(true);
        btnSystem3.setVisible(true);
        
    }
    
    public void addSystem3() {
        systemList.add(txfSystem.getText());
        txfSystem3.setDisable(true);
        btnSystem3.setDisable(true);
        txfSystem4.setVisible(true);
        btnSystem4.setVisible(true);
        
    }
    
    public void addSystem4() {
        systemList.add(txfSystem.getText());
        txfSystem4.setDisable(true);
        btnSystem4.setDisable(true);
        txfSystem5.setVisible(true);
        btnSystem5.setVisible(true);
        
    }
    
    public void addForløb() {
        forloebList.add(new Forloeb(systemList));
    }
    
    public void print() {
        String navn = txfNavn.getText();
        String trigger = txfTrigger.getText();
        String beskrivelse = txfBeskrivelse.getText();
        String aktører = txfAktør.getText();
        String rel = txfRelUseCase.getText();
        String interessenter = txfInteressenter.getText();
        String pre = txfPreB.getText();
        String post = txfPostB.getText();
        String alternativt = txfAlternativt.getText();
        uCase.setNavn(navn);
        uCase.setHaendelse(trigger);
        uCase.setBeskrivelse(beskrivelse);
        uCase.setAktoer(aktører);
        uCase.setRelUseCases(rel);
        uCase.setInteressenter(interessenter);
        uCase.setPreBetingelse(pre);
        uCase.setPostBetingelse(post);
        uCase.setAlternativForloeb(alternativt);
        
    }

    public void clear() {
        txfNavn.clear();
        txfTrigger.clear();
        txfBeskrivelse.clear();
        txfAktør.clear();
        txfRelUseCase.clear();
        txfInteressenter.clear();
        txfPreB.clear();
        txfPostB.clear();
        txfAlternativt.clear();
        txfAktørForløb.clear();
        txfSystem.clear();
        systemList.clear();
        forloebList.clear();
    }
    
}
