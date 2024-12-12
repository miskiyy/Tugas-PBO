import java.awt.Image;

public class Block {
    int x;
    int y;
    int width;
    int height;
    Image img;

    Block(int x, int y, int width, int height, Image img) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.img = img;
    }
}
