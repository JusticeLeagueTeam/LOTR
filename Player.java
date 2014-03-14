package LOTR;
public class Player {

	private int magicPower;
	
	public Player(){
		System.out.println("Player konstruktor - Player objektum létrejött.");
	}

	public int getMagicPower() {
		System.out.println("Player getMagicPower - visszaadja a játékos életerejét");
		return this.magicPower;
	}

	public void setMagicPower(int magicPower) {
		System.out.println("Player setMagicPower - átállítja a játékos életerejét");
		this.magicPower = magicPower;
	}

	public void createDefenseTool(DefenseTools DefenseTool) {
		System.out.println("Player creatDefenseTool - Player csinált egy defenseTool-t");
	}

}