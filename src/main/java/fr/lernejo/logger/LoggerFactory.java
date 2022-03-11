package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        FileLogger newFileLogger = new FileLogger("log.txt");
        Logger newContextualLogger1 = new ContextualLogger(newFileLogger, name);
        Predicate<String> containsSimulation = x -> x.contains("simulation");
        FilteredLogger newFilteredLogger = new FilteredLogger(newContextualLogger1, containsSimulation);
        
        ConsoleLogger newConsoleLogger = new ConsoleLogger(); 
        ContextualLogger newContextualLogger2 = new ContextualLogger(newConsoleLogger, name);

        CompositeLogger newCompositeLogger = new CompositeLogger(newFilteredLogger, newContextualLogger2);
        return newCompositeLogger;
    }
}
