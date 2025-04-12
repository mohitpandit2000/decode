package com.decode.decode.logger;

public class Logger {

    // Private static instance
    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {
        // Initialize any resources like log file handling, etc.
    }

    // Public method to provide access to the instance
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    // Example log method
    public void log(String message) {
        System.out.println(message);
    }
}

