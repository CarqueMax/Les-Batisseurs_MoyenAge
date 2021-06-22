package game;

import javax.swing.plaf.basic.BasicBorders;
import java.util.Random;

/**
 * Autoplayer management
 *
 * @author CHARGÉ Maxime - IUT Vannes
 * @version 1.0
 */
public class AutoPlayer extends Player {
    private Difficulties difficulty;
    private Random random;

    /**
     * AutoPlayer constructor
     *
     * @param name       Autoplayer name
     * @param board      Board on which the autoplayer plays
     * @param card       Randomly chosen "Apprentice" card at the start of the game
     * @param difficulty Autoplayer difficulty
     */
    public AutoPlayer(String name, Board board, Apprentice card, Difficulties difficulty) {
        super(name, board, card);
        if (difficulty != null) {
            this.difficulty = difficulty;
            this.random = new Random();
        } else {
            System.err.println("ERREUR AutoPlayer : difficulté null");
        }
    }

    /**
     * The autoplayer plays and can do different actions
     */
    public void play() {

    }

    /**
     * Get the difficulty of the autoplayer
     *
     * @return difficulty of autoplayer
     */
    public Difficulties getDifficulty() {
        return this.difficulty;
    }
}