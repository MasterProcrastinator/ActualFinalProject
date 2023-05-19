import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GamePanel extends JPanel{

    public final static int GAME_WIDTH = 700;
    public final static int GAME_HEIGHT = 400;
    ArrayList<Ball> balls = new ArrayList<Ball>();

    Score score = new Score(GAME_WIDTH,GAME_HEIGHT);
    Paddle player = new Paddle(50,80,5,50);
    Paddle player2 = new Paddle(GAME_WIDTH - 60,80,5,50);
    Ball ball = new Ball(GAME_WIDTH/2 - 50, GAME_HEIGHT/2 - 50, 5,5,1,1);

    public GamePanel(){
        this.setFocusable(true);
        this.setBackground(Color.BLACK);


        this.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e){
            }
            @Override
            public void keyPressed(KeyEvent e){
                int key2 = e.getKeyCode();

                if (key2 == 87 && player.y >= 10){
                    player.y -= 20;
                }
                else if(key2== 83 && player.y < GAME_HEIGHT - player.height - 30) {
                    player.y += 20;
                }

                else if(key2 == 38 && player2.y >= 10){
                    player2.y -= 20;
                }
                else if(key2 == 40 && player2.y < GAME_HEIGHT- player2.height - 30){
                    player2.y+= 20;
                }
            }
            @Override
            public void keyReleased(KeyEvent e){
            }
        });

    }


    public void checkCollision(){
        if (player2.intersects(ball)){
            int y = (int)(Math.random()* 2)+1;
            if (y ==1){
                balls.add(new Ball(1,1, 30));
                balls.add(new Ball(1,1, GAME_HEIGHT-60));
            }
            double x = Math.floor(Math.random()*2);
            if(x==1)
                ball.setXSpeed(-1);
            else{
                ball.setXSpeed(-2);
            }
            for(Ball array:balls){
                double o = Math.floor(Math.random()*2);
                if(o==1)
                    array.setXSpeed(-1);
                else{
                    array.setXSpeed(-2);
                }
            }


        }
        if (player.intersects(ball)){
            int y = (int)(Math.random()* 2)+1;
            if (y ==1){
                balls.add(new Ball(1,1, 30));
                balls.add(new Ball(1,1, GAME_HEIGHT-60));
            }
            double x = Math.floor(Math.random()*2);
            if(x==1)
                ball.setXSpeed(1);
            else{
                ball.setXSpeed(2);
            }
            for(Ball array:balls){
                double i = Math.floor(Math.random()*2);
                if(i==1)
                    array.setXSpeed(1);
                else{
                    array.setXSpeed(2);
                }
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        player.draw(g);
        player2.draw(g);
        ball.draw(g);
        ball.move();
        for(Ball array:balls){
            array.move(this);
            array.draw(g);
        }

        Score.setScore1(Ball.getScore());
        Score.setScore2(Ball.getScore2());
        Score.draw(g);


        try{
            Thread.sleep(8);
        }
        catch(Exception e){
            System.out.println(e);
        }
        checkCollision();
        repaint();

    }

}