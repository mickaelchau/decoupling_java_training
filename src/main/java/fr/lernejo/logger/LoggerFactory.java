package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        Logger newLogger = new ConsoleLogger();
        return newLogger;
    }
}
