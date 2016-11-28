package guifx;

import application.service.Service;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Kaj's Biler");
        BorderPane pane = new BorderPane();
        initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
    
    public void initContent(BorderPane pane) {
        Service.opretStartBiler();
        TabPane tabPane = new TabPane();
        initTabPane(tabPane);
        pane.setCenter(tabPane);
    }
    
    public void initTabPane(TabPane tabPane) {

        Tab tabUdlej = new Tab("Udlej/Reserver Bil");
        Tab tabAflever = new Tab("Aflever Bil");
        Tab tabOpret = new Tab("Administrer Biler");
        Tab tabPrisgrupper = new Tab("Administrer Bilgrupper");
        tabPane.getTabs().addAll(tabUdlej, tabAflever, tabOpret, tabPrisgrupper);
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        UdlejPane uP = new UdlejPane();
        tabUdlej.setContent(uP);
        BilPane bP = new BilPane();
        tabOpret.setContent(bP);
        PrisGruppePane pgP = new PrisGruppePane();
    }

}
