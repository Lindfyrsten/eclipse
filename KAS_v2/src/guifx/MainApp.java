package guifx;

import application.service.Service;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
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

//        pane.setGridLinesVisible(true);
        pane.setPrefHeight(350);
        pane.setPadding(new Insets(30));
        pane.setVgap(30);
        pane.setHgap(30);
        
        Button btnKonference = new Button("Konference");
        btnKonference.setPrefSize(100, 70);
        btnKonference.setOnAction(event -> konference());
        
        Button btnHotel = new Button("Hotel");
        btnHotel.setPrefSize(100, 70);
        btnHotel.setOnAction(event -> hotel());
        
        Button btnUdflugt = new Button("Udflugt");
        btnUdflugt.setPrefSize(100, 70);
        btnUdflugt.setOnAction(event -> udflugt());

        Button btnTilmeldning = new Button("Tilmeld");
        btnTilmeldning.setPrefSize(100, 70);
        btnTilmeldning.setOnAction(event -> nyTilmeldning());
        
        pane.add(btnTilmeldning, 0, 0);
        pane.add(btnKonference, 0, 1);
        pane.add(btnHotel, 0, 2);
        pane.add(btnUdflugt, 0, 3);
    }

    private void konference() {

        KonferencePane konferencePane = new KonferencePane();
        konferencePane.showAndWait();

    }

    private void hotel() {
        HotelPane hotelPane = new HotelPane();
        hotelPane.showAndWait();
    }

    private void udflugt() {
        UdflugtPane udflugtPane = new UdflugtPane();
        udflugtPane.showAndWait();
    }
    
    private void nyTilmeldning() {
        TilmeldningsPane tilmeldningsPane = new TilmeldningsPane();
        tilmeldningsPane.showAndWait();
    }

}
