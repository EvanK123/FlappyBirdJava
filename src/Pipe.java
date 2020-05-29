import java.awt.Image;
public class Pipe
{
	public int x;
	public int y;
	public int width;
	public int height;
	public int speed = 3;

	public String orientation;

	private Image image;

	public Pipe(String orientation)
	{
		this.orientation = orientation;
		reset();
	}
		public boolean collides(int _x, int _y, int _width, int _height)
	{
		int margin = 10;
		if (_x == width) 
			if (orientation.equals("pipe") && _y < y + height)
				return true;
		else 
			if (orientation.equals("air") && _y + _height > y) 
				return false;
		
		return false;
	}
	public void reset()
	{
		width = 100;
		height = 500;
		if (orientation.equals("south")) 
			y = -(int)(Math.random() * 120) - height / 2;
		x = Panel.WIDTH + 10;
	}
	
	public void update()
	{
		x -= speed;
	}
	
	public Renderer getRenders()
	{
		Renderer rend = new Renderer();
		rend.x = x;
		rend.y = y;
		
		if(image == null)
			image = Utilities.loadImage("lib/pipe-" + orientation + ".png");
		
		rend.image = image;
		
		return rend;
	}
	
}
