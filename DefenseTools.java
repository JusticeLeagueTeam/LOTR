package LOTR;
public class DefenseTools {

	private Position position;
	private int cost;

	public Position getPosition() {
		System.out.println("DefenseTools getPosition");
		return this.position;
	}


	public void setPosition(Position position) {
		System.out.println("DefenseTools setPosition");
		this.position = position;
	}

	public int getCost() {
		System.out.println("DefenseTools getCost");
		return this.cost;
	}


	public void setCost(int cost) {
		System.out.println("DefenseTools setCost");
		this.cost = cost;
	}

}