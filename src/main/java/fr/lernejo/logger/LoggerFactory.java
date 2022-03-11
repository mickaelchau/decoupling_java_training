package fr.lernejo.logger;

import java.io.Console;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        FileLogger newFileLogger = new FileLogger("log.txt");
        ConsoleLogger newConsoleLogger = new ConsoleLogger(); 
        ContextualLogger newContextualLogger1 = new ContextualLogger(newFileLogger, name);
        ContextualLogger newContextualLogger2 = new ContextualLogger(newConsoleLogger, name);
        CompositeLogger newCompositeLogger = new CompositeLogger(newContextualLogger1, newContextualLogger2);
        return newCompositeLogger;
    }
}
