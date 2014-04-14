package LOTR;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Random;

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
	
	/** A letrehozhato ellenfelek maximalis szamat adja meg. */
	public static int totalNumberOfEnemies;
	
	/** A tick_counter akkori erteke, amikor legutoljara
	 * hoztunk letre ellenfelet.
	 */
	public static int lastTickValueWhenEnemyWasCreated;
	
	
	/**A Map osztaly konstruktora, amely egy Map objektum letrehozasakor hivodik meg. 
	 * A konstruktor hozza letre a Jatekost (Player) reprezentalo objektumot, amelyet a 
	 * jatek soran vegig hasznalunk. 
	 * A konstruktor hozza letre azon adatszerkezeteket amelyekben taroljuk a 
	 * palyan levo Enemy leszarmazottakat (Elf, Dwarf, Hobbit, Human), valamint
	 * a DefenseTool (vedelmi eszkoz) leszarmazottakat mint tornyok, akadalyok, varazskovek.
	 * Inicializalja az orajel szamlalot (tick_counter).
	 */
	public Map(){	
		
		player=new Player();
		enemies=new LinkedList<Enemy>();
		towers=new LinkedList<Tower>();
		barriers=new LinkedList<Barrier>();
		magicStones=new LinkedList<MagicStone>();		
		tick_counter=0;
		tickFlag=0;
		totalNumberOfEnemies=20;
		lastTickValueWhenEnemyWasCreated=0;
		
	}
	
	
	/** Az ellenfeleket tarolo adatszerkezetet lehet lekerdezni. (enemies getter metodus)
	 * enemies getter metodusa.
	 * @return LinkedList Az ellenfeleket tarolo adatszerkezettel(enemies) ter vissza (adja vissza).
	 */
	public static  LinkedList getEnemies() { 
		
		return enemies;
	}
	
	
	/** Az ellenfeleket tarolo adatszerkezet "beallitasa". (enemies setter metodus)
	 * enemies setter metodusa.
	 * @param enemies Egy az ellenfeleket tarolo adatszerkezetet kap parameterkent.
	 */
	public static void setEnemies(LinkedList Enemies) {
		
		enemies = Enemies;
		}
	
	
	/** Ellenfelek letrehozasara szolgalo metodus. 
	 * A jatek soran az ido elore haladasaval (tick_counter erteke no)
	 * egyre gyorsabban egyre tobb ellenfel generalodik, de az ossz szamuk veges,
	 * igy csak korlatozott szamban johetnek letre a jatek soran.
	 * A generalt ellenfelek osszetetele valtozhat.
	 */
	public static void createEnemy(){
		
		//Ha a meg legyarthato ellenfelek szama nagyobb mint nulla
		//akkor meg letrehozhatunk ujabbakat
		if(totalNumberOfEnemies > 0)
		{
			//Random generatorral hozunk letre ellenfeleket
			//Egy alkalommal mindig ketto darabot
			Random rand = new Random();
			int randomNumber1 = rand.nextInt(4);
			int randomNumber2 = rand.nextInt(4);
			
			//0 - Human
			//1 - Hobbit
			//2 - Dwarf
			//3 - Elf
			
			//Ha a jatek elejen jarunk, az elso tick_count intervallumban
			if((tick_counter > 0) && (tick_counter <= 50))
			{							
				//Ha az utolso letrehozas ota eltelt megfelelo mennyisegu tick
				if(tick_counter - lastTickValueWhenEnemyWasCreated == 20)
				{					
					//Elso ellenfel tipusanak megallapitasa majd generalasa
					if(randomNumber1 == 0)
					{
						enemies.add(new Human());
					}
					if(randomNumber1 == 1)
					{
						enemies.add(new Hobbit());
					}
					if(randomNumber1 == 2)
					{
						enemies.add(new Dwarf());
					}
					if(randomNumber1 == 3)
					{
						enemies.add(new Elf());
					}
					
					//Masodik ellenfel tipusanak megallapitasa majd generalasa
					if(randomNumber2 == 0)
					{
						enemies.add(new Human());
					}
					if(randomNumber2 == 1)
					{
						enemies.add(new Hobbit());
					}
					if(randomNumber2 == 2)
					{
						enemies.add(new Dwarf());
					}
					if(randomNumber2 == 3)
					{
						enemies.add(new Elf());
					}
				}
			}
			
			//Ha a jatekban a masodik tick intervallumban jarunk
			if((tick_counter > 50) && (tick_counter <= 100))
			{							
				//Ha az utolso letrehozas ota eltelt megfelelo mennyisegu tick
				if(tick_counter - lastTickValueWhenEnemyWasCreated == 15)
				{					
					//Elso ellenfel tipusanak megallapitasa majd generalasa
					if(randomNumber1 == 0)
					{
						enemies.add(new Human());
					}
					if(randomNumber1 == 1)
					{
						enemies.add(new Hobbit());
					}
					if(randomNumber1 == 2)
					{
						enemies.add(new Dwarf());
					}
					if(randomNumber1 == 3)
					{
						enemies.add(new Elf());
					}
					
					//Masodik ellenfel tipusanak megallapitasa majd generalasa
					if(randomNumber2 == 0)
					{
						enemies.add(new Human());
					}
					if(randomNumber2 == 1)
					{
						enemies.add(new Hobbit());
					}
					if(randomNumber2 == 2)
					{
						enemies.add(new Dwarf());
					}
					if(randomNumber2 == 3)
					{
						enemies.add(new Elf());
					}
				}
			}
			
			//TODO: tovabbi intervallumokat megcsinalni, de ehhez
			//a tobbiekkel kell egyeztetni a konkret ertekekrol
			//Tovabbi tick intervallumok definialhatoak
		}
		
	}

	
	/** A jatek indulasa ota eltelt orajelek szamanak lekerdezese (tick_counter) 
	 * tick_counter getter metodusa.
	 * @return int A jatek kezdete ota eltelt orajelek szamat adja vissza.
	 */
	public static int getTickCount() {
		
		return tick_counter;
	}
	
	
	/**A jatek kezdete ota eltelt orajelek szamat tarolo szamlalo "beallitasa" (novelese).
	 * tick_counter setter metodusa.
	 * @param tickCount Az ertek amelyre az orajel szamlalot bekivanjuk allitani.
	 */
	public static void setTickCount(int tickCount) {
		
		tick_counter=tickCount;
	}

	/**A tornyokat tarolo adatszerkezetet lehet lekerdezni.
	 * towers getter metodusa.
	 * @return A tornyokat tarolo adatszerkezetet adja vissza.
	 */
	public static LinkedList getTowers() {
		
		return towers;
	}

	/**A tornyokat tarolo adatszerkezet "beallitasa".
	 * towers setter metodusa.
	 * @param towers A tornyokat tarolo adatszerkezet beallitasa(atadasa).
	 */
	public static void setTowers(LinkedList Towers) {
		
		towers = Towers;
	}

	/**Az akadalyokat tarolo adatszerkezetet lehet lekerdezni.
	 * barriers getter metodusa.
	 * @return LinkedList Az akadalyokat tarolo adatszerkezetet adja vissza.
	 */
	public static LinkedList getBarriers() {
		
		return barriers;
	}

	
	/**Az akadalyokat tarolo adatszerkezet "beallitasa".
	 * barriers setter metodusa.
	 * @param barriers Az akadalyokat tarolo adatszerkezet beallitasa(atadasa).
	 */
	public static void setBarriers(LinkedList Barriers) {
		
		barriers = Barriers;
	}
	
	
	/**A varazskoveket tarolo adatszerkezet lekerdezese.
	 * magicStones getter metodusa.
	 * @return A varazskoveket tarolo adatszerkezetet adja vissza.
	 */
	public static LinkedList getMagicStones() { 
		
		return magicStones;
	}
	
	
	/**A varazskoveket tarolo adatszerkezet "beallitasa".
	 * magicStones setter metodusa.
	 * @param magicStones A varazskoveket tarolo adatszerkezet beallitasa(atadasa)
	 */
	public static void setMagicStones(LinkedList MagicStones) {
		
		magicStones = MagicStones;
	}

	
	/**A generalt ellenfelek lepteteseert felelo metodus.
	 * Paraméterként megkapja az ellenfel helyzetet, majd az alapjan kiszamitja, hogy melyik mezo
	 * a kovetkezo, ahova lepnie kell a kovetkezo orajel ciklusban.
	 * @param position Az ellenfel aktualis pozicioja a palyan (cella, mezo)
	 * @return Az uj cella helyzete, ahova az ellenfelek lepnie kell.
	 */
	public static Position enemyStep(Position position) {
		
		//TODO: amig nincs palya adatszerkezet, addig nem tudom a leptetest megcsinalni
		
		return new Position();
	}

	
	/**A Timer-tol erkezo orajelre ellenorzi, hogy szukseges-e uj ellenfel generalasa.
	 */
	public static void tick() {
		
		createEnemy();

	}

}
