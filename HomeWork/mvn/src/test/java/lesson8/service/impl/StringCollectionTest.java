package lesson8.service.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class StringCollectionTest {
    private static StringCollection expected;
    private StringCollection testedObject;
    private static final String str1 = "STR1";
    private static final String str2 = "STR2";
    private static final int initialCapacity = 1;
    private static final int testedSize = 100;

    @BeforeAll
    static void setExpected() {
        expected = new StringCollection(initialCapacity);
        expected.add(str1);
        expected.add(str2);
    }

    @BeforeEach
    void setUp() {
        testedObject = new StringCollection(initialCapacity);
    }

    @Test
    void add() {
        assertTrue(testedObject.add(str2));
        assertTrue(testedObject.add(0, str1));

        assertEquals(str1, testedObject.get(0));
        assertEquals(str2, testedObject.get(1));
    }

    @Test
    void addNull() {
        assertFalse(testedObject.add(null));
        assertEquals(0, testedObject.size());
    }

    @Test
    void addWrongType() {
        assertFalse(testedObject.add(12345));
        assertEquals(0, testedObject.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, -1, 1, 12})
    void addWrongIndex(int index) {
        assertFalse(testedObject.add(index, str1));
    }

    @Test
    void deleteWrong() {
        testedObject.add(str1);
        assertFalse(testedObject.delete(null));
        assertFalse(testedObject.delete(12345));
        assertFalse(testedObject.delete(str2));

        assertEquals(1, testedObject.size());
    }

    @Test
    void delete() {
        testedObject.add(str1);
        testedObject.delete(str1);
        assertEquals(0, testedObject.size());
    }

    @Test
    void get() {
        testedObject.add(str1);
        assertEquals(str1, testedObject.get(0));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 2})
    void getIncorrectIndex(int index) {
        assertThrows(IndexOutOfBoundsException.class, () -> testedObject.get(index));
    }

    @Test
    void contain() {
        testedObject.add(str1);
        assertTrue(testedObject.contain(str1));
    }

    @Test
    void notContain() {
        testedObject.add(str2);
        assertFalse(testedObject.contain(str1));
    }

    @Test
    void testEquals() {
        testedObject.add(str1);
        testedObject.add(str2);

        assertTrue(testedObject.equals(expected));
    }

    @Test
    void testNotEquals() {
        testedObject.add(str2);

        assertFalse(testedObject.equals(expected));
        assertFalse(testedObject.equals(null));
        assertFalse(testedObject.equals(new StringCollection()));
    }

    @Test
    void clear() {
        for(int i = 0; i < testedSize; i++) {
            testedObject.add(String.valueOf(i));
        }
        testedObject.clear();
        assertEquals(0, testedObject.size());
    }

    @Test
    void size() {
        for(int i = 0; i < testedSize; i++) {
            testedObject.add(String.valueOf(i));
        }
        assertEquals(testedSize, testedObject.size());
    }
}