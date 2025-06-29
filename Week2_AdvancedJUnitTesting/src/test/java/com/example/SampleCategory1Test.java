package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class SampleCategory1Test {

    @Test
    public void testOne() {
        assertTrue(5 > 1);
    }

    @Test
    public void testTwo() {
        assertEquals(10, 5 + 5);
    }
}
