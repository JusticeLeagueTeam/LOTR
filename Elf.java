package LOTR;


/**
 * Elf - ellenfelek egy tipusa
 * @author justice_league
 *
 */
public class Elf extends Enemy {
	/**
	 * Elf - ellenfelek egy tipusa
	 */
	public Elf() {
		/**
		 * eletereje kozepes
		 */
		health = 100;
		/**
		 * sebessege gyors, furge faj
		 */
		speed = 4;
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