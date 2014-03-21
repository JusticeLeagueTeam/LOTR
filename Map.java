package LOTR;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**A palyara vonatkozo legfontosabb informaciokat tarolja, ellenfelek, vedelmi eszkozok, utvonalak, cel.
 * Tarolja a palya felepiteset, azon hol talalhatoak az utvonalak illetve
 * hova epithetoek vedelmi egysegek (SmallTower, BigTower) illetve helyezhetoek
 * el akadalyok (Swamp, ShiftingSand).
 * Tarolja a palyan levo ellenfeleket (Enemy leszarmazottak),
 * az elhelyezett tornyokat (Tower) es akadalyokat (Barrier), valamint
 * a varazskoveket (MagicStone).
 * Tovabba kezeli az objektumok egymasra gyakorolt hatasait.
 * @author justice_league Szoftlab4 team
 */
public class Map {

	/** A Timer altal a jatek kezdete ota kiadott orajelek szamat tarolja */
	private static int tick_counter;
	
	/** A jatekost reprezentalo objektum.
	 * Statikus, mivel egy van belole, es mindenkinek ezt az egyet kell hasznalnia.
	 */
	public static Player player;
	
	
	/** Az aktualisan a palyan levo Ellenfelek, Tornyok, Akadalyok, Varazskovek tarolasa.*/
	/** Az ellenfeleket (szovetsegesek) tarolo adatszerkezet. */
	public static LinkedList<Enemy> enemies;
	
	/** A tornyokat tarolo adatszerkezet. */
	public static LinkedList<Tower> towers;
	
	/** Az akadalyokat tarolo adatszerkezet. */
	public static LinkedList<Barrier> barriers;
	
	/** A varazskoveket tarolo adatszerkezet. */
	public static LinkedList<MagicStone> magicStones;
	
	public static int tickFlag;
	
	
	/**A Map osztaly konstruktora, amely egy Map objektum letrehozasakor hivodik meg. 
	 * A konstruktor hozza letre a Jatekost (Player) reprezentalo objektumot, amelyet a 
	 * jatek soran vegig hasznalunk. 
	 * A konstruktor hozza letre azon adatszerkezeteket amelyekben taroljuk a 
	 * palyan levo Enemy leszarmazottakat (Elf, Dwarf, Hobbit, Human), valamint
	 * a DefenseTool (vedelmi eszkoz) leszarmazottakat mint tornyok, akadalyok, varazskovek.
	 * Inicializalja az orajel szamlalot (tick_counter).
	 */
	public Map(){
		System.out.println("Map konstruktor - Map objektum letrejott");
		
		
		player=new Player();
		enemies=new LinkedList<Enemy>();
		towers=new LinkedList<Tower>();
		barriers=new LinkedList<Barrier>();
		magicStones=new LinkedList<MagicStone>();		
		tick_counter=0;
		tickFlag=0;
		
	}
	
	
	/** Az ellenfeleket tarolo adatszerkezetet lehet lekerdezni. (enemies getter metodus)
	 * enemies getter metodusa.
	 * @return LinkedList Az ellenfeleket tarolo adatszerkezettel(enemies) ter vissza (adja vissza).
	 */
	public static  LinkedList getEnemies() { 
		System.out.println("Map getEnemies - ellenfeleket tarolo adatszerkezet lekerdezese");
		return enemies;
	}
	
	
	/** Az ellenfeleket tarolo adatszerkezet "beallitasa". (enemies setter metodus)
	 * enemies setter metodusa.
	 * @param enemies Egy az ellenfeleket tarolo adatszerkezetet kap parameterkent.
	 */
	public static void setEnemies(LinkedList Enemies) {
		System.out.println("Map - setEnemies - ellenfeleket tarolo adatszerkezet beallitasa");
		enemies = Enemies;
		}
	
	
	/** Ellenfelek letrehozasara szolgalo metodus. 
	 * A jatek soran az ido elore haladasaval (tick_counter erteke no)
	 * egyre gyorsabban egyre tobb ellenfel generalodik, de az ossz szamuk veges,
	 * igy csak korlatozott szamban johetnek letre a jatek soran.
	 * A generalt ellenfelek osszetetele valtozhat.
	 */
	public static void createEnemy(){
		System.out.println("Map createEnemy - Ellenfel letrehozasa");
		
		enemies.add(new Elf());	
	}

	
	/** A jatek indulasa ota eltelt orajelek szamanak lekerdezese (tick_counter) 
	 * tick_counter getter metodusa.
	 * @return int A jatek kezdete ota eltelt orajelek szamat adja vissza.
	 */
	public static int getTickCount() {
		System.out.println("Map getTickCount - Az orajelek szamat visszaadja");
		return tick_counter;
	}
	
	
	/**A jatek kezdete ota eltelt orajelek szamat tarolo szamlalo "beallitasa" (novelese).
	 * tick_counter setter metodusa.
	 * @param tickCount Az ertek amelyre az orajel szamlalot bekivanjuk allitani.
	 */
	public static void setTickCount(int tickCount) {
		System.out.println("Map setTickCount - A jatek kezdete ota eltelt orajel szamanak beallitasa (novelese)");
		tick_counter=tickCount;
	}

	/**A tornyokat tarolo adatszerkezetet lehet lekerdezni.
	 * towers getter metodusa.
	 * @return A tornyokat tarolo adatszerkezetet adja vissza.
	 */
	public static LinkedList getTowers() {
		System.out.println("Map getTowers - A tornyokat tarolo adatszerkezet lekerdezese");
		return towers;
	}

	/**A tornyokat tarolo adatszerkezet "beallitasa".
	 * towers setter metodusa.
	 * @param towers A tornyokat tarolo adatszerkezet beallitasa(atadasa).
	 */
	public static void setTowers(LinkedList Towers) {
		System.out.println("Map setTowers - A tornyokat tarolo adatszerkezet beallitasa");
		towers = Towers;
	}

	/**Az akadalyokat tarolo adatszerkezetet lehet lekerdezni.
	 * barriers getter metodusa.
	 * @return LinkedList Az akadalyokat tarolo adatszerkezetet adja vissza.
	 */
	public static LinkedList getBarriers() {
		System.out.println("Map getBarriers - Az akadalyokat tarolo adatszerkezet lekerdezese");
		return barriers;
	}

	
	/**Az akadalyokat tarolo adatszerkezet "beallitasa".
	 * barriers setter metodusa.
	 * @param barriers Az akadalyokat tarolo adatszerkezet beallitasa(atadasa).
	 */
	public static void setBarriers(LinkedList Barriers) {
		System.out.println("Map setBarriers - Az akadalyokat tarolo adatszerkezet beallitasa");
		barriers = Barriers;
	}
	
	
	/**A varazskoveket tarolo adatszerkezet lekerdezese.
	 * magicStones getter metodusa.
	 * @return A varazskoveket tarolo adatszerkezetet adja vissza.
	 */
	public static LinkedList getMagicStones() { 
		System.out.println("Map getMagicStones - A varazskoveket tarolo adatszerkezet lekerdezese");
		return magicStones;
	}
	
	
	/**A varazskoveket tarolo adatszerkezet "beallitasa".
	 * magicStones setter metodusa.
	 * @param magicStones A varazskoveket tarolo adatszerkezet beallitasa(atadasa)
	 */
	public static void setMagicStones(LinkedList MagicStones) {
		System.out.println("Map setMagicStones - A varazskoveket tarolo adatszerkezet beallitasa");
		magicStones = MagicStones;
	}

	
	/**A generalt ellenfelek lepteteseert felelo metodus.
	 * Paraméterként megkapja az ellenfel helyzetet, majd az alapjan kiszamitja, hogy melyik mezo
	 * a kovetkezo, ahova lepnie kell a kovetkezo orajel ciklusban.
	 * @param position Az ellenfel aktualis pozicioja a palyan (cella, mezo)
	 * @return Az uj cella helyzete, ahova az ellenfelek lepnie kell.
	 */
	public static Position enemyStep(Position position) {
		System.out.println("Map enemyStep - Az ellenfel aktualis pozicioja alapjan kiszamitja az uj poziciojat ahova lephet");
		return new Position();
	}

	
	/**A Timer-tol erkezo orajelre ellenorzi, hogy szukseges-e uj ellenfel generalasa.
	 */
	public static void tick() {
		System.out.println("Map tick - Beerkezo orajel hatasara ellenorzi, hogy szukseges-e ellenfelet generalni, leptetni");
		System.out.println("Map tick (dokumentacio 5.3.2) - Meghivja az Enemy tick() metodusat, amely hatasara az Enemy tick() metodusa visszahivja a Map enemyStep() metodusat, hogy megtudja, hova lephet");
		System.out.println("Map tick (dokumentacio 5.3.3) - Meghivja a Tower es Enemy tick() metodusat");
		
		if(tickFlag==1)
		{
			System.out.println("[IF]Letelt-e eleg tick(orajel) uj ellenseg generalasahoz? (y/n )");
			System.out.println("input:");
			BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			try {
				line = buff.readLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			if(line.equals("y")){
				createEnemy();
			}
			
		}
		if(tickFlag==2)
		{
        	LinkedList<Enemy> enemiesLinkedList= Map.getEnemies();
        	if(enemiesLinkedList.size() == 0)
        	{
        		System.out.println("Meg nem jott letre enemy(ellenfel) igy nem tud lepni");
        	}
        	else
        	{
	        	Game.timer.tick();
        		for(Enemy e : enemiesLinkedList)
	        	{
	        		e.tick();
	        	}
        	}
		}
		if(tickFlag==3)
		{
			
		}
		
		

		//System.out.println("Ha move-rol(lepes) van szo es nem szukseges uj enemy-t(ellenseg) letrehozni, akkor  n  karaktert gepeljen be, egyebkent  y -t!");
		
		

	}

}
