package LOTR;
public class Game {

	//Map map;
	//Timer timer;
	
	public Game(){
		System.out.println("Game konstruktor - Game objektum l�trej�tt.");
		//Timer timer=new Timer();
		//Map map=new Map();
	}

	public void endGame() {
		System.out.println("Game endGame - j�t�k v�ge");
	}

	public void startGame() {
		System.out.println("Game startGame - indul a j�t�kmenet");
	}

	public void winGame() {
		System.out.println("Game wingame - a j�t�kos nyert");
	}

	public void tick() {
		System.out.println("Game tick - ellen�rzi, hogy a j�t�kos nyert vagy vesztett");
	}


}