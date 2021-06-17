package game;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void checkScore() {
        ArrayList<Building> pileBuilding;
        ArrayList<Worker> pileWorker;
        ArrayList<Player> playerList;
        Board board = new Board(15, 10, pileBuilding, pileWorker);
        HumanPlayer humanPlayer = new HumanPlayer("Player1", board, new Apprentice(5, 2, 1, 2, 5);
        humanPlayer.ecuToVictoryPoint(5);
        playerList.add(humanPlayer);
        Game game = new Game(board, playerList);
        assertEquals(false, game.checkScore());
    }

    @Test
    public void desciption() {
        ArrayList<Building> pileBuilding;
        ArrayList<Worker> pileWorker;
        Game game = new Game(new Board(15, 10, pileBuilding, pileWorker));
        assertEquals("Règles/Statistiques", game.desciption());
    }

}