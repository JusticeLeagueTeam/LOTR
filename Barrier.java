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
	protected int retardingValue;
	/**
	 * egyik varazsko miatt kell
	 */
	protected boolean elfOrDwarfFlag;

	/**
	 * visszaadja a lassitasi tenyezot
	 * @return visszaadja a lassitasi tenyezot
	 */
	public int getRetardingValue() {
		return retardingValue;
	}

	/**
	 * beallitja a lassitasi tenyezot
	 * @param retardingValue beallitja a lassitasi tenyezot
	 */
	public void setRetardingValue(int rv) {
		retardingValue = rv;
	}

	/**
	 * visszaadja a flag allapotat
	 * @return visszaadja a flag allapotat
	 */
	public boolean getElfOrDwarfFlag() {
		return elfOrDwarfFlag;
	}

	/**
	 * beallitja a flag-et
	 * @param elfOrDwarfFlag beallitja a flag-et
	 */
	public void setElfOrDwarfFlag(boolean eodf) {
		elfOrDwarfFlag = eodf;
	}

	/**
	 *
	 */
	public void effectEnemy() {
		//-
	}

	/**
	 * ellenorzi, hogy van-e ellenfel ezen a pozicion
	 * Observer mintahoz tartozik
	 */
	@Override
	public void update(Observable o, Object arg) {
		//ciklus vegigmegy az ellenfeleken es ellenorzi, hogy rajta vannak-e az akadalyon
		for(Enemy e : Map.enemies){
			if((e.getPosition().getRowValue() == this.position.getRowValue()) && e.getPosition().getColumnValue() == this.position.getColumnValue()){
				//akadaly tipusatol fuggoen kicsit vagy jobban lassitja az ellenfelet
				if(retardingValue == 1 && e.getSpeed() <= 8){
					e.setSpeed(e.getSpeed() +1);
				}
				if(retardingValue == 2 && e.getSpeed() <= 10){
					e.setSpeed(e.getSpeed() +2);
				}
			}
		}
	}
}