package game;

import java.util.Scanner;

/**
 * "Machine" card of the game
 *
 * @author CHARGÉ Maxime - IUT Vannes
 * @version 1.0
 */
public class Machine extends Cards {
    private String name;
    private int cost;
    private int stone;
    private int wood;
    private int knowledge;
    private int tile;
    private int point;
    private int stoneToBuild;
    private int woodToBuild;
    private int knowledgeToBuild;
    private int tileToBuild;

    /**
     * Machine constructor
     *
     * @param scanOfBoard Board class scanner that reads the file
     */
    public Machine(Scanner scanOfBoard) throws IllegalArgumentException {
        if (scanOfBoard != null) {
            this.name = scanOfBoard.next();
            this.cost = scanOfBoard.nextInt();
            this.stone = scanOfBoard.nextInt();
            this.wood = scanOfBoard.nextInt();
            this.knowledge = scanOfBoard.nextInt();
            this.tile = scanOfBoard.nextInt();
            this.point = scanOfBoard.nextInt();
            this.stoneToBuild = scanOfBoard.nextInt();
            this.woodToBuild = scanOfBoard.nextInt();
            this.knowledgeToBuild = scanOfBoard.nextInt();
            this.tileToBuild = scanOfBoard.nextInt();
        }
    }

    /**
     * Sets the cost of the card to 0
     */
    public void setCostNull() {
        setCost(0);
    }

    /**
     * Return the number of points of the machine
     *
     * @return Number of points
     */
    public int getPoint() {
        return this.point;
    }

    /**
     * Return the number of stones needed to build the machine
     *
     * @return Number of stone
     */
    public int getStoneToBuild() {
        return this.stoneToBuild;
    }

    /**
     * Return the number of woods needed to build the machine
     *
     * @return Number of wood
     */
    public int getWoodToBuild() {
        return this.woodToBuild;
    }

    /**
     * Return the number of knowledge needed to build the machine
     *
     * @return Number of knowmedge
     */
    public int getKnowledgeToBuild() {
        return this.knowledgeToBuild;
    }

    /**
     * Return the number of tiles needed to build the machine
     *
     * @return Number of tile
     */
    public int getTileToBuild() {
        return this.tileToBuild;
    }
}