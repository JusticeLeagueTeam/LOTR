package LOTR; 


/**
 * Swamp osztaly a mocsarnak felel meg
 * A konstrutorban beallitott ertek szerint lassitja az ellenfeleket
 * @author justice_league
 *
 */
public class Swamp extends Barrier {
	/**
	 * Swamp osztaly a mocsarnak felel meg
	 * A konstrutorban beallitott ertek szerint lassitja az ellenfeleket
	 */
	public Swamp() {
		/**
		 * alapbol nincs konkret pozicioja, azt a Map adja neki setPosition-nel
		 */
		position = new Position();
		/**
		 * 150 varazserobe kerul
		 */
		cost = 150;
	 	/**
	 	 * alapbol nincs rajta ko
	 	 */
		elfOrDwarfFlag = false;
		/**
		 * kicsit lassitja az ellenfelet
		 */
		retardingValue = 1;
	}

}