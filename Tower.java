package LOTR;

import java.util.Observable;

public class Tower extends DefenseTools {

	private int firingSpeed;
	private int firingRange;
	private boolean elfOrDwarfFlag;
	private int tick_counter;

	public int getFiringSpeed() {
		System.out.println("Tower getFiringSpeed - visszaadja a t�mad�s sebess�g�t");
		return this.firingSpeed;
	}

	public void setFiringSpeed(int firingSpeed) {
		System.out.println("Tower setFiringSpeed - be�ll�tja a t�mad�s sebess�g�t");
		this.firingSpeed = firingSpeed;
	}

	public int getFiringRange() {
		System.out.println("Tower getFiringRange - visszaadja a hat�t�vot");
		return this.firingRange;
	}

	public void setFiringRange(int firingRange) {
		System.out.println("Tower setFiringRange - be�ll�tja a hat�t�vot");
		this.firingRange = firingRange;
	}

	public boolean getElfOrDwarfFlag() {
		System.out.println("Tower getElfOrDwarfFlag - visszaadja a flag-et");
		return this.elfOrDwarfFlag;
	}

	public void setElfOrDwarfFlag(boolean elfOrDwarfFlag) {
		System.out.println("Tower setElfOrDwarfFlag - be�ll�tja a flag-et");
		this.elfOrDwarfFlag = elfOrDwarfFlag;
	}

	public void update(Observable observable) {
		System.out.println("Tower update - ellen�rzi, hogy van-e ellens�g a hat�k�r�ben");
	}

	public void tick() {
		System.out.println("Tower tick - t�veli a tick_counter-t eggyel");
	}

}