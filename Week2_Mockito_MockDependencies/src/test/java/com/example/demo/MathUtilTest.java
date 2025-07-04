package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.example.demo.util.MathUtil;

public class MathUtilTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 12})
    public void testIsEven_ShouldReturnTrue(int number) {
        assertTrue(MathUtil.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    public void testIsEven_ShouldReturnFalse(int number) {
        assertFalse(MathUtil.isEven(number));
    }
}
