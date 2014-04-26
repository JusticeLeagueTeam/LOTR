package LOTR;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MapView extends JPanel{
	public void Paint(Graphics g) {
		super.paint(g);
		/**
		 * Map texture beolvasasa fajlbol
		 */
		BufferedImage img = null;
		try {							
			img = ImageIO.read(new File("map_v04_balazs_smg"));
		} catch (IOException e) {
		}
		/**
		 * Terkep kirajzolasa
		 */
		g.drawImage(img, 0, 0, null);
	}

}
