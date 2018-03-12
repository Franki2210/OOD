package com.company.operations;

import com.company.BigNumber;

import java.util.List;
import java.util.Vector;

class Division {
    static BigNumber calc(BigNumber dividend, BigNumber divider) {
        List<Integer> dividendValue = dividend.get();
        List<Integer> dividerValue = divider.get();

        int dividendSize = dividendValue.size();
        int dividerSize = dividerValue.size();

        List<Integer> result = new Vector<>();

        if (dividendSize < dividerSize) {
            return new BigNumber(0);
        }

        if (dividendSize == dividerSize) {
            BigNumberAndInt greatDivAndSubtrahend = getGreatestDivisorAndSubtrahend(dividend, dividerValue);
            int greatDiv = greatDivAndSubtrahend.anInt;
            result.add(greatDiv);
            return new BigNumber(result);
        }

        int i = 0;

        BigNumber minuend = new BigNumber();
        for (; i < dividerSize; ++i) {
            minuend.get().add(dividendValue.get(i));
        }
        for (; i < dividendSize; ++i) {
            if (Operations.compare(minuend, divider) < 0) {
                minuend.get().add(dividendValue.get(i));
                result.add(0);
                ++i;
            }
            BigNumberAndInt greatDivAndSubtrahend = getGreatestDivisorAndSubtrahend(minuend, dividerValue);
            result.add(greatDivAndSubtrahend.anInt);
            minuend = Operations.sub(minuend, greatDivAndSubtrahend.bigNumber);
            if (i == dividendSize) minuend.get().add(0);
            else minuend.get().add(dividendValue.get(i));
        }

        if (minuend.get().size() > 0 && i <= dividendSize) {
            BigNumberAndInt greatDivAndSubtrahend = getGreatestDivisorAndSubtrahend(minuend, dividerValue);
            result.add(greatDivAndSubtrahend.anInt);
        }

        if (result.get(0) == 0) result = result.subList(1, result.size());

        BigNumber resultBigNumber = new BigNumber(result);
        if (dividend.isNegative() && divider.isNegative()) resultBigNumber.setNegative(false);
        else if (dividend.isNegative() || divider.isNegative()) resultBigNumber.setNegative(true);

        return resultBigNumber;
    }

    private static BigNumberAndInt getGreatestDivisorAndSubtrahend(BigNumber minuend, List<Integer> divider) {
        //Находим наибольшее число, при умножении на которое number2, сможем получить число как можно ближе к minuend
        int greatDiv = 0;

        BigNumber subtrahend = null;
        BigNumber lastSubtrahend = null;

        for (greatDiv = 1; greatDiv < 10; ++greatDiv) {
            subtrahend = Multiplication.calc(new BigNumber(divider), greatDiv);
            if (Operations.compare(subtrahend, minuend) > 0) {
                break;
            }
            lastSubtrahend = subtrahend;
        }
        return new BigNumberAndInt(lastSubtrahend, greatDiv - 1);
    }

    private static class BigNumberAndInt {
        BigNumber bigNumber;
        int anInt;

        BigNumberAndInt(BigNumber bigNumber, int anInt) {
            this.bigNumber = bigNumber;
            this.anInt = anInt;
        }
    }
}
