package com.company;

import com.company.Creator.Factory;
import com.company.Creator.IShapeCreator;
import com.company.Shape.IShape;
import com.company.operations.Operations;

public class Main {

    public static void main(String[] args) {
        /*BigNumber number1 = new BigNumber("5005");
        BigNumber number2 = new BigNumber(5);

        BigNumber result = Operations.div(number1, number2);

        System.out.println(result.getAsString());*/


        Reader reader = new Reader("input.txt");
        Writer writer = new Writer("output.txt");

        Factory factory = new Factory();
        String line;

        while ((line = reader.getNextLine()) != null) {
            IShapeCreator creator = factory.create(line);
            IShape shape = creator.create();

            if (shape != null) {
                writer.writeLine(shape.getName() + ": P=" + shape.getPerimeter().getAsString() + "; S=" + shape.getArea().getAsString());
                System.out.println(shape.getName() + ": P=" + shape.getPerimeter().getAsString() + "; S=" + shape.getArea().getAsString());
            } else {
                writer.writeLine("ERROR");
                System.out.println("ERROR");
            }
        }

        reader.close();
        writer.close();
    }
}
