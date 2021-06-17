package game;

import java.util.ArrayList;

/**
 * Construction management
 * @version 1.0
 * @author CHARGÉ Maxime - IUT Vannes
 */
public class Construction {

	private int stone;
	private int wood;
	private int knowledge;
	private int tile;
	private ArrayList<Worker> workers;
	private boolean progress;

	/**
	 * Construction constructor
	 * @param building building to be constructed
	 */
	public Construction(Cards building) {}

	/**
	 * Checks if all resources are reached
	 * @return True if everything is reached, otherwise false
	 */
	public boolean calculateProgress() {}

	/**
	 * Calculate the total number of wood
	 * @return True if the number is reached or exceeded, otherwise false
	 */
	private boolean calculateWood() {}

	/**
	 * Calculate the total number of knowledge
	 * @return True if the number is reached or exceeded, otherwise false
	 */
	private boolean calculateKnowledge() {}

	/**
	 * Calculate the total number of tiles
	 * @return True if the number is reached or exceeded, otherwise false
	 */
	private boolean calcutaleTile() {}

	/**
	 * 
	 * @param worker
	 */
	public void addWorker(Cards worker) {}

}