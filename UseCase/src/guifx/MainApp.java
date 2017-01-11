package guifx;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Forloeb;
import model.UseCase;
import service.Service;

/**
 * @author Lindbjerg
 */
public class MainApp extends Application {
    private TextField txfNavn, txfTrigger, txfBeskrivelse, txfAktør, txfRelUseCase,
        txfInteressenter, txfPreB, txfPostB, txfAlternativt, txfAktørForløb, txfSystem0,
        txfSystem1, txfSystem2, txfSystem3, txfSystem4;
    private Button btnAddForløb, btnSletForløb, btnNytForløb, btnGenerate, btnReset;
    private ListView<Forloeb> lvwForløb = new ListView<>();
    private ArrayList<String> systemList = new ArrayList<>();
    private ArrayList<Forloeb> forloebList = new ArrayList<>();
    
    public static void main(String[] args) {
        Application.launch(args);
        
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane, 730, 550);
        stage.setScene(scene);
        stage.setTitle("Use Case Generator");
        stage.show();
        stage.setResizable(false);
        pane.setVgap(10);
        pane.setHgap(30);
        pane.setPadding(new Insets(20, 10, 10, 10));
// pane.setGridLinesVisible(true);
        
        Label lblTitle = new Label("Use case generator");
        lblTitle.setTextFill(Color.GREY);
        lblTitle.setFont(Font.font("Impact", 48));
        Label lblNavn = new Label("Use case id/navn:");
        Label lblTrigger = new Label("Trigger hændelse:");
        Label lblBeskrivelse = new Label("Beskrivelse:");
        Label lblAktører = new Label("Aktører");
        Label lblRelUseCase = new Label("Rel. use cases:");
        Label lblInteres = new Label("Interessenter:");
        Label lblPreb = new Label("Præbetingelse:");
        Label lblPostB = new Label("Postbetingelse");
        Label lblForløb = new Label("Hovedforløb");
        lblForløb.setFont(Font.font("Arial", 18));
        Label lblAktørForløb = new Label("            Aktør");
        Label lblSystem = new Label("System");
        Label lblAlternativt = new Label("Alternativt forløb:");

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
        txfSystem0 = new TextField();
        txfSystem1 = new TextField();
        txfSystem2 = new TextField();
        txfSystem3 = new TextField();
        txfSystem4 = new TextField();
        txfAlternativt = new TextField();
        
        lvwForløb.setPrefSize(200, 120);
        ChangeListener<Forloeb> listener = (ov, oldForloeb, newForloeb) -> selectedForloebChanged();
        lvwForløb.getSelectionModel().selectedItemProperty().addListener(listener);
        
        btnGenerate = new Button("Print til fil");
        btnGenerate.setPrefSize(100, 50);
        btnGenerate.setOnAction(event -> print());
        btnReset = new Button("Reset");
        btnReset.setPrefSize(100, 50);
        btnReset.setOnAction(event -> clear());
        btnAddForløb = new Button("Tilføj/Opdater");
        btnAddForløb.setOnAction(event -> addForløb());
        btnSletForløb = new Button("Slet");
        btnSletForløb.setOnAction(event -> sletForløb());
        btnNytForløb = new Button("Nyt forløb");
        btnNytForløb.setOnAction(event -> clearForløb());

        VBox lblBox =
            new VBox(29, lblNavn, lblTrigger, lblBeskrivelse, lblAktører, lblRelUseCase, lblInteres,
                lblPreb, lblPostB);
        VBox txfBox = new VBox(20, txfNavn, txfTrigger, txfBeskrivelse, txfAktør, txfRelUseCase,
            txfInteressenter, txfPreB, txfPostB);
        HBox hbxForløb = new HBox(20, btnAddForløb, btnNytForløb, btnSletForløb);
        hbxForløb.setAlignment(Pos.BASELINE_CENTER);
        HBox hbxAlt = new HBox(20, lblAlternativt, txfAlternativt);
        
        pane.add(lblTitle, 0, 0, 4, 1);
        GridPane.setHalignment(lblTitle, HPos.CENTER);
        pane.add(lblBox, 0, 2, 1, 10);
        pane.add(txfBox, 1, 2, 1, 10);
        pane.add(lblForløb, 2, 1, 2, 1);
        pane.add(lblAktørForløb, 2, 2);
        pane.add(lblSystem, 3, 2);
        pane.add(txfAktørForløb, 2, 3);
        pane.add(txfSystem0, 3, 3);
        pane.add(txfSystem1, 3, 5);
        pane.add(txfSystem2, 3, 6);
        pane.add(txfSystem3, 3, 7);
        pane.add(txfSystem4, 3, 8);
        pane.add(hbxForløb, 2, 9, 3, 1);
        pane.add(lvwForløb, 2, 10, 2, 1);
        pane.add(hbxAlt, 2, 11, 2, 1);
        pane.add(btnGenerate, 0, 11);
        pane.add(btnReset, 1, 11);
        GridPane.setHalignment(btnGenerate, HPos.CENTER);
        GridPane.setHalignment(btnReset, HPos.CENTER);
        GridPane.setValignment(btnGenerate, VPos.CENTER);
        GridPane.setValignment(btnReset, VPos.CENTER);
        GridPane.setHalignment(lblForløb, HPos.CENTER);
        GridPane.setHalignment(lblSystem, HPos.CENTER);

    }

    private void selectedForloebChanged() {
        updateControls();
    }

    public void clearForløb() {
        txfAktørForløb.clear();
        txfSystem0.clear();
        txfSystem1.clear();
        txfSystem2.clear();
        txfSystem3.clear();
        txfSystem4.clear();
        systemList.clear();
        lvwForløb.getSelectionModel().clearSelection();
        
    }
    
    public void addForløb() {
        Forloeb f = lvwForløb.getSelectionModel().getSelectedItem();
        if (f != null) {
            ArrayList<String> systemer = new ArrayList<>();
            ArrayList<TextField> txfs = new ArrayList<>();
            txfs.add(txfSystem0);
            txfs.add(txfSystem1);
            txfs.add(txfSystem2);
            txfs.add(txfSystem3);
            txfs.add(txfSystem4);
            for (TextField txf : txfs) {
                if (!txf.getText().isEmpty()) {
                    systemer.add(txf.getText());
                }
            }
            f.setSystembesker(systemer);
            f.setAktoer(txfAktørForløb.getText());
        }
        else {
            
            ArrayList<String> systemer = new ArrayList<>();
            ArrayList<TextField> txfs = new ArrayList<>();
            txfs.add(txfSystem0);
            txfs.add(txfSystem1);
            txfs.add(txfSystem2);
            txfs.add(txfSystem3);
            txfs.add(txfSystem4);
            for (TextField txf : txfs) {
                if (!txf.getText().isEmpty()) {
                    systemer.add(txf.getText());
                }
            }
            
            forloebList.add(new Forloeb(txfAktørForløb.getText(), systemer));
        }
        lvwForløb.getItems().setAll(forloebList);
        clearForløb();
    }
    
    public void sletForløb() {
        Forloeb f = lvwForløb.getSelectionModel().getSelectedItem();
        forloebList.remove(f);
        lvwForløb.getItems().setAll(forloebList);
        lvwForløb.getSelectionModel().clearSelection();
        clearForløb();
    }
    
    public void updateControls() {
        Forloeb f = lvwForløb.getSelectionModel().getSelectedItem();
        if (f != null) {
            txfAktørForløb.setText(f.getAktoer());
            if (f.getSystembesker().size() == 1) {
                txfSystem0.setText(f.getSystembesker().get(0));
                txfSystem1.clear();
                txfSystem2.clear();
                txfSystem3.clear();
                txfSystem4.clear();
            }
            else
                if (f.getSystembesker().size() == 2) {
                    txfSystem0.setText(f.getSystembesker().get(0));
                    txfSystem1.setText(f.getSystembesker().get(1));
                    txfSystem2.clear();
                    txfSystem3.clear();
                    txfSystem4.clear();
                }
                else
                    if (f.getSystembesker().size() == 3) {
                        txfSystem0.setText(f.getSystembesker().get(0));
                        txfSystem1.setText(f.getSystembesker().get(1));
                        txfSystem2.setText(f.getSystembesker().get(2));
                        txfSystem3.clear();
                        txfSystem4.clear();
                    }
                    else
                        if (f.getSystembesker().size() == 4) {
                            txfSystem0.setText(f.getSystembesker().get(0));
                            txfSystem1.setText(f.getSystembesker().get(1));
                            txfSystem2.setText(f.getSystembesker().get(2));
                            txfSystem3.setText(f.getSystembesker().get(3));
                            txfSystem4.clear();
                        }

                        else
                            if (f.getSystembesker().size() == 5) {
                                txfSystem0.setText(f.getSystembesker().get(0));
                                txfSystem1.setText(f.getSystembesker().get(1));
                                txfSystem2.setText(f.getSystembesker().get(2));
                                txfSystem3.setText(f.getSystembesker().get(3));
                                txfSystem4.setText(f.getSystembesker().get(4));
                            }

        }

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
        UseCase uCase = Service.createUseCase(navn, trigger, beskrivelse, aktører, rel,
            interessenter, pre, post,
            alternativt, forloebList);
        uCase.printCase();

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
        forloebList.clear();
        clearForløb();
        lvwForløb.getItems().setAll(forloebList);
        
    }
    
}
