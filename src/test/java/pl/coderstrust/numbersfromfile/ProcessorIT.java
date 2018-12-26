package pl.coderstrust.numbersfromfile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.file.Files.readAllLines;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProcessorIT {
    @Test
    void shouldCorrectlyProcessDataFromInputFileAndSaveResultToResultFile() throws IOException {
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

    @DisplayName("Should throw exception if any of argument reference is null")
    @ParameterizedTest
    @MethodSource("shouldThrowExceptionForInvalidArgumentParams")
    void shouldThrowExceptionForInvalidArgument(String inputFile, String resultFile) {
        FileProcessor fileProcessor = new FileProcessor();
        NumbersProcessor numbersProcessor = new NumbersProcessor();
        Processor processor = new Processor(numbersProcessor, fileProcessor);
        assertThrows(IllegalArgumentException.class, () -> processor.process(inputFile, resultFile));
    }

    private static Stream<Arguments> shouldThrowExceptionForInvalidArgumentParams() {
        return Stream.of(
                Arguments.of(null, "src\\test\\resources\\resultIT.txt"),
                Arguments.of("src\\test\\resources\\inputIT.txt", null)
        );
    }

    @DisplayName("Should throw exception if any of argument reference is null")
    @ParameterizedTest
    @MethodSource("shouldThrowExceptionForInvalidArgumentPassedToConstructorParams")
    void shouldThrowExceptionForInvalidArgumentPassedToConstructor(NumbersProcessor numbersProcessor, FileProcessor fileProcessor) {
        assertThrows(IllegalArgumentException.class, () -> new Processor(numbersProcessor, fileProcessor));
    }

    private static Stream<Arguments> shouldThrowExceptionForInvalidArgumentPassedToConstructorParams() {
        return Stream.of(
                Arguments.of(null, new FileProcessor()),
                Arguments.of(new NumbersProcessor(), null)
        );
    }
}
