package pl.coderstrust.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class NumbersFromFileUsingStreams {
    public static void main(String[] args) throws IOException {
        String inputFilePath = "src/main/resources/Input.txt";
        String outputFilePath = "src/main/resources/OutputFromStream.txt";
        NumbersFromFileUsingStreams numbersFromFileUsingStreams = new NumbersFromFileUsingStreams();
        numbersFromFileUsingStreams.process(inputFilePath, outputFilePath);
    }

    public void process(String inputFile, String outputFile) throws IOException {
        if (inputFile == null) {
            throw new IllegalArgumentException("Input file reference cannot be null");
        }
        if (outputFile == null) {
            throw new IllegalArgumentException("Output file reference cannot be null");
        }
        String validLine = "([0-9]*\\)*\\(*\\s*)+";
        List<String> lines = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(inputFile))) {
            stream.filter(inputLine -> inputLine.matches(validLine))
                    .map(validatedLine -> validatedLine.split("\\s+"))
                    .forEach((String[] stringArrayOfNumbers) -> {
                        String processedLine = Arrays.stream(stringArrayOfNumbers)
                                .reduce("", (stringNumber1, stringNumber2) -> String.format("%s+%s", stringNumber1, stringNumber2))
                                .substring(1);
                        long sumOfNumbersInLine = Arrays.stream(stringArrayOfNumbers)
                                .map(Integer::valueOf)
                                .reduce(0, (number1, number2) -> number1 + number2);
                        lines.add(String.format("%s=%d", processedLine, sumOfNumbersInLine));
                    });
        }
        Files.write(Paths.get(outputFile), lines);
    }
}
