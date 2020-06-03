import java.awt.Image;

// pipe management class
public class Pipes
{

    public int x;
    public int y;
    public int width;
    public int height;
    public int speed = 3;

    public String orientation;

    private Image image;

    // determines orientation of pipes
    public Pipes(String orientation) 
    {
        this.orientation = orientation;
        reset();
    }

   
    public void reset() 
    {
        width = 66;
        height = 400;
        x = Main.WIDTH + 2;

        if (orientation.equals("south"))
            y = -(int)(Math.random() * 120) - height / 2;
    }

    // updates pipes location
    public void update() 
    {
        x -= speed;
    }

    // collision tests
    public boolean collides(int x1, int y1, int width1, int height1) 
    {
        int margin = 2;

        if (x1 + width1 - margin > x && x1 + margin < x + width) 
        {
            if (orientation.equals("south") && y1 < y + height) 
                return true;
            else 
            	if (orientation.equals("north") && y1 + height1 > y) 
            		return true;
        }

        return false;
    }

    // utilizes the renderer class to render the pipes (with orientation)
    public Renderer getRender() 
    {
    	Renderer r = new Renderer();
        r.x = x;
        r.y = y;

        if (image == null) 
            image = Utils.loadImage("lib/pipe-" + orientation + ".png");
        
        r.image = image;

        return r;
    }
}