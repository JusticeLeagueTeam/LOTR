package LOTR; 

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class EnemyView extends JPanel{
	/**
	 * enemy objektum
	 */
	private Enemy e;
	/**
	 * konstruktor
	 */
	public EnemyView(Enemy enemy){
		/**
		 * hala a jo egnek referencia szerint adodik at, igy a position is mindig frissul
		 */
		e=enemy;
	}
	
	/**
	 * enemy objektum kirajzolasa
	 * @param g
	 */
	public void Paint(Graphics g) {
		super.paint(g);
		/**
		 * fajlbol olvassa be a karater kepet
		 */
        BufferedImage img = null;
        try {
        	if(e instanceof Elf)
        		img = ImageIO.read(new File("elf_legolas_sm.png"));
        	if(e instanceof Dwarf)
        		img = ImageIO.read(new File("dwarf_gimli_sm.png"));
        	if(e instanceof Human)
        		img = ImageIO.read(new File("human_aragorn_sm.png"));
        	if(e instanceof Hobbit)
        		img = ImageIO.read(new File("hobbit_frodo_sm.png"));
        } catch (IOException e) {
        }
        /**
         * megfelelo cellaba rajzolja
         */
		g.drawImage(img, e.position.getColumnValue() * 33, e.position.getRowValue() * 33 +64, null);
	}
}
