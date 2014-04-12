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
		System.out.println("FiringSpeedIncreaseStone konstruktor - letrehozza a varazskovet kezdeti ertekekkel");
	}
	
	/**
	 * A torony tuzelesi sebesseget valtoztato ertek lekerdezesere hasznalhato metodus
	 */
	public int getFiringSpeedIncreaseValue() {
		System.out.println("FiringSpeedIncreaseStone getFiringSpeedIncreaseValue() - A torony tuzelesi sebesseget valtoztato ertek lekerdezese.");
		return this.firingSpeedIncreaseValue;
	}

	/**
	 *  A torony tuzelesi sebesseget valtoztato ertek beallitasara hasznalhato metodus.
	 */
	public void setFiringSpeedIncreaseValue(int firingSpeedIncreaseValue) {
		System.out.println("FiringSpeedIncreaseStone setFiringSpeedIncreaseValue(int firingSpeedIncreaseValue) - A torony tuzelesi sebesseget valtoztato ertek beallitasa.");
		this.firingSpeedIncreaseValue = firingSpeedIncreaseValue;
	}

	/**
	 *  A tornyok tulajdonsagait modositani kepes metodus.
	 */
	public void effectTower() {
		System.out.println("FiringSpeedIncreaseStone effectTower() - modositja a tornyok tulajdonsagait");
		LinkedList<Tower> towersLinkedList = Map.getTowers();
		for(Tower t : towersLinkedList)
		{
			t.setFiringSpeed(15);
		}
	}

}