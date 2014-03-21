package LOTR;


import java.util.Observable;

/**
 * Ellenfelek osztalya. Map generalja oket az orajel fuggvenyeben. Feladatuk, hogy eljussanak a vegzet hegyehez.
 * Tobb tipusa van: Elf, Dwarf, Human, Hobbit
 * Ezek kulonbozo alapertelmezett tulajdonsagokkal rendelkeznek (sebesseg, eletero)
 * Orajel (tick) alapjan alakul a sebesseguk
 * Minden lepeskor jelzi az Observer minta alapjan ot koveto tornyoknak es akadalyoknak a lepest
 * 
 * @author justice_league
 *
 */
public class Enemy extends Observable {

	/**
	 * eletero
	 */
	private int health;
	/**
	 * sebesseg (tick_counter%speed == 0-nal lep)
	 */
	private int speed;
	/**
	 * jelenlegi pozicio a palyan
	 */
	private Position position;
	/**
	 * ennyi varazserohoz jut a jatekos ha megoli
	 */
	private int magicPowerGain;
	/**
	 * orajelek szama a jatek kezdete ota
	 */
	private int tick_counter;

	/**
	 * visszater az eleterovel
	 * @return visszater az eleterovel
	 */
	public int getHealth() {
		System.out.println("Enemy getHealth - visszater az eleterovel");
		return this.health;
	}

	/**
	 * parameterrel csokkenti az eleterot
	 * @param health parameterrel csokkenti az eleterot
	 */
	public void setHealth(int health) {
		System.out.println("Enemy setHelath - parameterrel csokkenti az eleterot");
		this.health = health;
		
	}

	/**
	 * visszater a sebesseggel
	 * @return visszater a sebesseggel
	 */
	public int getSpeed() {
		System.out.println("Enemy getSpeed - visszater a sebesseggel");
		return this.speed;
	}

	/**
	 * beallitja a sebesseget
	 * @param speed beallitja a sebesseget
	 */
	public void setSpeed(int speed) {
		System.out.println("Enemy setSpeed - beallitja a sebesseget");
		this.speed = speed;
	}

	/**
	 * visszater a pozicioval
	 * @return visszater a pozicioval
	 */
	public Position getPosition() {
		System.out.println("Enemy getPosition - visszater a pozicioval");
		return this.position;
	}

	/**
	 * beallitja a poziciot
	 * @param position beallitja a poziciot
	 */
	public void setPosition(Position position) {
		System.out.println("Enemy setPosition - beallitja a poziciot");
		this.position = position;
	}

	/**
	 * beallitja a nyert varazsero erteket
	 * @return beallitja a nyert varazsero erteket
	 */
	public int getMagicPowerGain() {
		System.out.println("Enemy getMagicPowerGain - beallitja a nyert varazsero erteket");
		return this.magicPowerGain;
	}

	/**
	 * visszater a nyert varazsero ertekevel
	 * @param magicPowerGain visszater a nyert varazsero ertekevel
	 */
	public void setMagicPowerGain(int magicPowerGain) {
		System.out.println("Enemy setMagicPowerGain - visszater a nyert varazsero ertekevel");
		this.magicPowerGain = magicPowerGain;
	}

	/**
	 * orajel metodusa
	 * Map sajat tick() metodusa hivja meg
	 * ket dologert felelos:
	 * - ha megfelelo szamu orajel eltelt akkor lep egyet
	 * - ezt jelzi a ra feliratkozott tornyoknak, akadalyoknak
	 */
	public void tick() {
		System.out.println("Enemy tick ");
		System.out.println("Ha tick_counter megfelel a faj haladasi sebessegenek pl oszthato 5-tel");
		this.setPosition(Map.enemyStep(getPosition()));	
		notifyObservers();
	}
	
	/**
	 * parameter ertekevel csokkenti az eleterot es noveli a varazserot
	 * @param a parameter ertekevel csokkenti az eleterot es noveli a varazserot
	 */
	public void Attacked(int a){
		System.out.println("Enemy Attacked - parameter ertekevel csokkent az eletero es a varazsero");
		setHealth(a);
		Map.player.setMagicPower(a);
	}

}