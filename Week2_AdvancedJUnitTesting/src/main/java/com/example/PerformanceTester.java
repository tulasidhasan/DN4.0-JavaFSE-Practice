package com.example;

public class PerformanceTester {
    public void performTask() {
        // Simulate a task that takes ~200ms
        try {
            Thread.sleep(200);  // Simulated processing time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void longRunningTask() {
        try {
            Thread.sleep(2000); // Simulated long task
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
