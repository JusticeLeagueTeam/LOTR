package LOTR;


import java.util.Observable;
import java.util.Observer;
/**
 * Barrier - akadalyok osztalya
 * DefenseToolsbol szarmazik
 * tipusai: ShiftingSand, Swamp
 * Ellenfeleket figyelik Observer minta szerint es lassitjak oket
 * @author justice_league
 *
 */
public class Barrier extends DefenseTools implements Observer {
	/**
	 * ennyivel lassitja az ellenfelet
	 */
	private int retardingValue;
	/**
	 * egyik varazsko miatt kell
	 */
	private boolean elfOrDwarfFlag;

	/**
	 * visszaadja a lassitasi tenyezot
	 * @return visszaadja a lassitasi tenyezot
	 */
	public int getRetardingValue() {
		System.out.println("Barrier getRetardingValue - visszaadja a lassitasi tenyezot");
		return this.retardingValue;
	}

	/**
	 * beallitja a lassitasi tenyezot
	 * @param retardingValue beallitja a lassitasi tenyezot
	 */
	public void setRetardingValue(int retardingValue) {
		System.out.println("Barrier setRetardingValue - beallitja a lassitasi tenyezot");
		this.retardingValue = retardingValue;
	}

	/**
	 * visszaadja a flag allapotat
	 * @return visszaadja a flag allapotat
	 */
	public boolean getElfOrDwarfFlag() {
		System.out.println("Barrier getElfOrDwarfFlag - visszaadja a flag allapotat");
		return this.elfOrDwarfFlag;
	}

	/**
	 * beallitja a flag-et
	 * @param elfOrDwarfFlag beallitja a flag-et
	 */
	public void setElfOrDwarfFlag(boolean elfOrDwarfFlag) {
		System.out.println("Barrier setElfOrDwarfFlag - beallitja a flag-et");
		this.elfOrDwarfFlag = elfOrDwarfFlag;
	}

	/**
	 * osszes ellenfelet ellenorzi, hogy van-e rajta ko, ha igen akkor beallitja a hatasat
	 */
	public void effectEnemy() {
		System.out.println("Barrier effectEnemy - osszes ellenfelet ellenorzi, hogy akadalyra lepett-e, ha igen akkor beallitja a hatasat");
		//implementacional ez egy ciklus lesz - arnold
	}

	/**
	 * ellenorzi, hogy van-e ellenfel ezen a pozicion
	 * Observer mintahoz tartozik
	 */
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Barrier update - ellenorzi, hogy van-e ellenfel ezen a pozicion");
	}

}