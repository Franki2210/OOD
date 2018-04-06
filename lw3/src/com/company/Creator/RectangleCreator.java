package com.company.Creator;

import com.company.Shape.IShape;
import com.company.Shape.Point;
import com.company.Shape.Rectangle;

public class RectangleCreator implements IShapeCreator {
    private static RectangleCreator instance;

    private Point topLeftPoint;
    private Point bottomRightPoint;

    static RectangleCreator getInstance() {
        if (instance == null) {
            instance = new RectangleCreator();
        }
        return instance;
    }

    @Override
    public IShape create() {
        return new Rectangle(topLeftPoint, bottomRightPoint);
    }

    @Override
    public void setParameters(String[] parameters) {
        String[] pointCoord1 = parameters[1].split(",");
        String[] pointCoord2 = parameters[2].split(",");

        topLeftPoint = new Point(Integer.parseInt(pointCoord1[0]), Integer.parseInt(pointCoord1[1]));
        bottomRightPoint = new Point(Integer.parseInt(pointCoord2[0]), Integer.parseInt(pointCoord2[1]));
    }
}
