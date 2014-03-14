package LOTR;

import java.util.LinkedList;

public class Map {

	private Game game;
	private LinkedList enemies;
	private LinkedList towers;
	private LinkedList barriers;
	private Player player;
	private LinkedList magicStones;

	public Game getGame() {
		return this.game;
	}

	/**
	 * 
	 * @param game
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	public LinkedList getEnemies() {
		return this.enemies;
	}

	/**
	 * 
	 * @param enemies
	 */
	public void setEnemies(LinkedList enemies) {
		this.enemies = enemies;
	}

	public int getTickCount() {
		// TODO - implement Map.getTickCount
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tickCount
	 */
	public void setTickCount(int tickCount) {
		// TODO - implement Map.setTickCount
		throw new UnsupportedOperationException();
	}

	public LinkedList getTowers() {
		return this.towers;
	}

	/**
	 * 
	 * @param towers
	 */
	public void setTowers(LinkedList towers) {
		this.towers = towers;
	}

	public LinkedList getBarriers() {
		return this.barriers;
	}

	/**
	 * 
	 * @param barriers
	 */
	public void setBarriers(LinkedList barriers) {
		this.barriers = barriers;
	}

	public Player getPlayer() {
		return this.player;
	}

	/**
	 * 
	 * @param player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	public LinkedList getMagicStones() {
		return this.magicStones;
	}

	/**
	 * 
	 * @param magicStones
	 */
	public void setMagicStones(LinkedList magicStones) {
		this.magicStones = magicStones;
	}

	/**
	 * 
	 * @param Position
	 */
	public Position enemyStep(int Position) {
		// TODO - implement Map.enemyStep
		throw new UnsupportedOperationException();
	}

	public void tick() {
		// TODO - implement Map.tick
		throw new UnsupportedOperationException();
	}

}