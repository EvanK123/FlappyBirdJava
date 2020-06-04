import java.awt.Image;
import java.awt.Rectangle;
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
    public Rectangle collison(int x1, int y1, int width1, int height1) 
    {
    	return (new Rectangle (x, y, width, height));
    } 
    public Rectangle bird_collision(int x1, int y1, int width1, int height1) 
    { 
    	Bird b = new Bird(); 
    	return (new Rectangle(b.x, b.y, b.width, b.height));
    } 
    public boolean collide_test(Pipes p) 
    { 
    	Bird b = new Bird();
    	Rectangle bird = b.bird_collision(b.x, b.y, b.width, b.height);
    	Rectangle pipe = collison(p.x, p.y, p.width, p.height); 
    	if (bird.intersects(pipe) || pipe.intersects(bird)) 
    		return true; 
    	else 
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