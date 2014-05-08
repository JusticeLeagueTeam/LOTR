package LOTR; 

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class FogView extends JPanel{
	public void Paint(Graphics g) {
		super.paint(g);
		/**
		 * Fog texture beolvasasa fajlbol
		 */
		BufferedImage img = null;
		try {							
			img = ImageIO.read(new File("fog_sm.png"));
		} catch (IOException e) {
		}
		/**
		 * Kod kirajzolasa
		 */
		g.drawImage(img, 0, 0, null);
	}

}
