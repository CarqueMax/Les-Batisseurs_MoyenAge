package game;

import java.util.Random;

/**
 * Autoplayer management
 *
 * @author CHARGÉ Maxime - IUT Vannes
 * @version 1.0
 */
public class AutoPlayer extends Player {
    private Difficulties difficulty;
    private Random random;

    /**
     * AutoPlayer constructor
     *
     * @param name       Autoplayer name
     * @param board      Board on which the autoplayer plays
     * @param card       Randomly chosen "Apprentice" card at the start of the game
     * @param difficulty Autoplayer difficulty
     */
    public AutoPlayer(String name, Board board, Apprentice card, Difficulties difficulty) {
        super(name, board, card);
        if (difficulty != null) {
            this.difficulty = difficulty;
            this.random = new Random();
        } else {
            System.err.println("ERREUR AutoPlayer : difficulté null");
        }
    }

    /**
     * The autoplayer plays and can do different actions
     */
    public void play() {
        this.action += 3;
        while (this.action > 0) {
            int choiceNumber = this.random.nextInt(7);

            switch (choiceNumber) {
                case 0: // Recruter un nouvelle ouvrier
                    int choiceWorker = this.random.nextInt(this.board.getWorkersOutside().size() - 1);
                    recruitWorker(choiceWorker);
                    break;
                case 1: // Envoyer un ouvrier sur un chantier
                    choiceWorker = this.random.nextInt(this.listBuildingCard.size() - 1);
                    int choiceConstruction = this.random.nextInt(this.listBuildingCard.size() - 1);
                    sendworker(choiceWorker, choiceConstruction);
                    break;
                case 2: // Ouvrir un nouveau chantier
                    choiceConstruction = this.random.nextInt(this.board.getBuildingsOutside().size() - 1);
                    openConstruction(choiceConstruction);
                    break;
                case 3: // Echanger une action contre des écus
                    actionToEcu();
                    break;
                case 4: // Acheter une action
                    System.out.println("Entrer le nombre d'action que vous souhaitez acheter :");
                    int numberOfAction = this.random.nextInt(5);
                    buyAction(numberOfAction);
                    break;
                case 5: // Passer son tour
                    break;
                case 6: // Sauvegarder la partie
                    System.err.println("Pas encore de sauvegarde dispo");
                    break;
                case 7: // Quitter la partie
                    System.exit(1);
                    break;
            }
        }
        resetActionSaleCounter();
    }

    /**
     * Get the difficulty of the autoplayer
     *
     * @return difficulty of autoplayer
     */
    public Difficulties getDifficulty() {
        return this.difficulty;
    }
}