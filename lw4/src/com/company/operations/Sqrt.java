package com.company.operations;

import com.company.BigNumber;

import java.util.List;
import java.util.Vector;

public class Sqrt {
    public static BigNumber calc(BigNumber longInteger)
    {
        BigNumber possibleResult = longInteger;
        BigNumber l = new BigNumber();
        BigNumber r = longInteger;
        while (Operations.compare(l, r) <= 0)
        {
            BigNumber m = Operations.div(Operations.add(l, r), new BigNumber(2));
            BigNumber squareM = Operations.mul(m, m);
            if (Operations.compare(squareM, longInteger) <= 0)
            {
                possibleResult = m;
                l = Operations.add(possibleResult, new BigNumber(1));
            }
            else
            {
                r = Operations.sub(m, new BigNumber(1));
            }
        }
        return possibleResult;
    }

    /*public static BigNumber calc(BigNumber number) {
        List<Integer> sqrt = new Vector<>();
        List<String> numbers = divideByNumbers(number);
        int iterCount = numbers.size() - 1;

        int initDefaultValue = Integer.parseInt(numbers.get(numbers.size() - 1));
        numbers.remove(numbers.size() - 1);

        int firstSqrtDigit = (int) Math.sqrt(initDefaultValue);
        sqrt.add(firstSqrtDigit);

        BigNumber defaultValue = new BigNumber(String.valueOf(initDefaultValue));
        BigNumber sqrtValue = new BigNumber(String.valueOf(firstSqrtDigit));

        BigNumber valueSqr = Operations.mul(sqrtValue, sqrtValue);

        BigNumber firstValueForNumUnderRoot = Operations.sub(defaultValue, valueSqr);

        for (int i = 0; i < iterCount; i++) {
            String newPartOfValueUnderRoot = "";
            BigNumber currValueUnderRoot = defaultValue;
            if (!numbers.isEmpty()) {
                newPartOfValueUnderRoot = String.valueOf(firstValueForNumUnderRoot) + String.valueOf(numbers.get(numbers.size() - 1));
                numbers.remove(numbers.size() - 1);
                currValueUnderRoot = new BigNumber(newPartOfValueUnderRoot);
            }

            // значение корня умножили на 2, по алгоритму
            sqrtValue = Operations.mul(sqrtValue, new BigNumber(2));
            int newDigit = 0;
            BigNumber subtrahend = new BigNumber("0");
            for (int digit = 9; digit >= 0; digit--) {
                // конструируем число, подбираем коэффициент
                subtrahend = new BigNumber(String.valueOf(sqrtValue) + String.valueOf(digit));
                BigNumber comparisonValue = Operations.mul(subtrahend, new BigNumber(digit));
                if (Operations.compare(comparisonValue, currValueUnderRoot) <= 0) {
                    newDigit = digit;
                    sqrt.add(newDigit);
                    break;
                }
            }

            if (numbers.isEmpty()) {
                break;
            }

            BigNumber newDefaultValue = Operations.sub(currValueUnderRoot, Operations.mul(subtrahend, new BigNumber(newDigit)));
            defaultValue = newDefaultValue;
            sqrtValue = calculateNewValue(sqrt);
        }

        String sqrtString = "";
        for (int i = 0; i < sqrt.size(); i++) {
            sqrtString += String.valueOf(sqrt.get(i));
        }

        return new BigNumber(sqrtString);
    }

    private static List<String> divideByNumbers(BigNumber number) {
        List<String> result = new Vector<>();
        for (int i = 0; i < number.getAmount(); i += 2) {
            String digit1 = "";
            String digit2 = "";

            if (i < number.getAmount() - 1) {
                digit1 = number.get().get(i + 1).toString();
            }

            if (i < number.getAmount()) {
                digit2 = number.get().get(i).toString();
            }

            String digits = digit1 + digit2;
            result.add(digits);
        }
        return result;
    }

    static BigNumber calculateNewValue(List<Integer> numbers) {
        BigNumber number = new BigNumber("0");
        for (int i = 0; i < numbers.size(); i++) {
            number = Operations.add(Operations.mul(number, new BigNumber(10)), new BigNumber(numbers.get(i)));
        }
        return number;
    }*/
}
