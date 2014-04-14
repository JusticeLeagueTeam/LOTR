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
	}
	
	
	/**Ha a jatekos kikapott, elveszitette a jatekot, elvegzi a szukseges lepeseket.
	 * A jatekos akkor veszit, ha akar egyetlen egy ellenfel is eljut a vegzet hegyehez,
	 * tehat egy Enemy leszarmazott (Elf, Dwarf, Hobbit, Human) eljut a celba. 
	 */
	public static void endGame() {
		
		//TODO: palya adatszerkezet kell ahhoz, hogy tudjam vizsgalni, hogy
		//valamelyik ellenfel pozicioja egybe esik-e a célpoziciokkal
		
		System.out.println("Game endGame - A jatekos veszitett, jatek vege");
	}
	
	
	/**A jatek indulasakor letrehozza a szukseges objektumokat, beallitja az attributumokat. 
	*/
	public static void startGame() {
		
		
	}

	
	/**Abban az esetben hivodik meg, amennyiben a jatekos nyert, gyozott.
	 * A jatekos akkor nyer, ha az osszes Enemy leszarmazottat (Elf, Dwarf, Hobbit, Human)
	 * sikerult elpusztitania, tehat az ellenfelek szama nulla (enemies.Count()==0).
	 *  (a szamuk korlatozott, veges, igy idovel biztos elfogynak)
	 */
	public static void winGame() {
				
		if(Map.enemies.isEmpty())
		{
			System.out.println("Game wingame - A jatekos nyert, jatek vege");
		}
	}
	
	
	/**A Timer osztaly szinten tick() nevu metodusa hivja meg ezt egy orajel eltelte utan.
	 * Az orajel eltelte utan a metodus meghivasakor ellenorzi, hogy a jatekos nyert
	 * vagy veszitett-e mar.
	 */
	public static void tick() {
		
		//Wingame-hez nem kéne visszatérési érték? vagy csak simán kiprintel es kesz?
		//honnan fogja tudni az egesz rendszer, hogy ott lefutott az IF?
		//Valamit bekene hozza allitani
		winGame();
		
		endGame();
		
	}


}
