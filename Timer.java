package LOTR;
public class Timer {

	private int period;
	//Game game;//felesleges - arnold
	
	public Timer(){
		System.out.println("Timer konstruktor - Timer objektum l�trej�tt.");
	}

	public void run() {
		System.out.println("Timer run - ");
	}

	public void setPeriod(int intParameter) {
		this.period = intParameter;
		System.out.println("Timer setPeriod - peri�dusid� be�ll�t�sa");
	}

	public void setGame(int Game) {
		//ez a met�dus szvsz nem kell - arnold
		//szerintem sem - oliver
		System.out.println("Timer setGame -");
	}

	public void tick() {
		System.out.println("Timer tick - letelt egy �rajel");
	}
	


}
