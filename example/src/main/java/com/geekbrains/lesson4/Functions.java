package com.geekbrains.lesson4;

public class Functions {
    public static void main(String[] args) {
        areaTriangle(3, 4.0, 5);
    }
    public static boolean isNumberEven(Integer number) {
        return number % 2 == 0;
    }
    public static boolean isNumberPrime(Integer number) {
        if (number < 0) {
            return false;
        }
        if (number < 2) {
            return true;
        }
        for (int i = 2; i < number - 1; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
    public boolean isPalindrom(String word) {
        if (word.length() < 2) return true;
        if (word.charAt(0) != word.charAt(word.length() - 1)) {
            return false;
        }
        return isPalindrom(word.substring(1, word.length() - 1));
    }
    public static void areaTriangle(double a, double b, double c) {
//        if (a <= 0 | b <= 0 ) {
//            return false;
//        }
        double S;
        double p;
        p = (a + b + c)/2;
        S = Math.sqrt(p*(p - a) * (p - b) * (p - c));
        System.out.println(p);
        System.out.println(S);
    }
}
