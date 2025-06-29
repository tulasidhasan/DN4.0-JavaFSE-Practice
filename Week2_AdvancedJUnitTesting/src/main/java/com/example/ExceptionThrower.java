package com.example;

public class ExceptionThrower {
    public void throwException(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        System.out.println("Input is valid: " + input);
    }
}
