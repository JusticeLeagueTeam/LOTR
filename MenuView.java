package LOTR;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MenuView extends JPanel{
	
	public void Paint(Graphics g) {
		super.paint(g);

		BufferedImage img0 = null;
		BufferedImage img1 = null;
		BufferedImage img2 = null;
		BufferedImage img3 = null;
		BufferedImage img4 = null;
		BufferedImage img5 = null;
		BufferedImage img6 = null;
		/**
		 * TODO: logo balra, cuccok cost-ja cuccikon ala, varazsero jobb oldalt, maradek enemy jobboldalt,
		 * szebb hatter menu mogott, meretek igazitasa
		 */
		
        try {
        	img0 = ImageIO.read(new File("bigtower_sm.png"));
        	img1 = ImageIO.read(new File("smalltower_sm.png"));
        	img2 = ImageIO.read(new File("swamp_sm.png"));
        	img3 = ImageIO.read(new File("shiftingsand_sm.png"));
        	img4 = ImageIO.read(new File("firingspeedincreasestone_sm.png"));
       		img5 = ImageIO.read(new File("firingrangeincreasestone_sm.png"));
       		img6 = ImageIO.read(new File("elfdwarfspecializedstone_sm.png"));
        } catch (IOException e) {
        }
        /**
         * menu elemeket sorban rajzolja
         */
		g.drawImage(img0, 250 + 32*0, 0, null);
		g.drawImage(img1, 250 + 32*1, 0, null);
		g.drawImage(img2, 250 + 32*2, 0, null);
		g.drawImage(img3, 250 + 32*3, 0, null);
		g.drawImage(img4, 250 + 32*4, 0, null);
		g.drawImage(img5, 250 + 32*5, 0, null);
		g.drawImage(img6, 250 + 32*6, 0, null);
	}
}
