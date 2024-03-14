package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
class MainTest {


        private final InputStream originalIn = System.in;
        private final PrintStream originalOut = System.out;
        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        private final ByteArrayInputStream inContent = new ByteArrayInputStream("10\n2\n5\n3\n".getBytes());

        @BeforeEach
        public void setUpStreams() {
            System.setOut(new PrintStream(outContent));
            System.setIn(inContent);
        }

        @AfterEach
        public void restoreStreams() {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        @Test
        public void testMain() {
            Main.main(new String[]{});
            String expectedOutput = "Enter the dividend: Enter the divisor: \n" +
                    "Enter the dividend: Value should be less than or equal to dividend\n" +
                    "Enter the dividend: Value should be greater than 0.\n" +
                    "Enter the dividend: Enter the divisor: \n" +
                    " _10|2\n" +
                    "   2|-\n" +
                    "  --|5\n" +
                    "   0\n" +
                    "\n\n" +
                    "Enter the dividend: Enter the divisor: ";
            assertEquals(expectedOutput, outContent.toString());
        }

        @Test
        public void testMainInputMismatchException() {
            ByteArrayInputStream inputMismatchStream = new ByteArrayInputStream("not_an_integer\n5\n".getBytes());
            System.setIn(inputMismatchStream);

            Main.main(new String[]{});

            assertTrue(outContent.toString().contains("Input is not a valid integer."));
        }

}