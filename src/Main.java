import javax.swing.*;

/**
 * Run this to run the game
 */
public class Main 
{
    public static int WIDTH = 500;
    public static int HEIGHT = 520;

    public static void main(String[] args) 
    {
    	// main jframe
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        Keyboard keyboard = Keyboard.getInstance();
        frame.addKeyListener(keyboard);

        Panel panel = new Panel();
        frame.add(panel);
        frame.setResizable(false);
        frame.setSize(WIDTH, HEIGHT);
    }
}