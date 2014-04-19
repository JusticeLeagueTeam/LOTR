package LOTR;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Timer {

	private int period;

	public Timer(){

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
		 * Map tick metodus hivasa
		 */
		Map.tick();
		/**
		 * kulonbozo tick paramterekhez kulonbozo kimenet
		 */
		if(Game.isSpecial){
			/**
			 * specialis lovedek
			 */
			if(Game.fileMode){
				try{
					Game.bufferedWriter.write("tick - letelt egy orajel, specialis lovedek aktivalva");
					Game.bufferedWriter.newLine();
				}
				catch(IOException ex) {
					System.out.println("Hibas output fajl.");
				}
			}
			else{
				System.out.println("tick - letelt egy orajel, specialis lovedek aktivalva");
			}
		}
		else if(Game.fogPrint){
			/**
			 * kod szallt a palyara
			 */
			Game.fogPrint=false;
			if(Game.fileMode){
				try{
					Game.bufferedWriter.write("tick - letelt egy orajel, kod aktivalva");
					Game.bufferedWriter.newLine();
				}
				catch(IOException ex) {
					System.out.println("Hibas output fajl.");
				}
			}
			else{
				System.out.println("tick - letelt egy orajel, kod aktivalva");
			}
		}
		else{
			/**
			 * sima tick
			 */
			if(Game.fileMode){
				try{
					Game.bufferedWriter.write("tick - letelt egy orajel");
					Game.bufferedWriter.newLine();
				}
				catch(IOException ex) {
					System.out.println("Hibas output fajl.");
				}
			}
			else{
				if(Game.fileMode){
					try{
						Game.bufferedWriter.write("tick - letelt egy orajel");
						Game.bufferedWriter.newLine();
					}
					catch(IOException ex) {
						System.out.println("Hibas output fajl.");
					}
				}
				else{
					System.out.println("tick - letelt egy orajel");
				}
			}
		}
		/**
		 * Game tick metodus hivasa
		 */
		Game.tick();
	}
}
