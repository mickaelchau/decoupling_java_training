package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    static void main(String[] args){
        System.out.println("Hello World");
        HumanPlayer player = new HumanPlayer();
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)
        Simulation myGame = new Simulation(player);
        myGame.initialize(randomNumber);
        myGame.loopUntilPlayerSucceed();
    }
}
