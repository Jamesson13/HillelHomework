package com.storozhuk.lesson10.service;

import java.util.Collection;
import java.util.HashSet;

/**
 * Class DuplicatesRemover
 *
 * Method withoutDuplicates() returns collection without duplicates.
 */
public class DuplicatesRemover {
    public static <T> Collection<T> withoutDuplicates(Collection<T> input) {
        return new HashSet<>(input);
    }
}
