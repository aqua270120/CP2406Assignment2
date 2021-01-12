package Test;

import Model.ConstructionAlmostDone;
import Model.Road;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructionAlmostDoneTest {
    Road road = new Road("0", 1, 6, new int[]{0, 0}, Road.Orientation.HORIZONTAL);
    ConstructionAlmostDone constructionAlmostDone = new ConstructionAlmostDone("1", road);

    @Test
    void getWaitingTime() {
        assertEquals(3, constructionAlmostDone.getWaitingTime());
    }

    @Test
    void getId() {
        assertEquals("construction_1", constructionAlmostDone.getId());
    }

    @Test
    void getLocation() {
        assertEquals(3, constructionAlmostDone.getLocation()[0]);
    }

    //
    @Test
    void getRoadAttachedTo() {
        assertEquals(road, constructionAlmostDone.getRoadAttachedTo());
    }

    //
    @Test
    void getStatus() {
        assertEquals("done", constructionAlmostDone.getStatus());
    }

    //
    @Test
    void checkWaitingTime() {

        constructionAlmostDone.initializeConstructions();
        assertEquals(2, constructionAlmostDone.getWaitingTime());
    }

    @Test
    void checkStatus() {
        for (int i = 0; i < 4; i++) {
            constructionAlmostDone.initializeConstructions();
        }
        assertEquals("processing", constructionAlmostDone.getStatus());
    }
}