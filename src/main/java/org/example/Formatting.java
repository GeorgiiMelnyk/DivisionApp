package org.example;

import java.util.List;

public class Formatting {
    private final int dividend;
    private final int divisor;
    private final int quotient;
    private final List<Integer> result;
    private final List<Integer> spaces;

    public Formatting(Calculator calculator){
        this.dividend = calculator.getDividend();
        this.divisor = calculator.getDivisor();
        this.quotient = calculator.getQuotientInIntFormat();
        this.result = calculator.getResult();
        this.spaces = calculator.getSpaces();
    }


    public String format(){
        StringBuilder resultString = new StringBuilder();
        resultString.append("_")
                    .append(dividend)
                    .append("|")
                    .append(divisor)
                    .append("\n");

        int dividendLength = getLength(dividend);
        int firstDividendLength = getLength(result.get(0));
        int firstDivisorLength = getLength(result.get(1));
        int quotientLength = getLength(quotient);
        int difference = firstDividendLength - firstDivisorLength;
        String space = " ".repeat(dividendLength - firstDivisorLength - difference);

        resultString.append(" ")
                    .append(" ".repeat(difference))
                    .append(result.get(1))
                    .append(space)
                    .append("|")
                    .append("-".repeat(quotientLength))
                    .append("\n");

        resultString.append(" ")
                    .append("-".repeat(firstDividendLength))
                    .append(" ".repeat(dividendLength - firstDivisorLength - difference))
                    .append("|").append(quotient).append("\n");


        for(int i = 2; i < result.size(); i++){
            if(i != result.size() - 1){
                if(i % 2 == 0){
                    resultString.append(" ".repeat(spaces.get(i - 2)))
                                .append("_")
                                .append(result.get(i))
                                .append("\n");
                } else {
                    resultString.append(" ")
                                .append(" ".repeat(spaces.get(i - 2)))
                                .append(result.get(i))
                                .append("\n");
                    resultString.append(" ")
                                .append(" ".repeat(spaces.get(i - 3)))
                                .append("-".repeat(String.valueOf(result.get(i - 1)).length()))
                                .append("\n");
                }
            } else {
                resultString.append(" ")
                            .append(" ".repeat(spaces.get(i - 2)))
                            .append(result.get(i));
            }
        }

        return resultString.toString();
    }

    public void print(String string){
        System.out.print(string);
    }

    private int getLength(int number){
       return String.valueOf(number).length();
    }

}
