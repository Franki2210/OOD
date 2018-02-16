package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Reader reader = new Reader("input.txt");
        Writer writer = new Writer("output.txt");
        ArrayList<String> lines = reader.getLines();

        for (String line :
                lines) {
            Shape shape = GetterShapeFromLine.get(line);

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
