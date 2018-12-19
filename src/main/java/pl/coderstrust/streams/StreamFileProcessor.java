package pl.coderstrust.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamFileProcessor {
    public static void main(String[] args) throws IOException {
        String inputFilePath = "src/main/resources/Input.txt";
        String outputFilePath = "src/main/resources/OutputFromStream.txt";
        StreamFileProcessor streamFileProcessor = new StreamFileProcessor();
        streamFileProcessor.process(inputFilePath, outputFilePath);
    }

    public void process(String inputFile, String outputFile) throws IOException {
        if (inputFile == null) {
            throw new IllegalArgumentException("Input file cannot be null");
        }
        if (outputFile == null) {
            throw new IllegalArgumentException("Output file cannot be null");
        }
        List<String> lines = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(inputFile))) {
            stream.filter(line -> line.matches("^[\\d\\s]+"))
                    .map(line -> line.trim().split("\\s+"))
                    .forEach(arrayOfNumbers -> {
                        String numbers = Arrays.stream(arrayOfNumbers)
                                .reduce("", (num1, num2) ->
                                        String.format("%s+%s", num1, num2))
                                .substring(1);
                        long sumOfNumbers = Arrays.stream(arrayOfNumbers)
                                .mapToLong(Long::parseLong)
                                .sum();
                        lines.add(String.format("%s=%d", numbers, sumOfNumbers));
                    });
        }
        Files.write(Paths.get(outputFile), lines);
    }
}
