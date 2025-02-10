package org.automation.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PropertiesLoader {
    public static void loadFile()throws IOException {

        BufferedReader b = new BufferedReader(new FileReader("data.txt"));


        FileReader file = new FileReader("data.txt");

        file.close();
    }
}
