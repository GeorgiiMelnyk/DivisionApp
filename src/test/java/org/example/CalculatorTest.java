package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    //calculate() Should set collection "result" by partial divisors and dividends
    @Test
    void calculateCase1WithSimpleNumbers(){
        int dividend = 245;
        int divisor = 6;
        List<Integer> result = Arrays.asList(24, 24, 5);

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        assertEquals(calculator.getResult(), result);
    }

    @Test
    void calculateCase2WithSimpleNumbers(){
        int dividend = 472;
        int divisor = 8;
        List<Integer> result = Arrays.asList(47, 40, 72, 72, 0);

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        assertEquals(calculator.getResult(), result);
    }

    @Test
    void calculateZeroCase1(){
        int dividend = 10000;
        int divisor = 10;
        List<Integer> result = Arrays.asList(10, 10, 0);

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        assertEquals(calculator.getResult(), result);
    }

    @Test
    void calculateZeroCase2(){
        int dividend = 10200;
        int divisor = 5;
        List<Integer> result = Arrays.asList(10, 10, 20, 20, 0);

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        assertEquals(calculator.getResult(), result);
    }

    @Test
    void calculateZeroCase3(){
        int dividend = 400000;
        int divisor = 3;
        List<Integer> result = Arrays.asList(4, 3, 10, 9, 10, 9, 10, 9, 10, 9, 10, 9, 1);

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        assertEquals(calculator.getResult(), result);
    }

    @Test
    void calculateCase1WithLongNumbers(){
        int dividend = 999999999;
        int divisor = 45578993;
        List<Integer> result = Arrays.asList(99999999, 91157986, 88420139, 45578993, 42841146);

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        assertEquals(calculator.getResult(), result);
    }

    @Test
    void calculateCase2WithLongNumbers(){
        int dividend = 234569109;
        int divisor = 2;
        List<Integer> result = Arrays.asList(2, 2, 3, 2, 14, 14, 5, 4, 16, 16, 9, 8, 11, 10, 10, 10, 9, 8, 1);

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        assertEquals(calculator.getResult(), result);
    }

    @Test
    void calculateCase1WithShortNumbers(){
        int dividend = 5;
        int divisor = 3;
        List<Integer> result = Arrays.asList(5, 3, 2);

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        assertEquals(calculator.getResult(), result);
    }

    @Test
    void calculateCase2WithShortNumbers(){
        int dividend = 1;
        int divisor = 1;
        List<Integer> result = Arrays.asList(1, 1, 0);

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        assertEquals(calculator.getResult(), result);
    }

    @Test
    void calculateCase3WithShortNumbers(){
        int dividend = 9;
        int divisor = 4;
        List<Integer> result = Arrays.asList(9, 8, 1);

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        assertEquals(calculator.getResult(), result);
    }

}