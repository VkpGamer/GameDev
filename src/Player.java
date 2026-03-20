import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Player extends GameObject {
    public Player(double x, double y) {
        super(x, y, 64, 64, "player.png");
    }

    @Override
    public void move(double deltaTime) {
        int speed = 200;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))  setX(getX() - speed * deltaTime);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) setX(getX() + speed * deltaTime);
        if (Gdx.input.isKeyPressed(Input.Keys.UP))    setY(getY() + speed * deltaTime);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))  setY(getY() - speed * deltaTime);
    }
}
