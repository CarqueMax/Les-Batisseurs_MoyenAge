package game;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Board management
 *
 * @author CHARGÉ Maxime - IUT Vannes
 * @version 1.0
 */
public class Board {
    private int silverReserve;
    private int goldReserve;
    private ArrayList<Cards> pileBuilding;
    private ArrayList<Worker> pileWorker;
    private Scanner sc;
    private ArrayList<Cards> hashMapOfCards;

    /**
     * Board construtor
     *
     * @param silverReserve number of silver coins still available
     * @param goldReserve   number of gold coins still available
     * @param pileBuilding  Building card reserve
     * @param pileWorker    Worker card reserve
     */
    public Board(int silverReserve, int goldReserve, ArrayList<Building> pileBuilding, ArrayList<Worker> pileWorker) {
        this.hashMapOfCards = new ArrayList<>();
    }

    /**
     * Displays the board at the moment (stats, cards ...)
     *
     * @return board abstract
     */
    public String printBoard() {
        return "";
    }

    /**
     * Initializes all cards with their statistics
     *
     * @param fileName Name of the file
     */
    public void initializeCards(String fileName) {
        try {
            this.sc = new Scanner(new FileReader(fileName));
            this.sc.useDelimiter(":");
            while (this.sc.hasNextLine()) {
                char type = sc.next().charAt(0);
                String name = sc.next();
                if (type == 'W') {
                    Worker workerCard = new Worker(this.sc);
                    this.hashMapOfCards.add(workerCard);
                } else if (type == 'A') {
                    Apprentice apprenticeCard = new Apprentice(this.sc);
                    this.hashMapOfCards.add(apprenticeCard);
                } else if (type == 'M') {
                    Machine machineCard = new Machine(this.sc);
                    this.hashMapOfCards.add(machineCard);
                } else {
                    Building BuildingCard = new Building(this.sc);
                    this.hashMapOfCards.add(BuildingCard);
                }
                sc.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("ERREUR initializeCards : Fichier non trouve : " + fileName);
        }
    }
}