package LOTR; 

import java.util.LinkedList;
import java.util.Random;

import javax.swing.JOptionPane;



/**Game osztaly, ososztalya nincsen, jatek "mozgasat" biztositja.
 * A jatek lefolyasaert felelos objektum, amelynek a program elindulasakor es a jatek
 * befejezesekor van szerepe. Legfontosabb dolga, hogy amikor a jatekos uj jatekot kezd,
 * letre hozza a Map (palya) objektumot, illetve amikor befejezi, bezarja a programot.
 * @author justice_league Szoftlab4 team
 */
public class Game {

	/** (Map) Palya objektum */
	public static Map map;

	/** (Orajel) Jatek idoziteseert felelos objektum */
	public static MyTimer timer;

	/** A jatek allapotat jelzo flag, 4 allapotot tud jelezni.
	 *  0 = A jatek all, meg nem indult el.
	 *  1 = A jatek elindult, startGame() metodus allitja be, a jatek fut.
	 *  2 = A jatekos veszitett, endGame() metodus allitja be, a jatek megallt.
	 *  3 = A jatekos nyert, winGame() metodus allitja be, a jatek megallt.
	 */
	public static int gameStatus;
	/**
	 * Kodot jelzo flag.
	 */
	public static boolean isFog=false;
	/**
	 * Kod melyik orajelnel jelent meg
	 */
	public static int fogTick=-1;
	/**
	 * Kod print uzenete miatt szukseges flag
	 */
	public static boolean fogPrint=false;
	/**
	 * csak egy szamoljuk ki, hogy a kod (fog) mikor jojjon
	 */
	public static int FogRandom = -1;
	/**
	 * Specialis lovedeket jelzo flag.
	 */
	public static boolean isSpecial=false;


	/**A Game osztaly konstruktora, amely egy Game objektum letrehozasakor hivodik meg.
	 * A konstruktor hozza letre a jatek szamara az egyetlen Timer objektumot, amely a
	 * jatek mukodesehez az utemezest nyujtja. Tovabba a Map-et vagyis palya objektumot,
	 * amely a Player, Enemies (szovetsegesek) valamint a jatekos vedelmi eszkozeiert
	 * (DefenseTools) felel.
	 * 
	 * Az objektumok letrejotte utan elinditja a jatek futasat. 
	 */	
	public Game(){	

		MyTimer timer = new MyTimer();
		Map map = new Map();
		startGame();
		gameStatus = 0;
	}


	/**Ha a jatekos kikapott, elveszitette a jatekot, elvegzi a szukseges lepeseket.
	 * A jatekos akkor veszit, ha akar egyetlen egy ellenfel is eljut a vegzet hegyehez,
	 * tehat egy Enemy leszarmazott (Elf, Dwarf, Hobbit, Human) eljut a celba. 
	 */
	public static void endGame() {

		//Ellenorzom az osszes ellenfelre, hogy barmelyik aktualis
		//pozicioja egybe esik e a cel pozicioval (0,23 ; 0,24; 1,23; 1,24)
		for(Enemy e : Map.enemies)
		{
			//Ha csak egy cellara is ralepett a celt reprezentali 4 kozul akkor vege
			if((e.position.getRowValue() == 0 && e.position.getColumnValue() == 23) ||
					(e.position.getRowValue() == 0 && e.position.getColumnValue() == 24) ||	
					(e.position.getRowValue() == 1 && e.position.getColumnValue() == 23) ||
					(e.position.getRowValue() == 1 && e.position.getColumnValue() == 24))
			{
				/**
				 * vereseg kiirasa
				 */
				JOptionPane.showMessageDialog(null, "A jateknak vege! On vesztett!");
				System.exit(0);
				
				
				//A jatekos veszitett, flag beallitasa.
				gameStatus = 2;
			}
			else
			{
				//DO NOTHING
				//Meg nem erte el egyetlen ellenfel sem a celt
			}
		}	
	}

	/**A jatek indulasakor letrehozza a szukseges objektumokat, beallitja az attributumokat. 
	 */
	public static void startGame() {

		//A jatek elindult, flag beallitasa
		gameStatus = 1;
	}


	/**Abban az esetben hivodik meg, amennyiben a jatekos nyert, gyozott.
	 * A jatekos akkor nyer, ha az osszes Enemy leszarmazottat (Elf, Dwarf, Hobbit, Human)
	 * sikerult elpusztitania, tehat az ellenfelek szama nulla (enemies.Count()==0).
	 *  (a szamuk korlatozott, veges, igy idovel biztos elfogynak)
	 */
	public static void winGame() {
		

		if(Map.enemies.isEmpty() && Map.getTickCount() >= 100)
		{
			//A jatekos nyert, flag beallitasa.
			gameStatus = 3;
			
			JOptionPane.showMessageDialog(null, "A jateknak vege! On nyert!");
			System.exit(0);
		}
	}


	/**A Timer osztaly szinten tick() nevu metodusa hivja meg ezt egy orajel eltelte utan.
	 * Az orajel eltelte utan a metodus meghivasakor ellenorzi, hogy a jatekos nyert
	 * vagy veszitett-e mar.
	 */
	public static void tick() {
		/**
		 * kod kezdo tick-jenek beallitasa
		 */
		Random rand = new Random();
		//ha meg nincs beallitva, akkor a jatek soran egyszer beallitjuk a random kezdoidopontot
		if(Game.FogRandom == -1){
			/**
			 * 30 es 500 kozotti tick
			 */
			Game.FogRandom = rand.nextInt(500) + 30;
			}

		/**
		 * kod beallitasa
		 */
		if(Map.getTickCount() == FogRandom && Game.isFog == false){
			//tesztelesnel 30. ticknel fog leszallni a kod
			//flag-et felkapcsoljuk es elmentjuk a tick-szamot amikor indult
			Game.isFog=true;
			Game.fogTick=Map.getTickCount();
		}
		if(Game.isFog == true && Map.getTickCount() - Game.fogTick == 10){
			//10 msp utan eloszlik a kod
			Game.isFog=false;
			Game.fogTick=-1;
		}
		
		/**
		 * specialis lovedek beallitasa
		 * 10% esellyel lesz specialis lovedek
		 * de csak minimum 50-edik tick utan
		 * ezt a flag-et a Tower osztaly allitja vissza, tamadas utan
		 * igy csak egyetlen tower-nel fog elsulni ami pont jo
		 */
		if(Game.isSpecial == false && rand.nextInt(10) == 1 && Map.getTickCount() >= 50)
			Game.isSpecial=true;


		//Valamit bekene hozza allitani
		winGame();

		endGame();

	}
}
