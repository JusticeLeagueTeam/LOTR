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
	/**konstruktor - poziciot inicializal
	 * 
	 */
	public Enemy(){
		position=new Position();
		this.lastPosition=new Position();
		this.lastPosition.setColumnValue(0);
		this.lastPosition.setRowValue(0);
	}
	/**
	 * konstruktor - pozicio paramterrel
	 * @param row
	 * @param col
	 */
	public Enemy(int row, int col){
		position=new Position();
		lastPosition=new Position();
		lastPosition.setColumnValue(row);
		lastPosition.setRowValue(col);
		position.setColumnValue(row);
		position.setRowValue(col);
	}

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
		//az orajel erteke minden tick()-nel no
		tick_counter++;
		//megfelelo orajel letelte utan lep egyet
		if(tick_counter != 0 && tick_counter % this.getSpeed() == 0 && tick_counter > 2){
			/**
			 * tick nullazasa a lassitas aktivalasa miatt kell
			 * a lenyeg az oszthatosag ugyis
			 */
			tick_counter=0;

			Position temp_pos = new Position();
			//jelenlegi poziciot egy atmeneti valtozoba masoljuk
			temp_pos.setColumnValue(this.position.getColumnValue());
			temp_pos.setRowValue(this.position.getRowValue());
			//lekerjuk a poziciot es a jelenlegit frissitjuk
			this.setPosition(Map.enemyStep(this.position, this.lastPosition));
			//az elozo pozicio a korabban masolt erteket kapja meg
			this.lastPosition.setColumnValue(temp_pos.getColumnValue());
			this.lastPosition.setRowValue(temp_pos.getRowValue());
			//a lepesrol ertesitjuk a tornyokat, akadalyokat
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * parameter ertekevel csokkenti az eleterot es noveli a varazserot
	 * @param a parameter ertekevel csokkenti az eleterot es noveli a varazserot
	 */
	public void Attacked(int a){
		setHealth(getHealth() - a);
		Map.player.setMagicPower(Map.player.getMagicPower() + a/4);
	}
	/**
	 * specialis lovedekkel lett megtamadva az ellenfel
	 * kettehasad, tehat letrejon egy uj ugyanilyen tipusu ellenfel es mindkettonek csokken az erteke
	 */
	public void splitAttacked(int a){
		setHealth(getHealth() - a);
		setHealth(getHealth()/2);

		Map.player.setMagicPower(Map.player.getMagicPower() + a/4);
	}

}
