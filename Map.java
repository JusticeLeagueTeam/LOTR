package LOTR;

import java.util.LinkedList;

public class Map {

	//Game game;//ez kell? a main-ben van m�r egy, viszont a map-ben meg van egy game meg a timer-ben is, sz�val mindenk�pp jav�tani k�ll- arnold
	private LinkedList enemies;
	private LinkedList towers;
	private LinkedList barriers;
	//Player player;
	private LinkedList magicStones;
	private int tick_counter;
	
	public Map(){
		System.out.println("Map konstruktor - Map objektum l�trej�tt.");
		Player player=new Player();
		tick_counter=0;
	}

	//public Game getGame() {
		//return this.game;
		//ez szerintem t�r�lhet� met�dus - arnold
	//}

	//public void setGame(Game game) {
	//	this.game = game;
		//ez szerintem t�r�lhet� met�dus - arnold
	//}

	public LinkedList getEnemies() {
		System.out.println("Map - getEnemies - ellenfelek list�j�t lek�ri");
		return this.enemies;
	}

	public void setEnemies(LinkedList enemies) {
		System.out.println("Map - setEnemies - ellenfelek list�j�t be�ll�tja");
		this.enemies = enemies;
		}

	public int getTickCount() {
		System.out.println("Map - getTickCount - �rajelek sz�m�t visszaadja");
		return tick_counter;
	}

	public void setTickCount(int tickCount) {
		System.out.println("Map - setTickCount - �rajelek sz�m�t n�veli eggyel");
		tick_counter=tickCount;
	}

	public LinkedList getTowers() {
		System.out.println("Map - getTowers - tornyok list�j�t lek�ri");
		return this.towers;
	}


	public void setTowers(LinkedList towers) {
		System.out.println("Map - setTowers - tornyok list�j�t be�ll�tja");
		this.towers = towers;
	}

	public LinkedList getBarriers() {
		System.out.println("Map - getBarriers - akad�lyok list�j�t lek�ri");
		return this.barriers;
	}

	public void setBarriers(LinkedList barriers) {
		System.out.println("Map - setBarriers - akad�lyok list�j�t be�ll�tja");
		this.barriers = barriers;
	}

	//public Player getPlayer() {
	//	return this.player;
		//t�r�lhet�, �gyis csak annyi az eg�sz player, hogy az elej�n l�trehozzuk - arnold
	//}

	//public void setPlayer(Player player) {
	//	this.player = player;
		//t�r�lhet�, getPlayer komment miatt - arnold
	//}

	public LinkedList getMagicStones() {
		System.out.println("Map - getMagicStones - var�zsk�vek list�j�t lek�ri");
		return this.magicStones;
	}

	public void setMagicStones(LinkedList magicStones) {
		System.out.println("Map - setMagicStones - var�zsk�vek list�j�t be�ll�tja");
		this.magicStones = magicStones;
	}


	public Position enemyStep(int Position) {
		//param�tert be kell majd �ll�tani - arnold
		System.out.println("Map enemyStep - visszat�r egy p Position-nel ahova l�phet az ellenf�l");
		return new Position();
	}

	public void tick() {
		System.out.println("Map tick");
	}

}