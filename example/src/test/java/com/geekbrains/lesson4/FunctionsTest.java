package com.geekbrains.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static com.geekbrains.lesson4.Functions.isNumberEven;
import static com.geekbrains.lesson4.Functions.isNumberPrime;

public class FunctionsTest {
    private static Logger logger = LoggerFactory.getLogger(FunctionsTest.class);
    @BeforeAll
    static void beforeAll() {
        logger.trace("Сообщения уровня trace");
        logger.error("Сообщения уровня error");
        logger.info("Сообщения уровня info");
        logger.debug("Сообщения уровня debug");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Метод выполняется перед каждым тестом");
    }

    @Test
    @DisplayName("Четное число передали в метод...")
    @Disabled
    void testGivenEvenNumberWhenCheckIsEvenThenTrue() {
        boolean result = isNumberEven(8);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {2,3,7})
    void isNumberPrimeTest(int number) {
        Assertions.assertTrue(isNumberPrime(number));
    }
    @ParameterizedTest
    @CsvSource({"1, true", "3, true", "4, false"})
    void isNumberPrimeTest2(int number, boolean result) {
        Assertions.assertEquals(result, isNumberPrime(number));
    }


    @ParameterizedTest
    @MethodSource("testDataSourse")
    void objectAsExampleTest(Cat cat, boolean result) {
        System.out.println(cat);
        System.out.println(result);
    }
    private static Stream<Arguments> testDataSourse() {
        return Stream.of(
                Arguments.arguments(new Cat(10, "moris"), true),
                Arguments.arguments(new Cat(11, "moris2"), false)
        );
    }

    @AfterEach
    void afterEach() {
        System.out.println("Метод выполняется после каждого теста");
    }
    @AfterAll
    static void afterAll() {
        System.out.println("Метод выполнится после всех тестов класса");
    }
}
