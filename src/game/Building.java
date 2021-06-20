package game;

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
    public Building(Scanner scanOfBoard) {
        super(scanOfBoard);
        this.point = scanOfBoard.nextInt();
    }

    /**
     * Change the value of the building points
     *
     * @param point Point of the building to put
     */
    public void setPoint(int point) {
        if (point >= 0) {
            this.point = point;
        } else {
            System.err.println("ERREUR setPoint : valeur de point inférieur à 0");
        }
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