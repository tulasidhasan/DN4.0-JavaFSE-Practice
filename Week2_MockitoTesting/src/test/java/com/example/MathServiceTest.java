package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MathServiceTest {

    @Test
    public void testArgumentMatching() {
        Calculator calculator = mock(Calculator.class);
        MathService service = new MathService(calculator);

        service.calculateSum(5, 10);

        verify(calculator).add(eq(5), eq(10));
    }
}
