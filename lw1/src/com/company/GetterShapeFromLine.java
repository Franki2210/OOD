package com.company;

public class GetterShapeFromLine {
    static Shape get(String line) {
        String[] words = line.split(" ");

        if (words[0].equals("triangle")) {
            return getTriangle(words);
        } else if (words[0].equals("rectangle")) {
            return getRectangle(words);
        } else if (words[0].equals("circle")){
            return getCircle(words);
        }

        return null;
    }

    static private Triangle getTriangle(String[] words) {
        String[] pointCoord1 = words[1].split(",");
        String[] pointCoord2 = words[2].split(",");
        String[] pointCoord3 = words[3].split(",");

        Point point1 = new Point(Integer.parseInt(pointCoord1[0]), Integer.parseInt(pointCoord1[1]));
        Point point2 = new Point(Integer.parseInt(pointCoord2[0]), Integer.parseInt(pointCoord2[1]));
        Point point3 = new Point(Integer.parseInt(pointCoord3[0]), Integer.parseInt(pointCoord3[1]));

        return new Triangle(point1, point2, point3);
    }

    static private Rectangle getRectangle(String[] words) {
        String[] pointCoord1 = words[1].split(",");
        String[] pointCoord2 = words[2].split(",");

        Point point1 = new Point(Integer.parseInt(pointCoord1[0]), Integer.parseInt(pointCoord1[1]));
        Point point2 = new Point(Integer.parseInt(pointCoord2[0]), Integer.parseInt(pointCoord2[1]));

        return new Rectangle(point1, point2);
    }

    static private Circle getCircle(String[] words) {
        String[] centerString = words[1].split(",");
        String radiusString = words[2];

        Point center = new Point(Integer.parseInt(centerString[0]), Integer.parseInt(centerString[1]));
        int radius = Integer.parseInt(radiusString);

        return new Circle(center, radius);
    }
}
