package game;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Board management
 *
 * @author CHARGÉ Maxime - IUT Vannes
 * @version 1.0
 */
public class Board {
    private int ecuReserve;
    private ArrayList<Cards> pileBuildings;
    private ArrayList<Cards> buildingsOutside;
    private ArrayList<Cards> pileWorkers;
    private ArrayList<Cards> workersOutside;
    private ArrayList<Apprentice> pileApprentice;
    private Scanner sc;
    private Random random;

    /**
     * Board construtor
     */
    public Board() {
        this.ecuReserve = 100;
        this.pileBuildings = new ArrayList<>();
        this.buildingsOutside = new ArrayList<>();
        this.pileWorkers = new ArrayList<>();
        this.workersOutside = new ArrayList<>();
        this.pileApprentice = new ArrayList<>();
        initializeCards("../data/Cartes.txt");
        this.random = new Random();
    }

    /**
     * Modify the number of ecu in the reserve
     *
     * @param ecuReserve New number of ecu
     */
    public void setEcuReserve(int ecuReserve) {
        if (ecuReserve >= 0) {
            this.ecuReserve = ecuReserve;
        } else {
            System.err.println("ERREUR setEcuReserve : nouvelle valeur inférieur à 0");
        }
    }

    /**
     * Returns the number of ecu in the reserve
     *
     * @return Number of ecu
     */
    public int getEcuReserve() {
        return this.ecuReserve;
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
            while (this.sc.hasNext()) {
                char type = sc.next().charAt(0);
                if (type == 'W') {
                    Worker workerCard = new Worker(this.sc);
                    this.pileWorkers.add(workerCard);
                } else if (type == 'A') {
                    Apprentice apprenticeCard = new Apprentice(this.sc);
                    this.pileApprentice.add(apprenticeCard);
                } else if (type == 'M') {
                    Machine machineCard = new Machine(this.sc);
                    this.pileBuildings.add(machineCard);
                } else {
                    Building BuildingCard = new Building(this.sc);
                    this.pileBuildings.add(BuildingCard);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("ERREUR initializeCards : Fichier non trouve : " + fileName);
            System.exit(1);
        }
    }

    /**
     * Retrieve a construction site among the proposed construction sites and put a card back in the construction site line
     *
     * @param indexOfConstruction Index of the construction site in the list
     * @return Card chosen by the user
     */
    public Cards takeConstruction(int indexOfConstruction) {
        Cards card = null;
        if (indexOfConstruction >= 0 && indexOfConstruction <= 4) {
            card = this.buildingsOutside.get(indexOfConstruction);
            if (this.pileBuildings.size() >= 1) {
                int pickRandom = this.random.nextInt(this.pileBuildings.size());
                this.buildingsOutside.add(this.pileBuildings.get(pickRandom));
                this.pileBuildings.remove(pickRandom);
            } else {
                System.out.println("Pile de carte Bâtiment vide");
            }
        } else {
            System.err.println("/!\\ Aucun chantier trouvé avec l'index saisie /!\\");
        }
        return card;
    }

    /**
     * Retrieve a worker among the proposed workers and put a card back in the workers line
     *
     * @param indexOfWorker Index of the worker in the list
     * @return Card chosen by the user
     */
    public Cards takeWorker(int indexOfWorker) {
        Cards card = null;
        if (indexOfWorker >= 0 && indexOfWorker <= 4) {
            card = this.workersOutside.get(indexOfWorker);
            if (this.pileWorkers.size() >= 1) {
                int pickRandom = this.random.nextInt(this.pileWorkers.size());
                this.workersOutside.add(this.pileWorkers.get(pickRandom));
                this.pileWorkers.remove(pickRandom);
            } else {
                System.out.println("Pile de carte Ouvrier vide");
            }
        } else {
            System.err.println("/!\\ Aucun ouvrier trouvé avec l'index saisie /!\\");
        }
        return card;
    }

    /**
     * Put the remaining apprentices in the worker stack
     */
    public void assembleWorker() {
        for (int i = 0; i < this.pileApprentice.size(); i++) {
            this.pileWorkers.add(this.pileApprentice.get(i));
            this.pileApprentice.remove(i);
        }
    }

    /**
     * Retrieve a random apprentice from the apprentice list
     *
     * @return An apprentice
     */
    public Apprentice randomDetributeApprentices() {
        int random = this.random.nextInt(this.pileApprentice.size() - 1);
        Apprentice apprenticeOfPlayer = this.pileApprentice.get(random);
        this.pileApprentice.remove(random);
        return apprenticeOfPlayer;
    }

    /**
     * Get the list of buildings
     *
     * @return Building list
     */
    public ArrayList<Cards> getBuildingsOutside() {
        return this.buildingsOutside;
    }

    /**
     * Get the list of workers
     *
     * @return Workers list
     */
    public ArrayList<Cards> getWorkersOutside() {
        return this.workersOutside;
    }
}