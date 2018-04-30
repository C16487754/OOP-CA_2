package ie.dit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.Block;
import game.Enemy;
import game.Obsticle;

@SuppressWarnings("serial")
public class Game extends JPanel {


	public static int GameWidth = 800;
	 public static int GameHeight = 600;
	 
	 static Block[] screen1;
	 static Obsticle[] screen1_obst;
	 static Enemy[] screen1_enemy;

	public static void init()
	{

			
	}
	
	public Game() {

	}
	
	public void paint(Graphics g) {
		
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(new Color(204,255,255));
		g2d.fillRect(0,0,getWidth(), getHeight());
	
	}

	public static void main(String[] args) throws InterruptedException , IOException{
		JFrame frame = new JFrame("A simple platformer");
		Game game = new Game();
		frame.add(game);
		frame.setSize(GameWidth, GameHeight);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		init();
		

		while(true)
		{
			game.repaint();
			Thread.sleep(10);
		}	
	}
}