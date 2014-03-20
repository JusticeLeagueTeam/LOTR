package LOTR;
public class DefenseTools {

	private Position position;
	private int cost;

	public Position getPosition() {
		System.out.println("DefenseTools getPosition - visszater a pozicioval");
		return this.position;
	}


	public void setPosition(Position position) {
		System.out.println("DefenseTools setPosition - beallitja a poziciot");
		this.position = position;
	}

	public int getCost() {
		System.out.println("DefenseTools getCost - visszater a koltseggel");
		return this.cost;
	}


	public void setCost(int cost) {
		System.out.println("DefenseTools setCost - beallitja a koltseget");
		this.cost = cost;
	}

}