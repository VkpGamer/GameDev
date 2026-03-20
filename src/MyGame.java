import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.Iterator;

public class MyGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private ArrayList<GameObject> activeObjects;
    private Player player;
    
    @Override
    public void create() {
        batch = new SpriteBatch();
        activeObjects = new ArrayList<GameObject>();

        // TODO 3: Instantiate your Player subclass and add it to activeObjects.
        player = new Player(Gdx.graphics.getWidth() / 2, 50);
        activeObjects.add(player);

        // TODO 4: Write a for-loop to instantiate 5 Enemy objects at different
        // starting Y-coordinates and add them to activeObjects.
        for (int i = 0; i < 5; i++) {
            float enemyY = Gdx.graphics.getHeight() + (i * 100) + (float) (Math.random() * 50);
            float enemyX = (float) (Math.random() * (Gdx.graphics.getWidth() - 64));
            activeObjects.add(new Enemy(enemyX, enemyY));
        }
    }

    // render() is the game loop, called approx 60 times per second
    @Override
    public void render() {
        // Boilerplate: Clear the screen to black each frame
        Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // --- AP REVIEW: CASTING ---
        // Gdx.graphics.getDeltaTime() returns a float.
        // We cast it to a double to stay strictly within the AP CSA Java standards.
        double deltaTime = (double) Gdx.graphics.getDeltaTime();

        // --- AP REVIEW: POLYMORPHISM ---
        // TODO 5: Write a standard or enhanced for-loop to iterate through activeObjects.
        // For each object, call its move() method.
        for (GameObject obj : activeObjects) {
            obj.move(deltaTime);
        }

        // Note: Anything drawn must be between .begin() and .end()
        batch.begin();

        // TODO 6: Write a loop to iterate through activeObjects and call draw(batch).
        for (GameObject obj : activeObjects) {
            obj.draw(batch);
        }

        batch.end();

        // --- AP REVIEW: ARRAYLIST TRAVERSAL & REMOVAL ---
        // TODO 7: Write collision logic.
        // You must iterate through the list to check if the player overlaps with enemies.
        // See the cheat sheet for the overlap method!
        // NOTE: If you are removing items from an ArrayList, how must you structure
        // your for-loop to avoid skipping elements?

        Iterator<GameObject> iterator = activeObjects.iterator();
        while (iterator.hasNext()) {
            GameObject obj = iterator.next();
            if (obj instanceof Enemy && obj.getBounds().overlaps(player.getBounds())) {
                System.out.println("Collision detected! Game Over.");
                iterator.remove(); 
            }
            if (obj.getBounds().y + obj.getBounds().height < 0) {
                iterator.remove();
            }
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}