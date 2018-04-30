package ie.dit;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Obsticle extends Rectangle{
	
	private static final long serialVersionUID = 1L;
	public static final int blocksize = 30;
	
	public Obsticle(int x, int y)
	{
		setBounds(x,y, blocksize, blocksize);
	}

	
	public void draw(Graphics g, Image spike)
	{
		//g.fillRect(x, y, width, height);
		g.drawImage(spike, x, y, width, height, null);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, blocksize, blocksize);
	}
	
	
}

