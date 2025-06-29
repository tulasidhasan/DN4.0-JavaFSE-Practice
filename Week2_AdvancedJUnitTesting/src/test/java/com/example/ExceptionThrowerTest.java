package com.example;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ExceptionThrowerTest {

    @Test
    void testThrowsExceptionForNullInput() {
        ExceptionThrower thrower = new ExceptionThrower();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException(null);
        });

        assertEquals("Input cannot be null or empty", exception.getMessage());
    }

    @Test
    void testThrowsExceptionForEmptyInput() {
        ExceptionThrower thrower = new ExceptionThrower();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException("");
        });

        assertEquals("Input cannot be null or empty", exception.getMessage());
    }

    @Test
    void testNoExceptionForValidInput() {
        ExceptionThrower thrower = new ExceptionThrower();
        assertDoesNotThrow(() -> thrower.throwException("Valid input"));
    }
}
