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
    	Renderer r = new Renderer();
        super.paintComponent(g);
        JPanel imagepanel = new JPanel();
        JLabel picLabel = new JLabel(new ImageIcon("lib/bird.png"));
        imagepanel.add(picLabel);
        picLabel.setLocation(r.x, r.y);
        imagepanel.setBackground(Color.black);
        for (Renderer r1 : game.getRenders())
  if (r1.transform != null)
          {
           	imagepanel.add(picLabel);
           	imagepanel.setBackground(Color.blue);
            	g.drawImage(r1.image, r1.x, r1.y, null);
           }
         else
         { 
         	imagepanel.setBackground(Color.BLACK);
                g.drawImage(r1.image, r1.x, r1.y, null);
            }
        if (game.started == false) 
        {
   
        	imagepanel.setBackground(Color.blue);
            imagepanel.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
            
          //  imagepanel.drawString("SPACE to Start", 175, 100);
        } 
        else 
        {
            imagepanel.setFont(new Font("TimesRoman", Font.ITALIC, 24));
          //  imagepanel.drawString(Integer.toString(game.score), 10, 465);
        }

        if (game.gameover) 
        {
            imagepanel.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        //    g2D.drawString("R to Restart", 175, 100);
        //    g2D.drawString("Your score is " + Integer.toString(game.score), 175, 120);
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