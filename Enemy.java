package LOTR;

import java.util.Observable;

public class Enemy extends Observable {

	private int health;
	private int speed;
	private Position position;
	private int magicPowerGain;
	private int tick_counter;

	public int getHealth() {
		System.out.println("Enemy getHelath - visszat�r az �leter�vel");
		return this.health;
	}

	public void setHealth(int health) {
		System.out.println("Enemy setHelath - be�ll�tja az �leter�t");
		//itt nem annyira allitja be, hanem annyival CSOKKENTI, tehat
		//a torony nem tudja mennyi az enemy eletereje, hanem szimplan
		//a torony a sebzes merteket tudja, ezt adja at paramterkent
		//es ennyivel csokkenti
		//this.health=this.health-health;
		this.health = health;
	}

	public int getSpeed() {
		System.out.println("Enemy getSpeed - visszat�r a sebess�ggel");
		return this.speed;
	}

	public void setSpeed(int speed) {
		System.out.println("Enemy setSpeed - be�ll�tja a sebess�get");
		this.speed = speed;
	}

	public Position getPosition() {
		System.out.println("Enemy getPosition - visszat�r a poz�ci�val");
		return this.position;
	}

	public void setPosition(Position position) {
		System.out.println("Enemy setPosition - be�ll�tja a poz�ci�t");
		this.position = position;
	}

	public int getMagicPowerGain() {
		System.out.println("Enemy getMagicPowerGain - be�ll�tja a nyert var�zser� �rt�k�t");
		return this.magicPowerGain;
	}

	public void setMagicPowerGain(int magicPowerGain) {
		System.out.println("Enemy setMagicPowerGain - visszat�r a nyert var�zser� �rt�k�vel");
		this.magicPowerGain = magicPowerGain;
	}

	public void tick() {
		System.out.println("Enemy tick ");
		//itt visszahivas tortenik a Map.enemyStep(pos) metodusra	
		Map map = new Map();
		
		//this.setPosition(map.enemyStep(getPosition()));
		
		Position p=map.enemyStep(getPosition());
    	setPosition(p);//szekv diagramban move() van, az hib�s - arnold
	}
	
	public void Attacked(int a){
		System.out.println("Enemy Attacked - param�ter �rt�k�vel cs�kkent az �leter�");
		setHealth(10);//todo:param�ter sz�m�tsa  -arnold
	}

}