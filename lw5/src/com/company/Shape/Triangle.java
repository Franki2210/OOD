package com.company.Shape;

import com.company.BigNumber;
import com.company.Visitors.IVisitor;
import com.company.Operations.Operations;

public class Triangle implements IShape {
    private Point p1;
    private Point p2;
    private Point p3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.p1 = point1;
        this.p2 = point2;
        this.p3 = point3;
    }

    @Override
    public BigNumber getPerimeter() {
        BigNumber side12 = calcSide(p1, p2);
        BigNumber side23 = calcSide(p2, p3);
        BigNumber side31 = calcSide(p3, p1);

        return Operations.add(Operations.add(side12, side23), side31);
    }

    @Override
    public BigNumber getArea() {
        BigNumber t1 = Operations.sub(p1.getX(), p3.getX());
        BigNumber t2 = Operations.sub(p2.getY(), p3.getY());
        BigNumber mulT1T2 = Operations.mul(t1, t2);
        BigNumber t3 = Operations.sub(p2.getX(), p3.getX());
        BigNumber t4 = Operations.sub(p1.getY(), p3.getY());
        BigNumber mulT3T4 = Operations.mul(t3, t4);
        BigNumber sub = Operations.sub(mulT1T2, mulT3T4);
        if (sub.isNegative()) sub.setNegative(false);

        return Operations.div(sub, new BigNumber(2));
    }

    @Override
    public String getName() {
        return "Triangle";
    }

    private BigNumber calcSide(Point p1, Point p2) {
        BigNumber temp1 = Operations.sub(p2.getX(), p1.getX());
        temp1 = Operations.mul(temp1, temp1);
        BigNumber temp2 = Operations.sub(p2.getY(), p1.getY());
        temp2 = Operations.mul(temp2, temp2);

        BigNumber sum = Operations.add(temp1, temp2);
        return Operations.sqrt(sum);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
