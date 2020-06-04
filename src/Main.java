import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.*;
import javax.swing.*;

import javax.swing.*;
    
/**
 * Run this to run the game
 */
public class Main 
{
	Image img=Toolkit.getDefaultToolkit().getImage("welcome.png");

	ImageIcon imgicon=new ImageIcon(img); 
	
    public static int WIDTH = 500;
    public static int HEIGHT = 520;

    public static void main(String[] args) 
    {
    	SplashScreen splsh = new SplashScreen(1500);
    	splsh.showSplash();
    	// main jframe
        JFrame frame = new JFrame();
        frame.setBackground(Color.blue);
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
