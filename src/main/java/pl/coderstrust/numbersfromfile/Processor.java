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
            throw new NullPointerException("numberProcessor instance passed to Processor cannot be null");
        }
        if (fileProcessor == null) {
            throw new NullPointerException(("fileProcessor instance passed to Processor cannot be null"));
        }
        this.numbersProcessor = numbersProcessor;
        this.fileProcessor = fileProcessor;
    }

    void process(String inputFileName, String resultFileName) throws IOException {
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
