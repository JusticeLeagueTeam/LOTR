package LOTR;
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
		System.out.println("ElfDwarfSpecializedStone konstruktor");
	}

	/**
	 * hatassal van a vedelmi eszkozre
	 */
	public void effectDefenseTool() {
		System.out.println("ElfDwarfSpecializedStone effectDefenseTool - hatassal van a vedelmi eszkozre");
	}

	/**
	 * hatassal van a toronyra
	 */
	public void effectTower() {
		System.out.println("ElfDwarfSpecializedStone effectTower - hatassal van a toronyra");
	}

	/**
	 * hatassal van az akadalyra
	 */
	public void effectBarrier() {
		System.out.println("ElfDwarfSpecializedStone effectBarrier - hatassal van az akadalyra");
	}

}