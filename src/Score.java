import java.awt.*;

public class Score extends Rectangle{


    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    private static int scorePlayer1;
    private static int scorePlayer2;

    Score(int GAME_HEIGHT, int GAME_WIDTH){
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;

    }
    public static void setScore1(int newScore){
        scorePlayer1=newScore;
    }
    public static void setScore2(int newScore){
        scorePlayer2=newScore;
    }

    public static void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Consolas",Font.PLAIN,60));
        g.drawString(String.valueOf(scorePlayer1),(GAME_WIDTH/2)-85, 50);
        g.drawString(String.valueOf(scorePlayer2),(GAME_WIDTH/2)+345, 50);

    }
}
