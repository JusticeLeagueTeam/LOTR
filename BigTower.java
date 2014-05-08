package LOTR;

/**
 * BigTower - tornyok egy tipusa
 * nagyobb toronytipusnak felel meg
 * @author justice_league
 *
 */
public class BigTower extends Tower {
	/**
	 * BigTower konstruktor
	 */
	public BigTower() {
		/**
		 * alapbol nincs konkret pozicioja, azt a Map adja neki setPosition-nel
		 */
		position = new Position();
		/**
		 * 600 varazserobe kerul
		 */
		cost = 600;
		/**
		 * normal tuzeles = 0
		 * gyorsabb tuzeles = 1
		 */
		firingSpeed = 0;
		/**
		 * nagyobb lotav
		 */
	 	firingRange = 2;
		/**
		 * nagyobb tuzero
		 */
	 	firingPower = 8;
	 	/**
	 	 * alapbol nincs rajta ko
	 	 */
		elfOrDwarfFlag = false;
		/**
		 * nullarol indul az orajel termeszetesen
		 */
		tick_counter = 0;
	}

}
