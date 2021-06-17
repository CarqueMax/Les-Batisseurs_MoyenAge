package game;

/**
 * Autoplayer management
 * @version 1.0
 * @author CHARGÉ Maxime - IUT Vannes
 */
public class AutoPlayer extends Player {

	private Difficulties difficulty;

	/**
	 * AutoPlayer constructor
	 * @param name Autoplayer name
	 * @param board Board on which the autoplayer plays
	 * @param card Randomly chosen "Apprentice" card at the start of the game
	 * @param difficulty Autoplayer difficulty
	 */
	public AutoPlayer(String name, Board board, Cards card, Difficulties difficulty) {}

	/**
	 * The autoplayer plays and can do different actions
	 */
	public void play() {}

	/**
	 * Get the difficulty of the autoplayer
	 * @return difficulty of autoplayer
	 */
	public Difficulties getDifficulty() {
		return this.difficulty;
	}

}