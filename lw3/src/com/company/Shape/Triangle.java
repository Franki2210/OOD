package com.company.Shape;

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
    public float getPerimeter() {
        float side12 = (float)Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
        float side23 = (float)Math.sqrt(Math.pow(p3.getX() - p2.getX(), 2) + Math.pow(p3.getY() - p2.getY(), 2));
        float side31 = (float)Math.sqrt(Math.pow(p1.getX() - p3.getX(), 2) + Math.pow(p1.getY() - p3.getY(), 2));

        return side12 + side23 + side31;
    }

    @Override
    public float getArea() {
        return Math.abs((p1.getX() - p3.getX()) * (p2.getY() - p3.getY()) -
                        (p2.getX() - p3.getX()) * (p1.getY() - p3.getY())) / 2;
    }

    @Override
    public String getName() {
        return "Triangle";
    }
}
