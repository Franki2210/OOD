package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Reader {
    private BufferedReader reader;

    Reader(String fileName)  {
        try {
            FileReader fileReader = new FileReader(fileName);
            reader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    String getNextLine() {
        String line = null;

        try {
            line = reader.readLine();
        } catch (IOException e) {
            line = null;
        }

        return line;
    }

    void close() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
