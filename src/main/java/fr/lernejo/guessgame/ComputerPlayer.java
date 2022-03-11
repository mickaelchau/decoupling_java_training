package fr.lernejo.guessgame;

import fr.lernejo.logger.*;
import java.util.Scanner;

public class ComputerPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");
    private long min;
    private long max;
    private long lastAsked;
    private boolean isLower;
    private boolean firstTime = true;
    Scanner stdin = new Scanner(System.in);

    public long askNextGuess() {
        if (firstTime) {
            lastAsked = 50;
            firstTime = false;
        } else if (!isLower) {
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
