package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.JwtBuilder;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start /authenticate");
        LOGGER.debug("Authorization Header: {}", authHeader);

        Map<String, String> map = new HashMap<>();
        try {
            String user = getUser(authHeader);
            String token = generateJwt(user);
            map.put("token", token);
        } catch (Exception e) {
            LOGGER.error("Authentication failed: ", e);
            throw new RuntimeException("Authentication error: " + e.getMessage());
        }

        LOGGER.info("End /authenticate");
        return map;
    }

    private String getUser(String authHeader) {
        LOGGER.info("Decoding Authorization header...");

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            throw new RuntimeException("Invalid or missing Authorization header");
        }

        try {
            String base64Credentials = authHeader.substring("Basic ".length()).trim();
            byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(credDecoded);
            LOGGER.debug("Decoded credentials: {}", credentials);
            return credentials.split(":")[0];
        } catch (Exception e) {
            LOGGER.error("Error decoding header: ", e);
            throw new RuntimeException("Authorization decoding failed");
        }
    }

    private String generateJwt(String user) {
        LOGGER.info("Generating JWT for user: {}", user);

        JwtBuilder builder = Jwts.builder()
            .setSubject(user)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 20 * 60 * 1000)) // 20 mins
            .signWith(SignatureAlgorithm.HS256, "secretkey");

        String token = builder.compact();
        LOGGER.debug("Generated Token: {}", token);
        return token;
    }
}
