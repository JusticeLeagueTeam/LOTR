package LOTR;
public class Player {

	private int magicPower;
	
	public Player(){
		System.out.println("Player konstruktor - Player objektum l�trej�tt.");
	}

	public int getMagicPower() {
		System.out.println("Player getMagicPower - visszaadja a j�t�kos �leterej�t");
		return this.magicPower;
	}

	public void setMagicPower(int magicPower) {
		System.out.println("Player setMagicPower - �t�ll�tja a j�t�kos �leterej�t");
		this.magicPower = magicPower;
	}

	public void createDefenseTool(DefenseTools DefenseTool) {
		System.out.println("Player creatDefenseTool - Player csin�lt egy defenseTool-t");
	}

}