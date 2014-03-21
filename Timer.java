package LOTR;

public class Timer {

	private int period;
	
	public Timer(){
		System.out.println("Timer konstruktor");
	}

	public void run() {
		System.out.println("Timer run - ");
	}

	public void setPeriod(int intParameter) {
		this.period = intParameter;
		System.out.println("Timer setPeriod - periodusio beallitasa");
	}

	public static void tick() {
		System.out.println("Timer tick - letelt egy orajel");
	}
	


}
