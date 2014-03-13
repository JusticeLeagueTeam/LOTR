public class Tower extends DefenseTools {

	private int firingSpeed;
	private int firingRange;
	private boolean elfOrDwarfFlag;
	private int tick_counter;

	public int getFiringSpeed() {
		return this.firingSpeed;
	}

	/**
	 * 
	 * @param firingSpeed
	 */
	public void setFiringSpeed(int firingSpeed) {
		this.firingSpeed = firingSpeed;
	}

	public int getFiringRange() {
		return this.firingRange;
	}

	/**
	 * 
	 * @param firingRange
	 */
	public void setFiringRange(int firingRange) {
		this.firingRange = firingRange;
	}

	public boolean getElfOrDwarfFlag() {
		return this.elfOrDwarfFlag;
	}

	/**
	 * 
	 * @param elfOrDwarfFlag
	 */
	public void setElfOrDwarfFlag(boolean elfOrDwarfFlag) {
		this.elfOrDwarfFlag = elfOrDwarfFlag;
	}

	/**
	 * 
	 * @param observable
	 */
	public void update(Observable observable) {
		// TODO - implement Tower.update
		throw new UnsupportedOperationException();
	}

	public void tick() {
		// TODO - implement Tower.tick
		throw new UnsupportedOperationException();
	}

}