package ie.dit;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Obsticle extends Rectangle{
	
	private static final long serialVersionUID = 1L;
	public static final int blocksize = 32;
	
	public Obsticle(int x, int y)
	{
		setBounds(x,y, blocksize, blocksize);
	}

	
	public void draw(Graphics g)
	{
		g.fillRect(x, y, width, height);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, blocksize, blocksize);
	}
	
	
}

