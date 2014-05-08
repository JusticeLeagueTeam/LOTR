package LOTR; 


/**
 * Hobbit - Ellenfelek egy fajtaja
 * @author justice_league
 *
 */
public class Hobbit extends Enemy {

	/**
	 * inicializalja az eleterot es a sebesseget
	 */
	public Hobbit() {
		/**
		 * eletereje alacsony
		 */
		health = 80;
		/**
		 * furgen mozog
		 */
		speed = 4;
		/**
		 * konkret kezdopoziciojat a Map adja meg
		 */
		position = new Position();
		/**
		 * ennyit nyer a jatekos ha megoli
		 */
		magicPowerGain = 80;
		/**
		 * alapbol nulla az orajel
		 */
		tick_counter = 0;
	}

}