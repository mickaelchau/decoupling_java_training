package fr.lernejo.guessgame;
import java.sql.Date;
import java.text.SimpleDateFormat;

import fr.lernejo.logger.*;


public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type
  
    public Simulation(Player player) {
      this.player = player;
    }
  
    public void initialize(long numberToGuess) {
      logger.log("Simulation initialize with " + numberToGuess);
      this.numberToGuess = numberToGuess;
    }
  
    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
      logger.log("Choose a number:");
      long playerNumber = player.askNextGuess();
      if (playerNumber == numberToGuess) {
        return true;
      } 

      boolean isLower = true;
      if (playerNumber > numberToGuess) {
        isLower = false;
      }
      if (isLower) {
        logger.log("Player value: " + playerNumber + " is lower than simulation value: " + numberToGuess);
      } else {
        logger.log("Player value: " + playerNumber + " is bigger than player value: " + numberToGuess);
      }
      player.respond(isLower);
      return false;
    }
  
    public void loopUntilPlayerSucceed(long iterationsNumber) {
      long startDate = System.currentTimeMillis();
      for (long i = 0; i < iterationsNumber; i++) {
        if (nextRound()) {
          break;
        }
      }
      long endDate = System.currentTimeMillis();
      long gameDuration = endDate - startDate;

      SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
      String formatted = sdf.format(new Date(gameDuration));
      logger.log("Player wins ! Player needs " + formatted + " to find the Captain age");
    }
  }