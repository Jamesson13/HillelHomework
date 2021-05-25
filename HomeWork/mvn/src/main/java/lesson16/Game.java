package lesson16;

import lesson16.service.GameService;

/**
 * Class Game
 *
 * Realization of Rock, scissors and paper game.
 */
public class Game {
    public static void main(String[] args) {
        new GameService().play();
    }
}
