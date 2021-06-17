package game;

import java.util.ArrayList;

/**
 * Game management
 * @version 1.0
 * @author CHARGÉ Maxime - IUT Vannes
 */
public class Game implements IGame {

	private int currentId;
	private int nbPlayer;
	private ArrayList<Player> playerList;
	private Mode mode;
	private Board board;

	/**
	 * Game constructor
	 * @param board
	 * @param playerList List of players
	 */
	public Game(Board board, ArrayList<Player> playerList) {}

	/**
	 * Initializes the game by creating players, distributing cards ...
	 */
	public void initializeGame() {}

	/**
	 * Create players based on game mode
	 * @param playerList The list of players
	 * @param mode The game mode
	 */
	private void createPlayer(ArrayList<Player> playerList, Mode mode) {}

	/**
	 * Change player
	 * @param indexTurn Current player
	 */
	public void changeCurrentPlayer(int indexTurn) {}

	/**
	 * Change index in the list (randomly)
	 * @param indexTurn Current player
	 */
	private void changeIndexTurn(int indexTurn) {}

	/**
	 * Open a new construction site
	 */
	public void openConstruction() {}

	/**
	 * Recruits a new worker
	 */
	public void recruitWorker() {}

	/**
	 * Send a worker to a construction site
	 * @param constuction a building site
	 */
	public void sendworker(Construction constuction) {}

	/**
	 * Buy ecus in exchange for a share
	 */
	public void buyEcu() {}

	/**
	 * Check if there is a winner (17 victory points)
	 * @return True if there is a winner, otherwise false
	 */
	public boolean checkScore() {}

	/**
	 * View game rules and card statistics
	 * @return rules, statistics
	 */
	public String desciption() {}

	/**
	 * Start the game part
	 */
	public void start() {}

	/**
	 * End of the game, announces the winner and the statistics of the game
	 */
	public void endOfGame() {}
}