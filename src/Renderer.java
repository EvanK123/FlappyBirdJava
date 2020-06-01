import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;

public class Renderer
{
    public int x;
    public int y;
    public Image image;
    public AffineTransform transform;

    public Renderer() 
    {    	
    }

    public Renderer(int x, int y, String imagePath) 
    {
        Toolkit.getDefaultToolkit().sync();
        this.x = x;
        this.y = y;
        this.image = Utils.loadImage(imagePath);
    }
}