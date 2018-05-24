package com.company.Shape;

import com.company.BigNumber;
import com.company.operations.Operations;

public class Circle implements IShape {
    private Point center;
    private BigNumber radius;

    public Circle(Point center, BigNumber radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public BigNumber getPerimeter() {
        BigNumber twoMulPi = multiplicationByPi(new BigNumber(2));
        return Operations.mul(radius, twoMulPi);
    }

    @Override
    public BigNumber getArea() {
        BigNumber squareOfRadius = Operations.mul(radius, radius);
        return Operations.removeExtraZeros(multiplicationByPi(squareOfRadius));
    }

    @Override
    public String getName() {
        return "Circle";
    }

    private BigNumber multiplicationByPi(BigNumber bigNumber) {
        BigNumber temp = Operations.mul(bigNumber, new BigNumber(314159));
        return Operations.div(temp, new BigNumber(100000));
    }
}
