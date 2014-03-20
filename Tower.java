package LOTR;

import java.util.Observable;

public class Tower extends DefenseTools {

	private int firingSpeed;
	private int firingRange;
	private boolean elfOrDwarfFlag;
	private int tick_counter;

	public int getFiringSpeed() {
		System.out.println("Tower getFiringSpeed - visszaadja a tamadas sebesseget");
		return this.firingSpeed;
	}

	public void setFiringSpeed(int firingSpeed) {
		System.out.println("Tower setFiringSpeed - beallitja a tamadas sebesseget");
		this.firingSpeed = firingSpeed;
	}

	public int getFiringRange() {
		System.out.println("Tower getFiringRange - visszaadja a hatotavot");
		return this.firingRange;
	}

	public void setFiringRange(int firingRange) {
		System.out.println("Tower setFiringRange - beallitja a hatotavot");
		this.firingRange = firingRange;
	}

	public boolean getElfOrDwarfFlag() {
		System.out.println("Tower getElfOrDwarfFlag - visszaadja a flag-et");
		return this.elfOrDwarfFlag;
	}

	public void setElfOrDwarfFlag(boolean elfOrDwarfFlag) {
		System.out.println("Tower setElfOrDwarfFlag - beallitja a flag-et");
		this.elfOrDwarfFlag = elfOrDwarfFlag;
	}

	public void update(Observable observable) {
		System.out.println("Tower update - ellenorzi, hogy van-e ellenseg a hatokoreben");		
	}

	public void tick() {
		System.out.println("Tower tick - noveli a tick_counter-t eggyel");
	}

}