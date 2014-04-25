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
            img = ImageIO.read(new File("elf_legolas.jpg"));
        } catch (IOException e) {
        }
        /**
         * megfelelo cellaba rajzolja
         */
		g.drawImage(img, e.position.getColumnValue() * 32, e.position.getRowValue() * 32, null);
	}
}
