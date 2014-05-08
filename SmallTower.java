package LOTR; 


/**
 * SmallTower a kisebb toronynak felel meg
 * A konstruktorban beallitott ertekek szerint tamadja az ellenfelet.
 * @author justice_league
 *
 */
public class SmallTower extends Tower {
	/**
	 * SmallTower a kisebb toronynak felel meg
	 * A konstruktorban beallitott ertekek szerint tamadja az ellenfelet.
	 */
	public SmallTower() {
		/**
		 * alapbol nincs konkret pozicioja, azt a Map adja neki setPosition-nel
		 */
		position = new Position();
		/**
		 * 400 varazserobe kerul
		 */
		cost = 400;
		/**
		 * normal tuzeles = 0
		 * gyorsabb tuzeles = 1
		 */
		firingSpeed = 0;
		/**
		 * kisebb lotav
		 */
	 	firingRange = 1;
		/**
		 * kisebb tuzero
		 */
	 	firingPower = 1;
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
