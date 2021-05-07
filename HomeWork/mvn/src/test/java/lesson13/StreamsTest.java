package lesson13;

import lesson13.service.dto.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamsTest {

    @Test
    void average() {
        double expected = 5.5;
        List<Integer> l = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        assertEquals(expected, Streams.average(l));
    }

    @Test
    void averageFromNullList() {
        assertDoesNotThrow(() -> Streams.average(null));
        assertEquals(Double.NaN, Streams.average(null));
    }

    @Test
    void averageFromEmptyList() {
        List<Integer> l = new ArrayList<>();

        assertDoesNotThrow(() -> Streams.average(l));
        assertEquals(Double.NaN, Streams.average(l));
    }

    @Test
    void pairs() {
        List<Pair> expected = new ArrayList<>(Arrays.asList(
                new Pair("one", "ONE"),
                new Pair("two", "TWO"),
                new Pair("three", "THREE"),
                new Pair("four", "FOUR"),
                new Pair("five", "FIVE")));
        List<String> l = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five"));

        System.out.println("\t\tpairs() input:" + l);
        System.out.println("\t\tpairs() result:" + Streams.pairs(l));
        assertEquals(expected, Streams.pairs(l));
    }

    @Test
    void pairsFromNullList() {
        assertDoesNotThrow(() -> Streams.pairs(null));
    }

    @Test
    void filter() {
        List<String> l = new ArrayList<>(Arrays.asList("ONE", "Two", "three", "four", "Five", "six", "here"));

        System.out.println("\t\tfilter() input:" + l);
        System.out.println("\t\tfilter() result:" + Streams.filter(l));
        assertTrue(Streams.filter(l).contains("four"));
        assertEquals(Streams.filter(l).size(), 2);
    }

    @Test
    void filterFromNullList() {
        assertDoesNotThrow(() -> Streams.filter(null));
    }
}