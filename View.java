package LOTR;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class View extends JPanel{
	public static LinkedList<EnemyView> enemyviews;
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		/**
		 * Map texture beolvasasa fajlbol
		 */
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("map_v2_balazs.jpg"));
		} catch (IOException e) {
		}
		g.drawImage(img, 0, 0, null);
		
		/**
		 * enemy-k megjelenitese
		 */
		for(EnemyView ev : enemyviews){
			ev.Paint(g);					
		}
		/**
		 * egy teszt enemy
		 */
		//EnemyView evteszt=new EnemyView(new Enemy());
		//evteszt.Paint(g);
		/**
		 * megegy teszt enemy
		 */
		//enemyviews.add(new EnemyView(new Enemy()));
		//EnemyView evteszt2=enemyviews.get(0);
		//evteszt2.Paint(g);
		
	}
	/**
	 * frissites
	 */
	public void update(Graphics g){
		paintComponent(g);
	}
	/**
	 * konstruktor
	 */
	public View(){
		enemyviews=new LinkedList<EnemyView>();
	}
}
