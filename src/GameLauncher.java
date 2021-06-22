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
    public void main(String[] args) {
        System.out.println("""
                lllllll                        BBBBBBBBBBBBBBBBB                                                tttt                                               \s
                l:::::l                        B::::::::::::::::B                                            ttt:::t                                               \s
                l:::::l                        B::::::BBBBBB:::::B                                           t:::::t                                               \s
                l:::::l                        BB:::::B     B:::::B                                          t:::::t                                               \s
                 l::::l   aaaaaaaaaaaaa          B::::B     B:::::B    eeeeeeeeeeee    uuuuuu    uuuuuuttttttt:::::ttttttt        eeeeeeeeeeee    uuuuuu    uuuuuu \s
                 l::::l   a::::::::::::a         B::::B     B:::::B  ee::::::::::::ee  u::::u    u::::ut:::::::::::::::::t      ee::::::::::::ee  u::::u    u::::u \s
                 l::::l   aaaaaaaaa:::::a        B::::BBBBBB:::::B  e::::::eeeee:::::eeu::::u    u::::ut:::::::::::::::::t     e::::::eeeee:::::eeu::::u    u::::u \s
                 l::::l            a::::a        B:::::::::::::BB  e::::::e     e:::::eu::::u    u::::utttttt:::::::tttttt    e::::::e     e:::::eu::::u    u::::u \s
                 l::::l     aaaaaaa:::::a        B::::BBBBBB:::::B e:::::::eeeee::::::eu::::u    u::::u      t:::::t          e:::::::eeeee::::::eu::::u    u::::u \s
                 l::::l   aa::::::::::::a        B::::B     B:::::Be:::::::::::::::::e u::::u    u::::u      t:::::t          e:::::::::::::::::e u::::u    u::::u \s
                 l::::l  a::::aaaa::::::a        B::::B     B:::::Be::::::eeeeeeeeeee  u::::u    u::::u      t:::::t          e::::::eeeeeeeeeee  u::::u    u::::u \s
                 l::::l a::::a    a:::::a        B::::B     B:::::Be:::::::e           u:::::uuuu:::::u      t:::::t    tttttte:::::::e           u:::::uuuu:::::u \s
                l::::::la::::a    a:::::a      BB:::::BBBBBB::::::Be::::::::e          u:::::::::::::::uu    t::::::tttt:::::te::::::::e          u:::::::::::::::uu
                l::::::la:::::aaaa::::::a      B:::::::::::::::::B  e::::::::eeeeeeee   u:::::::::::::::u    tt::::::::::::::t e::::::::eeeeeeee   u:::::::::::::::u
                l::::::l a::::::::::aa:::a     B::::::::::::::::B    ee:::::::::::::e    uu::::::::uu:::u      tt:::::::::::tt  ee:::::::::::::e    uu::::::::uu:::u
                llllllll  aaaaaaaaaa  aaaa     BBBBBBBBBBBBBBBBB       eeeeeeeeeeeeee      uuuuuuuu  uuuu        ttttttttttt      eeeeeeeeeeeeee      uuuuuuuu  uuuu"""
        );

        ArrayList<String> playerNameList = new ArrayList<>();
        ArrayList<Difficulties> difficultyOfRobot = new ArrayList<>();
        int numberOfHumanPlayer = 0;
        int numberOfAutoPlayer = 0;

        System.out.println("Entrer le nombre de joueur humain:");
        Scanner scan = new Scanner(System.in);
        do {
            if (scan.hasNextInt()) {
                numberOfHumanPlayer = scan.nextInt();
            } else {
                scan.next();
                System.err.println("Entrer un nombre entier");
            }
        } while (numberOfHumanPlayer < 0 || numberOfHumanPlayer > 4);

        int numberPlayerRemaining = 4 - numberOfHumanPlayer;
        if (numberPlayerRemaining > 0) {
            System.out.println("Entrer le nombre de joueur robot (encore " + numberPlayerRemaining + " possible(s)):");
            do {
                if (scan.hasNextInt()) {
                    numberOfAutoPlayer = scan.nextInt();
                } else {
                    scan.next();
                    System.err.println("Entrer un nombre entier");
                }
            } while (numberOfAutoPlayer < 0 || numberOfAutoPlayer > numberPlayerRemaining);
        }

        if (numberOfHumanPlayer > 0) {
            for (int i = 1; i <= numberOfHumanPlayer; i++) {
                System.out.println("Entrer le nom du joueur humain" + i);
                String nameOfHumanPlayer = scan.nextLine();
                playerNameList.add(nameOfHumanPlayer);
            }
        }

        if (numberOfAutoPlayer > 0) {
            for (int i = 1; i <= numberOfAutoPlayer; i++) {
                System.out.println("Entrer le nom du joueur robot" + i);
                String nameOfAutoPlayer = scan.nextLine();
                playerNameList.add(nameOfAutoPlayer);

                System.out.println("""
                        Difficulté :
                        0. Facile
                        1. Moyen
                        2. Difficile"""
                );
                System.out.println("Entrer la difficulté du joueur robot" + i);
                int choiceDiff = 0;
                do {
                    System.out.print("Entrer une valeur : ");
                    if (scan.hasNextInt()) {
                        choiceDiff = scan.nextInt();
                    } else {
                        scan.next();
                        System.err.println("Entrer un nombre entier");
                    }
                } while (choiceDiff < 0 || choiceDiff > 2);

                Difficulties diff = switch (choiceDiff) {
                    case 0 -> Difficulties.EASY;
                    case 1 -> Difficulties.MEDIUM;
                    case 2 -> Difficulties.HARD;
                    default -> null;
                };
                difficultyOfRobot.add(diff);
            }
        }

        Game game = new Game(playerNameList, difficultyOfRobot, numberOfHumanPlayer, numberOfAutoPlayer);
        game.start();
    }
}