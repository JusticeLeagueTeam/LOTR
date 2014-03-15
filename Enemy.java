package LOTR;

import java.util.Observable;

public class Enemy extends Observable {

	private int health;
	private int speed;
	private Position position;
	private int magicPowerGain;
	private int tick_counter;

	public int getHealth() {
		System.out.println("Enemy getHelath - visszatér az életerõvel");
		return this.health;
	}

	public void setHealth(int health) {
		System.out.println("Enemy setHelath - beállítja az életerõt");
		//itt nem annyira allitja be, hanem annyival CSOKKENTI, tehat
		//a torony nem tudja mennyi az enemy eletereje, hanem szimplan
		//a torony a sebzes merteket tudja, ezt adja at paramterkent
		//es ennyivel csokkenti
		//this.health=this.health-health;
		this.health = health;
	}

	public int getSpeed() {
		System.out.println("Enemy getSpeed - visszatér a sebességgel");
		return this.speed;
	}

	public void setSpeed(int speed) {
		System.out.println("Enemy setSpeed - beállítja a sebességet");
		this.speed = speed;
	}

	public Position getPosition() {
		System.out.println("Enemy getPosition - visszatér a pozícióval");
		return this.position;
	}

	public void setPosition(Position position) {
		System.out.println("Enemy setPosition - beállítja a pozíciót");
		this.position = position;
	}

	public int getMagicPowerGain() {
		System.out.println("Enemy getMagicPowerGain - beállítja a nyert varázserõ értékét");
		return this.magicPowerGain;
	}

	public void setMagicPowerGain(int magicPowerGain) {
		System.out.println("Enemy setMagicPowerGain - visszatér a nyert varázserõ értékével");
		this.magicPowerGain = magicPowerGain;
	}

	public void tick() {
		System.out.println("Enemy tick ");
		//itt visszahivas tortenik a Map.enemyStep(pos) metodusra	
		Map map = new Map();
		
		//this.setPosition(map.enemyStep(getPosition()));
		
		Position p=map.enemyStep(getPosition());
    	setPosition(p);//szekv diagramban move() van, az hibás - arnold
	}
	
	public void Attacked(int a){
		System.out.println("Enemy Attacked - paraméter értékével csökkent az életerõ");
		setHealth(10);//todo:paraméter számítsa  -arnold
	}

}