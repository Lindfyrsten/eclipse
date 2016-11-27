package guifx;

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
        TabPane tabPane = new TabPane();
        initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    public void initTabPane(TabPane tabPane) {

        Tab tabReserver = new Tab("Reserver Bil");
        Tab tabUdlej = new Tab("Udlej Bil");
        Tab tabAflever = new Tab("Aflever Bil");
        Tab tabOpret = new Tab("Opret Bil");
        Tab tabPrisgrupper = new Tab("Administrer Bilgrupper");
        tabPane.getTabs().addAll(tabReserver, tabUdlej, tabAflever, tabOpret, tabPrisgrupper);
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        ReserverPane rsvPane = new ReserverPane();
//        tabReserver.setContent(rsvPane);
        UdlejPane uP = new UdlejPane();
        BilPane bP = new BilPane();
        tabOpret.setContent(bP);
        PrisGruppePane pgP = new PrisGruppePane();
        
    }
    
}
