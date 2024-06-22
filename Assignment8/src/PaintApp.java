import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;
/**
 * This class represents a simple drawing application using JavaFX.
 * Users can draw shapes on a canvas, switch between circle and square,
 * and undo drawn shapes. The application follows the documentation standards.
 * @author Vishnu M Marwadi
 */

public class PaintApp extends Application {

    private GeometricObject currentShape;
    private List<GeometricObject> shapesList = new ArrayList<>();
    private Canvas canvas;
    private Button drawButton;
    private Button undrawButton;
    private Button switchButton;
    private Label errorLabel;
    /**
     * The main entry point of the application.
     * @param args Command-line arguments
     */

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initialize and set up the GUI components.
     * @param stage The primary stage for the application
     */
    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Simple Drawing App");
        stage.setScene(scene);

        canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        drawButton = new Button("Draw");
        undrawButton = new Button("Undraw");
        switchButton = new Button("Switch Shape");
        errorLabel = new Label("No Errors");

        // Set layout positions for GUI components
        drawButton.setLayoutX(10);
        drawButton.setLayoutY(10);
        undrawButton.setLayoutX(100);
        undrawButton.setLayoutY(10);
        switchButton.setLayoutX(200);
        switchButton.setLayoutY(10);
        errorLabel.setLayoutX(300);
        errorLabel.setLayoutY(10);

        // Set action listeners for buttons
        drawButton.setOnAction(event -> drawShape(gc));
        undrawButton.setOnAction(event -> undrawShape(gc));
        switchButton.setOnAction(event -> switchShape());

        // Add GUI components to the root pane
        root.getChildren().addAll(canvas, drawButton, undrawButton, switchButton, errorLabel);

        // Set mouse event handlers for canvas
        canvas.setOnMouseClicked(event -> handleMouseClick(event, gc));
        canvas.setOnMouseDragged(event -> handleMouseDragged(event, gc));

        // Show the stage
        stage.show();
    }

    /**
     * Draws the current shape on the canvas and adds it to the shapes list.
     * If an error occurs, displays the error message in the error label.
     * @param gc The GraphicsContext used for drawing
     */
    private void drawShape(GraphicsContext gc) {
        try {
            if (currentShape != null) {
                currentShape.draw(gc);
                shapesList.add(currentShape);
                errorLabel.setText("No Errors");
                errorLabel.setTextFill(Color.BLACK);
            }
        } catch (IllegalArgumentException e) {
            errorLabel.setText("Error: " + e.getMessage());
            errorLabel.setTextFill(Color.RED);
        }
    }

    private void undrawShape(GraphicsContext gc) {
        if (!shapesList.isEmpty()) {
            shapesList.remove(shapesList.size() - 1);
            redrawAllShapes(gc);
        }
    }

    private void redrawAllShapes(GraphicsContext gc) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (GeometricObject shape : shapesList) {
            shape.draw(gc);
        }
    }

    private void switchShape() {
        if (currentShape instanceof Circle) {
            currentShape = new Square(currentShape.getX(), currentShape.getY(), currentShape.getFillColor(), 50);
        } else {
            currentShape = new Circle(currentShape.getX(), currentShape.getY(), currentShape.getFillColor(), 50);
        }
        redrawAllShapes(canvas.getGraphicsContext2D());
    }

    private void handleMouseClick(MouseEvent event, GraphicsContext gc) {
        currentShape = createNewShape(Color.BLACK, 50);
        currentShape.setX(event.getX());
        currentShape.setY(event.getY());
        drawShape(gc);
    }

    private void handleMouseDragged(MouseEvent event, GraphicsContext gc) {
        if (currentShape != null) {
            currentShape.setX(event.getX());
            currentShape.setY(event.getY());
            redrawAllShapes(gc);
            currentShape.draw(gc);
        }
    }

    /**
     * Create a new shape based on the current shape type and parameters.
     * @param fillColor The fill color of the shape
     * @param size The size of the shape
     * @return A new geometric shape object
     */
    private GeometricObject createNewShape(Color fillColor, double size) {
        if (currentShape instanceof Circle) {
            return new Circle(0, 0, fillColor, size);
        } else {
            return new Square(0, 0, fillColor, size);
        }
    }
}
