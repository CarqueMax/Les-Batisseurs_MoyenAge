import game.Difficulties;
import game.Game;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Launch of the game
 *
 * @author CHARGÉ Maxime - IUT Vannes
 * @version 1.0
 */
public class GameLauncher {
    /**
     * Starts game startup (configuration, parameter, game)
     *
     * @param args Default argument
     */
    public static void main(String[] args) {
        System.out.println("" +
                "  _                ____        _   _                                   __  __                                _              \n" +
                " | |    ___  ___  | __ )  __ _| |_(_)___ ___  ___ _   _ _ __ ___   _  |  \\/  | ___  _   _  ___ _ __         / \\   __ _  ___ \n" +
                " | |   / _ \\/ __| |  _ \\ / _` | __| / __/ __|/ _ \\ | | | '__/ __| (_) | |\\/| |/ _ \\| | | |/ _ \\ '_ \\ _____ / _ \\ / _` |/ _ \\\n" +
                " | |__|  __/\\__ \\ | |_) | (_| | |_| \\__ \\__ \\  __/ |_| | |  \\__ \\  _  | |  | | (_) | |_| |  __/ | | |_____/ ___ \\ (_| |  __/\n" +
                " |_____\\___||___/ |____/ \\__,_|\\__|_|___/___/\\___|\\__,_|_|  |___/ (_) |_|  |_|\\___/ \\__, |\\___|_| |_|    /_/   \\_\\__, |\\___|\n" +
                "                                                                                    |___/                        |___/      \n"
        );
        System.out.println("====================================================================================");
        ArrayList<String> playerNameList = new ArrayList<>();
        ArrayList<Difficulties> difficultyOfRobot = new ArrayList<>();
        int numberOfHumanPlayer = 0;
        int numberOfAutoPlayer = 0;

        System.out.println("===> Entrer le nombre de joueur humain (4 max):");
        Scanner scan = new Scanner(System.in);
        boolean saisie = false;
        do {
            if (scan.hasNextInt()) {
                numberOfHumanPlayer = scan.nextInt();
                saisie = true;
            } else {
                scan.next();
                System.err.println("Entrer un nombre entier, recommencez :");
            }
        } while (numberOfHumanPlayer < 0 || numberOfHumanPlayer > 4 || !saisie);

        int numberPlayerRemaining = 4 - numberOfHumanPlayer;
        if (numberPlayerRemaining > 0) {
            System.out.println("===> Entrer le nombre de joueur robot (encore " + numberPlayerRemaining + " possible(s)):");
            saisie = false;
            do {
                if (scan.hasNextInt()) {
                    numberOfAutoPlayer = scan.nextInt();
                    saisie = true;
                } else {
                    scan.next();
                    System.err.println("Entrer un nombre entier, recommencez :");
                }
            } while (numberOfAutoPlayer < 0 || numberOfAutoPlayer > numberPlayerRemaining || (numberOfAutoPlayer + numberOfHumanPlayer < 2) || !saisie);
        }

        if (numberOfHumanPlayer > 0) {
            for (int i = 1; i <= numberOfHumanPlayer; i++) {
                System.out.println("===> Entrer le nom du joueur humain " + i);
                String nameOfHumanPlayer = scan.nextLine();
                playerNameList.add(nameOfHumanPlayer);
            }
        }

        System.out.println("==========================================");

        if (numberOfAutoPlayer > 0) {
            for (int i = 1; i <= numberOfAutoPlayer; i++) {
                System.out.println("===> Entrer le nom du joueur robot " + i);
                String nameOfAutoPlayer = scan.nextLine();
                playerNameList.add(nameOfAutoPlayer);

                System.out.println("\nDifficulté :\n" +
                        "0. Facile\n" +
                        "1. Moyen\n" +
                        "2. Difficile"
                );
                System.out.println("\n> Entrer la difficulté du joueur robot " + i);
                int choiceDiff = 0;
                saisie = false;
                do {
                    System.out.print("Entrer une valeur : ");
                    if (scan.hasNextInt()) {
                        choiceDiff = scan.nextInt();
                        saisie = true;
                    } else {
                        scan.next();
                        System.err.println("Entrer un nombre entier, recommencez :");
                    }
                } while (choiceDiff < 0 || choiceDiff > 2 || !saisie);

                Difficulties diff = null;
                switch (choiceDiff) {
                    case 0:
                        diff = Difficulties.EASY;
                        break;
                    case 1:
                        diff = Difficulties.MEDIUM;
                        break;
                    case 2:
                        diff = Difficulties.HARD;
                        break;
                }
                difficultyOfRobot.add(diff);
            }
        }

        System.out.println("====================================================================================");

        Game game = new Game(playerNameList, difficultyOfRobot, numberOfHumanPlayer, numberOfAutoPlayer);
        game.start();
    }
}