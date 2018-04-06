package com.company;

import com.company.Creator.Factory;
import com.company.Creator.IShapeCreator;
import com.company.Shape.IShape;

public class Main {

    public static void main(String[] args) {
        Reader reader = new Reader("input.txt");
        Writer writer = new Writer("output.txt");

        Factory factory = new Factory();
        String line;

        while ((line = reader.getNextLine()) != null) {
            IShapeCreator creator = factory.create(line);
            IShape shape = creator.create();

            if (shape != null) {
                writer.writeLine(shape.getName() + ": P=" + shape.getPerimeter() + "; S=" + shape.getArea());
                System.out.println(shape.getName() + ": P=" + shape.getPerimeter() + "; S=" + shape.getArea());
            } else {
                writer.writeLine("ERROR");
                System.out.println("ERROR");
            }
        }

        reader.close();
        writer.close();
    }
}
