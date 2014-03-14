package LOTR;
public class Timer {

	private int period;
	//Game game;//felesleges - arnold
	
	public Timer(){
		System.out.println("Timer konstruktor - Timer objektum létrejött.");
	}

	public void run() {
		System.out.println("Timer run - ");
	}

	public void setPeriod(int intParameter) {
		this.period = intParameter;
		System.out.println("Timer setPeriod - periódusidõ beállítása");
	}

	public void setGame(int Game) {
		//ez a metódus szvsz nem kell - arnold
		System.out.println("Timer setGame -");
	}

	public void tick() {
		System.out.println("Timer tick - letelt egy órajel");
	}
	


}