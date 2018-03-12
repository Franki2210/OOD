package com.company.operations;

import com.company.BigNumber;
import com.company.OperationType;

import java.util.List;
import java.util.Vector;

public class Operations {

    public static BigNumber calculate(BigNumber number1, BigNumber number2, OperationType operationType) {
        BigNumber result = null;
        switch (operationType) {
            case ADD:
                result = add(number1, number2);
                break;
            case SUB:
                result = sub(number1, number2);
                break;
            case MUL:
                result = mul(number1, number2);
                break;
            case DIV:
                result = div(number1, number2);
        }
        return result;
    }

    public static BigNumber add(BigNumber number1, BigNumber number2) {
        return getResultWithNormalizeOperation(number1, number2, OperationType.ADD);
    }

    public static BigNumber sub(BigNumber number1, BigNumber number2) {
        return getResultWithNormalizeOperation(number1, number2, OperationType.SUB);
    }

    public static BigNumber mul(BigNumber number1, BigNumber number2) {
        return Multiplication.calc(number1, number2);
    }

    public static BigNumber div(BigNumber number1, BigNumber number2) {
        return Division.calc(number1, number2);
    }

    private static BigNumber getResultWithNormalizeOperation(BigNumber number1, BigNumber number2, OperationType operation) {
        BigNumber result;

        if (operation == OperationType.ADD) {
            if (number1.isNegative() && number2.isNegative()) {
                result = Addition.calc(number1, number2);
                result.setNegative(true);
            } else if (number1.isNegative()) {
                result = Subtraction.calc(number2, number1);
            } else if (number2.isNegative()) {
                result = Subtraction.calc(number1, number2);
            } else {
                result = Addition.calc(number1, number2);
            }
        } else {
            if (number1.isNegative() && number2.isNegative()) {
                result = Subtraction.calc(number2, number1);
            } else if (number1.isNegative()) {
                result = Addition.calc(number1, number2);
                result.setNegative(true);
            } else if (number2.isNegative()) {
                result = Addition.calc(number1, number2);
            } else {
                result = Subtraction.calc(number1, number2);
            }
        }
        return result;
    }

    static int getMaxNumberOfDigitInNumbers(BigNumber number1, BigNumber number2) {
        int compareByNumberOfDigits = compareByNumberOfDigits(number1, number2);
        if (compareByNumberOfDigits > 0) {
            return number1.get().size();
        } else {
            return number2.get().size();
        }
    }

    private static int compareByNumberOfDigits(BigNumber number1, BigNumber number2) {
        List<Integer> number1Value = number1.get();
        List<Integer> number2Value = number2.get();
        if (number1Value.size() > number2Value.size())
            return 1;
        else if (number1Value.size() < number2Value.size())
            return -1;
        else return 0;
    }

    static int compare(BigNumber number1, BigNumber number2) {
        int compareByNumOfDigits = compareByNumberOfDigits(number1, number2);
        if (compareByNumOfDigits == 0) {
            List<Integer> number1Value = number1.get();
            List<Integer> number2Value = number2.get();
            int size = number1Value.size();
            for (int i = 0; i < size; ++i) {
                if (number1Value.get(i) > number2Value.get(i))
                    return 1;
                else if (number1Value.get(i) < number2Value.get(i))
                    return -1;
            }
            return 0;
        } else if (compareByNumOfDigits > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
