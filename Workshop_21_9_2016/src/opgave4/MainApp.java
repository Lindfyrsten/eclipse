package opgave4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane root = initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent() {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(200, 200);
        pane.add(canvas, 0, 0);
        drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------
    
    //  FIGUR 1
    //
//    private void drawShapes(GraphicsContext gc) {
//        int x = 100; //center (x,y)
//        int y = 100;
//        int r = 100; //radius
//
//        while (r >= 10) {
//            gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
//            r = r - 20;
//        }
//
//    }

    //
    // FIGUR 2
    //
//    private void drawShapes(GraphicsContext gc) {
//        int x = 90; //center (x,y)
//        int y = 100;
//        int r = 80; //radius
//
//        while (r >= 10) {
//            gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
//            r = r - 10;
//            x = x - 10;
//        }
//
//    }
    
    //
    // FIGUR 3
    //
    private void drawShapes(GraphicsContext gc) {
        int x = 100; //center (x,y)
        int y = 100;
        int r = 100; //radius
        
        while (r >= 20) {
            gc.strokeOval(x - r, y - 40, 2 * r, 80);
            r = r - 10;
        }

    }

}
