package LOTR;


import java.util.LinkedList;

/**
 * ElfDwarfSpecializedStone - varazskovek egyike
 * kulonlegessege, hogy csak elfekre es torpekre hat
 * emiatt kell egy flag amit a torony minden tamadaskor ellenoriz
 * @author justice_league
 *
 */
public class ElfDwarfSpecializedStone extends MagicStone {
	/**
	 * ElfDwarfSpecializedStone - varazskovek egyike
	 */
	public ElfDwarfSpecializedStone(){
		this.position=new Position();
		this.cost=100;
	}

	/**
	 * A tornyok tulajdonsagait modositani kepes metodus.
	 */
	public void effectTower() {	
		/**
		 * vegigmegy a tornyokon es kivalasztja azt amelyik tulajdonsagat frissiteni kell
		 */
		for(Tower t : Map.towers)
		{
			if(t.position.getColumnValue()==this.position.getColumnValue() && t.position.getRowValue() == this.position.getRowValue())
			{
				t.setElfOrDwarfFlag(true);
			}
		}
	}
}
