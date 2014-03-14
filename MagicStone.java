package LOTR;
public abstract class MagicStone extends DefenseTools {

	private boolean wasItUsed;

	public boolean getWasItUsed() {
		return this.wasItUsed;
	}

	/**
	 * 
	 * @param wasItUsed
	 */
	public void setWasItUsed(boolean wasItUsed) {
		this.wasItUsed = wasItUsed;
	}

	public void effectBarrier() {
		// TODO - implement MagicStone.effectBarrier
		throw new UnsupportedOperationException();
	}

	public void effectTower() {
		// TODO - implement MagicStone.effectTower
		throw new UnsupportedOperationException();
	}

}