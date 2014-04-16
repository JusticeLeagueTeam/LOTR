package LOTR;


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
		Map.tick();
		Game.tick();
		if(Game.isSpecial)
			System.out.println("tick - letelt egy orajel, specialis lovedek aktivalva");
		else if(Game.fogPrint){
			Game.fogPrint=false;
			System.out.println("tick - letelt egy orajel, köd aktivalva");
		}
		else
			System.out.println("tick - letelt egy orajel");
	}
}
