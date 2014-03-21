package LOTR;

/**
 * DefenseTools - vedelmi eszkozok
 * ide tartoznak a tornyok es akadolyok osszes leszarmazottaival egyutt
 * @author justice_league
 *
 */
public class DefenseTools {
	/**
	 * jelenlegi pozicio
	 */
	private Position position;
	/**
	 * ennyi varazserobe kerul megepiteni
	 */
	private int cost;

	/**
	 * visszater a poziciova
	 * @return visszater a poziciova
	 */
	public Position getPosition() {
		System.out.println("DefenseTools getPosition - visszater a pozicioval");
		return this.position;
	}

	/**
	 * beallitja a poziciot
	 * @param position beallitja a poziciot
	 */
	public void setPosition(Position position) {
		System.out.println("DefenseTools setPosition - beallitja a poziciot");
		this.position = position;
	}

	/**
	 * visszater a koltseggel
	 * @return visszater a koltseggel
	 */
	public int getCost() {
		System.out.println("DefenseTools getCost - visszater a koltseggel");
		return this.cost;
	}

	/**
	 * beallitja a koltseget
	 * @param cost beallitja a koltseget
	 */
	public void setCost(int cost) {
		System.out.println("DefenseTools setCost - beallitja a koltseget");
		this.cost = cost;
	}

}