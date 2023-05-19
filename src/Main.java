import javax.swing.*;
public class Main {

    public static void main(String[]args){
        JFrame frame = new JFrame();
        frame.setSize(710,410);
        GamePanel myPanel = new GamePanel();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(myPanel);

    }
}