package lesson17.service;

import lesson16.service.GameService;
import lesson16.service.dto.types.Items;
import lesson16.service.dto.types.RoundStatus;
import lesson17.service.impl.GamesLogger;
import lesson17.service.impl.ResultsLogger;
import lesson17.util.TimeUtils;

/**
 * Class LoggedGameService
 *
 * Extended version of GameService that writes results into log files.
 */
public class LoggedGameService extends GameService {
    FileLogger resLog;

    @Override
    protected RoundStatus playRound(Items i1, Items i2) {
        // play round and save results into tmp
        RoundStatus tmp = super.playRound(i1, i2);
        // log results into file
        if(!this.writeRoundToLog(tmp)) {
            System.out.println("Unable to write round results to log file!");
        }
        return tmp;
    }

    @Override
    protected void configure() {
        super.configure();
        // specify filename for game log
        String fileName = "log_" + player.getName() + "_" + TimeUtils.timeStamp() + ".log";
        resLog = new GamesLogger(fileName);
    }

    @Override
    public void play() {
        super.play();
        if(!this.writeResultsToLog()) {
            System.out.println("Unable to write game results to log file!");
        }
    }

    /* Write final game results to log file and return true if success */
    private boolean writeResultsToLog() {
        String winner = player.getScore()==pc.getScore()?"none": // draw
                player.getScore()>pc.getScore()?player.getName():pc.getName();  // winner's name

        return new ResultsLogger().log(TimeUtils.timeStampExtended()
                .concat(" " + player.getName() + " vs " + pc.getName() + ", Rounds played:" + playedRounds
                + "/" + totalRounds + ", Winner:" + winner + " (" + player.getScore() + ":" + pc.getScore() + ")"));
    }

    /* Write round results to log file and return true if success */
    private boolean writeRoundToLog(RoundStatus res) {
        return resLog.log(TimeUtils.timeStampExtended()
                .concat(" Round " + (playedRounds+1) + "/" + totalRounds + " : " + res));
    }
}
