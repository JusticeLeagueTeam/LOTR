package LOTR;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class MyTimer {
	
	private int period;
	Timer timer;

	public MyTimer(){
		timer=new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
				 // if(Game.gameStatus == 1)
					  MyTimer.tick();
			  }
			}, 1000, 1000);
	}
	/**
	 * Elinditja az idozitot
	 * Csak a GUI-s megodasban lesz implementalva
	 */
	public void run() {
	}

	/** Beallitja a periodusidot */
	public void setPeriod(int intParameter) {
		this.period = intParameter;
	}

	/** Az orajelert felelos metodus, minden periodus letelte utan meghivodik 
	 * Meghivja a Map es a Game tick metodusat
	 */
	public static void tick() {
		/**
		 * GUI ujrarajzolasa
		 */
		Map.frame.repaint();
		/**
		 * Map tick metodus hivasa
		 */
		Map.tick();
		/**
		 * Game tick metodus hivasa
		 */
		Game.tick();
		/**
		 * ellenfelek gyartasa
		 */
		Map.createEnemy();
		
	}
}
