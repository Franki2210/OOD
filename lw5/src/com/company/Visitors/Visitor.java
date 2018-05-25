package com.company.Visitors;

import com.company.Shape.Circle;
import com.company.Shape.IShape;
import com.company.Shape.Rectangle;
import com.company.Shape.Triangle;

public class Visitor implements IVisitor {
    private String string;

    public String getInfo(IShape shape) {
        shape.accept(this);
        return string;
    }

    @Override
    public void visit(Circle circle) {
        string = circle.getName() + ": P=" + circle.getPerimeter().getAsString() + "; S=" + circle.getArea().getAsString();
    }

    @Override
    public void visit(Rectangle rectangle) {
        string = rectangle.getName() + ": P=" + rectangle.getPerimeter().getAsString() + "; S=" + rectangle.getArea().getAsString();
    }

    @Override
    public void visit(Triangle triangle) {
        string = triangle.getName() + ": P=" + triangle.getPerimeter().getAsString() + "; S=" + triangle.getArea().getAsString();
    }
}
