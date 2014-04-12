package LOTR;


/**
 * ShiftingSand a futohomoknak felel meg
 * A konstruktorban beallitott erteket alapjan lassitja az ellenfelet.
 * @author justice_league
 *
 */
public class ShiftingSand extends Barrier {
	/**
	 * ShiftingSand a futohomoknak felel meg
	 * A konstruktorban beallitott erteket alapjan lassitja az ellenfelet.
	 */
	public ShiftingSand() {
		/**
		 * alapbol nincs konkret pozicioja, azt a Map adja neki setPosition-nel
		 */
		position = new Position();
		/**
		 * 200 varazserobe kerul
		 */
		cost = 200;
	 	/**
	 	 * alapbol nincs rajta ko
	 	 */
		elfOrDwarfFlag = false;
		/**
		 * jobban lassitja az ellenfelet
		 */
		retardingValue = 2;
	}

}