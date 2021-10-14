package com.geekbrains.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import static com.geekbrains.lesson4.Functions.isNumberEven;

public class AssumptionsExamplesTest  {
    @Test
    void trueAssumption(){
        Assumptions.assumeTrue(1==2);
        Assertions.assertFalse(false);
    }

    @Test  //Здесь видим рез-тат-отчет только по 1-й проверке, по 2-й непонятно, упал или нет
    void trueAssumption2(){
        Assertions.assertTrue(true);
        Assertions.assertFalse(false);
    }
    @Test  //Здесь видим рез-тат-отчет по обеим проверкам
    void softAssertionsTest(){
        Assertions.assertAll(
                () -> Assertions.assertTrue(isNumberEven(4)),
                () -> Assertions.assertTrue(true)
        );
    }

}
