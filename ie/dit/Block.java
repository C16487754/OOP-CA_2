package gam;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends Rectangle{
	
	private static final long serialVersionUID = 1L;
	public static final int blocksize = 32;

	
	public Block(int x, int y)
	{
		setBounds(x,y, blocksize, blocksize);

	}


	
	
	public void draw(Graphics g)
	{
		
		g.fillRect(x, y, width, height);
		//g.drawImage(bi, x, y, width, height, null);
		 //g.drawImage(bi, x, y, width, height, null);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, blocksize, blocksize);
	}

	
}
