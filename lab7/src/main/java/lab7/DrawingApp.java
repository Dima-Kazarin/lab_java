package lab7;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DrawingApp extends Application {

    private double brushSize = 10;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lab7");

        Group root = new Group();
        Canvas canvas = new Canvas(500, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        drawInitialShape(gc);

        ChoiceBox<Double> brushSizeSelector = new ChoiceBox<>();
        brushSizeSelector.getItems().addAll(5.0, 10.0, 15.0, 20.0);
        brushSizeSelector.setValue(brushSize);

        brushSizeSelector.setOnAction(e -> brushSize = brushSizeSelector.getValue());

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {
            gc.clearRect(e.getX() - brushSize / 2, e.getY() - brushSize / 2, brushSize, brushSize);
        });

        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            if (e.getClickCount() == 3) {
                drawInitialShape(gc);
            }
        });

        VBox layout = new VBox(brushSizeSelector, canvas);
        root.getChildren().add(layout);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    private void drawInitialShape(GraphicsContext gc) {
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0, 0, 500, 500);

        gc.setFill(Color.BEIGE);
        gc.fillRect(150, 200, 200, 200);

        gc.setStroke(Color.DARKBLUE);
        gc.setLineWidth(4);
        gc.strokeRect(150, 200, 200, 200);

        gc.setFill(Color.SADDLEBROWN);
        gc.fillPolygon(new double[]{150, 350, 250}, new double[]{200, 200, 100}, 3);

        gc.setStroke(Color.DARKRED);
        gc.setLineWidth(3);
        gc.strokePolygon(new double[]{150, 350, 250}, new double[]{200, 200, 100}, 3);

        gc.setFill(Color.DARKSLATEGRAY);
        gc.fillRect(220, 300, 50, 100);

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.strokeRect(220, 300, 50, 100);

        gc.setFill(Color.LIGHTCYAN);
        gc.fillRect(180, 250, 40, 40);

        gc.setStroke(Color.DARKBLUE);
        gc.setLineWidth(2);
        gc.strokeRect(180, 250, 40, 40);

        gc.setFill(Color.LIGHTCYAN);
        gc.fillRect(280, 250, 40, 40);

        gc.setStroke(Color.DARKBLUE);
        gc.setLineWidth(2);
        gc.strokeRect(280, 250, 40, 40);

        gc.setStroke(Color.DARKBLUE);
        gc.setLineWidth(1);
        gc.strokeLine(200, 250, 200, 290);  
        gc.strokeLine(180, 270, 220, 270);  
        gc.strokeLine(300, 250, 300, 290);  
        gc.strokeLine(280, 270, 320, 270);  
    }
}
