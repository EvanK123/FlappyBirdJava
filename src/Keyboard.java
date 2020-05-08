import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener
{
	private static Keyboard instance;
	private boolean[] keys;
	
	private Keyboard()
	{
		keys = new boolean[256];
	}
	
	public static Keyboard getInstance()
	{
		if(instance == null)
			instance = new Keyboard();
		
		return instance;
	}
	
	public void keyPressed(KeyEvent keyevent)
	{
		if(keyevent.getKeyCode() >= 0 && keyevent.getKeyCode() < keys.length)
			keys[keyevent.getKeyCode()] = true;
	}
	
	public void keyReleased(KeyEvent keyevent)
	{
		if(keyevent.getKeyCode() >= 0 && keyevent.getKeyCode() < keys.length)
			keys[keyevent.getKeyCode()] = false;
	}
	
	//required else the compiler will scream at you for having so many errors
	public void keyTyped(KeyEvent keyevent)
	{
	}
	
	public boolean isDown(int key)
	{
		if(key >= 0 && key < keys.length)
			return keys[key];
		
		return false;
	}
}
