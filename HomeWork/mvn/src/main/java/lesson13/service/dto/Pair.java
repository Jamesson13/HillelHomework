package lesson13.service.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Class Pair
 *
 * Data object consisting of two strings.
 */
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Pair {
    private String L;
    private String R;

    @Override
    public String toString() {
        return "{\"" + L + "\",\"" + R + "\"}";
    }
}
