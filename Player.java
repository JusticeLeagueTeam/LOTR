package LOTR;

/**
 * Player a jatekos osztalya
 * a jatekos iranyitja a GUI-n keresztul az egysegeit
 * @author justice_league
 *
 */
public class Player {
	/**
	 * jatekos varazsereje
	 */
	private int magicPower;
	/**
	 * Player a jatekos osztalya
	 * a jatekos iranyitja a GUI-n keresztul az egysegeit
	 */
	public Player(){
		System.out.println("Player konstruktor");
	}
	/**
	 * visszaadja a jatekos eleterejet
	 * @return visszaadja a jatekos eleterejet
	 */
	public int getMagicPower() {
		System.out.println("Player getMagicPower - visszaadja a jatekos eleterejet");
		return this.magicPower;
	}
	/**
	 * beallitja a jatekos eleterejet
	 * @param magicPower jatekos eletereje
	 */
	public void setMagicPower(int magicPower) {
		System.out.println("Player setMagicPower - beallitja a jatekos eleterejet");
		this.magicPower = this.magicPower + magicPower;
	}
	/**
	 * uj vedelmi egyseg letrehozasa
	 * ez a metodus gondoskodik uj tornyok, akadalyok, kovek letrehozasaert
	 * paramterekent kapja meg a deklaralt valzotot
	 * jatekos varazserejet ellenorzi 
	 * tipus szerint hozzaadja a Map megfelelo listajahoz
	 * @param dt paramterekent kapja meg a deklaralt valzotot
	 */
	public void createDefenseTool(DefenseTools dt) {
		System.out.println("Player createDefenseTool - Player csinal egy defenseTool-t");
		dt.getCost();
		getMagicPower();
		System.out.println("[IF] ha van eleg varazsero a torony megepitesere");
		
		String dtClass = dt.getClass().toString();
		dtClass = dtClass.substring(5);	//TODO
		
		if(dt instanceof Tower)
		{
			Map.towers.add((Tower) dt);
			System.out.println("towers add " + dtClass);
		}
		if(dt instanceof Barrier)
		{
			Map.barriers.add((Barrier) dt);
			System.out.println("barriers add " + dtClass);
		}
		if(dt instanceof MagicStone)
		{
			Map.magicStones.add((MagicStone) dt);
			System.out.println("magicstones add " + dtClass);
		}
	}
}
