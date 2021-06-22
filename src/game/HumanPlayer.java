package game;

import java.util.Scanner;

/**
 * Human player management
 *
 * @author CHARGÉ Maxime - IUT Vannes
 * @version 1.0
 */
public class HumanPlayer extends Player {
    private Scanner scan;

    /**
     * HumanPlayer constructor
     *
     * @param name  Human player name
     * @param board Board on which the human player plays
     * @param card  Randomly chosen "Apprentice" card at the start of the game
     */
    public HumanPlayer(String name, Board board, Apprentice card) {
        super(name, board, card);
        this.scan = new Scanner(System.in);
    }

    /**
     * The human player plays and can do different actions
     */
    public void play() {
        System.out.println(displayInfoPlayer());
        System.out.println(displayListWorkerCards());
        System.out.println(displayListBuildingCards());
        System.out.println(displayListConstruction());
        System.out.println("""
                Actions possible :
                0. Recruter un nouvelle ouvrier
                1. Envoyer un ouvrier sur un chantier
                2. Ouvrir un nouveau chantier
                3. Echanger une action contre des écus
                4. Acheter une action

                5. Passer son tour
                6. Sauvegarder la partie
                7. Quitter la partie
                """
        );

        int choiceNumber = 0;
        do {
            System.out.print("Entrer une valeur : ");
            if (this.scan.hasNextInt()) {
                choiceNumber = this.scan.nextInt();
            } else {
                this.scan.next();
                System.err.println("Entrer un nombre entier");
            }
        } while (choiceNumber < 0 || choiceNumber > 7);

        switch (choiceNumber) {
            case 0: // Recruter un nouvelle ouvrier
                System.out.println(displayWorkersOutside());
                int choiceWorker = 0;
                do {
                    if (this.scan.hasNextInt()) {
                        choiceWorker = this.scan.nextInt();
                    } else {
                        this.scan.next();
                        System.err.println("Entrer un nombre entier");
                    }
                } while (choiceWorker < 0 || choiceWorker >= this.board.getWorkersOutside().size());
                recruitWorker(choiceWorker);
                break;
            case 1: // Envoyer un ouvrier sur un chantier
                System.out.println(displayListWorkerCards());
                System.out.println(displayListConstruction());
                choiceWorker = 0;
                do {
                    if (this.scan.hasNextInt()) {
                        choiceWorker = this.scan.nextInt();
                    } else {
                        this.scan.next();
                        System.err.println("Entrer un nombre entier");
                    }
                } while (choiceWorker < 0 || choiceWorker >= this.listWorkerCard.size());
                int choiceConstruction = 0;
                do {
                    if (this.scan.hasNextInt()) {
                        choiceConstruction = this.scan.nextInt();
                    } else {
                        this.scan.next();
                        System.err.println("Entrer un nombre entier");
                    }
                } while (choiceConstruction < 0 || choiceConstruction >= this.listeConstruction.size());
                sendworker(choiceWorker, choiceConstruction);
                break;
            case 2: // Ouvrir un nouveau chantier
                System.out.println(displayBuildingsOutside());
                choiceConstruction = 0;
                do {
                    if (this.scan.hasNextInt()) {
                        choiceConstruction = this.scan.nextInt();
                    } else {
                        this.scan.next();
                        System.err.println("Entrer un nombre entier");
                    }
                } while (choiceConstruction < 0 || choiceConstruction >= this.board.getBuildingsOutside().size());
                openConstruction(choiceConstruction);
                break;
            case 3: // Echanger une action contre des écus
                actionToEcu();
                break;
            case 4: // Acheter une action
                int numberOfAcion = 0;
                do {
                    if (this.scan.hasNextInt()) {
                        numberOfAcion = this.scan.nextInt();
                    } else {
                        this.scan.next();
                        System.err.println("Entrer un nombre entier");
                    }
                } while (numberOfAcion <= 0);
                buyAction(numberOfAcion);
                break;
            case 5: // Passer son tour
                break;
            case 6: // Sauvegarder la partie
                //..
                break;
            case 7: // Quitter la partie
                //..
                break;
        }
        resetActionSaleCounter();
        coinToEcu();
    }
}