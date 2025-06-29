package com.example;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class FixtureTest {

    private Calculator calc;

    // Setup method (runs before each test)
    @Before
    public void setUp() {
        System.out.println("Setup: Creating calculator instance");
        calc = new Calculator();
    }

    // Teardown method (runs after each test)
    @After
    public void tearDown() {
        System.out.println("Teardown: Nullifying calculator instance");
        calc = null;
    }

    @Test
    public void testAddition() {
        // Arrange is done in @Before
        // Act
        int result = calc.add(10, 5);
        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testSubtraction() {
        int result = calc.subtract(10, 3);
        assertEquals(7, result);
    }

    @Test
    public void testDivision() {
        int result = calc.divide(10, 2);
        assertEquals(5, result);
    }
}
