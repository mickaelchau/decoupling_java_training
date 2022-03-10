package fr.lernejo.guessgame;
import fr.lernejo.logger.*;


public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type
  
    public Simulation(Player player) {
      this.player = player;
    }
  
    public void initialize(long numberToGuess) {
      logger.log("Game starts !");
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
      player.respond(isLower);
      return false;
    }
  
    public void loopUntilPlayerSucceed() {
      while (!nextRound());
    }
  }