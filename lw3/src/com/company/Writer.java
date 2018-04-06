package com.company;

import java.io.FileWriter;
import java.io.IOException;

class Writer {
    private FileWriter fileWriter;

    Writer(String fileName) {
        try {
            this.fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeLine(String line) {
        try {
            fileWriter.write(line + '\n');
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
