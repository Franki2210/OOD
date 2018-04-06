package com.company.Shape;

public class Circle implements IShape {
    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public float getPerimeter() {
        return (float)(2 * Math.PI * radius);
    }

    @Override
    public float getArea() {
        return (float)(Math.PI * Math.pow(radius, 2));
    }

    @Override
    public String getName() {
        return "Circle";
    }
}
