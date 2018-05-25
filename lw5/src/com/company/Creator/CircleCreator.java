package com.company.Creator;

import com.company.BigNumber;
import com.company.Shape.Circle;
import com.company.Shape.IShape;
import com.company.Shape.Point;

public class CircleCreator implements IShapeCreator {
    private static CircleCreator instance;

    private Point center;
    private BigNumber radius;

    static CircleCreator getInstance() {
        if (instance == null) {
            instance = new CircleCreator();
        }
        return instance;
    }

    @Override
    public IShape create() {
        return new Circle(center, radius);
    }

    @Override
    public void setParameters(String[] parameters) {
        String[] centerString = parameters[1].split(",");
        String radiusString = parameters[2];

        center = new Point(new BigNumber(centerString[0]), new BigNumber(centerString[1]));
        radius = new BigNumber(radiusString);
    }
}
