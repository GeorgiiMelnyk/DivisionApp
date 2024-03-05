package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        calculator.calculate(9587, 3);
        Formatting formatting = new Formatting();
        System.out.println(calculator.getSpaces());
        System.out.println(calculator.getResult());
        formatting.formatAndPrint(calculator.getDividend(), calculator.getDivisor(),  calculator.getResult(), calculator.getQuotient(), calculator.getSpaces());

        System.out.println();
        for (Integer item : calculator.getResult()) {
            System.out.println(item);
        }

        System.out.println("----");
        for (Integer item : calculator.getQuotient()) {
            System.out.println(item);
        }
    }

}