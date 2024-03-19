package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private Scanner scanner;
    private int result;

    public DataReader(){
        this.scanner = new Scanner(System.in);
    }

    public void enterTheValue(int otherNumber, String divisionTerm, String textForDivisorCase){
        int value = 0;
        do {
            try {
                System.out.print("Enter the " + divisionTerm + ": ");
                value = scanner.nextInt();
                if(value <= 0) {
                    System.out.println("Value should be greater than 0.");
                }
                if(value > otherNumber){
                    System.out.print(textForDivisorCase);
                }
            } catch (InputMismatchException e){
                System.out.println("Input is not a valid integer. Please try again.");
                scanner.next();
            }
        } while (value <= 0 || value > otherNumber);

        this.result = value;
    }

    public int getResult() {
        return result;
    }
}
