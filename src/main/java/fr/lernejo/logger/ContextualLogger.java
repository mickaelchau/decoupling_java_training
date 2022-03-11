package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger {
    Logger delegateLogger;
    String callerClass;

    public ContextualLogger(Logger delegateLogger, String callerClass) {
        this.delegateLogger = delegateLogger;
        this.callerClass = callerClass;
    }
    
    public void log(String message) {
        delegateLogger.log(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + " " + callerClass + " " + message);
    }
}
