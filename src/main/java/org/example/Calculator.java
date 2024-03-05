package org.example;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private int dividend;
    private int divisor;
    private int [] dividendDigits;
    private List<Integer> result = new ArrayList<>();
    private List<Integer> quotient = new ArrayList<>();
    private List<Integer> spaces = new ArrayList<>();

    public void calculate(int dividend, int divisor){

        this.dividend = dividend;
        this.divisor = divisor;
        result.clear();
        quotient.clear();
        spaces.clear();
        initDivideDigits();

        int currentSpace = 0;
        int curDividend = dividendDigits[0];
        int curDivivsior = 0;

        for(int i = 0; i < dividendDigits.length; i++){

            if(divisor <= curDividend){
                curDivivsior = findGreatestCommonDivisor(curDividend);

                int dividendLength = String.valueOf(curDividend).length();
                int differenceLength = String.valueOf(curDividend - curDivivsior).length();
                System.out.println(dividendLength);
                System.out.println(differenceLength);
                if(curDividend - curDivivsior != 0){
                    currentSpace += dividendLength - differenceLength;
                    System.out.println("*");
                            //(String.valueOf(curDividend).length()) - (String.valueOf(curDividend - curDivivsior).length());
                } else {
                    currentSpace += String.valueOf(curDivivsior).length();
                    System.out.println("+");
                }

                result.add(curDividend);
                result.add(curDivivsior);
                spaces.add(currentSpace);
                spaces.add(currentSpace);
                curDividend = curDividend - curDivivsior;


            } else if (!quotient.isEmpty()){
                quotient.add(0);
                currentSpace++;
            }

            if (i < dividendDigits.length - 1) {
                curDividend = curDividend * 10 + dividendDigits[i + 1];
            } else {
                currentSpace += String.valueOf(curDivivsior).length() - String.valueOf(curDividend).length();
                result.add(curDividend);
                spaces.add(currentSpace);
            }


        }

        result.remove(0);
        spaces.remove(0);
    }


    private int findGreatestCommonDivisor(int num1){

        int num2 = divisor;
        int multiplier = 1;
        int result = num2;

        while (num2 * multiplier <= num1) {
            result = num2 * multiplier;
            multiplier++;
        }

        quotient.add(multiplier - 1);
        return result;
    }

    private void initDivideDigits(){
        String numAsString = String.valueOf(dividend);
        dividendDigits = new int[numAsString.length()];

         for(int i = 0; i < numAsString.length(); i++){
             dividendDigits[i] = Character.getNumericValue(numAsString.charAt(i));
         }
    }

    public List<Integer> getResult() {
        return result;
    }

    public List<Integer> getQuotient() {
        return quotient;
    }

    public List<Integer> getSpaces() {
        return spaces;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }
}
