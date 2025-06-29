package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(3)
    void testC() {
        System.out.println("Running test C");
        assertTrue(true);
    }

    @Test
    @Order(1)
    void testA() {
        System.out.println("Running test A");
        assertEquals(5, 2 + 3);
    }

    @Test
    @Order(2)
    void testB() {
        System.out.println("Running test B");
        assertNotNull("Hello");
    }
}
