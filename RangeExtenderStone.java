package LOTR;
public class RangeExtenderStone extends MagicStone {

	private int rangeExtendingValue;
	
	public RangeExtenderStone(){
		System.out.println("RangeExtenderStone konstruktor");
	}

	public int getRangeExtendingValue() {
		System.out.println("RangeExtenderStone getRangeExtendingValue - visszaadja hatokor novelesenek erteket");
		return rangeExtendingValue;
	}

	public void setRangeExtendingValue(int rangeExtendingValue) {
		System.out.println("RangeExtenderStone setRangeExtendingValue - beallitja hatokor novelesenek erteket");
		this.rangeExtendingValue = rangeExtendingValue;
	}

	public void effectTower() {
		System.out.println("RangeExtenderStone effectTower - az adott pozicion levo toronynak beallitja a modositott paramtereit");
	}

}