package com.company.Shape;

import com.company.BigNumber;
import com.company.Visitors.IVisitor;
import com.company.Operations.Operations;

public class Rectangle implements IShape {
    private Point p1;
    private Point p2;

    private BigNumber side1;
    private BigNumber side2;

    String name;

    public Rectangle(Point topLeftCorner, Point bottomRightCorner) {
        this.p1 = topLeftCorner;
        this.p2 = bottomRightCorner;

        calculateSides();
    }

    private void calculateSides() {
        side1 = Operations.sub(p2.getX(), p1.getX());
        if (side1.isNegative()) side1.setNegative(false);
        side2 = Operations.sub(p2.getY(), p1.getY());
        if (side2.isNegative()) side2.setNegative(false);
    }

    @Override
    public BigNumber getPerimeter() {
        return Operations.add(Operations.mul(side1, new BigNumber(2)), Operations.mul(side2, new BigNumber(2)));
    }

    @Override
    public BigNumber getArea() {
        return Operations.mul(side1, side2);
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
