package game;

/**
 * Player management
 * @version 1.0
 * @author CHARGÉ Maxime - IUT Vannes
 */
public abstract class Player {

	protected String name;
	protected int ecu;
	protected int silverCoin;
	protected int goldenCoin;
	protected int action;
	protected int victoryPoint;
	protected int id;
	protected Board board;
	protected Cards cards;
	protected Construction construction;

	/**
	 * Player constructor
	 * @param name Player name
	 * @param board Board on which the player plays
	 * @param card Randomly chosen "Apprentice" card at the start of the game
	 */
	public Player(String name, Board board, Apprentice card) {}

	/**
	 * The player plays and can do different actions
	 */
	public abstract void play();

	/**
	 * Change the number of ecu
	 * @param ecu New ecu value
	 */
	public void setEcu(int ecu) {
		this.ecu = ecu;
	}

	/**
	 * Recover the player's ecu number
	 * @return The player's ecu number
	 */
	public int getEcu() {
		return this.ecu;
	}

	/**
	 * Change the number of silverCoin
	 * @param silverCoin New silverCoin number
	 */
	public void setSilverCoin(int silverCoin) {
		this.silverCoin = silverCoin;
	}

	/**
	 * Recover the player's silverCoin number
	 * @return The player's silverCoin number
	 */
	public int getSilverCoin() {
		return this.silverCoin;
	}

	/**
	 * Change the number of goldenCoin
	 * @param goldenCoin New goldenCoin number
	 */
	public void setGoldenCoin(int goldenCoin) {
		this.goldenCoin = goldenCoin;
	}

	/**
	 * Recover the player's goldenCoin number
	 * @return The player's goldenCoin number
	 */
	public int getGoldenCoin() {
		return this.goldenCoin;
	}

	/**
	 * Change the number of action
	 * @param action New action number
	 */
	public void setAction(int action) {
		this.action = action;
	}

	/**
	 * Convert money into ecu
	 * @return Number of ecu
	 */
	public int coinToEcu() {}

	/**
	 * Convert ecu into victory point
	 * @param ecu Number of ecu
	 */
	public int ecuToVictoryPoint(int ecu) {}

	/**
	 * Collect the number of victory points
	 * @return Number of victory points
	 */
	public int getVictoryPoint() {
		return this.victoryPoint;
	}

}