package LOTR; 


/**
 * Varazskovek a vedelmi eszkozok egy fajtaja.
 * Varazskovekkel modosithatjuk tornyok alapertelmezett parametereit
 * mint peldaul hatotavolsag, tuzero, stb.
 */
public abstract class MagicStone extends DefenseTools {

	/**
	 * wasItUsed boolean tipusu valtozoban (flag) taroljuk, hogy volt-e mar hasznalva a ko
	 * GUI-nal kellhet
	 */
	private boolean wasItUsed;

	/**
	 * visszaadja a flag-et
	 * GUI-nal kellhet
	 */
	public boolean getWasItUsed() {
		return this.wasItUsed;
	}

	/**
	 * beallitja a flag-et
	 * GUI-nal kellhet
	 */
	public void setWasItUsed(boolean wIU) {
		this.wasItUsed = wIU;
	}

	/**
	 * beallitja a pozicion levo torony parametereit
	 */
	public void effectTower() {
		//leszarmazottakban van implementalva
	}

}
