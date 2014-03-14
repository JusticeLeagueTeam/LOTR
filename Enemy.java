package LOTR;

import java.util.Observable;

public class Enemy extends Observable {

	private int health;
	private int speed;
	private Position position;
	private int magicPowerGain;
	private int tick_counter;

	public int getHealth() {
		return this.health;
	}

	/**
	 * 
	 * @param health
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	public int getSpeed() {
		return this.speed;
	}

	/**
	 * 
	 * @param speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Position getPosition() {
		return this.position;
	}

	/**
	 * 
	 * @param position
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	public int getMagicPowerGain() {
		return this.magicPowerGain;
	}

	/**
	 * 
	 * @param magicPowerGain
	 */
	public void setMagicPowerGain(int magicPowerGain) {
		this.magicPowerGain = magicPowerGain;
	}

	public void tick() {
		// TODO - implement Enemy.tick
		throw new UnsupportedOperationException();
	}

}