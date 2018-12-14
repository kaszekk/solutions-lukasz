package pl.coderstrust.numbersfromfile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FileProcessor {

    List<String> readLinesFromFile(String fileName) throws IOException {
        List<String> linesFromFile = new ArrayList<>();
        Reader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.isEmpty()) {
                linesFromFile.add(line);
            }
        }
        bufferedReader.close();
        fileReader.close();
        return linesFromFile;
    }

    void writeLinesToFile(String fileName, List<String> linesToWrite) throws IOException {
        Writer fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (String line : linesToWrite) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        fileWriter.close();
    }
}
