package LOTR; 

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class StoneView extends JPanel{
	/**
	 * stone objektum
	 */
	private MagicStone m;
	/**
	 * konstruktor
	 */
	public StoneView(MagicStone magicstone){
		/**
		 * referencia szerint adodik at
		 */
		m=magicstone;
	}
	
	/**
	 * magicstone objektum kirajzolasa
	 * @param g
	 */
	public void Paint(Graphics g) {
		super.paint(g);
		/**
		 * fajlbol olvassa be a magicstone kepet
		 */
        BufferedImage img = null;
        try {
        	if(m instanceof FiringSpeedIncreaseStone)
        		img = ImageIO.read(new File("firingspeedincreasestone_sm.png"));
        	if(m instanceof RangeExtenderStone)
        		img = ImageIO.read(new File("firingrangeincreasestone_sm.png"));
        	if(m instanceof ElfDwarfSpecializedStone)
        		img = ImageIO.read(new File("elfdwarfspecializedstone_sm.png"));
        } catch (IOException e) {
        }
        /**
         * megfelelo cellaba rajzolja
         */
		g.drawImage(img,m.position.getColumnValue() * 33, m.position.getRowValue() * 33+60,15,15, null);
	}

}
