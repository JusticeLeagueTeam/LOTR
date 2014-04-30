package LOTR;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BarrierView extends JPanel{
	/**
	 * barrier objektum
	 */
	private Barrier b;
	/**
	 * konstruktor
	 */
	public BarrierView(Barrier barrier){
		/**
		 * referencia szerint adodik at, igy a kovektol esetleg valtozo parameter is mindig frissul
		 */
		b=barrier;
	}
	
	/**
	 * barrier objektum kirajzolasa
	 * @param g
	 */
	public void Paint(Graphics g) {
		super.paint(g);
		/**
		 * fajlbol olvassa be a barrier kepet
		 */
        BufferedImage img = null;
        try {
        	if(b instanceof Swamp)
        		img = ImageIO.read(new File("swamp_sm.png"));
        	if(b instanceof ShiftingSand)
        		img = ImageIO.read(new File("shiftingsand_sm.png"));
        } catch (IOException e) {
        }
        /**
         * megfelelo cellaba rajzolja
         */
		g.drawImage(img, b.position.getColumnValue() * 33, b.position.getRowValue() * 33+60, null);
	}
}
