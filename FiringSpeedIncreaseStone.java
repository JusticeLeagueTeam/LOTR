package LOTR;
public class FiringSpeedIncreaseStone extends MagicStone {

	private int firingSpeedIncreaseValue;

	public int getFiringSpeedIncreaseValue() {
		System.out.println("FiringSpeedIncreaseStone getFiringSpeedIncreaseValue - visszaadja a tamadoero novekedesenek merteket");
		return this.firingSpeedIncreaseValue;
	}

	public void setFiringSpeedIncreaseValue(int firingSpeedIncreaseValue) {
		System.out.println("FiringSpeedIncreaseStone setFiringSpeedIncreaseValue - beallitja a tamadoero novekedesenek merteket");
		this.firingSpeedIncreaseValue = firingSpeedIncreaseValue;
	}

	public void effectTower() {
		System.out.println("FiringSpeedIncreaseStone effectTower - az adott pozicion megnezi, hogy van-e torony, ha igen akkor modositja a parametereit");
	}

}