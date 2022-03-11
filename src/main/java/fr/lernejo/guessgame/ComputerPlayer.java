package fr.lernejo.guessgame;

import fr.lernejo.logger.*;
import java.util.Scanner;

public class ComputerPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");
    private long min = 0;
    private long max = 100;
    private long lastAsked = 0;
    private boolean isLower = true;
    Scanner stdin = new Scanner(System.in);

    public long askNextGuess() {
        if (isLower) {
            min = lastAsked;
        } else {
            max = lastAsked;
        }
        lastAsked = (max + min) / 2;
        return lastAsked;
    }
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            logger.log("The value is lower");
        } else {
            logger.log("The value is greater");
        }
        isLower = lowerOrGreater;
    }
}
