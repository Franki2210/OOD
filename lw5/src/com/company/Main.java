package com.company;

import com.company.Creator.Factory;
import com.company.Creator.IShapeCreator;
import com.company.Shape.IShape;
import com.company.Visitors.Visitor;

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
                Visitor visitor = new Visitor();
                String info = visitor.getInfo(shape);
                writer.writeLine(info);
                System.out.println(info);
            } else {
                writer.writeLine("ERROR");
                System.out.println("ERROR");
            }
        }

        reader.close();
        writer.close();
    }
}
