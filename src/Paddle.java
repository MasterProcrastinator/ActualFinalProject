import java.awt.Rectangle;
import java.awt.*;
import java.awt.Color;
public class Paddle extends Rectangle {
    private Color color;
    private int speed;

    public Paddle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        color = Color.WHITE;
        speed = 10;
    }
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.width, this.height);
    }

}
