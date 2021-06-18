package lesson24;

import lesson24.service.ExtLoggedGameService;
/**
 * Class Game
 *
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 18.06.2021
 *
 * Realization of Rock, scissors and paper game with extended logging.
 * See ExtLoggedGameService class for more info.
 */
public class Game {
    public static void main(String[] args) {
        new ExtLoggedGameService().play();
    }
}
