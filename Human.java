package LOTR; 


/**
 *Human osztaly az Enemy leszarmazottja, ember fajt kepviseli.
 *Az ellenfel tipusoknal ot vehetjuk kiindulasi alapnak.
 *Konstruktoraban definialjuk a valtozoinak erteket 
 * @author justice_league
 *
 */
public class Human extends Enemy {

	/**
	 *Human osztaly az Enemy leszarmazottja, ember fajt kepviseli.
	 *Az ellenfel tipusoknal ot vehetjuk kiindulasi alapnak.
	 *Konstruktoraban definialjuk a valtozoinak erteket
	 */
	public Human() {
		/**
		 * eletereje kozepes
		 */
		health = 100;
		/**
		 * sebessge kozepes
		 */
		speed = 5;
		/**
		 * konkret kezdopoziciojat a Map adja meg
		 */
		position = new Position();
		/**
		 * ennyit nyer a jatekos ha megoli
		 */
		magicPowerGain = 100;
		/**
		 * alapbol nulla az orajel
		 */
		tick_counter = 0;
	}

}