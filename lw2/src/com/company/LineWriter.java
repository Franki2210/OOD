package com.company;

import java.io.FileWriter;
import java.io.IOException;

class LineWriter {
    private FileWriter fileWriter;

    LineWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    void writeLine(String line) throws IOException {
        fileWriter.write(line + "\r\n");
        fileWriter.flush();
    }
}
