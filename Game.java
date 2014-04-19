package LOTR;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;



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
	 * fileMode flag
	 * ha fajlbol vesszuk az input-kat es fajlba irjuk az output-okat akkor true lesz
	 * program indulasakor a Main arugmentumkent kapja meg a fajlneveket
	 */
	public static boolean fileMode=false;
	/**
	 * BufferedWriter az output fajlba irasahoz
	 */
	public static BufferedWriter bufferedWriter = null;
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
				/**
				 * lehetseges input-ok
				 */
				if(Game.fileMode){
					try{
						Game.bufferedWriter.newLine();
						Game.bufferedWriter.write("Lehetseges inputok: gamestart, bigtower, smalltower, enemy , shiftingsand, swamp, printdefensetools, printall, firingspeedincreaserstone, rangeextenderstone, elfdwarfspecializedstone, tick, endgame, exit");
						Game.bufferedWriter.newLine();
						Game.bufferedWriter.newLine();
					}
					catch(IOException ex) {
						System.out.println("Hibas output fajl.");
					}
				}
				/**
				 * vereseg kiirasa
				 */
				if(Game.fileMode){
					try{
						Game.bufferedWriter.write("Game endGame - A jatekos veszitett, jatek vege");
						Game.bufferedWriter.newLine();
						Game.bufferedWriter.newLine();
					}
					catch(IOException ex) {
						System.out.println("Hibas output fajl.");
					}
				}
				/**
				 * lehetseges input-ok
				 */
				if(Game.fileMode){
					try{
						Game.bufferedWriter.write("Lehetseges inputok: gamestart, bigtower, smalltower, enemy , shiftingsand, swamp, printdefensetools, printall, firingspeedincreaserstone, rangeextenderstone, elfdwarfspecializedstone, tick, endgame, exit");
						Game.bufferedWriter.newLine();
						Game.bufferedWriter.newLine();
					}
					catch(IOException ex) {
						System.out.println("Hibas output fajl.");
					}
				}
				/**
				 * printall
				 */
				if(Game.fileMode){
					try{
						Game.bufferedWriter.write("tick "+Map.getTickCount());
						Game.bufferedWriter.newLine();
					}
					catch(IOException ex) {
						System.out.println("Hibas output fajl.");
					}
				}
				if(Game.fileMode){
					try{
						Game.bufferedWriter.write("player varazsereje "+Map.player.getMagicPower());
						Game.bufferedWriter.newLine();
					}
					catch(IOException ex) {
						System.out.println("Hibas output fajl.");
					}
				}
				//Tornyok kiiratasa
				if(Game.fileMode){
					try{
						Game.bufferedWriter.write("tornyok listaja:");
						Game.bufferedWriter.newLine();
					}
					catch(IOException ex) {
						System.out.println("Hibas output fajl.");
					}
				}
				if(Map.towers.isEmpty()){
					if(Game.fileMode){
						try{
							Game.bufferedWriter.write("nincs torony");
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
				}
				else{
					LinkedList<Tower> towers = Map.getTowers();
					for(Tower element : towers){
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write(element.getClass().toString().substring(6).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue());
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
					}
				}
				if(Game.fileMode){
					try{
						Game.bufferedWriter.newLine();
					}
					catch(IOException ex) {
						System.out.println("Hibas output fajl.");
					}
				}
				//Akadalyok kiiratasa
				if(Game.fileMode){
					try{
						Game.bufferedWriter.write("akadalyok listaja:");
						Game.bufferedWriter.newLine();
					}
					catch(IOException ex) {
						System.out.println("Hibas output fajl.");
					}
				}
				if(Map.barriers.isEmpty()){
					if(Game.fileMode){
						try{
							Game.bufferedWriter.write("nincs akadaly");
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
				}
				else{
					LinkedList<Barrier> barriers = Map.getBarriers();
					for(Barrier element : barriers){
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write(element.getClass().toString().substring(6).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue());
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
					}
				}
				if(Game.fileMode){
					try{
						Game.bufferedWriter.newLine();
					}
					catch(IOException ex) {
						System.out.println("Hibas output fajl.");
					}
				}
				//Varazskovek kiiratasa
				if(Game.fileMode){
					try{
						Game.bufferedWriter.write("varazskovek listaja:");
						Game.bufferedWriter.newLine();
					}
					catch(IOException ex) {
						System.out.println("Hibas output fajl.");
					}
				}
				if(Map.magicStones.isEmpty()){
					if(Game.fileMode){
						try{
							Game.bufferedWriter.write("nincs varazsko");
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
				}
				else{
					LinkedList<MagicStone> magicStones = Map.getMagicStones();
					for(MagicStone element : magicStones){
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write(element.getClass().toString().substring(6).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue());
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
					}
				}
				if(Game.fileMode){
					try{
						Game.bufferedWriter.newLine();
					}
					catch(IOException ex) {
						System.out.println("Hibas output fajl.");
					}
				}
				//Ellenfelek kiiaratasa
				if(Game.fileMode){
					try{
						Game.bufferedWriter.write("ellenfelek:");
						Game.bufferedWriter.newLine();
					}
					catch(IOException ex) {
						System.out.println("Hibas output fajl.");
					}
				}
				if(Map.enemies.isEmpty()){
					if(Game.fileMode){
						try{
							Game.bufferedWriter.write("nincs ellenfel");
							Game.bufferedWriter.newLine();
						}
						catch(IOException ex) {
							System.out.println("Hibas output fajl.");
						}
					}
				}
				else{
					LinkedList<Enemy> enemies = Map.getEnemies();
					for(Enemy element : enemies){
						if(Game.fileMode){
							try{
								Game.bufferedWriter.write(element.getClass().toString().substring(6).toLowerCase()+" "+element.position.getRowValue()+" "+element.position.getColumnValue()+" "+element.getHealth());
								Game.bufferedWriter.newLine();
							}
							catch(IOException ex) {
								System.out.println("Hibas output fajl.");
							}
						}
					}
				}
				if(Game.fileMode){
					try{
						Game.bufferedWriter.newLine();
					}
					catch(IOException ex) {
						System.out.println("Hibas output fajl.");
					}
				}
				
				/**
				 * lehetseges input-ok
				 */
				if(Game.fileMode){
					try{
						Game.bufferedWriter.write("Lehetseges inputok: gamestart, bigtower, smalltower, enemy , shiftingsand, swamp, printdefensetools, printall, firingspeedincreaserstone, rangeextenderstone, elfdwarfspecializedstone, tick, endgame, exit");
					}
					catch(IOException ex) {
						System.out.println("Hibas output fajl.");
					}
				}
				
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
		}
	}


	/**A Timer osztaly szinten tick() nevu metodusa hivja meg ezt egy orajel eltelte utan.
	 * Az orajel eltelte utan a metodus meghivasakor ellenorzi, hogy a jatekos nyert
	 * vagy veszitett-e mar.
	 */
	public static void tick() {

		//Valamit bekene hozza allitani
		winGame();

		endGame();

	}
}
