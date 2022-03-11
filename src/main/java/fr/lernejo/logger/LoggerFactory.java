package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        Logger newFileLogger = new FileLogger("log.txt");
        Logger newContextualLogger1 = new ContextualLogger(name, newFileLogger);
        Predicate<String> containsSimulation = x -> x.contains("simulation");
        FilteredLogger newFilteredLogger = new FilteredLogger(newContextualLogger1, containsSimulation);
        
        Logger newConsoleLogger = new ConsoleLogger(); 
        Logger newContextualLogger2 = new ContextualLogger(name, newConsoleLogger);

        Logger newCompositeLogger = new CompositeLogger(newFilteredLogger, newContextualLogger2);
        return newCompositeLogger;
    }
}
