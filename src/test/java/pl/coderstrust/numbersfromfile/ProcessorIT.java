package pl.coderstrust.numbersfromfile;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.readAllLines;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProcessorIT {
    @Test
    void shouldTest() throws IOException {
        //Given
        String inputFile = "src\\test\\resources\\inputIT.txt";
        String resultFile = "src\\test\\resources\\resultIT.txt";
        String expectedFile = "src\\test\\resources\\expectedIT.txt";
        List<String> expected = new ArrayList<>(readAllLines(Paths.get(expectedFile)));
        FileProcessor fileProcessor = new FileProcessor();
        NumbersProcessor numbersProcessor = new NumbersProcessor();
        Processor processor = new Processor(numbersProcessor, fileProcessor);

        //When
        processor.process(inputFile, resultFile);
        List<String> result = new ArrayList<>(readAllLines(Paths.get(resultFile)));

        //Then
        assertEquals(expected, result);
    }
}
