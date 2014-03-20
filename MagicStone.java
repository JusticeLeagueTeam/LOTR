package LOTR;
/**
 * Varazskovek a vedelmi eszkozok egy fajtaja.
 * Varazskovekkel modosithatjuk tornyok alapertelmezett parametereit
 * mint peldaul hatotavolsag, tuzero, stb.
 */
public abstract class MagicStone extends DefenseTools {

	/**
	 * wasItUsed boolean tipusu valtozoban (flag) taroljuk, hogy volt-e mar hasznalva a ko
	 */
	private boolean wasItUsed;

	/**
	 * visszaadja a flag-et
	 */
	public boolean getWasItUsed() {
		System.out.println("MagicStone getWasItUsed() - visszaadja a flag-et");
		return this.wasItUsed;
	}

	/**
	 * beallitja a flag-et
	 */
	public void setWasItUsed(boolean wasItUsed) {
		System.out.println("MagicStone getWasItUsed(boolean wasItUsed) - beallitja a flag-et");
		this.wasItUsed = wasItUsed;
	}

	/**
	 * beallitja a pozicion levo akadaly parametereit
	 */
	public void effectBarrier() {
		System.out.println("MagicStone effectBarrier() - beallitja a pozicion levo akadaly parametereit");
	}

	/**
	 * beallitja a pozicion levo torony parametereit
	 */
	public void effectTower() {
		System.out.println("MagicStone effectTower() - beallitja a pozicion levo torony parametereit");
	}

}