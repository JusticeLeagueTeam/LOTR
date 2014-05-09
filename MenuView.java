package LOTR; 

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 * Menu megjeleniteseert felelos osztaly
 * @author justice_league
 *
 */
public class MenuView extends JPanel{
	/**
	 * megjelenitest vegzo metodus
	 * @param g
	 */
	public void Paint(Graphics g) {
		super.paint(g);
		/**
		 * ezekbe a valtozokba tolti a menuhoz szukeges ikonokat, logot, stb.-t
		 */
		BufferedImage img_logo = null;
		BufferedImage varazsero = null;
		BufferedImage ellenfelek = null;
		/**
		 * ikonok
		 */
		BufferedImage img0 = null;
		BufferedImage img1 = null;
		BufferedImage img2 = null;
		BufferedImage img3 = null;
		BufferedImage img4 = null;
		BufferedImage img5 = null;
		BufferedImage img6 = null;
		
		/**
		 * betolti a png fajlokat
		 */
        try {
        	//logo
        	img_logo = ImageIO.read(new File("logo.png"));
        	//tornyok es akadalyok
        	img0 = ImageIO.read(new File("bigtower_sm.png"));
        	img1 = ImageIO.read(new File("smalltower_sm.png"));
        	img2 = ImageIO.read(new File("swamp_sm.png"));
        	img3 = ImageIO.read(new File("shiftingsand_sm.png"));
        	//varazskovek
        	img4 = ImageIO.read(new File("firingspeedincreasestone_sm.png"));
       		img5 = ImageIO.read(new File("firingrangeincreasestone_sm.png"));
       		img6 = ImageIO.read(new File("elfdwarfspecializedstone_sm.png"));
       		//tovabbi ellenfelek es varazsero
       		ellenfelek = ImageIO.read(new File("tovabbi_ellenfelek.png"));
       		varazsero = ImageIO.read(new File("varazsero.png"));
        } catch (IOException e) {
        }
        /**
         * menu elemeket sorban rajzolja
         */
        g.drawImage(img_logo, 0, 0, null);
		g.drawImage(img0, 250 + 32*0, 0, null);
		g.drawImage(img1, 250 + 32*1, 0, null);
		g.drawImage(img2, 250 + 32*2, 0, null);
		g.drawImage(img3, 250 + 32*3, 0, null);
		g.drawImage(img4, 250 + 32*4, 0, null);
		g.drawImage(img5, 250 + 32*5, 0, null);
		g.drawImage(img6, 250 + 32*6, 0, null);
		g.drawImage(varazsero, 376 + 32*8, 20, null);
		g.drawImage(ellenfelek, 350 + 32*7, 0, null);
		
        /**
         * menu elemek koltsegenek kiirasa
         */
		g.drawString("600", 253 + 32*0, 45);
		g.drawString("400", 253 + 32*1, 45);
		g.drawString("150", 253 + 32*2, 45);
		g.drawString("200", 253 + 32*3, 45);
		g.drawString("50", 256 + 32*4, 45);
		g.drawString("50", 256 + 32*5, 45);
		g.drawString("100", 253 + 32*6, 45);
		/**
		 * tovabbi ellenfelek szama
		 * jatekos varazsereje
		 */
		g.drawString(Integer.toString(Map.player.getMagicPower()) , 370 + 32*11, 40);
		g.drawString(Integer.toString(Map.totalNumberOfEnemies-Map.numberOfCreatedEnemies) , 370 + 32*11, 20);
	}
}
