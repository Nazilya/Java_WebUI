package com.geekbrains.lesson4.Homework;

public class Triangle {

    public static double calculateTriangleSquare(int a, int b, int c) throws Exception {
        if (a <= 0 || b <= 0 || c <= 0) throw new Exception();
        double p = (a + b + c)/2;
        return (Math.sqrt(p*(p - a) * (p - b) * (p - c)));

    }
}
