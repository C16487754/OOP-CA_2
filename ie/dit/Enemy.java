package ie.dit;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Enemy extends Rectangle{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static boolean flip = true;
	 static int x = 96;
	 static int y = 320;
	 static int move = 1;
	 public static int Width = 800;
	 public static int Height = 600;
	 
	public Enemy(int x, int y)
	{
		Enemy.x = x;
		Enemy.y = y;

	}
	
	public static void move()
	{
		x = x + move;
		if(x == 96 || x == 320)
		{
			if(flip)
			{
				move = -1;
			}
			else
			{
				move = 1;
			}
			flip = !flip;
		}
		
	}
	
	public static void paint(Graphics2D g)
	{
		g.fillRect(x, y, 30, 30);
	}
}


