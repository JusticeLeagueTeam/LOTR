package LOTR; 



import java.util.LinkedList;

/**
 * torony tamadas gyakorisagat novelo ko
 */
public class FiringSpeedIncreaseStone extends MagicStone {

	/**
	 * Ezzel az ertekkel noveljuk a tuzelesi sebesseget.
	 */
	private int firingSpeedIncreaseValue;

	/**
	 * torony tamadas gyakorisagat novelo ko
	 */
	public FiringSpeedIncreaseStone(){
		this.position=new Position();
		this.firingSpeedIncreaseValue=1;
		this.cost=50;
	}
	
	/**
	 * A torony tuzelesi sebesseget valtoztato ertek lekerdezesere hasznalhato metodus
	 */
	public int getFiringSpeedIncreaseValue() {
		return this.firingSpeedIncreaseValue;
	}

	/**
	 *  A torony tuzelesi sebesseget valtoztato ertek beallitasara hasznalhato metodus.
	 */
	public void setFiringSpeedIncreaseValue(int fSI) {
		this.firingSpeedIncreaseValue = fSI;
	}

	/**
	 *  A tornyok tulajdonsagait modositani kepes metodus.
	 */
	public void effectTower() {
		for(Tower t : Map.towers)
		{
			if(t.position.getColumnValue()==this.position.getColumnValue() && t.position.getRowValue() == this.position.getRowValue())
			{
				t.setFiringSpeed(t.getFiringSpeed() + this.firingSpeedIncreaseValue);
			}
		}
	}
}
