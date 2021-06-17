package game;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConstructionTest {

    @Test
    public void calculateProgress() {
        Construction construction = new(new Building(3, 2, 2, 3, 18, 5));
        construction.addWorker(new Worker(2, 2, 1, 1, 5));
        construction.addWorker(new Worker(1, 0, 1, 2, 7));
        assertEquals(true, construction.calculateProgress());
    }

    @Test
    public void addWorker() {
        Construction construction = new(new Building(3, 2, 2, 3, 18, 5));
        construction.addWorker(new Worker(2, 2, 1, 1, 5));
        construction.addWorker(new Worker(1, 0, 1, 2, 7));
        assertEquals(2, construction.workers.size());
    }

}