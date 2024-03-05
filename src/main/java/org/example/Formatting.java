package org.example;

import java.util.List;

public class Formatting {

    public void formatAndPrint(int dividend, int divisor, List<Integer> result, List<Integer> quotient, List<Integer> spaces){
        System.out.println("_" + dividend + "|" + divisor);
        int dividendLength = String.valueOf(dividend).length();
        int firstDivisorLength = String.valueOf(result.get(0)).length();
        int quotientLength = quotient.size();
        String space = " ".repeat(dividendLength - firstDivisorLength);

        System.out.println(" " + result.get(0) + space + "|" + "-".repeat(quotientLength));

        System.out.print(" " + "-".repeat(firstDivisorLength) + " ".repeat(dividendLength - firstDivisorLength) + "|");
        for(int i : quotient){
            System.out.print(i);
        }
        System.out.print("\n");

        for(int i = 1; i < result.size(); i++){
            if(i != result.size() - 1){
                if(i % 2 == 1){
                    System.out.println(" ".repeat(spaces.get(i)) + "_" + result.get(i));
                    //System.out.println(" ".repeat(spaces.get(i) - 1) + "_" + result.get(i));
                } else {
                    System.out.println(" " + " ".repeat(spaces.get(i)) + result.get(i));
                    System.out.println(" " + " ".repeat(spaces.get(i)) + "-".repeat(String.valueOf(result.get(i)).length()));
                }
            } else {
                System.out.println(" " + " ".repeat(spaces.get(i)) + result.get(i));
            }
        }
    }
}
