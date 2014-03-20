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
	/* tuzelesi gyakorisag */
	private int firingSpeed;
	/* tuzelesi hatotav */
	private int firingRange;
	/* flag az olyan varazskoveknek ami csak elfekre vagy torpekre hat */
	private boolean elfOrDwarfFlag;
	/* jatek kezdete ota eltelt orajelek szama */
	private int tick_counter;
	
	public Tower(){
		//a leszarmazottakba eleg print - arnold
	}

	public int getFiringSpeed() {
		/*
		 * visszaadja a tamadas sebesseget
		 */
		System.out.println("Tower getFiringSpeed - visszaadja a tamadas sebesseget");
		return this.firingSpeed;
	}

	public void setFiringSpeed(int firingSpeed) {
		/*
		 * beallitja a tamadas sebesseget
		 */
		System.out.println("Tower setFiringSpeed - beallitja a tamadas sebesseget");
		this.firingSpeed = firingSpeed;
	}

	public int getFiringRange() {
		/*
		 * visszaadja a hatotavot
		 */
		System.out.println("Tower getFiringRange - visszaadja a hatotavot");
		return this.firingRange;
	}

	public void setFiringRange(int firingRange) {
		/*
		 * beallitja a hatotavot
		 */
		System.out.println("Tower setFiringRange - beallitja a hatotavot");
		this.firingRange = firingRange;
	}

	public boolean getElfOrDwarfFlag() {
		/*
		 *visszaadja a flag-et 
		 */
		System.out.println("Tower getElfOrDwarfFlag - visszaadja a flag-et");
		return this.elfOrDwarfFlag;
	}

	public void setElfOrDwarfFlag(boolean elfOrDwarfFlag) {
		/*
		 * beallitja a flag-et
		 */
		System.out.println("Tower setElfOrDwarfFlag - beallitja a flag-et");
		this.elfOrDwarfFlag = elfOrDwarfFlag;
	}

	public void update(Observable observable) {
		/*
		 * ellenorzi, hogy van-e ellenseg a hatokoreben
		 */
		System.out.println("Tower update - ellenorzi, hogy van-e ellenseg a hatokoreben");		
	}

	public void tick() {
		/*
		 * noveli a tick_counter-t eggyel
		 */
		System.out.println("Tower tick - noveli a tick_counter-t eggyel");
	}

}