package pl.coderstrust.numbersfromfile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FileProcessor {

    List<String> readLinesFromFile(String fileName) throws IOException {
        validateFileNameArgument(fileName);
        List<String> linesFromFile = new ArrayList<>();
        Reader fileReader = new FileReader(fileName);
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    linesFromFile.add(line);
                }
            }
            return linesFromFile;
        }
    }

    void writeLinesToFile(String fileName, List<String> linesToWrite) throws IOException {
        validateFileNameArgument(fileName);
        if (linesToWrite == null) {
            throw new IllegalArgumentException("LinesToWrite argument cannot be null");
        }
        Writer fileWriter = new FileWriter(fileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (String line : linesToWrite) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        }
    }

    private void validateFileNameArgument(String file) {
        if (file == null) {
            throw new IllegalArgumentException("File reference argument cannot be null");
        }
    }
}
