public class Enemy extends GameObject {
    private float speedY = -100f;

    public Enemy(float x, float y) {
        super(x, y, 64, 64, "enemy.png");
    }

    @Override
    public void move(double deltaTime) {
        // Use the setters from GameObject to keep the hitbox in sync
        setY(getY() + (speedY * deltaTime));
    }
}
