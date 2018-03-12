package com.company.operations;

import com.company.BigNumber;

import java.util.List;
import java.util.Vector;

public class Multiplication {
    static BigNumber calc(BigNumber number1, BigNumber number2) {
        List<Integer> number1Value = number1.get();
        List<Integer> number2Value = number2.get();

        int number1Size = number1Value.size();
        int number2Size = number2Value.size();

        List<Integer> temp;
        BigNumber result = new BigNumber();
        int transfer;
        for (int i = number1Size - 1; i >= 0; --i) {
            temp = new Vector<>();
            transfer = 0;
            for (int j = number2Size - 1; j >= 0; --j) {
                int digit1 = number1Value.get(i);
                int digit2 = number2Value.get(j);

                int resultDigit = digit1 * digit2 + transfer;

                if (resultDigit >= 10) {
                    transfer = resultDigit / 10;
                    resultDigit = resultDigit % 10;
                } else transfer = 0;
                temp.add(0, resultDigit);
            }
            if (transfer != 0) temp.add(0, transfer);
            for (int k = 0; k < number1Size - i - 1; ++k) temp.add(0);
            result = Addition.calc(new BigNumber(temp), result);
        }

        if (number1.isNegative() && number2.isNegative()) result.setNegative(false);
        else if (number1.isNegative() || number2.isNegative()) result.setNegative(true);

        return result;
    }

    static BigNumber calc(BigNumber number1, int number2) {
        BigNumber bigNumber2 = new BigNumber(number2);
        return calc(number1, bigNumber2);
    }

    public static BigNumber calc(int number1, BigNumber number2) {
        return calc(number2, number1);
    }
}
