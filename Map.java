package LOTR;

import java.util.LinkedList;

public class Map {

	//Game game;//ez kell? a main-ben van már egy, viszont a map-ben meg van egy game meg a timer-ben is, szóval mindenképp javítani köll- arnold
	private LinkedList enemies;
	private LinkedList towers;
	private LinkedList barriers;
	//Player player;
	private LinkedList magicStones;
	private int tick_counter;
	
	public Map(){
		System.out.println("Map konstruktor - Map objektum létrejött.");
		Player player=new Player();
		tick_counter=0;
	}

	//public Game getGame() {
		//return this.game;
		//ez szerintem törölhetõ metódus - arnold
	//}

	//public void setGame(Game game) {
	//	this.game = game;
		//ez szerintem törölhetõ metódus - arnold
	//}

	public LinkedList getEnemies() {
		System.out.println("Map - getEnemies - ellenfelek listáját lekéri");
		return this.enemies;
	}

	public void setEnemies(LinkedList enemies) {
		System.out.println("Map - setEnemies - ellenfelek listáját beállítja");
		this.enemies = enemies;
		}

	public int getTickCount() {
		System.out.println("Map - getTickCount - órajelek számát visszaadja");
		return tick_counter;
	}

	public void setTickCount(int tickCount) {
		System.out.println("Map - setTickCount - órajelek számát növeli eggyel");
		tick_counter=tickCount;
	}

	public LinkedList getTowers() {
		System.out.println("Map - getTowers - tornyok listáját lekéri");
		return this.towers;
	}


	public void setTowers(LinkedList towers) {
		System.out.println("Map - setTowers - tornyok listáját beállítja");
		this.towers = towers;
	}

	public LinkedList getBarriers() {
		System.out.println("Map - getBarriers - akadályok listáját lekéri");
		return this.barriers;
	}

	public void setBarriers(LinkedList barriers) {
		System.out.println("Map - setBarriers - akadályok listáját beállítja");
		this.barriers = barriers;
	}

	//public Player getPlayer() {
	//	return this.player;
		//törölhetõ, úgyis csak annyi az egész player, hogy az elején létrehozzuk - arnold
	//}

	//public void setPlayer(Player player) {
	//	this.player = player;
		//törölhetõ, getPlayer komment miatt - arnold
	//}

	public LinkedList getMagicStones() {
		System.out.println("Map - getMagicStones - varázskövek listáját lekéri");
		return this.magicStones;
	}

	public void setMagicStones(LinkedList magicStones) {
		System.out.println("Map - setMagicStones - varázskövek listáját beállítja");
		this.magicStones = magicStones;
	}


	public Position enemyStep(int Position) {
		//paramétert be kell majd állítani - arnold
		System.out.println("Map enemyStep - visszatér egy p Position-nel ahova léphet az ellenfél");
		return new Position();
	}

	public void tick() {
		System.out.println("Map tick");
	}

}