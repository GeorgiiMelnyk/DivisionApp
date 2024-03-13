package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true){

            int dividend = 0;
            do {
                try {
                    System.out.print("Enter the dividend: ");
                    dividend = scanner.nextInt();
                    if(dividend <= 0) {
                        System.out.println("Value should be greater than 0.");
                    }
                } catch (InputMismatchException e){
                    System.out.println("Input is not a valid integer. Please try again.");
                    scanner.next();
                }
            } while (dividend <= 0);


            int divisor = 0;
            do {
                try {
                    System.out.print("Enter the divisor: ");
                    divisor = scanner.nextInt();
                    if(divisor <= 0) {
                        System.out.println("Value should be greater than 0.");
                    }
                    if(divisor > dividend){
                        System.out.println("Value should be less than or equal to dividend");
                    }
                }  catch (InputMismatchException e){
                    System.out.println("Input is not a valid integer. Please try again.");
                    scanner.next();
                }
            } while (divisor <= 0 || divisor > dividend);

            Calculator calculator = new Calculator(dividend, divisor);
            calculator.calculate();

            Formatting formatting = new Formatting(calculator);

            System.out.print("\n");
            formatting.formatAndPrint();
            System.out.print("\n".repeat(2));
        }
    }

}