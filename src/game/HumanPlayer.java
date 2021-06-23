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
        this.action += 3;
        while (this.action > 0) {
            System.out.println(displayInfoPlayer());
            System.out.println(displayListWorkerCards());
            System.out.println(displayListBuildingCards());
            System.out.println(displayListConstruction());
            System.out.println(displayWorkersOutside());
            System.out.println(displayBuildingsOutside());
            System.out.println("" +
                    "0. Recruter un nouvelle ouvrier (coute 1 action)\n" +
                    "1. Envoyer un ouvrier sur un chantier (coute 1 action)\n" +
                    "2. Ouvrir un nouveau chantier (coute 1 action)\n" +
                    "3. Echanger une action contre des écus\n" +
                    "4. Acheter une action\n" +
                    "5. Passer son tour\n" +
                    "6. Sauvegarder la partie\n" +
                    "7. Quitter la partie"
            );

            int choiceNumber = 0;
            do {
                System.out.print("Entrer une valeur :");
                if (this.scan.hasNextInt()) {
                    choiceNumber = this.scan.nextInt();
                } else {
                    this.scan.next();
                    System.err.println("Entrer un nombre entier, recommencez :");
                }
            } while (choiceNumber < 0 || choiceNumber > 7);

            switch (choiceNumber) {
                case 0: // Recruter un nouvelle ouvrier
                    System.out.println("Entrer le numéro de l'ouvrier à recruter :");
                    int choiceWorker = 0;
                    boolean quit = false;
                    do {
                        if (this.scan.hasNextInt()) {
                            choiceWorker = this.scan.nextInt();
                            quit = true;
                        } else {
                            this.scan.next();
                            System.err.println("Entrer un nombre entier, recommencez :");
                        }
                    } while (!quit);
                    recruitWorker(choiceWorker);
                    break;
                case 1: // Envoyer un ouvrier sur un chantier
                    System.out.println("Entrer le numéro de l'ouvrier à envoyer en chantier :");
                    choiceWorker = 0;
                    quit = false;
                    do {
                        if (this.scan.hasNextInt()) {
                            choiceWorker = this.scan.nextInt();
                            quit = true;
                        } else {
                            this.scan.next();
                            System.err.println("Entrer un nombre entier, recommencez :");
                        }
                    } while (!quit);
                    System.out.println("Entrer le numéro du chantier sur lequel vous allez envoyer un ouvrier :");
                    int choiceConstruction = 0;
                    quit = false;
                    do {
                        if (this.scan.hasNextInt()) {
                            choiceConstruction = this.scan.nextInt();
                            quit = true;
                        } else {
                            this.scan.next();
                            System.err.println("Entrer un nombre entier, recommencez :");
                        }
                    } while (!quit);
                    sendworker(choiceWorker, choiceConstruction);
                    break;
                case 2: // Ouvrir un nouveau chantier
                    System.out.println("Entrer le numéro du chantier que vous souhaitez ouvrir :");
                    choiceConstruction = 0;
                    quit = false;
                    do {
                        if (this.scan.hasNextInt()) {
                            choiceConstruction = this.scan.nextInt();
                            quit = true;
                        } else {
                            this.scan.next();
                            System.err.println("Entrer un nombre entier, recommencez :");
                        }
                    } while (!quit);
                    openConstruction(choiceConstruction);
                    break;
                case 3: // Echanger une action contre des écus
                    actionToEcu();
                    break;
                case 4: // Acheter une action
                    System.out.println("Entrer le nombre d'action que vous souhaitez acheter :");
                    int numberOfAction = 0;
                    quit = false;
                    do {
                        if (this.scan.hasNextInt()) {
                            numberOfAction = this.scan.nextInt();
                            quit = true;
                        } else {
                            this.scan.next();
                            System.err.println("Entrer un nombre entier, recommencez :");
                        }
                    } while (!quit);
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
}