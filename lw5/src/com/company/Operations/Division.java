package com.company.Operations;

import com.company.BigNumber;

class Division {
    static BigNumber calc(BigNumber dividend, BigNumber divider) {
        if (divideByZero(divider))
            throw new ArithmeticException();

        if (Operations.compare(dividend, divider) < 0) //Если делимое < делителя, возвращаем ноль
            return new BigNumber(0);

        BigNumber result = new BigNumber();
        BigNumber minuend = new BigNumber();
        int index = 0;

        while (index < dividend.getAmount()) {
            //Отсечь от делимого столько цифр, сколько понадобится для деления на делитель
            int t = 0;
            while (Operations.compare(minuend, divider) < 0 && index < dividend.getAmount()) {
                minuend.addDigit(dividend.getDigit(index));
                ++index;
                if (t > 0)
                    result.addDigit(0);
                ++t;
            }

            if (index >= dividend.getAmount() && Operations.compare(minuend, divider) < 0) {
                result.addDigit(0);
                break;
            }

            //Найти наибольшее число которое можно вычесть из minuend(отсечённого числа), а так же множитель
            BigNumberAndInt multiplierAndSubtrahend = getGreatestMulAndSubtrahend(minuend, divider);
            int multiplier = multiplierAndSubtrahend.anInt;
            BigNumber subtrahend = multiplierAndSubtrahend.bigNumber;

            //Множитель в результат, вычитаемое вычитаем из minuend(отсечённого числа)
            result.addDigit(multiplier);
            minuend = Operations.sub(minuend, subtrahend);

            minuend = Operations.removeExtraZeros(minuend);
        }

        return Operations.removeExtraZeros(result);
    }

    private static boolean divideByZero(BigNumber divider) {
        return divider.getAmount() == 1 && divider.getDigit(0) == 0;
    }

    private static BigNumberAndInt getGreatestMulAndSubtrahend(BigNumber minuend, BigNumber divider) {
        //Находим наибольшее число, при умножении на которое number2, сможем получить число как можно ближе к minuend
        int greatDiv = 0;

        BigNumber subtrahend;
        BigNumber lastSubtrahend = null;

        for (greatDiv = 1; greatDiv < 10; ++greatDiv) {
            subtrahend = Multiplication.calc(divider, greatDiv);
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
