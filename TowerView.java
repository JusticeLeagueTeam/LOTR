package LOTR;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TowerView extends JPanel{
	/**
	 * tower objektum
	 */
	private Tower t;
	/**
	 * konstruktor
	 */
	public TowerView(Tower tower){
		/**
		 * referencia szerint adodik at, igy a kovektol esetleg valtozo parameter is mindig frissul
		 */
		t=tower;
	}
	
	/**
	 * tower objektum kirajzolasa
	 * @param g
	 */
	public void Paint(Graphics g) {
		super.paint(g);
		/**
		 * fajlbol olvassa be a tower kepet
		 */
        BufferedImage img = null;
        try {
        	if(t instanceof BigTower)
        		img = ImageIO.read(new File("bigtower_sm.png"));
        	if(t instanceof SmallTower)
        		img = ImageIO.read(new File("smalltower_sm.png"));
        	if(Game.isSpecial == true)
        		img = ImageIO.read(new File("special_attack_sm.png"));
        } catch (IOException e) {
        }
        /**
         * megfelelo cellaba rajzolja
         */
		g.drawImage(img, t.position.getColumnValue() * 33, t.position.getRowValue() * 33+60, null);
	}

}
