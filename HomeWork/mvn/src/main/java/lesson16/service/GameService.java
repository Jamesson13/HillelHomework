package lesson16.service;

import lesson16.service.dto.Player;
import lesson16.service.dto.types.Items;
import lesson16.service.dto.types.RoundStatus;

import static lesson16.service.dto.types.RoundStatus.*;

/**
 * Class GameService
 *
 * Contains table of possible outcomes of a game round
 * and static method play().
 */
public class GameService {
    private final static RoundStatus[][] result = new RoundStatus[][] {
            {DRAW, WIN, LOSE},
            {LOSE, DRAW, WIN},
            {WIN, LOSE, DRAW}
    };

    /* Method to play one game round and return result for Player p1 */
    public static RoundStatus play(Player p1, Items i1, Player p2, Items i2) {
        switch (result[i1.ordinal()][i2.ordinal()]) {
            case WIN -> p1.setScore(p1.getScore()+1);
            case LOSE -> p2.setScore(p2.getScore()+1);
        }
        return result[i1.ordinal()][i2.ordinal()];
    }
}
