package LOTR; 



import java.util.LinkedList;

/**
 * A varazskovek egy fajtaja, a tornyok hatotavolsagat lehet vele valtoztatni.
 */
public class RangeExtenderStone extends MagicStone {

	/**
	 * rangeExtendingValue valtozo ertekevel fogja ez a ko novelni a torony hatotavolsagat
	 */
	private int rangeExtendingValue;
	
	/**
	 * RangeExtenderStone ko a torony hatotavolsagat noveli
	 */
	public RangeExtenderStone(){
		this.position=new Position();
		this.rangeExtendingValue=1;
		this.cost=50;
	}

	/**
	 *  visszaadja hatokor novelesenek erteket
	 */
	public int getRangeExtendingValue() {
		return rangeExtendingValue;
	}

	/**
	 * beallitja hatokor novelesenek erteket
	 */
	public void setRangeExtendingValue(int rEV) {
		this.rangeExtendingValue = rEV;
	}

	/**
	 * az adott pozicion levo toronynak beallitja a modositott paramtereit
	 */
	public void effectTower() {
		for(Tower t : Map.towers)
		{
			if(t.position.getColumnValue()==this.position.getColumnValue() && t.position.getRowValue() == this.position.getRowValue())
			{
				t.setFiringRange(t.getFiringRange() + this.rangeExtendingValue);
			}
		}
	}
}
