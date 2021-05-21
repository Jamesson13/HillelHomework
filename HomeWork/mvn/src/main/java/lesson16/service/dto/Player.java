package lesson16.service.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Class Player
 *
 * Contains player stats and nickname.
 */
@Getter
@Setter
public class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
    }
}
