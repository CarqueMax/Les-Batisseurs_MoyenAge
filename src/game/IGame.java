package game;

/**
 * Interface class for the Game class
 * @version 1.0
 * @author CHARGÉ Maxime - IUT Vannes
 */
public interface IGame {

	/**
	 * View game rules and card statistics
	 */
	void description();

	/**
	 * Start the game part
	 */
	void start();

	/**
	 * End of the game, announces the winner and the statistics of the game
	 */
	void endOfGame();

}