import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * A class representing a circle shape.
 * Circles can be drawn on the canvas with a specified radius and fill color.
 * They follow the GeometricObject superclass and implement the Drawable interface.
 * @author Vishnu M Marwadi
 */
public class Circle extends GeometricObject {

    private double radius; // The radius of the circle

    /**
     * Constructor for creating a circle shape.
     * @param x The X-coordinate of the circle's center
     * @param y The Y-coordinate of the circle's center
     * @param fillColor The fill color of the circle
     * @param radius The radius of the circle
     */
    public Circle(double x, double y, Color fillColor, double radius) {
        super(x, y, fillColor);
        this.radius = radius;
    }
    /**
     * Draw the circle on the canvas using the specified GraphicsContext.
     * @param gc The GraphicsContext used for rendering
     */
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getFillColor());
        gc.fillOval(getX() - radius, getY() - radius, 2 * radius, 2 * radius);
    }
}
