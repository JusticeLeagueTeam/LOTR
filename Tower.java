package LOTR;

import java.util.Observable;


/**
 * Tower osztaly a DefenseTools osztaly leszarmazottja.
 * Toronynak felel meg. A jatekos rakja le oket ha van eleg varazsereje
 * Az ellenfeleket az Observer mintan keresztul figyeli.
 * Ha egy ellenfel a hatotavolsagaba er akkor tuzel
 * Varazskovekkel javithatok a konstruktorban beallitott valtozoi
 * 
 * @author justice_league
 *
 */
public class Tower extends DefenseTools {
	/**
	 *  tuzelesi gyakorisag 
	 */
	protected int firingSpeed;
	/**
	 *  tuzelesi hatotav 
	 */
	protected int firingRange;
	/**
	 *  tuzero
	 */
	protected int firingPower;
	/**
	 *  flag az olyan varazskoveknek ami csak elfekre vagy torpekre hat 
	 */
	protected boolean elfOrDwarfFlag;
	/**
	 *  jatek kezdete ota eltelt orajelek szama
	 */
	protected int tick_counter;
	/**
	 * Tower konstruktor
	 */
	public Tower(){

	}
	/**
	 * visszaadja a tamadas sebesseget
	 */
	public int getFiringSpeed() {
		return firingSpeed;
	}
	/**
	 * beallitja a tamadas sebesseget
	 */
	public void setFiringSpeed(int fs) {
		firingSpeed = fs;
	}
	/**
	 * visszaadja a hatotavot
	 */
	public int getFiringRange() {
		return firingRange;
	}
	/**
	 * beallitja a hatotavot
	 */
	public void setFiringRange(int fr) {
		firingRange = fr;
	}
	/**
	 * visszaadja a tuzerot
	 */
	public int getFiringPower() {
		return firingPower;
	}
	/**
	 * beallitja a tuzerot
	 */
	public void setFiringPower(int fp) {
		firingPower = fp;
	}
	/**
	 *visszaadja a flag-et 
	 */
	public boolean getElfOrDwarfFlag() {
		return elfOrDwarfFlag;
	}
	/**
	 * beallitja a flag-et
	 */
	public void setElfOrDwarfFlag(boolean eodf) {
		elfOrDwarfFlag = eodf;
	}
	/**
	 * ellenorzi, hogy van-e ellenseg a hatokoreben
	 */
	public void update(Observable observable) {
	//TODO	
	}
	/**
	 * noveli a tick_counter-t eggyel
	 */
	public void tick() {
		tick_counter++;
	}

}