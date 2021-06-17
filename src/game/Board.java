package game;

import java.util.ArrayList;

/**
 * Board management
 * @version 1.0
 * @author CHARGÉ Maxime - IUT Vannes
 */
public class Board {

	private int silverReserve;
	private int goldReserve;
	private ArrayList<Cards> pileBuilding;
	private ArrayList<Worker> pileWorker;

	/**
	 * Board construtor
	 * @param silverReserve number of silver coins still available
	 * @param goldReserve number of gold coins still available
	 * @param pileBuilding Building card reserve
	 * @param pileWorker Worker card reserve
	 */
	public Board(int silverReserve, int goldReserve, ArrayList<Building> pileBuilding, ArrayList<Worker> pileWorker) {}

	/**
	 * Displays the board at the moment (stats, cards ...)
	 * @return board abstract
	 */
	public String printBoard() {}

}