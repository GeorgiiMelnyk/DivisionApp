package org.example;

import java.util.List;

public class Formatting {
    private int dividend;
    private int divisor;
    private int quotient;
    private List<Integer> result;
    private List<Integer> spaces;

    public Formatting(Calculator calculator){
        this.dividend = calculator.getDividend();
        this.divisor = calculator.getDivisor();
        this.quotient = calculator.getQuotientInIntFormat();
        this.result = calculator.getResult();
        this.spaces = calculator.getSpaces();
    }


    public void formatAndPrint(){
        StringBuilder resultString = new StringBuilder();
        resultString.append("_").append(dividend).append("|").append(divisor).append("\n");

        int dividendLength = String.valueOf(dividend).length();
        int firstDividendLength = String.valueOf(result.get(0)).length();
        int firstDivisorLength = String.valueOf(result.get(1)).length();
        int quotientLength = String.valueOf(quotient).length();
        int difference = firstDividendLength - firstDivisorLength;
        String space = " ".repeat(dividendLength - firstDivisorLength - difference);

        resultString.append(" ").append(" ".repeat(difference)).append(result.get(1)).append(space).append("|").append("-".repeat(quotientLength)).append("\n");

        resultString.append(" ").append("-".repeat(firstDividendLength)).append(" ".repeat(dividendLength - firstDivisorLength - difference))
                .append("|").append(quotient).append("\n");


        for(int i = 2; i < result.size(); i++){
            if(i != result.size() - 1){
                if(i % 2 == 0){
                    resultString.append(" ".repeat(spaces.get(i - 2))).append("_").append(result.get(i)).append("\n");
                } else {
                    resultString.append(" ").append(" ".repeat(spaces.get(i - 2))).append(result.get(i)).append("\n");
                    resultString.append(" ").append(" ".repeat(spaces.get(i - 3))).append("-".repeat(String.valueOf(result.get(i - 1)).length())).append("\n");
                }
            } else {
                resultString.append(" ").append(" ".repeat(spaces.get(i - 2))).append(result.get(i));
            }
        }

        String finalResult = resultString.toString();
        System.out.println(finalResult);
    }

}
