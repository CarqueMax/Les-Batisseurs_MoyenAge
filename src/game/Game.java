package game;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Game management
 *
 * @author CHARGÉ Maxime - IUT Vannes
 * @version 1.0
 */
public class Game implements IGame {
    private ArrayList<Player> playerList;
    private Board board;
    private int currentPlayerId;
    private Player currentPlayer;

    /**
     * Game constructor
     *
     * @param playerNameList    List of players
     * @param difficultyOfRobot Difficulty of robot players
     * @param numberHuman       Number of human player
     * @param numberRobot       Number of robot player
     */
    public Game(ArrayList<String> playerNameList, ArrayList<Difficulties> difficultyOfRobot, int numberHuman, int numberRobot) {
        if (playerNameList != null && difficultyOfRobot != null && numberHuman >= 0 && numberHuman <= 4 && numberRobot >= 0 && numberRobot <= 4) {
            initializeGame(playerNameList, difficultyOfRobot, numberHuman, numberRobot);
        } else {
            System.err.println("ERREUR Game : arguments null");
        }
    }

    /**
     * Initializes the game by creating players, distributing cards ...
     *
     * @param playerNameList    List of players
     * @param difficultyOfRobot Difficulty of robot players
     * @param numberHuman       Number of human player
     * @param numberRobot       Number of robot player
     */
    public void initializeGame(ArrayList<String> playerNameList, ArrayList<Difficulties> difficultyOfRobot, int numberHuman, int numberRobot) {
        this.playerList = new ArrayList<>();
        this.board = new Board();
        createPlayer(playerNameList, difficultyOfRobot, numberHuman, numberRobot);
    }

    /**
     * Create players based on game mode
     *
     * @param playerNameList    List of players
     * @param difficultyOfRobot Difficulty of robot players
     * @param numberHuman       Number of human player
     * @param numberRobot       Number of robot player
     */
    private void createPlayer(ArrayList<String> playerNameList, ArrayList<Difficulties> difficultyOfRobot, int numberHuman, int numberRobot) {
        int indexNamePlayer = 0;
        for (int i = 0; i < numberHuman; i++) {
            HumanPlayer HPlayer = new HumanPlayer(playerNameList.get(indexNamePlayer), this.board, this.board.randomDetributeApprentices());
            this.playerList.add(HPlayer);
            indexNamePlayer++;
        }
        for (int i = 0; i < numberRobot; i++) {
            AutoPlayer APlayer = new AutoPlayer(playerNameList.get(indexNamePlayer), this.board, this.board.randomDetributeApprentices(), difficultyOfRobot.get(i));
            this.playerList.add(APlayer);
            indexNamePlayer++;
        }
    }

    /**
     * Change player
     */
    public void changeCurrentPlayer() {
        if (this.currentPlayerId == this.playerList.size() - 1) {
            this.currentPlayerId = 0;
        } else {
            this.currentPlayerId++;
        }
        this.currentPlayer = this.playerList.get(this.currentPlayerId);
    }

    /**
     * Check if there is a winner (17 victory points)
     *
     * @return True if there is a winner, otherwise false
     */
    public boolean checkScore() {
        boolean winner = false;
        for (int i = 0; i < this.playerList.size() && !winner; i++) {
            if (this.playerList.get(i).getVictoryPoint() >= 17) {
                winner = true;
            }
        }
        return winner;
    }

    public void firstPlayerDraw() {
        Random random = new Random();
        this.currentPlayerId = random.nextInt(this.playerList.size() - 1);
        this.currentPlayer = this.playerList.get(currentPlayerId);
    }

    /**
     * View game rules and card statistics
     */
    public void description() {
        if (Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
            try {
                Desktop.getDesktop().open(new File("../../data/LES-BATISSEURS_MOYEN-AGE_rulebook_FR.pdf"));
            } catch (IOException ex) {
                System.err.println("ERREUR desciption : Desktop n'est pas prise en charge sur votre ordinateur. Voici une autre source pour consulter les règles : https://www.cjoint.com/c/KFwac2IlDVT");
            }
        }
    }

    /**
     * Start the game part
     */
    public void start() {
        description();
        firstPlayerDraw();
        while (checkScore()) {
            currentPlayer.play();
            changeCurrentPlayer();
        }
        endOfGame();
    }

    /**
     * End of the game, announces the winner and the statistics of the game
     */
    public void endOfGame() {
    }
}