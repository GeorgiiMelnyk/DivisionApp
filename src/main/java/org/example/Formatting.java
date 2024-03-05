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
        int firstDivisorLength = String.valueOf(result.get(0)).length();
        int quotientLength = String.valueOf(quotient).length();
        String space = " ".repeat(dividendLength - firstDivisorLength);

        System.out.println(" " + result.get(0) + space + "|" + "-".repeat(quotientLength));

        System.out.print(" " + "-".repeat(firstDivisorLength) +
                " ".repeat(dividendLength - firstDivisorLength) + "|" + quotient);

        System.out.print("\n");

        for(int i = 1; i < result.size(); i++){
            if(i != result.size() - 1){
                if(i % 2 == 1){
                    System.out.println(" ".repeat(spaces.get(i - 1)) + "_" + result.get(i));
                } else {
                    System.out.println(" " + " ".repeat(spaces.get(i - 1)) + result.get(i));
                    System.out.println(" " + " ".repeat(spaces.get(i - 1)) +
                            "-".repeat(String.valueOf(result.get(i)).length()));
                }
            } else {
                System.out.println(" " + " ".repeat(spaces.get(i - 1)) + result.get(i));
            }
        }
/*        result.remove(0);
        for(int i = 0; i < result.size(); i++){
            if(i != result.size() - 1){
                if(i % 2 == 0){
                    System.out.println(" ".repeat(spaces.get(i)) + "_" + result.get(i));
                    //System.out.println(" ".repeat(spaces.get(i) - 1) + "_" + result.get(i));
                } else {
                    System.out.println(" " + " ".repeat(spaces.get(i)) + result.get(i));
                    System.out.println(" " + " ".repeat(spaces.get(i)) + "-".repeat(String.valueOf(result.get(i)).length()));
                }
            } else {
                System.out.println(" " + " ".repeat(spaces.get(i)) + result.get(i));
            }
        }*/
    }
}
