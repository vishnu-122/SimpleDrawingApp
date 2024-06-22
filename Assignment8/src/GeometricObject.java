import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
/**
 * An abstract class representing a geometric object with position and color.
 * Subclasses should implement the draw method for rendering the shape.
 * @author Vishnu M Marwadi
 */

public abstract class GeometricObject {

    private double x; // X-coordinate of the object
    private double y; // Y-coordinate of the object
    private Color fillColor; // Fill color of the object

    /**
     * Constructor for a geometric object.
     * @param x The X-coordinate of the object
     * @param y The Y-coordinate of the object
     * @param fillColor The fill color of the object
     */
    public GeometricObject(double x, double y, Color fillColor) {
        this.x = x;
        this.y = y;
        this.fillColor = fillColor;
    }

    /**
     * Get the X-coordinate of the object.
     * @return The X-coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Get the Y-coordinate of the object.
     * @return The Y-coordinate
     */
    public double getY() {
        return y;
    }
    /**
     * Set the X-coordinate of the object.
     * @param x The new X-coordinate
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Set the Y-coordinate of the object.
     * @param y The new Y-coordinate
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Get the fill color of the object.
     * @return The fill color
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * Abstract method to be implemented by subclasses to draw the shape.
     * @param gc The GraphicsContext used for rendering
     */
    public abstract void draw(GraphicsContext gc);
}
