package org.example.core;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLogger {
    private static final Logger log = LogManager.getLogger(CustomLogger.class);
    public static void log(Object logText) {
        log.info(logText);
    }
}
