package fr.lernejo.guessgame;

import fr.lernejo.logger.*;
import java.util.Scanner;

public class ComputerPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");
    private long lastAsked;
    private boolean isLower;
    private boolean firstTime = true;
    Scanner stdin = new Scanner(System.in);

    public long askNextGuess() {
        long playerGuess = 0;
        if (firstTime) {
            playerGuess = 50;
            firstTime = false;
        } else if (!isLower) {
            playerGuess = lastAsked / 2;
        } else {
            playerGuess = (100 - lastAsked) / 2 + lastAsked;
        }
        lastAsked = playerGuess;
        logger.log("You has chosen value " + playerGuess);
        return playerGuess;
    }
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            logger.log("The value is lower");
        } else {
            logger.log("The value is bigger");
        }
        isLower = lowerOrGreater;
    }
}
