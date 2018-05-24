package com.company.Creator;

import com.company.Shape.IShape;

public interface IShapeCreator {
    IShape create();
    void setParameters(String[] parameters);
}
