package lesson16;

import lesson16.service.GameService;
import lesson16.service.dto.Player;
import lesson16.service.dto.types.Items;

import java.util.Scanner;

import static lesson16.utils.RandomGenerator.*;
import static lesson16.utils.ScannerController.*;

/**
 * Class Game
 *
 * Realization of Rock, scissors and paper game.
 */
public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player pc = new Player("PC");
        Player player;
        int totalGames;
        int playerInput, pcInput;

        // set name and games count from console input
        System.out.println("You're playing \"Rock, scissors and paper\" game.\n");
        System.out.print("Enter your name:");
        player = new Player(sc.next());
        totalGames = scanCorrectIntValue(sc, 0, 100, "Enter number of games you want to play");

        // play the game
        System.out.println("Game started!");
        for(int i = 0; i < totalGames; i++) {
            // get input from console
            playerInput = scanCorrectIntValue(sc, 0, 3,
                    "\n1-Rock, 2-Scissors, 3-Paper\n0-End the game\nYour turn:");

            // leave game if needed
            if(playerInput == 0) {
                break;
            }

            // play game round and show info
            pcInput = getRandomInt(0,2);
            System.out.printf("%s:%s %s:%s Round:%s\n",
                    player.getName(), Items.values()[playerInput-1],
                    pc.getName(), Items.values()[pcInput],
                    GameService.play(player, Items.values()[playerInput-1], pc, Items.values()[pcInput]));
        }

        // get results
        System.out.printf("\nGame finished! Scores:\n%s: %d\n%s: %d\nWinner: %s\n",
                player.getName(), player.getScore(),
                pc.getName(), pc.getScore(),
                player.getScore()==pc.getScore()?"none": // draw
                        player.getScore()>pc.getScore()?player.getName():pc.getName());
    }
}
