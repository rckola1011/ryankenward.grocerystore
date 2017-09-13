package com.ryankenward.grocerystore.models.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author rckola1011
 */
public class InputReader {
    
    public ArrayList<String[]> readCsv(String filePath) {
        ArrayList<String[]> fileOutput = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] commaSeparatedData;
            while ((line = bufferedReader.readLine()) != null) {
                commaSeparatedData = line.split(",");
                fileOutput.add(commaSeparatedData);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading CSV input (File not found)");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error reading CSV input");
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                System.err.println("Error disposing of reader objects");
                e.printStackTrace();
            }
        }
        return fileOutput;
    }
}
