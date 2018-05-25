package com.company.Creator;

import com.company.BigNumber;
import com.company.Shape.IShape;
import com.company.Shape.Point;
import com.company.Shape.Triangle;

import java.util.List;

public class TriangleCreator implements IShapeCreator {
    private static TriangleCreator instance;

    private Point point1;
    private Point point2;
    private Point point3;

    static TriangleCreator getInstance() {
        if (instance == null) {
            instance = new TriangleCreator();
        }
        return instance;
    }

    @Override
    public IShape create() {
        return new Triangle(point1, point2, point3);
    }

    @Override
    public void setParameters(String[] parameters) {
        String[] pointCoord1 = parameters[1].split(",");
        String[] pointCoord2 = parameters[2].split(",");
        String[] pointCoord3 = parameters[3].split(",");

        point1 = new Point(new BigNumber(pointCoord1[0]), new BigNumber(pointCoord1[1]));
        point2 = new Point(new BigNumber(pointCoord2[0]), new BigNumber(pointCoord2[1]));
        point3 = new Point(new BigNumber(pointCoord3[0]), new BigNumber(pointCoord3[1]));
    }
}
