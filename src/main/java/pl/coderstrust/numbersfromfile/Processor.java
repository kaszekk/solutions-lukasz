package pl.coderstrust.numbersfromfile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Processor {

    private NumbersProcessor numbersProcessor;
    private FileProcessor fileProcessor;

    public static void main(String[] args) throws IOException {

        String inputFilePath = "src/main/resources/Input.txt";
        String outputFilePath = "src/main/resources/Output.txt";
        FileProcessor fileProcessor = new FileProcessor();
        NumbersProcessor numbersProcessor = new NumbersProcessor();
        Processor processor = new Processor(numbersProcessor, fileProcessor);
        processor.process(inputFilePath, outputFilePath);
    }

    Processor(NumbersProcessor numbersProcessor, FileProcessor fileProcessor) {
        if (numbersProcessor == null) {
            throw new IllegalArgumentException("numberProcessor instance passed to Processor constructor cannot be null");
        }
        if (fileProcessor == null) {
            throw new IllegalArgumentException("fileProcessor instance passed to Processor constructor cannot be null");
        }
        this.numbersProcessor = numbersProcessor;
        this.fileProcessor = fileProcessor;
    }

    void process(String inputFileName, String resultFileName) throws IOException {
        if (inputFileName == null) {
            throw new IllegalArgumentException("inputFileName argument cannot be null");
        }
        if (resultFileName == null) {
            throw new IllegalArgumentException("resultFileName argument cannot be null");
        }
        List<String> linesFromFile = fileProcessor.readLinesFromFile(inputFileName);
        List<String> resultLines = new ArrayList<>();
        for (String line : linesFromFile) {
            String processedLine = numbersProcessor.processLine(line);
            if (!"".equals(processedLine)) {
                resultLines.add(processedLine);
            }
        }
        fileProcessor.writeLinesToFile(resultFileName, resultLines);
    }
}
