package LOTR;
public abstract class MagicStone extends DefenseTools {

	private boolean wasItUsed;

	public boolean getWasItUsed() {
		System.out.println("MagicStone getWasItUsed - visszaadja a flag-et");
		return this.wasItUsed;
	}

	public void setWasItUsed(boolean wasItUsed) {
		System.out.println("MagicStone getWasItUsed - beallitja a flag-et");
		this.wasItUsed = wasItUsed;
	}

	public void effectBarrier() {
		System.out.println("MagicStone effectBarrier - beallitja a pozicion levo akadaly parametereit");
	}

	public void effectTower() {
		System.out.println("MagicStone effectBarrier - beallitja a pozicion levo torony parametereit");
	}

}