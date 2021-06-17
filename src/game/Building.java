package game;

/**
 * "Building" card of the game
 * @version 1.0
 * @author CHARGÉ Maxime - IUT Vannes
 */
public class Building extends Cards {

	private int point;

	/**
	 * Building constructor
	 * @param stone Quantity of stone required for this building
	 * @param wood Quantity of wood required for this building
	 * @param knowledge Quantity of knowledge required for this building
	 * @param tile Quantity of tile required for this building
	 * @param cost Amount of money the player earns after the Building is finished constructing
	 * @param point Number of points the player earns after the Building is finished constructing
	 */
	public Building(int stone, int wood, int knowledge, int tile, int cost, int point) {}

	/**
	 * Change the value of the building points
	 * @param point Point of the building to put
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * Return the number of points of the building
	 * @return Number of points
	 */
	public int getPoint() {
		return this.point;
	}

}