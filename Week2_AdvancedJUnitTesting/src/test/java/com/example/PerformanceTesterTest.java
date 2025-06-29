package com.example;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class PerformanceTesterTest {

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void testPerformTaskWithinTime() {
        PerformanceTester tester = new PerformanceTester();
        assertDoesNotThrow(() -> tester.performTask());
    }

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void testLongRunningTaskFailsTimeout() {
        PerformanceTester tester = new PerformanceTester();
        tester.longRunningTask(); // This test will fail if it takes > 1s
    }
}
