package lesson16.service;

import lesson16.service.dto.Player;
import lesson16.service.dto.types.Items;
import lesson16.service.dto.types.RoundStatus;

import java.util.Scanner;

import static lesson16.service.dto.types.RoundStatus.*;
import static lesson16.utils.RandomGenerator.getRandomInt;
import static lesson16.utils.ScannerController.scanCorrectIntValue;

/**
 * Class GameService
 *
 * Contains table of possible outcomes of a game round
 * and static method play().
 */
public class GameService {
    protected int totalRounds;
    protected int playedRounds;
    protected Player pc;
    protected Player player;

    protected final static RoundStatus[][] result = new RoundStatus[][] {
            {DRAW, WIN, LOSE},
            {LOSE, DRAW, WIN},
            {WIN, LOSE, DRAW}
    };

    /* Method to play one game round and return result for the first player */
    protected RoundStatus playRound(Items i1, Items i2) {
        switch (result[i1.ordinal()][i2.ordinal()]) {
            case WIN -> player.setScore(player.getScore()+1);
            case LOSE -> pc.setScore(pc.getScore()+1);
        }
        return result[i1.ordinal()][i2.ordinal()];
    }

    /* Set player's name and game rounds count from console input */
    protected void configure() {
        System.out.print("Enter your name:");
        player = new Player(new Scanner(System.in).next());
        pc = new Player("PC");

        this.totalRounds = scanCorrectIntValue(0, 100, "Enter number of games you want to play");
    }

    /* Show players stats */
    protected void showResults() {
        System.out.printf("\nGame finished! Scores:\n%s: %d\n%s: %d\nWinner: %s\n",
                player.getName(), player.getScore(),
                pc.getName(), pc.getScore(),
                player.getScore()==pc.getScore()?"none": // draw
                        player.getScore()>pc.getScore()?player.getName():pc.getName());
    }

    /* Play the game */
    public void play() {
        int playerInput, pcInput;

        System.out.println("You're playing \"Rock, scissors and paper\" game.\n");
        this.configure();

        System.out.println("Game started!");
        for(playedRounds = 0; playedRounds < totalRounds; playedRounds++) {
            // get input from console
            playerInput = scanCorrectIntValue(0, 3,
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
                    playRound(Items.values()[playerInput-1], Items.values()[pcInput]));
        }

        this.showResults();
    }
}
