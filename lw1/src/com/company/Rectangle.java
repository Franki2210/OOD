package com.company;

public class Rectangle implements Shape {
    private Point p1;
    private Point p2;

    private float side1;
    private float side2;

    String name;

    public Rectangle(Point topLeftCorner, Point bottomRightCorner) {
        this.p1 = topLeftCorner;
        this.p2 = bottomRightCorner;

        calculateSides();
    }

    private void calculateSides() {
        side1 = Math.abs(p2.getX() - p1.getX());
        side2 = Math.abs(p2.getY() - p1.getY());
    }

    @Override
    public float getPerimeter() {
        return side1 * 2 + side2 * 2;
    }

    @Override
    public float getArea() {
        return side1 * side2;
    }

    @Override
    public String getName() {
        return "Rectangle";
    }
}
