package game;

import java.util.ArrayList;

/**
 * Player management
 *
 * @author CHARGÉ Maxime - IUT Vannes
 * @version 1.0
 */
public abstract class Player {
    protected String name;
    protected int ecu;
    protected int action;
    protected int victoryPoint;
    protected Board board;
    protected ArrayList<Construction> listeConstruction;
    protected ArrayList<Cards> listWorkerCard;
    protected ArrayList<Cards> listBuildingCard;
    public static final int ECU_EXCHANGE_PRICE = 5;
    private int actionSaleCounter;

    /**
     * Player constructor
     *
     * @param name      Player name
     * @param board     Board on which the player plays
     * @param firstCard Randomly chosen "Apprentice" card at the start of the game
     */
    public Player(String name, Board board, Apprentice firstCard) {
        if (name != null && board != null && firstCard != null) {
            this.name = name;
            this.board = board;
            this.listWorkerCard = new ArrayList<>();
            this.listBuildingCard = new ArrayList<>();
            this.listeConstruction = new ArrayList<>();
            addCardToListWorkerCard(firstCard);
        } else {
            System.err.println("ERREUR Player : arguments null");
        }
    }

    /**
     * The player plays and can do different actions
     */
    public abstract void play();

    public String getName() {
        return this.name;
    }

    /**
     * Change the number of ecu
     *
     * @param ecu New ecu value
     */
    public void setEcu(int ecu) {
        if (ecu >= 0) {
            this.ecu = ecu;
        } else {
            System.err.println("ERREUR setEcu : nouvelle valeur inférieur à 0");
        }
    }

    /**
     * Recover the player's ecu number
     *
     * @return The player's ecu number
     */
    public int getEcu() {
        return this.ecu;
    }

    /**
     * Change the number of action
     *
     * @param action New action number
     */
    public void setAction(int action) {
        if (action >= 0) {
            this.action = action;
        } else {
            System.err.println("ERREUR setAction : nouvelle valeur inférieur à 0");
        }
    }

    /**
     * Recover the number of action
     *
     * @return Number of action
     */
    public int getAction() {
        return this.action;
    }

    /**
     * Convert action into ecu (1 action = 1 ecu, 2 action = 3 ecu, 3 action = 6 ecu)
     */
    public void actionToEcu() {
        if (this.actionSaleCounter == 0) {
            setAction(this.action - 1);
            setEcu(this.ecu + 1);
            this.actionSaleCounter++;
            System.out.println(" => Lors de ce tour, vous avez vendu 1 action contre 1 ecu");
        } else if (this.actionSaleCounter == 1) {
            setAction(this.action - 1);
            setEcu(this.ecu + 2);
            this.actionSaleCounter++;
            System.out.println(" => Lors de ce tour, vous avez vendu 2 actions contre 3 ecus");
        } else if (this.actionSaleCounter == 2) {
            setAction(this.action - 1);
            setEcu(this.ecu + 3);
            this.actionSaleCounter++;
            System.out.println(" => Lors de ce tour, vous avez vendu 3 actions contre 6 ecus");
        } else {
            System.err.println("/!\\ Vous ne pouvez pas vendre plus de 3 actions par tour /!\\");
        }
    }

    /**
     * Resets the action sale counter to 0
     */
    public void resetActionSaleCounter() {
        this.actionSaleCounter = 0;
    }

    /**
     * Convert ecu into action (5 ecus = 1 action)
     *
     * @param numberAction Number of action
     */
    public void buyAction(int numberAction) {
        if (numberAction > 0) {
            int costBuyAction = numberAction * ECU_EXCHANGE_PRICE;
            if (costBuyAction <= this.ecu) {
                setEcu(this.ecu - costBuyAction);
                setAction(this.action + numberAction);
                System.out.println(" => Vous avez maintenant " + this.action + " action(s) et " + this.ecu + " ecu(s)");
            } else {
                int maxAction = this.ecu / 5;
                System.err.println("/!\\ Vous n'avez assez d'écu pour acheter des actions /!\\ \n" +
                        "Vous pouvez acheter maximum " + maxAction + " ecu(s) avec vos écus"
                );
            }
        } else {
            System.err.println("/!\\ Entrer une valeur supérieur à 0 /!\\");
        }
    }

    /**
     * Convert ecu into victory point (10 ecus = 1 victory point)
     */
    public void ecuToVictoryPoint() {
        int numberOfVictoryPoint = this.ecu / 10;
        setEcu(0);
        setVictoryPoint(this.victoryPoint + numberOfVictoryPoint);
    }

    /**
     * Collect the number of victory points
     *
     * @return Number of victory points
     */
    public int getVictoryPoint() {
        return this.victoryPoint;
    }

    /**
     * Change the number of victory points
     *
     * @param victoryPoint New victory points value
     */
    public void setVictoryPoint(int victoryPoint) {
        if (victoryPoint >= 0) {
            this.victoryPoint = victoryPoint;
        } else {
            System.err.println("ERREUR setVictoryPoint : nouvelle valeur inférieur à 0");
        }
    }

    /**
     * Add a card to the player's stack of worker
     *
     * @param card Card to add
     */
    public void addCardToListWorkerCard(Cards card) {
        if (card != null) {
            this.listWorkerCard.add(card);
        } else {
            System.err.println("ERREUR addCardToListePlayerCard : carte à ajouter null");
        }
    }

    /**
     * Open a new construction site
     *
     * @param indexOfConstruction The index of the construction site to be opened among the proposed construction sites
     */
    public void openConstruction(int indexOfConstruction) {
        if (indexOfConstruction >= 0 && indexOfConstruction < this.board.getBuildingsOutside().size()) {
            Construction construction = new Construction(this.board.takeConstruction(indexOfConstruction));
            this.listeConstruction.add(construction);
            setAction(this.action - 1);
        } else {
            System.err.println("/!\\ Aucun chantier trouvé avec l'index saisie /!\\");
        }
    }

    /**
     * Recruits a new worker
     *
     * @param indexOfWorker The index of the worker to be recruited among the proposed workers
     */
    public void recruitWorker(int indexOfWorker) {
        if (indexOfWorker >= 0 && indexOfWorker <= this.board.getWorkersOutside().size()) {
            this.listWorkerCard.add(this.board.takeWorker(indexOfWorker));
            setAction(this.action - 1);
        } else {
            System.err.println("/!\\ Aucun ouvrier trouvé avec l'index saisie /!\\");
        }
    }

    /**
     * Send a worker to a construction site
     *
     * @param indexOfWorkerToSend Index od worker to send to the construction site
     * @param indexOfConstruction Index of construction site on which the worker will work
     */
    public void sendworker(int indexOfWorkerToSend, int indexOfConstruction) {
        if (indexOfWorkerToSend >= 0 && indexOfWorkerToSend < this.listWorkerCard.size() && indexOfConstruction >= 0 && indexOfConstruction < this.listeConstruction.size()) {
            if (!this.listeConstruction.get(indexOfConstruction).calculateProgress()) {
                this.listeConstruction.get(indexOfConstruction).addWorker(this.listWorkerCard.get(indexOfWorkerToSend));
                setAction(this.action - 1);
            } else {
                System.err.println("/!\\ Ce chantier est déjà fini, vous ne pouvez pas rajouter d'ouvrier /!\\");
            }
        } else {
            System.err.println("/!\\ Aucun ouvrier et/ou chantier trouvé avec l'index saisie /!\\");
        }
    }

    /**
     * Add a card to the player's stack of building
     *
     * @param card Card to add
     */
    public void addCardToListBuildingCard(Cards card) {
        if (card != null) {
            this.listBuildingCard.add(card);
        } else {
            System.err.println("ERREUR addCardToListBuildingCard : carte à ajouter null");
        }
    }

    /**
     * Display player information
     *
     * @return String of characters
     */
    public String displayInfoPlayer() {
        return "=== " + this.ecu + " écu(s) | " + this.action + " action | " + this.victoryPoint + " point(s) de victoire";
    }

    /**
     * Display player workers
     *
     * @return String of characters
     */
    public String displayListWorkerCards() {
        String ret = "===== VOS OUVRIERS =====\n";
        if (this.listWorkerCard.size() == 0) {
            ret += "Vous n'avez pas encore d'Ouvrier\n";
        } else {
            ret += "\tNom:\tCout:\tPierre:\tBois:\tSavoir:\tTuile:\tPoint\n";
            for (int i = 0; i < this.listWorkerCard.size(); i++) {
                ret += i + ".\t" + this.listWorkerCard.get(i).getName() + "\t" +
                        "-" + this.listWorkerCard.get(i).getCost() + "\t" +
                        this.listWorkerCard.get(i).getStone() + "\t" +
                        this.listWorkerCard.get(i).getWood() + "\t" +
                        this.listWorkerCard.get(i).getKnowledge() + "\t" +
                        this.listWorkerCard.get(i).getTile() + "\n"
                ;
            }
        }
        ret += "\n=========================";
        return ret;
    }

    /**
     * Display player buildings
     *
     * @return String of characters
     */
    public String displayListBuildingCards() {
        String ret = "===== VOS BATIMENTS =====\n";
        if (this.listBuildingCard.size() == 0) {
            ret += "Vous n'avez pas encore de Batiment\n";
        } else {
            ret += "\tNom:\t\tCout:\tPierre:\tBois:\tSavoir:\tTuile:\tPoint:\tEcu:\n";
            for (int i = 0; i < this.listBuildingCard.size(); i++) {
                ret += i + ".\t" + this.listBuildingCard.get(i).getName() + "\t" +
                        this.listBuildingCard.get(i).getStone() + "\t" +
                        this.listBuildingCard.get(i).getWood() + "\t" +
                        this.listBuildingCard.get(i).getKnowledge() + "\t" +
                        this.listBuildingCard.get(i).getTile() +
                        //this.listBuildingCard.get(i).getPoint() + "\t" +
                        "+" + this.listBuildingCard.get(i).getCost() + "\n"
                ;
            }
        }
        ret += "\n=========================";
        return ret;
    }

    /**
     * Display player construction sites
     *
     * @return String of characters
     */
    public String displayListConstruction() {
        String ret = "===== VOS CHANTIERS =====\n";
        if (this.listeConstruction.size() == 0) {
            ret += "Vous n'avez pas encore de Chantier\n";
        } else {
            ret += "\tNom:\t\tPierre:\tBois:\tSavoir:\tTuile:\tFini:\tCout:\n";
            for (int i = 0; i < this.listeConstruction.size(); i++) {
                ret += i + ".\t" + this.listeConstruction.get(i).getItemToBuild().getName() + "\t" +
                        this.listeConstruction.get(i).getItemToBuild().getStone() + "\t" +
                        this.listeConstruction.get(i).getItemToBuild().getWood() + "\t" +
                        this.listeConstruction.get(i).getItemToBuild().getKnowledge() + "\t" +
                        this.listeConstruction.get(i).getItemToBuild().getTile() +
                        this.listeConstruction.get(i).calculateProgress() + "\t" +
                        "+" + this.listeConstruction.get(i).getItemToBuild().getCost() + "\n"
                ;
            }
        }
        ret += "\n=========================";
        return ret;
    }

    /**
     * Show buildings to draw
     *
     * @return String of characters
     */
    public String displayBuildingsOutside() {
        String ret = "=== BATIMENTS DISPOS ===\n";
        if (this.board.getBuildingsOutside().size() == 0) {
            ret += "Il n'y a plus de carte Batiment disponible\n";
        } else {
            ret += "\tNom:\t\tPierre:\tBois:\tSavoir:\tTuile:\tPoint:\tCout:\n";
            for (int i = 0; i < this.board.getBuildingsOutside().size(); i++) {
                ret += i + ".\t" + this.board.getBuildingsOutside().get(i).getName() + "\t" +
                        this.board.getBuildingsOutside().get(i).getStone() + "\t" +
                        this.board.getBuildingsOutside().get(i).getWood() + "\t" +
                        this.board.getBuildingsOutside().get(i).getKnowledge() + "\t" +
                        this.board.getBuildingsOutside().get(i).getTile() +
                        //this.board.getWorkersOutside().get(i).getPoint() + "\t" +
                        "+" + this.board.getBuildingsOutside().get(i).getCost() + "\n"
                ;
            }
        }
        ret += "\n=========================";
        return ret;
    }

    /**
     * Show workers to draw
     *
     * @return String of characters
     */
    public String displayWorkersOutside() {
        String ret = "=== OUVRIERS DISPOS ===\n";
        if (this.board.getWorkersOutside().size() == 0) {
            ret += "Il n'y a plus de carte Ouvrier disponible\n";
        } else {
            ret += "\tNom:\t\tPierre:\tBois:\tSavoir:\tTuile:\tCout:\n";
            for (int i = 0; i < this.board.getWorkersOutside().size(); i++) {
                ret += i + ".\t" + this.board.getWorkersOutside().get(i).getName() + "\t" +
                        this.board.getWorkersOutside().get(i).getStone() + "\t" +
                        this.board.getWorkersOutside().get(i).getWood() + "\t" +
                        this.board.getWorkersOutside().get(i).getKnowledge() + "\t" +
                        this.board.getWorkersOutside().get(i).getTile() +
                        "+" + this.board.getWorkersOutside().get(i).getCost() + "\n"
                ;
            }
        }
        ret += "\n=========================";
        return ret;
    }
}