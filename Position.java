package LOTR;


/**
 * Poziciot reprezentalo osztaly.
 */
public class Position {

	/** 
	 * cellamatrixon beluli sorszam 
	 */
	private int rowValue;
	
	/** 
	 * cellamatrixon beluli oszlopszam 
	 */
	private int columnValue;
	/**
	 * utat jelzo flag
	 */
	private boolean roadFlag;

	/**
	 *  visszaadja a sorszamot 
	 */
	public int getRowValue() {
		return this.rowValue;
	}

	/** 
	 * beallitja a sorszamot
	 */
	public void setRowValue(int rV) {
		this.rowValue = rV;
	}

	/**
	 *  visszaadja az oszlopszamot
	 */
	public int getColumnValue() {
		return this.columnValue;
	}

	/** 
	 * beallitja az oszlopszamot 
	 */
	public void setColumnValue(int cV) {
		this.columnValue = cV;
	}
	/**
	 * utat jelzo flag-et adja vissza
	 * @return roadFlag
	 */
	public boolean getRoadFlag() {
		return this.roadFlag;
	}
	/**
	 * utat jelzo flag-et allitja be
	 * @param rF
	 */
	public void setRoadFlag(boolean rF) {
		this.roadFlag = rF;
	}
}
