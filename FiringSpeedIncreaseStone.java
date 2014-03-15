package LOTR;
public class FiringSpeedIncreaseStone extends MagicStone {

	private int firingSpeedIncreaseValue;

	public int getFiringSpeedIncreaseValue() {
		return this.firingSpeedIncreaseValue;
	}

	/**
	 * 
	 * @param firingSpeedIncreaseValue
	 */
	public void setFiringSpeedIncreaseValue(int firingSpeedIncreaseValue) {
		this.firingSpeedIncreaseValue = firingSpeedIncreaseValue;
	}

	public void effectTower() {
		//vegig megy a Map.towers listán, amelyiknek a pozicioja megegyezik
		// az o poziciojaval, annak meghivja a setFiringSpeed() metodusat.
	}

}