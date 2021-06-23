package game;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * "Building" card of the game
 *
 * @author CHARGÉ Maxime - IUT Vannes
 * @version 1.0
 */
public class Building extends Cards {
    private int point;

    /**
     * Building constructor
     *
     * @param scanOfBoard Board class scanner that reads the file
     */
    public Building(Scanner scanOfBoard) throws FileNotFoundException {
        super(scanOfBoard);
        this.point = scanOfBoard.nextInt();
    }

    /**
     * Return the number of points of the building
     *
     * @return Number of points
     */
    public int getPoint() {
        return this.point;
    }
}