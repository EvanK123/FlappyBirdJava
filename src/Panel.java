import javax.swing.*;
import java.awt.*;

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
	
	protected void paintComponent(Graphics graphic)
	{
		super.paintComponent(graphic);
		
		Graphics2D g2D = (Graphics2D) graphic;
		for(Renderer r : game.getRenders())
			if(r.transform != null)
				g2D.drawImage(r.image,  r.transform, null);
			else
				graphic.drawImage(r.image, r.x, r.y, null);
		
		g2D.setColor(Color.BLUE);
		
		if(!game.started)
		{
			g2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			g2D.drawString("Space to Start",  150,  240);
		}
		else
		{
			g2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			g2D.drawString(Integer.toString(game.score), 10, 465);
		}
		
		if(game.gameover)
		{
			g2D.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			g2D.drawString("R to Restart", 150, 240);
		}
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				update();
				Thread.sleep(25);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
