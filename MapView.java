package LOTR; 

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 * Palya megjeleniteseert felelos osztaly
 * @author justice_league
 *
 */
public class MapView extends JPanel{
	/**
	 * rajzolast vegzo metodus
	 * @param g
	 */
	public void Paint(Graphics g) {
		super.paint(g);
		/**
		 * Map texture beolvasasa fajlbol
		 */
		BufferedImage img = null;
		try {							
			img = ImageIO.read(new File("map_v04_balazs_sm2.png"));
		} catch (IOException e) {
		}
		/**
		 * Terkep kirajzolasa
		 */
		g.drawImage(img, 0, 0, null);
	}

}
