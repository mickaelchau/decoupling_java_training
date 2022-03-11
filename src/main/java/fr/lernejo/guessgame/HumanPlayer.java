package fr.lernejo.guessgame;

import fr.lernejo.logger.*;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");
    Scanner stdin = new Scanner(System.in);

    public long askNextGuess() {
        long playerGuess = stdin.nextLong();
        logger.log("You has chosen value " + playerGuess);
        return playerGuess;
    }
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            logger.log("The value is lower");
        } else {
            logger.log("The value is bigger");
        }
    }
}
