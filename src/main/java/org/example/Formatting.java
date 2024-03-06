package org.example;

import java.util.List;

public class Formatting {

    private int dividend;
    private int divisor;
    private int quotient;
    private List<Integer> result;
    private List<Integer> spaces;

    public Formatting(int dividend, int divisor, int quotient, List<Integer> result, List<Integer> spaces){
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
        this.result = result;
        this.spaces = spaces;
    }

    public void formatAndPrint(){
        System.out.println("_" + dividend + "|" + divisor);

        int dividendLength = String.valueOf(dividend).length();
        int firstDividendLength = String.valueOf(result.get(0)).length();
        int firstDivisorLength = String.valueOf(result.get(1)).length();
        int quotientLength = String.valueOf(quotient).length();
        int difference = firstDividendLength - firstDivisorLength;
        String space = " ".repeat(dividendLength - firstDivisorLength - difference);

        System.out.println(" " + " ".repeat(difference) + result.get(1) + space + "|" + "-".repeat(quotientLength));

        System.out.print(" " + "-".repeat(firstDividendLength) +
                " ".repeat(dividendLength - firstDivisorLength - difference) + "|" + quotient);

        System.out.print("\n");

        for(int i = 2; i < result.size(); i++){
            if(i != result.size() - 1){
                if(i % 2 == 0){
                    System.out.println(" ".repeat(spaces.get(i - 2)) + "_" + result.get(i));
                } else {
                    System.out.println(" " + " ".repeat(spaces.get(i - 2)) + result.get(i));
                    System.out.println(" " + " ".repeat(spaces.get(i - 3)) +
                            "-".repeat(String.valueOf(result.get(i - 1)).length()));
                }
            } else {
                System.out.println(" " + " ".repeat(spaces.get(i - 2)) + result.get(i));
            }
        }

    }

}
