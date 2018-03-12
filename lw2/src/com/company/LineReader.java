package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LineReader {
    private BufferedReader reader;

    public LineReader(String fileName) throws FileNotFoundException {
        this.reader = new BufferedReader(new java.io.FileReader(fileName));
    }

    public String getNextLine() {
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            return null;
        }
        return line;
    }
}
