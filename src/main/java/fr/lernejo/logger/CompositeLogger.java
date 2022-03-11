package fr.lernejo.logger;

public class CompositeLogger implements Logger {
    Logger delegateLogger1;
    Logger delegateLogger2;

    public CompositeLogger(Logger delegateLogger1, Logger delegateLogger2) {
        this.delegateLogger1 = delegateLogger1;
        this.delegateLogger2 = delegateLogger2;
    }

    public void log(String message) {
        delegateLogger1.log(message);
        delegateLogger2.log(message);
    }
}
