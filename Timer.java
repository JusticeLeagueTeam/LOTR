package LOTR;


public class Timer {

	private int period;
	
	public Timer(){
		System.out.println("Timer konstruktor");
	}

	public void run() {
		System.out.println("Timer run - ");
	}

	/** Beallitja a periodusidot */
	public void setPeriod(int intParameter) {
		this.period = intParameter;
		System.out.println("Timer setPeriod - periodusio beallitasa");
	}

	/** Az orajelert felelos metodus, minden periodus letelte utan meghivodik 
	 * Meghivja a Map es a Game tick metodusat
	 */
	public static void tick() {
		Map.tick();
		Game.tick();
		System.out.println("Timer tick - letelt egy orajel");
	}
	
}
