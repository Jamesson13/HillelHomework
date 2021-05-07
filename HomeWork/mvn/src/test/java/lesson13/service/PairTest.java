package lesson13.service;

import lesson13.service.dto.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {

    @Test
    void testToString() {
        String expected = "{\"one\",\"ONE\"}";
        Pair p = new Pair("one", "ONE");

        System.out.println("\t\tpair.toString() result: " + p);
        assertEquals(expected, p.toString());
    }
}