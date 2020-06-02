import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
// renderer class
public class Renderer
{
    public int x;
    public int y;
    public Image image;
    public AffineTransform transform;

    public Renderer() 
    {    	
    }
// what other classes utilize
    public Renderer(int x, int y, String imagePath) 
    {
        Toolkit.getDefaultToolkit().sync();
        this.x = x;
        this.y = y;
        this.image = Utils.loadImage(imagePath);
    }
}