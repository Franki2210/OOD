package com.company.Shape;

import com.company.BigNumber;
import com.company.Visitors.IVisitor;
import com.company.Operations.Operations;

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

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    private BigNumber multiplicationByPi(BigNumber bigNumber) {
        BigNumber temp = Operations.mul(bigNumber, new BigNumber(BigNumber.PI));
        return Operations.div(temp, new BigNumber(BigNumber.NUMBER_OF_DECIMAL_PLACES_IN_PI));
    }
}
