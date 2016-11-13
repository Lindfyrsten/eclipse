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
    public void init() {
        Service.init();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Konference organizer");
        BorderPane pane = new BorderPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

        Tab tabKonferencer = new Tab("Konference");
        tabPane.getTabs().add(tabKonferencer);

        KonferencePane konferencePane = new KonferencePane();
        tabKonferencer.setContent(konferencePane);
        tabKonferencer.setOnSelectionChanged(event -> konferencePane.updateControls());

        Tab tabDeltagere = new Tab("Deltager");
        tabPane.getTabs().add(tabDeltagere);

        DeltagerPane deltagerPane = new DeltagerPane();
        tabDeltagere.setContent(deltagerPane);
        tabDeltagere.setOnSelectionChanged(event -> deltagerPane.updateControls());

        Tab tabHotels = new Tab("Hotel");
        tabPane.getTabs().add(tabHotels);

        HotelPane hotelPane = new HotelPane();
        tabHotels.setContent(hotelPane);
        tabHotels.setOnSelectionChanged(event -> hotelPane.updateControls());
    }
}
