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
	
	private boolean roadFlag;

	/**
	 *  visszaadja a sorszamot 
	 */
	public int getRowValue() {
		System.out.println("Position getRowValue() - Sorszam lekerdezese.");
		return this.rowValue;
	}

	/** 
	 * beallitja a sorszamot
	 */
	public void setRowValue(int rowValue) {
		System.out.println("Position setRowValue(int rowValue) - Sorszam beallitasa.");
		this.rowValue = rowValue;
	}

	/**
	 *  visszaadja az oszlopszamot
	 */
	public int getColumnValue() {
		System.out.println("Position setRowValue() - Oszlopszam lekerdezese.");
		return this.columnValue;
	}

	/** 
	 * visszaadja az oszlopszamot 
	 */
	public void setColumnValue(int columnValue) {
		System.out.println("Position setColumnValue(int columnValue) - Oszlopszam beallitasa.");
		this.columnValue = columnValue;
	}
	
	public boolean getRoadFlag() {
		return this.roadFlag;
	}
	
	public void setRoadFlag(boolean roadflag) {
		this.roadFlag = roadflag;
	}


}