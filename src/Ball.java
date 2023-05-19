import java.awt.*;
import java.awt.Rectangle;
public class Ball extends Rectangle{
    private Color color;
    private double xSpeed;
    private double ySpeed;
    private static int score;
    private static int score2;
    private boolean fake;


    public Ball(int x, int y, int width, int height, double xSpeed, double ySpeed){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        color = Color.WHITE;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public Ball(int xSpeed, int ySpeed, int y){
        this.x = 300;
        this.y = y;
        this.width = 5;
        this.height = 5;
        color = new Color(209, 209,209);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        fake = true;
    }
    public void draw(Graphics g){
        g.setColor(this.color);
        g.fillOval(this.x, this.y, this.width, this.height);
    }

    public void setXSpeed(double newX){
        xSpeed=newX;
    }

    public void move(){
        if (this.y >= 400 - this.height - 35|| y <= 0){
            ySpeed*= -1;
        }
        if (this.x > 700 - this.width - 10){
            x = 700/2 - 20;
            score++;
        }
        if (x <= 0){
            x = 700/2 - 20;
            score2++;
        }

        this.x += this.xSpeed;
        this.y += this.ySpeed;
    }
    public void move(GamePanel anyName){
        if (this.y >= 400 - this.height - 35|| y <= 0){
            ySpeed*= -1;
        }
        if (this.x > 700 - this.width - 10){
            x = 700/2 - 20;
        }
        if (x <= 0){
            x = 700/2 - 20;
        }

        this.x += this.xSpeed;
        this.y += this.ySpeed;
    }
public static int getScore() {
    return score;
}
public static int getScore2(){
        return score2;
    }





}