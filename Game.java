package LOTR;

/**Game osztaly, ososztalya nincsen, jatek "mozgasat" biztositja.
 * A jatek lefolyasaert felelos objektum, amelynek a program elindulasakor es a jatek
 * befejezesekor van szerepe. Legfontosabb dolga, hogy amikor a jatekos uj jatekot kezd,
 * letre hozza a Map (palya) objektumot, illetve amikor befejezi, bezarja a programot.
 * @author justice_league Szoftlab4 team
 */
public class Game {

	/** (Map) Palya objektum */
	Map map;
	
	/** (Orajel) Jatek idoziteseert felelos objektum */
	Timer timer;
	
	
	/**A Game osztaly konstruktora, amely egy Game objektum letrehozasakor hivodik meg.
	 * A konstruktor hozza letre a jatek szamara az egyetlen Timer objektumot, amely a
	 * jatek mukodesehez az utemezest nyujtja. Tovabba a Map-et vagyis palya objektumot,
	 * amely a Player, Enemies (szovetsegesek) valamint a jatekos vedelmi eszkozeiert
	 * (DefenseTools) felel.
	 * 
	 * Az objektumok letrejotte utan elinditja a jatek futasat. 
	 */	
	public Game(){
		System.out.println("Game konstruktor - Game objektum letrejott");
		
		
		Timer timer = new Timer();
		Map map = new Map();
		this.startGame();
	}
	
	
	/**Ha a jatekos kikapott, elveszitette a jatekot, elvegzi a szukseges lepeseket.
	 * A jatekos akkor veszit, ha akar egyetlen egy ellenfel is eljut a vegzet hegyehez,
	 * tehat egy Enemy leszarmazott (Elf, Dwarf, Hobbit, Human) eljut a celba. 
	 */
	public void endGame() {
		System.out.println("Game endGame - A jatekos veszitett, jatek vege");
	}
	
	
	/**A jatek indulasakor letrehozza a szukseges objektumokat, beallitja az attributumokat. 
	*/
	public void startGame() {
		System.out.println("Game startGame - A jatek elindult");
	}

	
	/**Abban az esetben hivodik meg, amennyiben a jatekos nyert, gyozott.
	 * A jatekos akkor nyer, ha az osszes Enemy leszarmazottat (Elf, Dwarf, Hobbit, Human)
	 * sikerult elpusztitania, tehat az ellenfelek szama nulla (enemies.Count()==0).
	 *  (a szamuk korlatozott, veges, igy idovel biztos elfogynak)
	 */
	public void winGame() {
		System.out.println("Game wingame - A jatekos nyert, jatek vege");
		
		if(Map.enemies.isEmpty())
		{
			//WIN
		}
	}
	
	
	/**A Timer osztaly szinten tick() nevu metodusa hivja meg ezt egy orajel eltelte utan.
	 * Az orajel eltelte utan a metodus meghivasakor ellenorzi, hogy a jatekos nyert
	 * vagy veszitett-e mar.
	 */
	public void tick() {
		System.out.println("Game tick - Orajelre ellenorzi, hogy a jatekos nyert vagy veszitett");
	}


}
