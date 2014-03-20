package LOTR;

import java.util.Observable;
import java.util.Observer;

public class Barrier extends DefenseTools implements Observer {

	private int retardingValue;
	private boolean elfOrDwarfFlag;

	public int getRetardingValue() {
		System.out.println("Barrier getRetardingValue - visszaadja a lassitasi tenyezot");
		return this.retardingValue;
	}

	public void setRetardingValue(int retardingValue) {
		System.out.println("Barrier setRetardingValue - beallitja a lassitasi tenyezot");
		this.retardingValue = retardingValue;
	}

	public boolean getElfOrDwarfFlag() {
		System.out.println("Barrier getElfOrDwarfFlag - visszaadja a flag allapotat");
		return this.elfOrDwarfFlag;
	}

	public void setElfOrDwarfFlag(boolean elfOrDwarfFlag) {
		System.out.println("Barrier setElfOrDwarfFlag - beallitja a flag-et");
		this.elfOrDwarfFlag = elfOrDwarfFlag;
	}

	public void effectEnemy() {
		System.out.println("Barrier effectEnemy - osszes ellenfelet ellenorzi, hogy van-e rajta ko, ha igen akkor beallitja a hatasat");
		//implementacional ez egy ciklus lesz - arnold
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Barrier update - ellenorzi, hogy van-e ellenfel ezen a pozicion");
	}

}