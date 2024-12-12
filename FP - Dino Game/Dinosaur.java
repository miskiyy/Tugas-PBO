import java.awt.Image;

public class Dinosaur extends Block {
    boolean isDucking = false;
    int velocityY = 0;
    int gravity = 1;
    int originalY;

    public Dinosaur(int x, int y, int width, int height, Image img) {
        super(x, y, width, height, img);
        this.originalY = y;
    }

    public void jump() {
        if (y == originalY) {
            velocityY = -17; // Set jump speed
        }
    }

    public void duck() {
        isDucking = true;
        height = 60; // Height when ducking
        y = 180; // Duck position
    }

    public void standUp() {
        isDucking = false;
        height = 94; // Normal height
        y = originalY; // Original position
    }

    public void move() {
        velocityY += gravity;
        y += velocityY;

        if (y > originalY) { // Stop the dinosaur from falling past the ground
            y = originalY;
            velocityY = 0;
        }
    }
}
