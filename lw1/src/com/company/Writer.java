package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    FileWriter fileWriter;

    public Writer(String fileName) {
        try {
            this.fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLine(String line) {
        try {
            fileWriter.write(line + '\n');
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
