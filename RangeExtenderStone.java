package LOTR;
public class RangeExtenderStone extends MagicStone {

	/**
	 * rangeExtendingValue valtozo ertekevel fogja ez a ko novelni a torony hatotavolsagat
	 */
	private int rangeExtendingValue;
	
	/**
	 * RangeExtenderStone ko a torony hatotavolsagat noveli
	 */
	public RangeExtenderStone(){
		System.out.println("RangeExtenderStone konstruktor");
	}

	/**
	 *  visszaadja hatokor novelesenek erteket
	 */
	public int getRangeExtendingValue() {
		System.out.println("RangeExtenderStone getRangeExtendingValue - visszaadja hatokor novelesenek erteket");
		return rangeExtendingValue;
	}

	/**
	 * beallitja hatokor novelesenek erteket
	 */
	public void setRangeExtendingValue(int rangeExtendingValue) {
		System.out.println("RangeExtenderStone setRangeExtendingValue - beallitja hatokor novelesenek erteket");
		this.rangeExtendingValue = rangeExtendingValue;
	}

	/**
	 * az adott pozicion levo toronynak beallitja a modositott paramtereit
	 */
	public void effectTower() {
		System.out.println("RangeExtenderStone effectTower - az adott pozicion levo toronynak beallitja a modositott paramtereit");
	}

}