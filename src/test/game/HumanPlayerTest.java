package game;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HumanPlayerTest {

    @Test
    public void setEcu() {
        int ecu = 10;
        HumanPlayer player = new HumanPlayer("Player1", new Board(new ArrayList<Cards>(), new ArrayList<Cards>()), new ArrayList<Cards>());
        player.setEcu(ecu);
        assertEquals(ecu, player.getEcu());
    }

    @Test
    public void getEcu() {
        int ecu = 10;
        HumanPlayer player = new HumanPlayer("Player1", new Board(new ArrayList<Cards>(), new ArrayList<Cards>()), new ArrayList<Cards>());
        player.setEcu(ecu);
        assertEquals(player.getEcu(), ecu);
    }

    @Test
    public void setSilverCoin() {
        int silverCoin = 10;
        HumanPlayer player = new HumanPlayer("Player1", new Board(new ArrayList<Cards>(), new ArrayList<Cards>()), new ArrayList<Cards>());
        player.setSilverCoin(silverCoin);
        assertEquals(silverCoin, player.getSilverCoin());
    }

    @Test
    public void getSilverCoin() {
        int silverCoin = 10;
        HumanPlayer player = new HumanPlayer("Player1", new Board(new ArrayList<Cards>(), new ArrayList<Cards>()), new ArrayList<Cards>());
        player.setSilverCoin(silverCoin);
        assertEquals(player.getSilverCoin(), silverCoin);
    }

    @Test
    public void setGoldenCoin() {
        int goldenCoin = 10;
        HumanPlayer player = new HumanPlayer("Player1", new Board(new ArrayList<Cards>(), new ArrayList<Cards>()), new ArrayList<Cards>());
        player.setGoldenCoin(goldenCoin);
        assertEquals(goldenCoin, player.getGoldenCoin());
    }

    @Test
    public void getGoldenCoin() {
        int goldenCoin = 10;
        HumanPlayer player = new HumanPlayer("Player1", new Board(new ArrayList<Cards>(), new ArrayList<Cards>()), new ArrayList<Cards>());
        player.setGoldenCoin(goldenCoin);
        assertEquals(player.getGoldenCoin(), goldenCoin);
    }

    @Test
    public void setAction() {
        int action = 2;
        HumanPlayer player = new HumanPlayer("Player1", new Board(new ArrayList<Cards>(), new ArrayList<Cards>()), new ArrayList<Cards>());
        player.setAction(action);
        assertEquals(action, player.action);
    }

    @Test
    public void coinToEcu() {
        int coin = 3;
        HumanPlayer player = new HumanPlayer("Player1", new Board(new ArrayList<Cards>(), new ArrayList<Cards>()), new ArrayList<Cards>());
        assertEquals(player.getEcu(), player.coinToEcu(coin));
    }

    @Test
    public void ecuToVictoryPoint() {
        int ecu = 3;
        HumanPlayer player = new HumanPlayer("Player1", new Board(new ArrayList<Cards>(), new ArrayList<Cards>()), new ArrayList<Cards>());
        assertEquals(player.getVictoryPoint(), player.ecuToVictoryPoint(ecu));
    }

    @Test
    public void getVictoryPoint() {
        int ecu = 2;
        HumanPlayer player = new HumanPlayer("Player1", new Board(new ArrayList<Cards>(), new ArrayList<Cards>()), new ArrayList<Cards>());
        assertEquals(player.getVictoryPoint(), player.ecuToVictoryPoint(ecu));
    }
}