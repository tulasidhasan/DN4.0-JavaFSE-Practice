package com.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "tulasi";
        int userId = 101;

        logger.info("User {} has logged in with ID {}", username, userId);
        logger.warn("User {} attempted access to a restricted page", username);
        logger.error("Error occurred for user {} with ID {}", username, userId);
    }
}
