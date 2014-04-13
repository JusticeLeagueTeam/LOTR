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
		this.cost=100;
		System.out.println("ElfDwarfSpecializedStone konstruktor - letrehozza a varazskovet  kezdeti ertekekkel");
	}

	/**
	 * A vedelmi eszkozok tulajdonsagait modositani kepes metodus.
	 */
	public void effectDefenseTool() {
		//System.out.println("ElfDwarfSpecializedStone effectDefenseTool() - modositja a vedelmi eszkoz tulajdonsagait");
		//LinkedList<Tower> towersLinkedList = Map.getTowers();		
		//Tower t = (Tower) Map.getTowers().get(0);
		//t.setElfOrDwarfFlag(true);
	}

	/**
	 * A tornyok tulajdonsagait modositani kepes metodus.
	 */
	public void effectTower() {
		System.out.println("ElfDwarfSpecializedStone effectTower() - modositja a tornyok tulajdonsagait");
		LinkedList<Tower> towersLinkedList = Map.getTowers();		
		for(Tower t : towersLinkedList)
		{
			if(t.position.getColumnValue()==this.position.getColumnValue() && t.position.getRowValue() == this.position.getRowValue())
			{
				t.setElfOrDwarfFlag(true);
			}

		}
	}

	/**
	 * Az akadalyok tulajdonsagait modositani kepes metodus.
	 */
	public void effectBarrier() {
		System.out.println("ElfDwarfSpecializedStone effectBarrier() - modositja az akadalyok tulajdonsagait");
	}

}