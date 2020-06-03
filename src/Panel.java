import javax.swing.*;
import java.awt.*;

// Panel class
public class Panel extends JPanel implements Runnable 
{


	private static final long serialVersionUID = 1L;
	private Game game;

    public Panel() 
    {
        game = new Game();
        new Thread(this).start();
    }

    public void update() 
    {
        game.update();
        repaint();
    }

    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        g2D.setBackground(Color.black);
        for (Renderer r : game.getRenders())
            if (r.transform != null)
            {
            	g2D.setColor(Color.blue);
                g2D.drawImage(r.image, r.transform, null);
            }
            else
            { 
            	g2D.setColor(Color.blue);
                g.drawImage(r.image, r.x, r.y, null);
            }
           


        g2D.setColor(Color.BLACK);

        // logic for drawing instructions onscreen
        if (!game.started) 
        {
        	
        	g2D.setColor(Color.blue);
            g2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g2D.drawString("SPACE to Start", 175, 100);
        } 
        else 
        {
            g2D.setFont(new Font("TimesRoman", Font.ITALIC, 24));
            g2D.drawString(Integer.toString(game.score), 10, 465);
        }

        if (game.gameover) 
        {
            g2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g2D.drawString("R to Restart", 175, 100);
            g2D.drawString("Your score is " + Integer.toString(game.score), 175, 120);
        }
    }

    // update thread
    public void run() 
    {
        try 
        {
            while (true) 
            {
                update();
                Thread.sleep(25);
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}