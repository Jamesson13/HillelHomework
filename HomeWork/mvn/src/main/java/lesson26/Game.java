package lesson26;

import lesson24.service.ExtLoggedGameService;
import lesson26.service.GameServiceLoc;

/**
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 02.07.2021
 *
 * Realization of Rock, scissors and paper game with extended logging and localization support.
 * Localization can be set by program arguments.
 *
 * See mode info at GameServiceLoc class.
 */
public class Game {
    public static void main(String[] args) {
        GameServiceLoc game = new ExtLoggedGameService();
        if(args.length == 2) {
            game.setLocale(args[0], args[1]);
        }
        game.play();
    }
}
