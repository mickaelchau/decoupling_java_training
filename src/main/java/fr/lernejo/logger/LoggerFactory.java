package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        FileLogger newFileLogger = new FileLogger("log.txt");
        ContextualLogger newContextualLogger1 = new ContextualLogger(newFileLogger, name);
        
        ConsoleLogger newConsoleLogger = new ConsoleLogger(); 
        ContextualLogger newContextualLogger2 = new ContextualLogger(newConsoleLogger, name);

        CompositeLogger newCompositeLogger = new CompositeLogger(newContextualLogger1, newContextualLogger2);
        return newCompositeLogger;
    }
}
