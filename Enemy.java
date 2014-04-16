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
	protected int health;
	/**
	 * sebesseg (tick_counter%speed == 0-nal lep)
	 */
	protected int speed;
	/**
	 * jelenlegi pozicio a palyan
	 */
	protected Position position;
	/**
	 * elozo pozicio a palyan
	 */
	protected Position lastPosition;
	/**
	 * ennyi varazserohoz jut a jatekos ha megoli
	 */
	protected int magicPowerGain;
	/**
	 * orajelek szama a jatek kezdete ota
	 */
	protected int tick_counter;

	/**
	 * visszater az eleterovel
	 * @return visszater az eleterovel
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * parameterrel csokkenti az eleterot
	 * @param health parameterrel csokkenti az eleterot
	 */
	public void setHealth(int h) {
		health = h;
	}

	/**
	 * visszater a sebesseggel
	 * @return visszater a sebesseggel
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * beallitja a sebesseget
	 * @param speed beallitja a sebesseget
	 */
	public void setSpeed(int s) {
		speed = s;
	}

	/**
	 * visszater a pozicioval
	 * @return visszater a pozicioval
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * beallitja a poziciot
	 * @param position beallitja a poziciot
	 */
	public void setPosition(Position p) {
		position = p;
	}
	/**
	 * visszater az elozo pozicioval
	 * @return visszater a pozicioval
	 */
	public Position getLastPosition() {
		return lastPosition;
	}

	/**
	 * beallitja az elozo poziciot
	 * @param position beallitja a poziciot
	 */
	public void setLastPosition(Position p) {
		lastPosition = p;
	}

	/**
	 * beallitja a nyert varazsero erteket
	 * @return beallitja a nyert varazsero erteket
	 */
	public int getMagicPowerGain() {
		return magicPowerGain;
	}

	/**
	 * visszater a nyert varazsero ertekevel
	 * @param magicPowerGain visszater a nyert varazsero ertekevel
	 */
	public void setMagicPowerGain(int mpg) {
		magicPowerGain = mpg;
	}

	/**
	 * orajel metodusa
	 * Map sajat tick() metodusa hivja meg
	 * harom dologert felelos:
	 * - ha megfelelo szamu orajel eltelt akkor lep egyet
	 * - ezt jelzi a ra feliratkozott tornyoknak, akadalyoknak
	 * - tick_counter ereteket noveli eggyel 
	 */
	public void tick() {
		if(tick_counter % this.getSpeed() == 0){
			this.setPosition(Map.enemyStep(this.position, this.lastPosition));	
			notifyObservers();
		}
		tick_counter++;
	}
	
	/**
	 * parameter ertekevel csokkenti az eleterot es noveli a varazserot
	 * @param a parameter ertekevel csokkenti az eleterot es noveli a varazserot
	 */
	public void Attacked(int a){
		setHealth(getHealth() - a);
		Map.player.setMagicPower(Map.player.getMagicPower() + a);
	}

}
