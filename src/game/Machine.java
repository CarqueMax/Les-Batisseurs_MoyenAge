package game;

/**
 * "Machine" card of the game
 * @version 1.0
 * @author CHARGÉ Maxime - IUT Vannes
 */
public class Machine extends Cards {

	private int point;

	/**
	 * Machine constructor
	 * @param stone Quantity of stone required for this machine
	 * @param wood Quantity of wood required for this machine
	 * @param knowledge Quantity of knowledge required for this machine
	 * @param tile Quantity of tile required for this machine
	 * @param cost Amount of money the player earns after the Building is finished constructing
	 * @param point Number of points the player earns after the Building is finished constructing
	 */
	public Machine(int stone, int wood, int knowledge, int tile, int cost, int point) {}

	/**
	 * Change the value of the machine points
	 * @param point Point of the machine to put
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * Return the number of points of the machine
	 * @return Number of points
	 */
	public int getPoint() {
		return this.point;
	}

}