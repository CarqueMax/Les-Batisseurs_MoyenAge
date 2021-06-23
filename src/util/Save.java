package util;

import game.Game;

import java.io.*;

/**
 * Manage game saves
 *
 * @author CHARGÉ Maxime - IUT Vannes
 * @version 1.0
 */
public class Save {
    private String fileName;

    public Save(String fileName) {
        if(fileName != null) {
            this.fileName = fileName;
        } else {
            System.err.println("ERREUR Save : fileName null");
        }
    }

    /**
     * Save a game to a file
     *
     * @param fileName Backup file name
     */
    public void saveGame(String fileName) throws IOException {
        if (fileName != null) {
            ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(fileName));
            save.writeObject(this);
            save.close();
        } else {
            System.err.println("ERREUR loadGame : fileName null");
        }
    }

    /**
     * Load an existing save and resume the game
     *
     * @param fileName Backup file name
     * @return game load
     */
    public Game loadGame(String fileName) throws IOException, ClassNotFoundException {
        Game gameLoad = null;
        if (fileName != null) {
            ObjectInputStream load = new ObjectInputStream(new FileInputStream(fileName));
            gameLoad = (Game) load.readObject();
            load.close();
        } else {
            System.err.println("ERREUR loadGame : fileName null");
        }
        return gameLoad;
    }
}