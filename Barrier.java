package LOTR;

import java.util.Observable;
import java.util.Observer;

public class Barrier extends DefenseTools implements Observer {

	private int retardingValue;
	private boolean elfOrDwarfFlag;

	public int getRetardingValue() {
		System.out.println("Barrier getRetardingValue");
		return this.retardingValue;
	}

	public void setRetardingValue(int retardingValue) {
		System.out.println("Barrier setRetardingValue");
		this.retardingValue = retardingValue;
	}

	public boolean getElfOrDwarfFlag() {
		System.out.println("Barrier getElfOrDwarfFlag");
		return this.elfOrDwarfFlag;
	}

	public void setElfOrDwarfFlag(boolean elfOrDwarfFlag) {
		System.out.println("Barrier setElfOrDwarfFlag");
		this.elfOrDwarfFlag = elfOrDwarfFlag;
	}

	public void effectEnemy() {
		System.out.println("Barrier effectEnemy");
		//A Map.enemies -en végig kell menni, es ahol egy enemy position-je
		//megegyezik a barrier position-jevel, azt lassitja
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Barrier update - ellenõrzi, hogy van-e ellenfél a közelében");
	}

}