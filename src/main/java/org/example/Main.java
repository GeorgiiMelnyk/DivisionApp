package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true){

            int dividend;
            do {
                System.out.print("Enter the dividend: ");
                dividend = scanner.nextInt();
                if(dividend < 0) {
                    System.out.println("Value should be greater than 0.");
                }
            } while (dividend < 0);


            int divisor;
            do {
                System.out.print("Enter the divisor: ");
                divisor = scanner.nextInt();
                if(divisor < 0) {
                    System.out.println("Value should be greater than 0.");
                }
            } while (divisor < 0);

            Calculator calculator = new Calculator(dividend, divisor);
            calculator.calculate();

            Formatting formatting = new Formatting(calculator.getDividend(), calculator.getDivisor(),
                    calculator.getQuotientInIntFormat(), calculator.getResult(), calculator.getSpaces());

            System.out.print("\n");
            formatting.formatAndPrint();
            System.out.print("\n".repeat(2));
        }
    }

}