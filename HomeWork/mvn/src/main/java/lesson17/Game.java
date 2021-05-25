package lesson17;

import lesson17.service.LoggedGameService;

/**
 * Class Game
 *
 * Realization of Rock, scissors and paper game.
 * Write results to log files.
 */
public class Game {
    public static void main(String[] args) {
        new LoggedGameService().play();
    }
}
