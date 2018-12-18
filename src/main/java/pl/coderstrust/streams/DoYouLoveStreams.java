package pl.coderstrust.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoYouLoveStreams {

    public static void main(String[] args) throws IOException {
        String REGEX = "([0-9]*\\)*\\(*\\s*)+";
        List<String> lines = new ArrayList<>();
        Files.lines(Paths.get("src\\main\\resources\\Input.txt"))
                .filter(v -> v.matches(REGEX))
                .map(line -> line.split("\\s+"))
                .forEach(arrayOfNumbers -> {
                    String processedLine = Arrays.stream(arrayOfNumbers)
                            .reduce("", (number1, number2) -> number1 + "+" + number2);
                    processedLine = processedLine.substring(1);
                    long sumOfLineNumbers = Arrays.stream(arrayOfNumbers)
                            .map(Integer::valueOf)
                            .reduce(0, (number1, number2) -> number1 + number2);
                    lines.add(String.format("%s=%d", processedLine, sumOfLineNumbers));

                });
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
