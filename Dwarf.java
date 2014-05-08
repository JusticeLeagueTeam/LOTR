package LOTR;

/**
 * Dwarf - ellenfelek egy tipusa
 * torpenek felel meg
 * @author justice_league
 *
 */
public class Dwarf extends Enemy {
	/**
	 * Dwarf - ellenfelek egy tipusa
	 */
	public Dwarf() {
		/**
		 * eletereje nagy, eros pancelja van
		 */
		health = 120;
		/**
		 * sok pancel es alacsony termet miatt lassu
		 */
		speed = 6;
		/**
		 * konkret kezdopoziciojat a Map adja meg
		 */
		position = new Position();
		/**
		 * ennyit nyer a jatekos ha megoli
		 */
		magicPowerGain = 120;
		/**
		 * alapbol nulla az orajel
		 */
		tick_counter = 0;
	}

}