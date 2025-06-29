package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10, 12})
    public void testIsEvenTrue(int number) {
        EvenChecker checker = new EvenChecker();
        assertTrue(checker.isEven(number), number + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    public void testIsEvenFalse(int number) {
        EvenChecker checker = new EvenChecker();
        assertFalse(checker.isEven(number), number + " should be odd");
    }
}
