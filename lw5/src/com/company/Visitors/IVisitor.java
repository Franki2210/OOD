package com.company.Visitors;

import com.company.Shape.Circle;
import com.company.Shape.Rectangle;
import com.company.Shape.Triangle;

public interface IVisitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
    void visit(Triangle triangle);
}
