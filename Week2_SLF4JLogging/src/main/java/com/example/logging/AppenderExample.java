package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {

    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        logger.info("Logging to console and file using SLF4J + Logback");
        logger.warn("This is a warning log");
        logger.error("This is an error log");
    }
}
