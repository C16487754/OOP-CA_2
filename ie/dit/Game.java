package ie.dit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Game extends JPanel {


	public static int GameWidth = 800;
	 public static int GameHeight = 600;
	 
	 static Block[] screen1;

	public static void init()
	{

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
		g2d.setColor(Color.ORANGE);



		for(int i = 0; i<screen1.length; i++)
		{
		screen1[i].draw(g);
		}
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