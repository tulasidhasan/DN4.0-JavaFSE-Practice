package com.example;

public class MathService {
    private Calculator calculator;

    public MathService(Calculator calculator) {
        this.calculator = calculator;
    }

    public int calculateSum(int a, int b) {
        return calculator.add(a, b);
    }
}
