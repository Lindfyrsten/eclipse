package opgave3;

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

    //
    // figur 1
    //
//    private void drawShapes(GraphicsContext gc) {
//        int x1 = 20; // start point: (x1,y1)
//        int y1 = 190;
//        int x2 = 20; // end point: (x2,y2)
//        int y2 = 10;
//        while (x2 <= 180 && x1 <= 180) {
//            gc.strokeLine(x1, y1, x2, y2);
//            x1 = x1 + 40;
//            x2 = x2 + 40;
//
//        }
    
    //
    //  figur 2
    //
//    private void drawShapes(GraphicsContext gc) {
//        int x1 = 190; // start point: (x1,y1)
//        int y1 = 20;
//        int x2 = 10; // end point: (x2,y2)
//        int y2 = 20;
//
//        while (y1 <= 180 && y2 <= 180) {
//            gc.strokeLine(x1, y1, x2, y2);
//            y1 = y1 + 40;
//            y2 = y2 + 40;
//        }
//    }
//
    //
    //  figur 3
    //
    private void drawShapes(GraphicsContext gc) {
        double x = 180; // start point: (x1,y1)
        double y1 = x / 5 + x / 2;
        double y2 = y1 / 7;
        while (x > 5) {
            gc.strokeLine(x, y1, x, y2);
            x = 0.75 * x;
            
        }
        
    }
}
