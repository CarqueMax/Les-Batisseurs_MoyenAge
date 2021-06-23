package game;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * "Worker" card of the game
 *
 * @author CHARGÉ Maxime - IUT Vannes
 * @version 1.0
 */
public class Worker extends Cards {
    /**
     * Worker constructor
     *
     * @param scanOfBoard Board class scanner that reads the file
     */
    public Worker(Scanner scanOfBoard) throws FileNotFoundException {
        super(scanOfBoard);
    }
}