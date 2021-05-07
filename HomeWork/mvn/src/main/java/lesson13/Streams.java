package lesson13;

import lesson13.service.dto.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class Streams
 *
 * Contains static methods which operates with data using streams.
 */
public class Streams {
    private static final Predicate<String> lenEqualsFour = (s) -> s.length() == 4;
    private static final Predicate<String> inLowerCase = (s) -> s.compareTo(s.toLowerCase()) == 0;

    /* Calculation of average value of all elements in list */
    public static double average(List<Integer> list) {
        return Optional.ofNullable(list).isPresent() ? // check null input
                Optional.of(list).get()
                        .stream()
                        .mapToDouble(d -> (double)d)
                        .average()
                        .orElse(Double.NaN)
                : Double.NaN; // return not a number result
    }

    /* Conversion of strings into Pairs which contains original strings and it's UPPERCASE form */
    public static List<Pair> pairs(List<String> list) {
        return Optional.ofNullable(list).isPresent() ?
                Optional.of(list).get()
                        .stream()
                        .map(p -> new Pair(p, p.toUpperCase()))
                        .collect(Collectors.toList())
                : new ArrayList<>();  // return empty list
    }

    /* Filtering of list of strings which is in lowercase and it's length equals 4  */
    public static List<String> filter(List<String> list) {
        return Optional.ofNullable(list).isPresent() ?
                Optional.of(list).get()
                        .stream()
                        .filter(lenEqualsFour.and(inLowerCase))
                        .collect(Collectors.toList())
                : new ArrayList<>(); // return empty list
    }
}
