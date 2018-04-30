package gam;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;



public class Player {

	 public static int GameWidth = 800;
	 public static int GameHeight = 600;
	static int Y = 200;
	public static int jumpHeight = 100;
	static int x = 0;

	private static Game game;
	
	private static double jumpspeed = 5;
	private static double currentjumpspeed = jumpspeed;
	
	private static double maxfallspeed = 5;
	private static double currentfallspeed = .1;
	private static int width;
	private static int height;
	

	public Player(Game game, int width, int height) {
		Player.game = game;
		Player.width = width;
		Player.height = height;
		
	}


	public static void move(Block[] b, Obsticle[] o, Enemy[] e) {
		
		
		System.out.println(currentjumpspeed);
		if (x + Player.width >= GameWidth)
		{
			x = GameWidth - Player.width;
			System.out.println("level complete");
			JOptionPane.showMessageDialog( game, "Level Complete!", "Level Complete!", JOptionPane.YES_NO_OPTION);
			x= 0;
			Y = 200;
			moveRight = false;
			moveLeft = false;	
			Game.level++;
			
		}

		if(moveRight)
		{
			x+=4;
		}
		
		if(moveLeft){
			x-=4;
		}
		
		
		if (jumping)
		{
			Y -= currentjumpspeed;
			currentjumpspeed -=.1;
			if(currentjumpspeed<=0)
			{
				currentjumpspeed = jumpspeed;
				jumping = false;
				falling =true;
			}
		}
		
		if (falling)
			{
				Y += currentfallspeed;
				if(currentfallspeed <maxfallspeed) 
				{
					currentfallspeed +=.1;	
				}		
			}
			
		if(!falling)
		{
			currentfallspeed = .1;
		}
		
		
			
			
			if (Y >= GameHeight - height)
			{
				game.gameOver();
			}
			
			
			falling = true;
			
			if(Game.level==1) {
			collision(b);	
			collision_obst(o);
			collision_enemy(e);
			}
			
			if(Game.level==2) {
			collision2(b);
			}
			
			
	}

	public static void paint(Graphics2D g) {
		g.fillRect(x, Y, width, height);
	
	}
	
	public static Rectangle getBounds() {
		return new Rectangle(x+((width/2)-(width/4)), Y+(height/2), width/2, height/2);
	}
	public static Rectangle getBoundsTop() {
		return new Rectangle(x+((width/2)-(width/4)), Y, width/2, height/2);
	}
	public static Rectangle getBoundsRight() {
		return new Rectangle(x+(width-5), Y+5, 5, height-10);
	}
	public static Rectangle getBoundsLeft() {
		return new Rectangle(x, Y+5, 5, height-10);
	}
	
	

	
	private static void collision(Block[] screen1) {
		for(int i = 0; i< screen1.length; i++)
		{
			if ((getBounds().intersects(Game.screen1[i].getBounds())))
			{
				falling = false;
				jumping = false;
				currentjumpspeed = jumpspeed;
				
			}
			
			if (getBoundsTop().intersects(Game.screen1[i].getBounds()))
			{
				Y = Game.screen1[i].y + 32;
				currentfallspeed = maxfallspeed;
				
				
			}
			
			if (getBoundsRight().intersects(Game.screen1[i].getBounds()))
			{
				x = Game.screen1[i].x - width;
				
			}
			
			if (getBoundsLeft().intersects(Game.screen1[i].getBounds()))
			{
				x = Game.screen1[i].x + width;
				
			}
		}
	}
	
	private static void collision2(Block[] screen2) {
		for(int i = 0; i< screen2.length; i++)
		{
			if ((getBounds().intersects(Game.screen2[i].getBounds())))
			{
				falling = false;
				jumping = false;
				
			}
			
			if (getBoundsTop().intersects(Game.screen2[i].getBounds()))
			{
				Y = Game.screen2[i].y + 32;
				
			}
			
			if (getBoundsRight().intersects(Game.screen2[i].getBounds()))
			{
				x = Game.screen2[i].x - width;
				
			}
			
			if (getBoundsLeft().intersects(Game.screen2[i].getBounds()))
			{
				x = Game.screen2[i].x + width;
				
			}
		}
	}
	
	private static void collision_obst(Obsticle[] screen1_obst) {
		for(int i = 0; i< screen1_obst.length; i++)
		{
			if ((getBounds().intersects(Game.screen1_obst[i].getBounds())))
			{
				falling = false;
				jumping = false;
				gameOver();
			}
		
			
			if (getBoundsRight().intersects(Game.screen1_obst[i].getBounds()))
			{
				x = Game.screen1_obst[i].x - width;
				gameOver();
				
			}
			
			if (getBoundsLeft().intersects(Game.screen1_obst[i].getBounds()))
			{
				x = Game.screen1_obst[i].x + width;
				gameOver();
			}
			
		}
	}

	
	private static void collision_enemy(Enemy[] screen1_enemy) {
		for(int i = 0; i< screen1_enemy.length; i++)
		{
			if (Game.screen1_enemy[i].intersects(getBoundsLeft()))
			{
				System.out.println("hit by enemy");
				
			}
			
			if (Game.screen1_enemy[i].intersects(getBounds()))
			{
				gameOver();
				
			}
			
			if (Game.screen1_enemy[i].intersects(getBoundsRight()))
			{
				gameOver();
				
			}
			
		}
	}
	public static void gameOver() {
		System.out.println("game over");
		JOptionPane.showMessageDialog( game, "Game Over!");
		x= 0;
		Y = 200;
		moveRight = false;
		moveLeft = false;
	}

	public static void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			moveLeft = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
		moveRight = false;
		}
	}
	static boolean moveRight = false;
	static boolean moveLeft = false;
	static boolean jumping = false;
	static boolean falling = true;
	static boolean lock = true;

	public static void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			moveLeft = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			moveRight = true;
			
		}
		if (e.getKeyCode() == KeyEvent.VK_UP && !jumping && !falling )
		{
				jumping = true;
				System.out.println(jumping);

				
	
		}
				
	}

}

