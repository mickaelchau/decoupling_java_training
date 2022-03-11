package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        FileLogger newFileLogger = new FileLogger("log.txt"); 
        ContextualLogger newContextualLogger = new ContextualLogger(newFileLogger, name);
        return newContextualLogger;
    }
}
