import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GameObject {
    // AP Standard: private instance variables
    private double x;
    private double y;
    private int width;
    private int height;
    private Texture image;
    private Rectangle hitbox;

    // AP Standard: constructors
    public GameObject(double x, double y, int width, int height, String imagePath) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = new Texture(imagePath);
        // AP Review: Casting double to int for the LibGDX Rectangle class
        this.hitbox = new Rectangle((int) x, (int) y, width, height);
    }

    public Rectangle getBounds() {
        hitbox.setPosition((float)x, (float)y);
        return hitbox;
    }

    // TODO 1: Write getter methods for x, y, and hitbox.
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    // TODO 2: Write setter methods for x and y. 
    // HINT: When you change x or y, you MUST also update the hitbox!
    // Example: hitbox.setPosition((int) newX, (int) newY);
    public void setX(double newX) { 
        this.x = newX; 
        this.hitbox.setX((float)newX); // Must update the hitbox too!
    }
    public void setY(double newY) { 
        this.y = newY; 
        this.hitbox.setY((float)newY); 
    }

    /**
     * Draws the object to the screen. 
     */
    public void draw(SpriteBatch batch) {
        batch.draw(image, (int) x, (int) y, width, height);
    }

    /**
     * To be overridden by subclasses (Polymorphism).
     * The default GameObject does not move.
     */
    public void move(double deltaTime) {
        // Leave blank for subclasses to override!
    }
}