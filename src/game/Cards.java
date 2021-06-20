package game;

import java.util.Scanner;

/**
 * Cards of the game
 *
 * @author CHARGÉ Maxime - IUT Vannes
 * @version 1.0
 */
public abstract class Cards {
    private String name;
    private int cost;
    private int stone;
    private int wood;
    private int knowledge;
    private int tile;

    /**
     * Cards constructor
     *
     * @param scanOfBoard Board class scanner that reads the file
     */
    public Cards(Scanner scanOfBoard) {
        if (scanOfBoard != null) {
            this.name = scanOfBoard.next();
            this.cost = scanOfBoard.nextInt();
            this.stone = scanOfBoard.nextInt();
            this.wood = scanOfBoard.nextInt();
            this.knowledge = scanOfBoard.nextInt();
            this.tile = scanOfBoard.nextInt();
        } else {
            System.err.println("ERREUR Cards : arguments null");
        }
    }

    /**
     * Return the name of the card
     *
     * @return Name of the card
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return the cost of the card
     *
     * @return Cost of the card
     */
    public int getCost() {
        return this.cost;
    }

    /**
     * Return the amount of stone on the card
     *
     * @return Amount of stone on the card
     */
    public int getStone() {
        return this.stone;
    }

    /**
     * Return the amount of wood on the card
     *
     * @return Amount of wood on the card
     */
    public int getWood() {
        return this.wood;
    }

    /**
     * Return the amount of knowledge on the card
     *
     * @return Amount of knowledge on the card
     */
    public int getKnowledge() {
        return this.knowledge;
    }

    /**
     * Return the amount of tile on the card
     *
     * @return Amount of tile on the card
     */
    public int getTile() {
        return this.tile;
    }
}