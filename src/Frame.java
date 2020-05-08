import javax.swing.*;

public class Frame extends JFrame
{
	public static int WIDTH = 500;
	public static int HEIGHT = 520;
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Keyboard keyboard = Keyboard.getInstance();
		frame.addKeyListener(keyboard);
		
		Panel gpanel = new Panel();
		frame.add(gpanel);
		frame.setResizable(false);
		frame.setSize(WIDTH, HEIGHT);
	}
}
