package com.geekbrains.lesson4.Homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.geekbrains.lesson4.Homework.Triangle.calculateTriangleSquare;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class TriangleSquareCalculationTest {
    @Test
    void positiveSquareCalcTest() throws Exception {
        double result = calculateTriangleSquare(3,4,5);
        Assertions.assertEquals(6, result);
    }
    @Test
    void negativeSquareCalcTest() {
        assertThatExceptionOfType(Exception.class).isThrownBy(()-> calculateTriangleSquare(3, -4, 5));
    }
}
