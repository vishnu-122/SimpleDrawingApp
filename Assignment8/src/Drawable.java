    import javafx.scene.canvas.GraphicsContext;
/**
        * An interface representing a drawable object.
            * Objects that implement this interface can be drawn on the canvas using a GraphicsContext.
            * This interface enforces the implementation of the draw method for rendering.
            * It follows the documentation standards and is intended to be implemented by shape classes.
            * @author Vishnu M Marwadi
            */
    public interface Drawable {
    /**
     * Draw the object on the canvas using the provided GraphicsContext.
     * @param gc The GraphicsContext used for rendering
     */
        void draw(GraphicsContext gc);
    }
