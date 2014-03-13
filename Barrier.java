public class Barrier extends DefenseTools implements Observer {

	private int retardingValue;
	private boolean elfOrDwarfFlag;

	public int getRetardingValue() {
		return this.retardingValue;
	}

	/**
	 * 
	 * @param retardingValue
	 */
	public void setRetardingValue(int retardingValue) {
		this.retardingValue = retardingValue;
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

	public void effectEnemy() {
		// TODO - implement Barrier.effectEnemy
		throw new UnsupportedOperationException();
	}

}