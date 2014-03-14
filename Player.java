package LOTR;
public class Player {

	private int magicPower;
	
	public Player(){
		System.out.println("Player objektum létrejött.");
	}

	public int getMagicPower() {
		return this.magicPower;
	}

	/**
	 * 
	 * @param magicPower
	 */
	public void setMagicPower(int magicPower) {
		this.magicPower = magicPower;
	}

	/**
	 * 
	 * @param DefenseTool
	 */
	public void createDefenseTool(DefenseTools DefenseTool) {
		System.out.println("creatDefenseTool metódus - Player csinált egy defenseTool-t");
	}

}