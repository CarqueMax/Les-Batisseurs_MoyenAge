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
    private int silverReserve;
    private int goldReserve;
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
        this.silverReserve = 25;
        this.goldReserve = 15;
        this.pileBuildings = new ArrayList<>();
        this.buildingsOutside = new ArrayList<>();
        this.pileWorkers = new ArrayList<>();
        this.workersOutside = new ArrayList<>();
        this.pileApprentice = new ArrayList<>();
        initializeCards("../../data/Cartes.txt");
        this.random = new Random();
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
                sc.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("ERREUR initializeCards : Fichier non trouve : " + fileName);
        }
    }

    /**
     * Take cards from the piles and fill them in the rows if there are missing cards
     */
    public void completeLineCard() {
        int counterWorker = 5 - this.workersOutside.size();
        if (this.workersOutside.size() < 5 && this.pileWorkers.size() >= counterWorker) {
            for (int i = this.workersOutside.size(); i <= 5; i++) {
                int pickRandom = this.random.nextInt(this.pileWorkers.size() - 1);
                this.workersOutside.add(this.pileWorkers.get(pickRandom));
                this.pileWorkers.remove(pickRandom);
            }
        } else {
            System.out.println("Pile de carte Ouvrier vide");
        }
    }

    /**
     * Retrieve a construction site among the proposed constrcution sites and put a card back in the construction site line
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
            System.err.println("ERREUR takeConstruction : index de la carte choisi en dehors du tableau");
        }
        return card;
    }

    /**
     * Retrieve a worker among the proposed workers and put a card back in the workers line
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
            System.err.println("ERREUR takeWorker : index de la carte choisi en dehors du tableau");
        }
        return card;
    }

    public void assembleWorker() {
        for (int i = 0; i < this.pileApprentice.size(); i++) {
            this.pileWorkers.add(this.pileApprentice.get(i));
            this.pileApprentice.remove(i);
        }
    }

    public Apprentice randomDetributeApprentices() {
        int random = this.random.nextInt(this.pileApprentice.size() - 1);
        Apprentice apprenticeOfPlayer = this.pileApprentice.get(random);
        this.pileApprentice.remove(random);
        return apprenticeOfPlayer;
    }
}