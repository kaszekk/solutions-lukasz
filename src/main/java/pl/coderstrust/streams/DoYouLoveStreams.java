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
                .filter(inputLine -> inputLine.matches(REGEX))
                .map(validatedLine -> validatedLine.split("\\s+"))
                .forEach(StringArrayOfNumbers -> {
                    String processedLine = Arrays.stream(StringArrayOfNumbers)
                            .reduce("", (stringNumber1, stringNumber2) -> stringNumber1 + "+" + stringNumber2)
                            .substring(1);
                    long sumOfNumbersInLine = Arrays.stream(StringArrayOfNumbers)
                            .map(Integer::valueOf)
                            .reduce(0, (number1, number2) -> number1 + number2);
                    lines.add(String.format("%s=%d", processedLine, sumOfNumbersInLine));

                });
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
