package game;

/**
 * Interface class for the Game class
 * @version 1.0
 * @author CHARGÉ Maxime - IUT Vannes
 */
public interface IGame {

	/**
	 * View game rules and card statistics
	 * @return rules, statistics
	 */
	public String desciption();

	/**
	 * Start the game part
	 */
	public void start();

	/**
	 * End of the game, announces the winner and the statistics of the game
	 */
	public void endOfGame();

}