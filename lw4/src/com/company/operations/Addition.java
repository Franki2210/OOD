package com.company.operations;

import com.company.BigNumber;

import java.util.List;
import java.util.Vector;

class Addition {
    static BigNumber calc(BigNumber number1, BigNumber number2) {
        List<Integer> result = new Vector<>();

        int transfer = 0;

        int maxNumberOfDigits = Operations.getMaxNumberOfDigitInNumbers(number1, number2);

        for (int offset = 1; offset <= maxNumberOfDigits; ++offset) {
            int i1 = number1.get().size() - offset;
            int i2 = number2.get().size() - offset;

            int digit1;
            int digit2;

            if (i1 < 0) digit1 = 0;
            else digit1 = number1.get().get(i1);
            if (i2 < 0) digit2 = 0;
            else digit2 = number2.get().get(i2);

            int sum = digit1 + digit2 + transfer;

            if (sum >= 10) {
                transfer = 1;
                sum = sum - 10;
            } else transfer = 0;

            result.add(0, sum);
        }

        if (transfer != 0) result.add(0, transfer);

        return new BigNumber(result, false);
    }
}
