package com.company.Operations;

import com.company.BigNumber;

import java.util.List;
import java.util.Vector;

class Subtraction {
    static BigNumber calc(BigNumber number1, BigNumber number2) {
        int compareNumbers = Operations.compare(number1, number2);

        if (compareNumbers > 0) {
            return subSmallerFromLarger(number1, number2);
        } else if (compareNumbers < 0) {
            BigNumber result = subSmallerFromLarger(number2, number1);
            result.setNegative(true);
            return result;
        } else {
            return new BigNumber("0");
        }
    }

    private static BigNumber subSmallerFromLarger(BigNumber maxNumber, BigNumber minNumber) {
        List<Integer> result = new Vector<>();

        List<Integer> maxNumberValue = maxNumber.get();
        List<Integer> minNumberValue = minNumber.get();

        int maxNumberOfDigits = maxNumber.get().size();
        for (int offset = 1; offset <= maxNumberOfDigits; ++offset) {
            int i1 = maxNumberValue.size() - offset;
            int i2 = minNumberValue.size() - offset;

            int digit1;
            int digit2;

            if (i1 < 0) digit1 = 0;
            else digit1 = maxNumberValue.get(i1);
            if (i2 < 0) digit2 = 0;
            else digit2 = minNumberValue.get(i2);

            int difference;

            if (digit1 < digit2) {
                difference = digit1 + 10 - digit2;
                //Занимаем у след. разряда
                int digitInNextDischarge = maxNumberValue.get(i1 - 1);
                maxNumber.get().set(i1 - 1, digitInNextDischarge - 1);
            } else {
                difference = digit1 - digit2;
            }

            result.add(0, difference);
        }

        int offset = 0;
        for (int digit :
                result) {
            if (digit == 0) ++offset;
            else break;
        }

        result = result.subList(offset, result.size());

        return new BigNumber(result, false);
    }
}
