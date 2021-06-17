package game;

/**
 * Cards of the game
 * @version 1.0
 * @author CHARGÉ Maxime - IUT Vannes
 */
public abstract class Cards {

	private int stone;
	private int wood;
	private int knowledge;
	private int tile;
	private int cost;

	/**
	 * Cards constructor
	 * @param stone Quantity of stone of the card
	 * @param wood Quantity of wood of the card
	 * @param knowledge Quantity of knowledge of the card
	 * @param tile Quantity of tile of the card
	 * @param cost Amount of money the player pays or wins depending on the card
	 */
	public Cards(int stone, int wood, int knowledge, int tile, int cost) {}

}