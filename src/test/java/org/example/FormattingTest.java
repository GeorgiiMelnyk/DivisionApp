package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FormattingTest {

    @Test
    void testFormatAndPrintShortNumbersCase1(){

        int dividend = 234;
        int divisor = 23;
        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        Formatting formatting = new Formatting(calculator);

        String printedOutput = formatting.format();

        String expectedOutput = "_234|23\n" +
                                " 23 |--\n" +
                                " -- |10\n" +
                                "   4";

        assertEquals(expectedOutput, printedOutput);
    }

    @Test
    void testFormatAndPrintShortNumbersCase2(){

        int dividend = 9;
        int divisor = 2;
        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        Formatting formatting = new Formatting(calculator);

        String printedOutput = formatting.format();

        String expectedOutput = "_9|2\n" +
                                " 8|-\n" +
                                " -|4\n" +
                                " 1";

        assertEquals(expectedOutput, printedOutput);
    }

    @Test
    void testFormatAndPrintShortNumbersCase3(){

        int dividend = 1;
        int divisor = 1;
        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        Formatting formatting = new Formatting(calculator);

        String printedOutput = formatting.format();

        String expectedOutput = "_1|1\n" +
                                " 1|-\n" +
                                " -|1\n" +
                                " 0";

        assertEquals(expectedOutput, printedOutput);
    }

    @Test
    void testFormatAndPrintShortNumbersCase4(){

        int dividend = 55;
        int divisor = 3;
        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        Formatting formatting = new Formatting(calculator);

        String printedOutput = formatting.format();

        String expectedOutput = "_55|3\n" +
                                " 3 |--\n" +
                                " - |18\n" +
                                "_25\n" +
                                " 24\n" +
                                " --\n" +
                                "  1";

        assertEquals(expectedOutput, printedOutput);
    }
    @Test
    void testFormatAndPrintLongNumbersCase1(){

        int dividend = 999999999;
        int divisor = 4444444;
        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        Formatting formatting = new Formatting(calculator);

        String printedOutput = formatting.format();

        String expectedOutput = "_999999999|4444444\n" +
                                " 8888888  |---\n" +
                                " -------  |225\n" +
                                "_11111119\n" +
                                "  8888888\n" +
                                " --------\n" +
                                " _22222319\n" +
                                "  22222220\n" +
                                "  --------\n" +
                                "        99";

        assertEquals(expectedOutput, printedOutput);
    }

    @Test
    void testFormatAndPrintLongNumbersCase2(){

        int dividend = 1111111111;
        int divisor = 987654321;
        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        Formatting formatting = new Formatting(calculator);

        String printedOutput = formatting.format();

        String expectedOutput = "_1111111111|987654321\n" +
                                "  987654321|-\n" +
                                " ----------|1\n" +
                                "  123456790";

        assertEquals(expectedOutput, printedOutput);
    }

    @Test
    void testFormatAndPrintLongNumbersCase3(){

        int dividend = 654000345;
        int divisor = 7;
        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        Formatting formatting = new Formatting(calculator);

        String printedOutput = formatting.format();

        String expectedOutput = "_654000345|7\n" +
                                " 63       |--------\n" +
                                " --       |93428620\n" +
                                " _24\n" +
                                "  21\n" +
                                "  --\n" +
                                "  _30\n" +
                                "   28\n" +
                                "   --\n" +
                                "   _20\n" +
                                "    14\n" +
                                "    --\n" +
                                "    _60\n" +
                                "     56\n" +
                                "     --\n" +
                                "     _43\n" +
                                "      42\n" +
                                "      --\n" +
                                "      _14\n" +
                                "       14\n" +
                                "       --\n" +
                                "         5";

        assertEquals(expectedOutput, printedOutput);
    }

    @Test
    void testFormatAndPrintZeroNumbersCase1(){

        int dividend = 10000;
        int divisor = 10;
        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        Formatting formatting = new Formatting(calculator);

        String printedOutput = formatting.format();

        String expectedOutput = "_10000|10\n" +
                                " 10   |----\n" +
                                " --   |1000\n" +
                                "  0";

        assertEquals(expectedOutput, printedOutput);
    }

    @Test
    void testFormatAndPrintZeroNumbersCase2(){

        int dividend = 800600;
        int divisor = 50;
        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        Formatting formatting = new Formatting(calculator);

        String printedOutput = formatting.format();

        String expectedOutput = "_800600|50\n" +
                                " 50    |-----\n" +
                                " --    |16012\n" +
                                "_300\n" +
                                " 300\n" +
                                " ---\n" +
                                "   _60\n" +
                                "    50\n" +
                                "    --\n" +
                                "   _100\n" +
                                "    100\n" +
                                "    ---\n" +
                                "      0";

        assertEquals(expectedOutput, printedOutput);
    }

    @Test
    void testFormatAndDifferenceInLengthBetweenFirstDivisorAndFirstDividendCase(){

        int dividend = 101345;
        int divisor = 99;
        Calculator calculator = new Calculator(dividend, divisor);
        calculator.calculate();

        Formatting formatting = new Formatting(calculator);

        String printedOutput = formatting.format();

        String expectedOutput = "_101345|99\n" +
                                "  99   |----\n" +
                                " ---   |1023\n" +
                                "  _234\n" +
                                "   198\n" +
                                "   ---\n" +
                                "   _365\n" +
                                "    297\n" +
                                "    ---\n" +
                                "     68";

        assertEquals(expectedOutput, printedOutput);
    }
}