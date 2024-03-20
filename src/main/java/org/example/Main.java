package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        DataReader dataReader = new DataReader();
        while (true){

            dataReader.enterTheValue(2147483647, "dividend", "");
            //2147483647 is the maximum number for integer

            int dividend = dataReader.getResult();

            dataReader.enterTheValue(dividend, "divisor",
                    "Value should be less than or equal to dividend.\n");
            int divisor = dataReader.getResult();


            Calculator calculator = new Calculator(dividend, divisor);
            calculator.calculate();

            Formatting formatting = new Formatting(calculator);

            System.out.print("\n");
            formatting.print();
            System.out.print("\n".repeat(2));
        }
    }

}