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
	
	
	/** A palyat tarolo adatszerkezet, ket dimenzios Position matrix formaban */
	public static Position[][] mainMap;
	
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
		
		//A palyat tarolo adatszerkezet letrehozasa, valamint
		//mindegyik Position peldany sor es oszlop attributumanak feltoltese
		mainMap = new Position[25][25];				
		for(int i = 0; i < 25; i++)
		{
			for(int j = 0; j < 25; j++)
			{
				mainMap[i][j] = new Position();
				mainMap[i][j].setRowValue(i);
				mainMap[i][j].setColumnValue(j);
				mainMap[i][j].setRoadFlag(false);
			}
		}
		
		//A palyan utnak jelolt cellak beallitasa
		//0. sor
		for(int k=21; k<25; k++)
		{
			mainMap[0][k].setRoadFlag(true);
		}
		
		//1.sor
		mainMap[0][21].setRoadFlag(true);
		mainMap[0][23].setRoadFlag(true);
		mainMap[0][24].setRoadFlag(true);
		
		//2.sor
		for(int k=0; k<6; k++)
		{
			mainMap[2][k].setRoadFlag(true);
		}
		mainMap[2][21].setRoadFlag(true);
		mainMap[2][24].setRoadFlag(true);
		
		//3.sor
		mainMap[3][5].setRoadFlag(true);
		for(int k=14; k<20; k++)
		{
			mainMap[3][k].setRoadFlag(true);
		}
		mainMap[3][21].setRoadFlag(true);
		mainMap[3][24].setRoadFlag(true);
		
		//4.sor
		mainMap[4][5].setRoadFlag(true);
		mainMap[4][14].setRoadFlag(true);
		mainMap[4][19].setRoadFlag(true);
		mainMap[4][21].setRoadFlag(true);
		mainMap[4][24].setRoadFlag(true);
		
		//5.sor
		mainMap[5][5].setRoadFlag(true);
		mainMap[5][14].setRoadFlag(true);
		mainMap[5][19].setRoadFlag(true);
		mainMap[5][21].setRoadFlag(true);
		mainMap[5][24].setRoadFlag(true);
		
		//6.sor
		for(int k=5; k<15; k++)
		{
			mainMap[6][k].setRoadFlag(true);
		}
		for(int k=16; k<20; k++)
		{
			mainMap[6][k].setRoadFlag(true);
		}
		for(int k=21; k<25; k++)
		{
			mainMap[6][k].setRoadFlag(true);
		}
		
		//7.sor
		mainMap[7][11].setRoadFlag(true);
		mainMap[7][16].setRoadFlag(true);
		for(int k=19; k<22; k++)
		{
			mainMap[7][k].setRoadFlag(true);
		}
		mainMap[7][23].setRoadFlag(true);
		
		//8.sor
		mainMap[8][11].setRoadFlag(true);
		mainMap[8][16].setRoadFlag(true);
		mainMap[8][17].setRoadFlag(true);
		mainMap[8][19].setRoadFlag(true);
		mainMap[8][23].setRoadFlag(true);
		
		//9.sor
		mainMap[9][11].setRoadFlag(true);
		mainMap[9][17].setRoadFlag(true);
		mainMap[9][19].setRoadFlag(true);
		mainMap[9][23].setRoadFlag(true);
		
		//10.sor
		for(int k=3; k<6; k++)
		{
			mainMap[10][k].setRoadFlag(true);
		}
		mainMap[10][11].setRoadFlag(true);
		mainMap[10][17].setRoadFlag(true);
		mainMap[10][19].setRoadFlag(true);
		mainMap[10][23].setRoadFlag(true);
		
		//11.sor
		mainMap[11][3].setRoadFlag(true);
		mainMap[11][5].setRoadFlag(true);
		for(int k=7; k<12; k++)
		{
			mainMap[11][k].setRoadFlag(true);
		}
		for(int k=17; k<19; k++)
		{
			mainMap[11][k].setRoadFlag(true);
		}
		mainMap[11][23].setRoadFlag(true);
		
		//12.sor
		mainMap[12][3].setRoadFlag(true);
		mainMap[12][5].setRoadFlag(true);
		mainMap[12][7].setRoadFlag(true);
		mainMap[12][18].setRoadFlag(true);
		mainMap[12][23].setRoadFlag(true);
		
		//13.sor
		for(int k=0; k<4; k++)
		{
			mainMap[13][k].setRoadFlag(true);
		}
		mainMap[13][5].setRoadFlag(true);
		mainMap[13][7].setRoadFlag(true);
		for(int k=10; k<14; k++)
		{
			mainMap[13][k].setRoadFlag(true);
		}
		for(int k=18; k<24; k++)
		{
			mainMap[13][k].setRoadFlag(true);
		}
		
		//14.sor
		mainMap[14][5].setRoadFlag(true);
		mainMap[14][7].setRoadFlag(true);
		mainMap[14][10].setRoadFlag(true);
		mainMap[14][13].setRoadFlag(true);
		mainMap[14][23].setRoadFlag(true);
		
		//15.sor
		for(int k=5; k<8; k++)
		{
			mainMap[15][k].setRoadFlag(true);
		}
		mainMap[15][10].setRoadFlag(true);
		for(int k=12; k<15; k++)
		{
			mainMap[15][k].setRoadFlag(true);
		}
		mainMap[15][23].setRoadFlag(true);
		
		//16.sor
		mainMap[16][7].setRoadFlag(true);
		mainMap[16][10].setRoadFlag(true);
		mainMap[16][12].setRoadFlag(true);
		for(int k=15; k<21; k++)
		{
			mainMap[16][k].setRoadFlag(true);
		}
		mainMap[16][23].setRoadFlag(true);
		
		//17.sor
		mainMap[17][7].setRoadFlag(true);
		mainMap[17][10].setRoadFlag(true);
		mainMap[17][12].setRoadFlag(true);
		for(int k=20; k<24; k++)
		{
			mainMap[17][k].setRoadFlag(true);
		}
		
		//18.sor
		for(int k=7; k<11; k++)
		{
			mainMap[18][k].setRoadFlag(true);
		}
		mainMap[18][12].setRoadFlag(true);
		
		//19.sor
		mainMap[19][8].setRoadFlag(true);
		for(int k=12; k<19; k++)
		{
			mainMap[19][k].setRoadFlag(true);
		}
		
		//20.sor
		mainMap[20][8].setRoadFlag(true);
		mainMap[20][14].setRoadFlag(true);
		mainMap[20][18].setRoadFlag(true);
		
		//21.sor
		mainMap[21][8].setRoadFlag(true);
		mainMap[21][14].setRoadFlag(true);
		mainMap[21][18].setRoadFlag(true);
		
		//22.sor
		mainMap[22][8].setRoadFlag(true);
		mainMap[22][14].setRoadFlag(true);
		mainMap[22][18].setRoadFlag(true);
		
		//23.sor
		for(int k=8; k<15; k++)
		{
			mainMap[23][k].setRoadFlag(true);
		}
		mainMap[23][18].setRoadFlag(true);
		
		//24.sor
		mainMap[24][18].setRoadFlag(true);
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
	public static Position enemyStep(Position actualPosition, Position lastPosition) {
		
		LinkedList<Position> positionList = new LinkedList<Position>();
		
		//Az ellenfel pozicioja koruli cellak roadFlag attributumanak ellenorzese kereszt alakban
		//		| |
		//	  == X ==
		//		| |
		
		//A keresztiranyu mozgas miatt, maximum 4 ut lehet egy keresztezodesben
		//A 4 ut kozul az egyik iranybol erkezett, tehat maximum 3 elem kerulhet a listaba
		//az egyik ut, biztosan az egyik korabbi utvonal volt
		
		//Ha nem keresztezodesben van, es csak elore mehet egy iranyban
		//akkor csak az egyik ag fog vegrehajtodni, es egy elemu lesz a lista
		
		//Ha az adott cella folotti sorban levo cella is ut
		if(Map.mainMap[actualPosition.getRowValue()-1][actualPosition.getColumnValue()].getRoadFlag() == true)
		{
			//Ha az utolso cella pozicioja megegyezik az aktualis pozicioja
			//folotti cellaval, akkor oda mar nem lephet
			if((lastPosition.getRowValue() == actualPosition.getRowValue()-1) && (lastPosition.getColumnValue() == actualPosition.getColumnValue()))
			{
				//DO NOTHING
			}
			//Ha nem egyezik meg, akkor ez egy lehetseges irany ahova lephet
			else
			{
				Position tmp = new Position();
				tmp.setRowValue(actualPosition.getRowValue()-1);
				tmp.setColumnValue(actualPosition.getColumnValue());
				tmp.setRoadFlag(true);
				positionList.add(tmp);
			}
		}
		
		//Ha az adott cellatol balra levo cella is ut (egyel kisebb oszlopban de azonos sorban)
		if(Map.mainMap[actualPosition.getRowValue()][actualPosition.getColumnValue()-1].getRoadFlag() == true)
		{
			//Ha az utolso cella pozicioja megegyezik az aktualis pozicioja
			//melletti baloldali cellaval, akkor oda mar nem lephet
			if((lastPosition.getRowValue() == actualPosition.getRowValue()) && (lastPosition.getColumnValue() == actualPosition.getColumnValue()-1))
			{
				//DO NOTHING
			}
			//Ha nem egyezik meg, akkor ez egy lehetseges irany ahova lephet
			else
			{
				Position tmp = new Position();
				tmp.setRowValue(actualPosition.getRowValue());
				tmp.setColumnValue(actualPosition.getColumnValue()-1);
				tmp.setRoadFlag(true);
				positionList.add(tmp);
			}
		}
		
		//Ha az adott cellatol jobbra levo cella is ut
		if(Map.mainMap[actualPosition.getRowValue()][actualPosition.getColumnValue()+1].getRoadFlag() == true)
		{
			//Ha az utolso cella pozicioja megegyezik az aktualis pozicioja
			//melletti jobboldali cellaval, akkor oda mar nem lephet
			if((lastPosition.getRowValue() == actualPosition.getRowValue()) && (lastPosition.getColumnValue() == actualPosition.getColumnValue()+1))
			{
				//DO NOTHING
			}
			//Ha nem egyezik meg, akkor ez egy lehetseges irany ahova lephet
			else
			{
				Position tmp = new Position();
				tmp.setRowValue(actualPosition.getRowValue());
				tmp.setColumnValue(actualPosition.getColumnValue()+1);
				tmp.setRoadFlag(true);
				positionList.add(tmp);
			}
		}
		
		//Ha az adott cella alatti sorban levo cella is ut (egyel nagyobb oszlopban)
		if(Map.mainMap[actualPosition.getRowValue()+1][actualPosition.getColumnValue()].getRoadFlag() == true)
		{
			//Ha az utolso cella pozicioja megegyezik az aktualis pozicioja
			//alatti cellaval, akkor oda mar nem lephet
			if((lastPosition.getRowValue() == actualPosition.getRowValue()+1) && (lastPosition.getColumnValue() == actualPosition.getColumnValue()))
			{
				//DO NOTHING
			}
			else
			{
				Position tmp = new Position();
				tmp.setRowValue(actualPosition.getRowValue()+1);
				tmp.setColumnValue(actualPosition.getColumnValue());
				tmp.setRoadFlag(true);
				positionList.add(tmp);
			}
		}
		
		//Ha valamelyik keresztezodesnel egy masik ellenfel utjan visszafele
		//megy tovabb, es eler a palya szelehez, tehat az aktualis pozicioja 
		//a palya bal oldalso oszlopaban vmelyik cella vagy a legalso sorban
		//akkor az egyik fenti IF ag sem tud lefutni, tehat a listaban 0 elem lesz
		//Ha a listaban 0 elem van, akkor a palya szelen van az ellenfel, igy
		//a kovetkezo lepesben lelepne a palyarol, tehat az ellenfel torolheto
		
		//Ez fogja az uj cella sorszamat megadni a listaban Random alapjan
		int elementIndex = 0;
		
		if(positionList.size() == 0)
		{
			//Vegig iteralunk az ellenfeleket tarolo adatszerkezeten
			//hogy megkeressuk ezt az ellenfelet pozicio alapjan
			for(Enemy e : Map.enemies)
			{
				Position tmp = e.getPosition();
				
				//Ahol az ellenfel pozicioja megegyezik a parameterkent kapott
				//aktualis cella pozicioval, azt az ellenfelet toroljuk a listabol
				if((tmp.getRowValue() == actualPosition.getRowValue()) && (tmp.getColumnValue() == actualPosition.getColumnValue()))
				{
					Map.enemies.remove(e);
				}
			}
		}
		else
		{
			//Random szam generalas az ut kivalasztasahoz
			//a listaban levo elemek szamatol fuggoen			
			Random rand = new Random();
			
			//Ha csak egy uj pozicio van a listaban, akkor csak arra mehet
			if(positionList.size() == 1)
			{
				//Ekkor az egyetlen, 0-as indexu elemet kell kivenni
				elementIndex = 0;
			}
			
			if(positionList.size() == 2)
			{
				//Ekkor rand 0 vagy 1 lesz
				elementIndex = rand.nextInt(2);
			}
			
			if(positionList.size() == 3)
			{
				//Ekkor rand 0,1,2 lehet
				elementIndex = rand.nextInt(3);
			}
		}
		
		return positionList.get(elementIndex);
	}

	
	/**A Timer-tol erkezo orajelre ellenorzi, hogy szukseges-e uj ellenfel generalasa.
	 */
	public static void tick() {
		
		//Protohoz kikommenteltem a megbeszeltek szerint, GUI-hoz visszakerul
		//createEnemy();
		tick_counter++;

	}
}
