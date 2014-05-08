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

	public Player(){
		this.magicPower = 1500;
	}
	/**
	 * visszaadja a jatekos varazserejet
	 * @return visszaadja a jatekos varazserejet
	 */
	public int getMagicPower() {
		return this.magicPower;
	}
	/**
	 * beallitja a jatekos varazserejet
	 * @param magicPower jatekos varazsereje
	 */
	public void setMagicPower(int mP) {
		this.magicPower = mP;
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
		if(dt.getCost() <= getMagicPower()){
			boolean isRoad=Map.mainMap[dt.getPosition().getRowValue()][dt.getPosition().getColumnValue()].getRoadFlag();
			String dtClass = dt.getClass().toString();
			dtClass = dtClass.substring(11);	//TODO

			if(dt instanceof Tower && isRoad == false)
			{
				Map.towers.add((Tower) dt);
				for(Enemy e : Map.enemies){
					e.addObserver(Map.towers.get(Map.towers.indexOf(dt)));
				}
			}
			if(dt instanceof Barrier && isRoad)
			{
				Map.barriers.add((Barrier) dt);
				for(Enemy e : Map.enemies){
					e.addObserver(Map.barriers.get(Map.barriers.indexOf(dt)));
				}
			}
			if(dt instanceof MagicStone)
			{
				Map.magicStones.add((MagicStone) dt);
				//TODO:effectTower-t itt hivjuk meg; effectTower megnezi, h van-e torony a magicstone poziciojan, ha igen, akkor modositja a parametereit
				dt.effectTower();
			}
			/**
			 * vedelmi eszkoz koltsegenek levonasa a varazserobol
			 */
			this.magicPower -= dt.getCost();
		}
		/**
		 * Amennyiben nincs eleg varazsero
		 */
		else{
			//DO NOTHING
		}
	}
}
