package com.company.operations;

import com.company.BigNumber;

import java.util.List;
import java.util.Vector;

public class Sqrt {
    public static BigNumber calc(BigNumber bigNumber)
    {
        BigNumber result = bigNumber;
        BigNumber l = new BigNumber();
        BigNumber r = bigNumber;
        while (Operations.compare(l, r) <= 0)
        {
            BigNumber m = Operations.div(Operations.add(l, r), new BigNumber(2));
            BigNumber squareM = Operations.mul(m, m);
            if (Operations.compare(squareM, bigNumber) <= 0)
            {
                result = m;
                l = Operations.add(result, new BigNumber(1));
            }
            else
            {
                r = Operations.sub(m, new BigNumber(1));
            }
        }
        return result;
    }
}
