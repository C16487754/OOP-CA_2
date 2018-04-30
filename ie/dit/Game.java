package ie.dit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {


	public static int GameWidth = 800;
	 public static int GameHeight = 600;
	 
	 Player player = new Player(this,30,50);
	 
	 static Block[] screen1;
	 static Obsticle[] screen1_obst;
	 static Enemy[] screen1_enemy;
	 static Block[] screen2;
	 static Obsticle[] screen2_obst;
	 static Enemy[] screen2_enemy;
	 static public int level = 1;
	
	 

	public static void init()
	{
		//level 1
		if(level == 1) {
		screen1 = new Block[31];
		screen1[0] = new Block(0,GameHeight-60);
		screen1[1] = new Block(32,400);
		screen1[2] = new Block(64,350);
		screen1[3] = new Block(96,350);
		screen1[4] = new Block(128,350);
		screen1[5] = new Block(160,350);
		screen1[6] = new Block(192,350);
		screen1[7] = new Block(224,350);
		screen1[8] = new Block(256,350);
		screen1[9] = new Block(288,350);
		screen1[10] = new Block(320,350);
		
		screen1[11] = new Block(384,400);
		screen1[12] = new Block(384,400);
		screen1[13] = new Block(416,400);
		screen1[14] = new Block(448,400);
		screen1[15] = new Block(480,400);
		screen1[16] = new Block(512,400);
		screen1[17] = new Block(544,400);
		screen1[18] = new Block(576,400);
		screen1[19] = new Block(608,400);
		screen1[20] = new Block(640,400);
		screen1[21] = new Block(672,400);
		screen1[22] = new Block(704,400);
		screen1[23] = new Block(736,400);
		screen1[24] = new Block(768,400);
		screen1[25] = new Block(0,400);
		screen1[26] = new Block(96,200);
		screen1[27] = new Block(0,368);
		screen1[28] = new Block(0,336);
		screen1[29] = new Block(0,304);
		screen1[30] = new Block(0,272);

		
		screen1_obst = new Obsticle[2];
		screen1_obst[0] = new Obsticle(160, 325);
		screen1_obst[1] = new Obsticle(480,375);
		
		screen1_enemy = new Enemy[1];
		screen1_enemy[0] = new Enemy(96, 320);
		}

		//level 2
		if(level == 2) {
		screen2 = new Block[28];
		screen2[0] = new Block(0,GameHeight-60);
		screen2[1] = new Block(300,200);
		
		screen2[2] = new Block(64,350);
		screen2[3] = new Block(96,350);
		screen2[4] = new Block(128,350);
		screen2[5] = new Block(160,350);
		screen2[6] = new Block(192,350);
		screen2[7] = new Block(224,350);
		screen2[8] = new Block(256,350);
		screen2[9] = new Block(288,350);
		screen2[10] = new Block(320,350);
		screen2[11] = new Block(352,400);
		screen2[12] = new Block(384,400);
		screen2[13] = new Block(384,400);
		screen2[14] = new Block(416,400);
		screen2[15] = new Block(448,400);
		screen2[16] = new Block(480,400);
		screen2[17] = new Block(512,400);
		screen2[18] = new Block(544,400);
		screen2[19] = new Block(576,400);
		screen2[20] = new Block(608,400);
		screen2[21] = new Block(640,400);
		screen2[22] = new Block(672,400);
		screen2[23] = new Block(704,400);
		screen2[24] = new Block(736,400);
		screen2[25] = new Block(768,400);
		screen2[26] = new Block(0,400);
		screen2[27] = new Block(96,250);
		}
			
	}
	
	
	private void move()
	{
		
		gam.Enemy.move();
		if(level==1) {
		Player.move(screen1, screen1_obst, screen1_enemy);
		}
		if(level==2)
		{
		Player.move(screen2, screen2_obst, screen2_enemy);
		}

	}
	

	public Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				Player.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				Player.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	
	public void paint(Graphics g) {
		
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(new Color(204,255,255));
		g2d.fillRect(0,0,getWidth(), getHeight());
		g2d.setColor(Color.GREEN);
		Enemy.paint(g2d);
		Player.paint(g2d);

		
		g2d.setColor(Color.ORANGE);
		if(level==1) {
		for(int i = 0; i<screen1.length; i++)
		{
		screen1[i].draw(g);
		}
		
		g2d.setColor(Color.RED);
		for(int i = 0; i<screen1_obst.length; i++)
		{
		screen1_obst[i].draw(g);
		}
		}
	
		if(level==2) {
		for(int i = 0; i<screen2.length; i++)
		{
		screen2[i].draw(g);
		}
		}
		/*
		for(int i = 0; i<screen2_obst.length; i++)
		{
		screen2_obst[i].draw(g);
		}*/
		
	}
	
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		Player.x= 0;
		Player.Y = 200;
		Player.moveRight = false;
		Player.moveLeft = false;	
	}
	
	public void levelComplete()
	{
		System.out.println("level complete");
		//JOptionPane.showMessageDialog( this, "Level Complete!");
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
			game.move();
			game.repaint();
			Thread.sleep(10);
		}	
	}
}