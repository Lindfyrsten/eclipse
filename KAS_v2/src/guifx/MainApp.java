package guifx;

import application.service.Service;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        initContent(pane);
        
        stage.setScene(scene);
        stage.show();
    }
    
    private void initContent(GridPane pane) {
        
        pane.setPadding(new Insets(10));
        pane.setVgap(20);
        pane.setHgap(10);

        Button btnKonference = new Button("Konference");
        btnKonference.setTextFill(Color.GREY);
        btnKonference.setFont(Font.font("Impact", 24));
        btnKonference.setPrefSize(200, 50);
        btnKonference.setOnAction(event -> konference());
        
        Button btnHotel = new Button("Hotel");
        btnHotel.setTextFill(Color.DARKGREY);
        btnHotel.setFont(Font.font("Impact", 24));
        btnHotel.setPrefSize(200, 50);
        btnHotel.setOnAction(event -> hotel());
        
        Button btnTilmeldning = new Button("Tilmeldning");
        
        btnTilmeldning.setFont(Font.font("Impact", 24));
        btnTilmeldning.setPrefSize(200, 50);
        btnTilmeldning.setOnAction(event -> nyTilmeldning());
        
        pane.add(btnTilmeldning, 0, 0);
        pane.add(btnKonference, 0, 1);
        pane.add(btnHotel, 0, 2);
    }

    private void konference() {

        KonferencePane konferencePane = new KonferencePane();
        konferencePane.showAndWait();

    }

    private void hotel() {
        HotelPane hotelPane = new HotelPane();
        hotelPane.showAndWait();
    }
    
    private void nyTilmeldning() {
        TilmeldningsPane tilmeldningsPane = new TilmeldningsPane();
        tilmeldningsPane.showAndWait();
    }
    
}
