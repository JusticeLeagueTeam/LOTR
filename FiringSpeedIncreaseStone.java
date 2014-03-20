package LOTR;
/**
 * torony tamadas gyakorisagat novelo ko
 */
public class FiringSpeedIncreaseStone extends MagicStone {

	/**
	 * a tamadasi gyakorisag megnovelesenek az erteke
	 */
	private int firingSpeedIncreaseValue;

	/**
	 * torony tamadas gyakorisagat novelo ko
	 */
	public FiringSpeedIncreaseStone(){
		System.out.println("FiringSpeedIncreaseStone konstruktor");
	}
	
	/**
	 * visszaadja a tamadoero novekedesenek merteket
	 */
	public int getFiringSpeedIncreaseValue() {
		System.out.println("FiringSpeedIncreaseStone getFiringSpeedIncreaseValue - visszaadja a tamadoero novekedesenek merteket");
		return this.firingSpeedIncreaseValue;
	}

	/**
	 * beallitja a tamadoero novekedesenek merteket
	 */
	public void setFiringSpeedIncreaseValue(int firingSpeedIncreaseValue) {
		System.out.println("FiringSpeedIncreaseStone setFiringSpeedIncreaseValue - beallitja a tamadoero novekedesenek merteket");
		this.firingSpeedIncreaseValue = firingSpeedIncreaseValue;
	}

	public void effectTower() {
		System.out.println("FiringSpeedIncreaseStone effectTower - az adott pozicion megnezi, hogy van-e torony, ha igen akkor modositja a parametereit");
	}

}