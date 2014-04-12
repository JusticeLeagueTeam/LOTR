package LOTR;


public class Timer {

	private int period;
	
	public Timer(){
		System.out.println("Timer konstruktor");
	}

	public void run() {
		System.out.println("Timer run - ");
	}

	/** Beállítja a periódusidőt */
	public void setPeriod(int intParameter) {
		this.period = intParameter;
		System.out.println("Timer setPeriod - periodusio beallitasa");
	}

	/** Az órajelért felelős metódus, minden periódusidő lejártakor meghívódik. 
	 * Meghívja a Map és a Game tick metódusát.
	 */
	public static void tick() {
		Map.tick();
		Game.tick();
		System.out.println("Timer tick - letelt egy orajel");
	}
	
}
