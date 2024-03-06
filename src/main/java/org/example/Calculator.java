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

    public Calculator(int dividend, int divisor){
        this.dividend = dividend;
        this.divisor = divisor;
        initDivideDigits();
    }

    public void calculate(){

        result.clear();
        quotient.clear();
        spaces.clear();
        initDivideDigits();

        int currentSpace = 0;
        int curDividend = dividendDigits[0];
        int curDivisor = 0;

        for(int i = 0; i < dividendDigits.length; i++){

            if(divisor <= curDividend){
                curDivisor = findGreatestCommonDivisor(curDividend);

                int dividendLength = String.valueOf(curDividend).length();
                int differenceLength = String.valueOf(curDividend - curDivisor).length();

                if(curDividend - curDivisor != 0){
                    currentSpace += dividendLength - differenceLength;
                } else {
                    currentSpace += String.valueOf(curDivisor).length();
                }

                spaces.add(currentSpace);
                spaces.add(currentSpace);
                result.add(curDividend);
                result.add(curDivisor);
                compareDividendAndDivisor(curDividend, curDivisor);
                curDividend = curDividend - curDivisor;


            } else if (!quotient.isEmpty()){
                quotient.add(0);
            }

            if (i < dividendDigits.length - 1) {
                curDividend = curDividend * 10 + dividendDigits[i + 1];
            } else {
                currentSpace += String.valueOf(curDivisor).length() - String.valueOf(curDividend).length();
                result.add(curDividend);
                spaces.add(currentSpace);
                checkZeroCaseAndChangeSpace(curDividend);
            }


        }

    }


    private void initDivideDigits(){
        String numAsString = String.valueOf(dividend);
        dividendDigits = new int[numAsString.length()];

        for(int i = 0; i < numAsString.length(); i++){
            dividendDigits[i] = Character.getNumericValue(numAsString.charAt(i));
        }
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

    private void checkZeroCaseAndChangeSpace(int curDividend){

        if(curDividend == 0 && quotient.get(quotient.size() - 1) == 0){
            spaces.set(spaces.size() - 3, spaces.get(spaces.size() - 3) - 1);
        }
    }

    private void compareDividendAndDivisor(int curDividend, int curDivisor){
        int curDividendLength = String.valueOf(curDividend).length();
        int curDivisorLength = String.valueOf(curDivisor).length();

        if(curDividendLength > curDivisorLength && spaces.size() > 2){
            int difference = curDividendLength - curDivisorLength;
            spaces.set(spaces.size() - 3, spaces.get(spaces.size() - 3) + difference);
        }
    }
    public int getQuotientInIntFormat() {
        StringBuilder quotient = new StringBuilder();
        for(int i : this.quotient){
            quotient.append(i);
        }

        return Integer.parseInt(quotient.toString());
    }

    public List<Integer> getResult() {
        return result;
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
