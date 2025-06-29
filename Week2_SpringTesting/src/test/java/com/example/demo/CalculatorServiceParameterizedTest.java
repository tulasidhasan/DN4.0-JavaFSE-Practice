package com.example.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.service.CalculatorService;

public class CalculatorServiceParameterizedTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @CsvSource({
        "2, 3, 5",
        "10, 20, 30",
        "-5, 5, 0",
        "100, 200, 300"
    })
    public void testAddMultipleInputs(int a, int b, int expected) {
        int result = calculatorService.add(a, b);
        assertEquals(expected, result);
    }
}
