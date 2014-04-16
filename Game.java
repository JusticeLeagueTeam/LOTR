package LOTR;



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
	public static Timer timer;
	
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
	 * Kod print uzenete miatt szukseges flag
	 */
	public static boolean fogPrint=false;
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
		
		Timer timer = new Timer();
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
				
		if(Map.enemies.isEmpty() && Map.getTickCount() >= 500)
		{
			//A jatekos nyert, flag beallitasa.
			gameStatus = 3;
		}
	}
	
	
	/**A Timer osztaly szinten tick() nevu metodusa hivja meg ezt egy orajel eltelte utan.
	 * Az orajel eltelte utan a metodus meghivasakor ellenorzi, hogy a jatekos nyert
	 * vagy veszitett-e mar.
	 */
	public static void tick() {
		
		//Wingame-hez nem kĂ©ne visszatĂ©rĂ©si Ă©rtĂ©k? vagy csak simĂˇn kiprintel es kesz?
		//honnan fogja tudni az egesz rendszer, hogy ott lefutott az IF?
		//Valamit bekene hozza allitani
		winGame();
		
		endGame();
		
	}
}
