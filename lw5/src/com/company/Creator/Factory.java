package com.company.Creator;

public class Factory {
    public IShapeCreator create(String lineWithParams) {
        String[] parameters = lineWithParams.split(" ");
        String shapeName = parameters[0];

        IShapeCreator shapeCreator = null;

        if (shapeName.equals("triangle")) {
            shapeCreator = TriangleCreator.getInstance();
        } else if (shapeName.equals("rectangle")) {
            shapeCreator = RectangleCreator.getInstance();
        } else if (shapeName.equals("circle")){
            shapeCreator = CircleCreator.getInstance();
        }

        shapeCreator.setParameters(parameters);

        return shapeCreator;
    }
}
