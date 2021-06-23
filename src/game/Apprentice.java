package game;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * "Apprentice" card of the game
 *
 * @author CHARGÉ Maxime - IUT Vannes
 * @version 1.0
 */
public class Apprentice extends Worker {
    /**
     * Apprentice constructor
     *
     * @param scanOfBoard Board class scanner that reads the file
     */
    public Apprentice(Scanner scanOfBoard) throws FileNotFoundException {
        super(scanOfBoard);
    }
}