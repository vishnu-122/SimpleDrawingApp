import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * A class representing a square shape.
 * Squares can be drawn on the canvas with a specified size and fill color.
 * They follow the GeometricObject superclass and implement the Drawable interface.
 * @author Vishnu M Marwadi
 */
public class Square extends GeometricObject {

    private double size;
/**
        * Constructor for creating a square shape.
            * @param x The X-coordinate of the square's center
            * @param y The Y-coordinate of the square's center
            * @param fillColor The fill color of the square
     * @param size The size of the square
     */
    public Square(double x, double y, Color fillColor, double size) {
        super(x, y, fillColor);
        this.size = size;
    }

    /**
     * Draw the square on the canvas using the provided GraphicsContext.
     * The square is filled with the specified fill color.
     * @param gc The GraphicsContext used for rendering
     */
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.fillRect(getX() - size / 2, getY() - size / 2, size, size);
    }
}
