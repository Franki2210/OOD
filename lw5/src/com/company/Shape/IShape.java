package com.company.Shape;

import com.company.BigNumber;
import com.company.Visitors.IVisitor;

public interface IShape {
    BigNumber getPerimeter();
    BigNumber getArea();
    String getName();

    void accept(IVisitor visitor);
}
