package opgave1;

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

    private void drawShapes(GraphicsContext gc) {
        
        int arrowHeight = 4;
        int arrowLength = 20;
        int size = 0;
        arrowHeight = arrowHeight + size;
        arrowLength = arrowLength + size;
        // draw an arrowhead at (50,30)
        int x = 100;
        int y = 75;
        gc.strokeLine(x, y, x + arrowLength, y - arrowHeight);
        gc.strokeLine(x, y, x + arrowLength, y + arrowHeight);
        
        // draw an arrowhead at (25,140)
        x = 100;
        y = 125;
        gc.strokeLine(x, y, x + arrowLength, y - arrowHeight);
        gc.strokeLine(x, y, x + arrowLength, y + arrowHeight);
        
        // draw a third arrowhead at (20,50)
        
        x = 20;
        y = 50;
        gc.strokeLine(x, y, x + arrowLength, y - arrowHeight);
        gc.strokeLine(x, y, x + arrowLength, y + arrowHeight);
        
    }

}
