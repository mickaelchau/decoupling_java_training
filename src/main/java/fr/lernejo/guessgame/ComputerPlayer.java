package fr.lernejo.guessgame;

import fr.lernejo.logger.*;
import java.util.Scanner;

public class ComputerPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");
    private long min = 0;
    private long max = 100;
    private long lastAsked;
    private boolean isLower;
    Scanner stdin = new Scanner(System.in);

    public long askNextGuess() {
        if (!isLower) {
            min = lastAsked;
        } else {
            max = lastAsked;
        }
        lastAsked = (max + min) / 2;
        logger.log("You has chosen value " + lastAsked);
        return lastAsked;
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
