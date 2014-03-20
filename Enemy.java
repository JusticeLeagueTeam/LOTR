package LOTR;

import java.util.Observable;

public class Enemy extends Observable {

	private int health;
	private int speed;
	private Position position;
	private int magicPowerGain;
	private int tick_counter;

	public int getHealth() {
		System.out.println("Enemy getHealth - visszater az eleterovel");
		return this.health;
	}

	public void setHealth(int health) {
		System.out.println("Enemy setHelath - parameterrel csokkenti az eleterot");
		this.health = health;
		
	}

	public int getSpeed() {
		System.out.println("Enemy getSpeed - visszater a sebesseggel");
		return this.speed;
	}

	public void setSpeed(int speed) {
		System.out.println("Enemy setSpeed - beallitja a sebesseget");
		this.speed = speed;
	}

	public Position getPosition() {
		System.out.println("Enemy getPosition - visszater a pozicioval");
		return this.position;
	}

	public void setPosition(Position position) {
		System.out.println("Enemy setPosition - beallitja a poziciot");
		this.position = position;
	}

	public int getMagicPowerGain() {
		System.out.println("Enemy getMagicPowerGain - beallitja a nyert varazsero erteket");
		return this.magicPowerGain;
	}

	public void setMagicPowerGain(int magicPowerGain) {
		System.out.println("Enemy setMagicPowerGain - visszater a nyert varazsero ertekevel");
		this.magicPowerGain = magicPowerGain;
	}

	public void tick() {
		System.out.println("Enemy tick ");
		Map map = new Map();	
		System.out.println("Ha tick_counter megfelel a faj haladasi sebessegenek pl oszthato 5-tel");
		this.setPosition(map.enemyStep(getPosition()));
		
		notifyObservers();
	}
	
	public void Attacked(int a){
		System.out.println("Enemy Attacked - parameter ertekevel csokkent az eletero es a varazsero");
		setHealth(a);
		Map.player.setMagicPower(a);
	}

}