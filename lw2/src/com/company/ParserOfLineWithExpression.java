package com.company;

import com.company.operations.Operations;

public class ParserOfLineWithExpression {
    private BigNumber number1;
    private BigNumber number2;
    private OperationType operation;

    public ParserOfLineWithExpression(String line) {
        String[] partsOfExpression = line.split(" ");

        number1 = new BigNumber(partsOfExpression[0]);
        String operationSign = partsOfExpression[1];
        number2 = new BigNumber(partsOfExpression[2]);

        switch (operationSign){
            case "-":
                operation = OperationType.SUB;
                break;
            case "*":
                operation = OperationType.MUL;
                break;
            case "/":
                operation = OperationType.DIV;
                break;
            case "+":
                operation = OperationType.ADD;
        }
    }

    public BigNumber getNumber1() {
        return number1;
    }

    public BigNumber getNumber2() {
        return number2;
    }

    public OperationType getOperation() {
        return operation;
    }
}
