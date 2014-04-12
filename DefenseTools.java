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
	protected Position position;
	/**
	 * ennyi varazserobe kerul megepiteni
	 */
	protected int cost;

	/**
	 * visszater a poziciova
	 * @return visszater a poziciova
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * beallitja a poziciot
	 * @param position beallitja a poziciot
	 */
	public void setPosition(Position p) {
		position = p;
	}

	/**
	 * visszater a koltseggel
	 * @return visszater a koltseggel
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * beallitja a koltseget
	 * @param cost beallitja a koltseget
	 */
	public void setCost(int c) {
		cost = c;
	}

}