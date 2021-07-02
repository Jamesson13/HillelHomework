package lesson26.service;

import lesson16.service.dto.Player;
import lesson16.service.dto.types.Items;
import lesson16.service.dto.types.RoundStatus;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import static lesson16.service.dto.types.RoundStatus.*;
import static lesson16.service.dto.types.RoundStatus.DRAW;
import static lesson16.utils.RandomGenerator.getRandomInt;
import static lesson16.utils.ScannerController.scanCorrectIntValue;

/**
 * Class GameServiceLoc
 *
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 02.07.2021
 *
 * Improved GameService with localization support.
 * By default, localization set as system. It can be configured by setLocale() method.
 */
public class GameServiceLoc {
    protected int totalRounds;
    protected int playedRounds;
    protected Player pc;
    protected Player player;
    protected Locale loc = Locale.getDefault();
    protected ResourceBundle rb = ResourceBundle.getBundle("MessagesBundle", loc);

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
        System.out.print(rb.getString("enterName"));
        player = new Player(new Scanner(System.in).next());
        pc = new Player(rb.getString("pcName"));

        this.totalRounds = scanCorrectIntValue(0, 100, rb.getString("gamesToPlay"),
                rb.getString("badInput"));
    }

    /* Show players stats */
    protected void showResults() {
        System.out.printf(rb.getString("gameResults"),
                player.getName(), player.getScore(),
                pc.getName(), pc.getScore(),
                player.getScore()==pc.getScore()?rb.getString("noWinner"): // draw
                        player.getScore()>pc.getScore()?player.getName():pc.getName());
    }

    /* Play the game */
    public void play() {
        int playerInput, pcInput;

        System.out.println(rb.getString("greeting"));
        this.configure();

        System.out.println(rb.getString("started"));
        for(playedRounds = 0; playedRounds < totalRounds; playedRounds++) {
            // get input from console
            playerInput = scanCorrectIntValue(0, 3, rb.getString("roundTurn"),
                    rb.getString("badInput"));

            // leave game if needed
            if(playerInput == 0) {
                break;
            }

            // play game round and show info
            pcInput = getRandomInt(0,2);
            System.out.printf(rb.getString("roundRes"),
                    player.getName(), rb.getString(Items.values()[playerInput-1].name()),
                    pc.getName(), rb.getString(Items.values()[pcInput].name()),
                    rb.getString(playRound(Items.values()[playerInput-1], Items.values()[pcInput]).name()));
        }

        this.showResults();
    }

    /* Set game output localization */
    public void setLocale(String lang, String country) {
        loc = new Locale(lang, country);
        rb = ResourceBundle.getBundle("MessagesBundle", loc);
    }
}
