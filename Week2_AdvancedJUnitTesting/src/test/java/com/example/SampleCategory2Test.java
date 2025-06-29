package com.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class SampleCategory2Test {

    @Test
    public void testThree() {
        assertNotNull("JUnit");
    }

    @Test
    public void testFour() {
        assertFalse(2 > 10);
    }
}
