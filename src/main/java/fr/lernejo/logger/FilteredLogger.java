package fr.lernejo.logger;

import java.util.function.Predicate;

public class FilteredLogger implements Logger {
    Logger delegateLogger;
    Predicate<String> condition;

    public FilteredLogger(Logger delegate, Predicate<String> condition) {
        this.delegateLogger = delegate;
        this.condition = condition;
    }

    public void log(String message) {
        if (condition.test(message)) {
            delegateLogger.log(message);
        }
    }
}