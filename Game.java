package LOTR;
public class Game {

	//Map map;
	//Timer timer;
	
	public Game(){
		System.out.println("Game konstruktor - Game objektum létrejött.");
		//Timer timer=new Timer();
		//Map map=new Map();
	}

	public void endGame() {
		System.out.println("Game endGame - játék vége");
		//ha barmelyik ellenseg pozicioja egybe esik a cel pozicioval
	}

	public void startGame() {
		System.out.println("Game startGame - indul a játékmenet");
	}

	public void winGame() {
		System.out.println("Game wingame - a játékos nyert");
		
		if(Map.enemies.isEmpty())
		{
			//WIN
		}
	}

	public void tick() {
		System.out.println("Game tick - ellenõrzi, hogy a játékos nyert vagy vesztett");
	}


}