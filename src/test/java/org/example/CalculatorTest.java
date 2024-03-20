package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    // all values were calculated using an online calculator
    // calculate() Should set collection "result" by partial divisors and dividends
    @Test
    void calculateCase1WithSimpleNumbers(){
        int dividend = 245;
        int divisor = 6;
        List<Integer> result = Arrays.asList(24, 24, 5);

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        assertEquals(result, calculator.getResult());
    }

    @Test
    void calculateCase2WithSimpleNumbers(){
        int dividend = 472;
        int divisor = 8;
        List<Integer> result = Arrays.asList(47, 40, 72, 72, 0);

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        assertEquals(result, calculator.getResult());
    }

    @Test
    void calculateZeroCase1(){
        int dividend = 10000;
        int divisor = 10;
        List<Integer> result = Arrays.asList(10, 10, 0);

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        assertEquals(result, calculator.getResult());
    }

    @Test
    void calculateZeroCase2(){
        int dividend = 10200;
        int divisor = 5;
        List<Integer> result = Arrays.asList(10, 10, 20, 20, 0);

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        assertEquals(result, calculator.getResult());
    }

    @Test
    void calculateZeroCase3(){
        int dividend = 400000;
        int divisor = 3;
        List<Integer> result = Arrays.asList(4, 3, 10, 9, 10, 9, 10, 9, 10, 9, 10, 9, 1);

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        assertEquals(result, calculator.getResult());
    }

    @Test
    void calculateCase1WithLongNumbers(){
        int dividend = 999999999;
        int divisor = 45578993;
        List<Integer> result = Arrays.asList(99999999, 91157986, 88420139, 45578993, 42841146);

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        assertEquals(result, calculator.getResult());
    }

    @Test
    void calculateCase2WithLongNumbers(){
        int dividend = 234569109;
        int divisor = 2;
        List<Integer> result = Arrays.asList(2, 2, 3, 2, 14, 14, 5, 4, 16, 16, 9, 8, 11, 10, 10, 10, 9, 8, 1);

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        assertEquals(result, calculator.getResult());
    }

    @Test
    void calculateCase1WithShortNumbers(){
        int dividend = 5;
        int divisor = 3;
        List<Integer> result = Arrays.asList(5, 3, 2);

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        assertEquals(result, calculator.getResult());
    }

    @Test
    void calculateCase2WithShortNumbers(){
        int dividend = 1;
        int divisor = 1;
        List<Integer> result = Arrays.asList(1, 1, 0);

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        assertEquals(result, calculator.getResult());
    }

    @Test
    void calculateCase3WithShortNumbers(){
        int dividend = 9;
        int divisor = 4;
        List<Integer> result = Arrays.asList(9, 8, 1);

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        assertEquals(result, calculator.getResult());
    }

    // calculate() should also set collection spaces by number of spaces for each partial divisors and dividends(except first and second). The last two spaces are redundant

    @Test
    void calculateCheckingTheCorrectnessOfSpaceCountingCase1(){
        int dividend = 10000;
        int divisor = 33;

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();
        calculator.getSpaces().remove(calculator.getSpaces().size() - 1); // remove two last elements which are redundant
        calculator.getSpaces().remove(calculator.getSpaces().size() - 1);
        List<Integer> spaces = Arrays.asList(2, 3, 4);

        assertEquals(spaces, calculator.getSpaces());
    }

    @Test
    void calculateCheckingTheCorrectnessOfSpaceCountingCase2(){
        int dividend = 9999;
        int divisor = 27;

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();
        calculator.getSpaces().remove(calculator.getSpaces().size() - 1); // remove two last elements which are redundant
        calculator.getSpaces().remove(calculator.getSpaces().size() - 1);
        List<Integer> spaces = Arrays.asList(0, 0, 3);

        assertEquals(spaces, calculator.getSpaces());
    }

    @Test
    void calculateCheckingTheCorrectnessOfSpaceCountingCase3(){
        int dividend = 834753;
        int divisor = 444;

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();
        calculator.getSpaces().remove(calculator.getSpaces().size() - 1); // remove two last elements which are redundant
        calculator.getSpaces().remove(calculator.getSpaces().size() - 1);
        List<Integer> spaces = Arrays.asList(0, 0, 1, 1, 4);

        assertEquals(spaces, calculator.getSpaces());
    }

    @Test
    void calculateCheckingTheCorrectnessOfSpaceCountingCase4(){
        int dividend = 10000;
        int divisor = 10;

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();
        calculator.getSpaces().remove(calculator.getSpaces().size() - 1); // remove two last elements which are redundant
        calculator.getSpaces().remove(calculator.getSpaces().size() - 1);
        List<Integer> spaces = Arrays.asList(1);

        assertEquals(spaces, calculator.getSpaces());
    }

    @Test
    void calculateCheckingTheCorrectnessOfSpaceCountingCase5(){
        int dividend = 6600400;
        int divisor = 34;

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();
        calculator.getSpaces().remove(calculator.getSpaces().size() - 1); // remove two last elements which are redundant
        calculator.getSpaces().remove(calculator.getSpaces().size() - 1);
        List<Integer> spaces = Arrays.asList(0, 0, 1, 1, 3, 3, 3, 4, 4, 4, 5);

        assertEquals(spaces, calculator.getSpaces());
    }

    @Test
    void calculateCheckingTheCorrectnessOfSpaceCountingCase6(){
        int dividend = 7;
        int divisor = 3;

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();
        calculator.getSpaces().remove(calculator.getSpaces().size() - 1); // remove two last elements which are redundant
        calculator.getSpaces().remove(calculator.getSpaces().size() - 1);
        List<Integer> spaces = Arrays.asList(0);

        assertEquals(spaces, calculator.getSpaces());
    }

    @Test
    void calculateCheckingTheCorrectnessOfSpaceCountingCase7(){
        int dividend = 800600;
        int divisor = 50;

        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();
        calculator.getSpaces().remove(calculator.getSpaces().size() - 1); // remove two last elements which are redundant
        calculator.getSpaces().remove(calculator.getSpaces().size() - 1);
        List<Integer> spaces = Arrays.asList(0, 0, 3, 3, 3, 3, 5);

        assertEquals(spaces, calculator.getSpaces());
    }

}