package lesson24.service;

import lesson16.service.GameService;
import lesson16.service.dto.types.Items;
import lesson16.service.dto.types.RoundStatus;
import lesson16.utils.ScannerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class ExtLoggedGameService
 *
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 18.06.2021
 *
 * Extended version of GameService that writes results into log files.
 *
 * There are 3 types of logs:
 *  - Each game information         /log/GamesLog/log_[playerName]_[date].log
 *  - Game results                  /log/Results/results.log
 *  - All possible warnings         /log/warn.log
 */
public class ExtLoggedGameService extends GameService {
    private static Logger gamesLogger;
    private static Logger resLogger;

    @Override
    protected void configure() {
        super.configure();

        // add player's name to filename and initialize logger
        System.setProperty("player.name", player.getName());
        gamesLogger = LoggerFactory.getLogger("lesson24.log.games");
        resLogger = LoggerFactory.getLogger("lesson24.log.results");
        ScannerController.setLogger(gamesLogger);

        // log game joining
        gamesLogger.info("Player {} joined the game.", this.player.getName());
    }

    @Override
    protected RoundStatus playRound(Items i1, Items i2) {
        // play round and save results into res
        RoundStatus res = super.playRound(i1, i2);
        // log results into file
        gamesLogger.debug("{} selected {}, {} selected {}",
                this.player.getName(), i1.name(), this.pc.getName(), i2.name());
        gamesLogger.info("Round {}/{} : {}", playedRounds+1, totalRounds, res);
        return res;
    }

    @Override
    public void play() {
        super.play();
        String winner = player.getScore()==pc.getScore()?"none": // draw
                player.getScore()>pc.getScore()?player.getName():pc.getName();  // winner's name

        if(totalRounds != playedRounds) {
            gamesLogger.warn("Player selected {} games, {} games played, {} games left.",
                    totalRounds, playedRounds, totalRounds-playedRounds);
        }
        gamesLogger.info("Player {} left the game.", this.player.getName());
        resLogger.info("{} vs {}, Rounds played: {}/{}, Winner:{} ({}:{})", player.getName(), pc.getName(),
                playedRounds, totalRounds, winner, player.getScore(), pc.getScore());
    }
}
