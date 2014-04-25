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
	public static int cnt = 0;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		/**
		 * Map texture beolvasasa fajlbol
		 */
		BufferedImage img = null;
		try {							
			img = ImageIO.read(new File("map_v02_balazs_sm.jpg"));
		} catch (IOException e) {
		}
		//Terkep kirajzolasa
		g.drawImage(img, 0, 0, null);
		
		/**
		 * enemy-k megjelenitese
		 */
		
		//teszt enemy kirajzolashoz
		Enemy e = new Enemy();
		Position p = new Position();
		p.setColumnValue(3);
		p.setRowValue(2);
		e.setPosition(p);
		EnemyView evteszt=new EnemyView(e);
		enemyviews.add(evteszt);
		
		//enemy megjelenitese
		for(EnemyView ev : enemyviews){
			ev.Paint(g);	
		}
				
		System.out.println("\n" + cnt + "\n");
		cnt++;
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
