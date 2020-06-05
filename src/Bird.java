import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.util.Random;

// class for managing the bird
public class Bird 
{
    public int x;
    public int y;
    public int width;
    public int height;

    public boolean dead;
    Renderer r1 = new Renderer(); 
    
    public double yvel;
    public double gravity;

    private int jumpDelay;
    private double rotation;

    private Image image;
    private Keyboard keyboard;

    public Bird() 
    {
    	Random rand = new Random();
        x = 100;
        y = 150;
        yvel = 0;
        width = 40;
        height = 30;
        gravity = .3;
        jumpDelay = 0;
        rotation = 0.0;
        dead = false;

        keyboard = Keyboard.getInstance();
    }

    // velocity and gravity updates
    public void update() 
    {
        yvel += gravity;

        if (jumpDelay > 0)
            jumpDelay--;

        if (!dead && keyboard.isDown(KeyEvent.VK_SPACE) && jumpDelay <= 0) 
        {
            yvel = -10;
            jumpDelay = 10;
        }

        y += (int)yvel;
    }

    // utilizes the renderer class to render the bird
    public Renderer getRender() 
    {
    	Renderer r = new Renderer();
        r.x = x;
        r.y = y;

        if (image == null)
            image = Utils.loadImage("lib/bird.png");
        r.image = image;

        rotation = (90 * (yvel + 20) / 20) - 90;
        rotation = rotation * Math.PI / 180;

        if (rotation > Math.PI / 2)
            rotation = Math.PI / 2;

        r.transform = new AffineTransform();
        r.transform.translate(x + width / 2, y + height / 2);
        r.transform.rotate(rotation);
        r.transform.translate(-width / 2, -height / 2);
        r1 = r;
        return r1;
    }
    public Rectangle bird_collision(int x1, int y1, int width1, int height1) 
    { 
    	Bird b = new Bird(); 
    	return (new Rectangle(b.x, b.y, b.width, b.height));
    } 
}