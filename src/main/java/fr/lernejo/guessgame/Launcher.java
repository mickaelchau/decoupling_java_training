package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args){
        if (args[0] == "-interactive") {
            HumanPlayer player = new HumanPlayer();
            Simulation myGame = new Simulation(player);
            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextInt(100); 
            myGame.initialize(randomNumber);
            myGame.loopUntilPlayerSucceed(Long.MAX_VALUE);
        } else if ((args.length == 2) && (args[0] == "-auto") && isLong(args[1])) {
            ComputerPlayer player = new ComputerPlayer();
            Simulation myGame = new Simulation(player);
            myGame.initialize(Long.parseLong(args[1]));
            myGame.loopUntilPlayerSucceed(1000);
        } else {
            System.out.println("USAGE 1: java Launcher -interactive\n USAGE 2: java Launcher -auto <long>");
        }
    }

    public static boolean isLong(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Long.parseLong(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
