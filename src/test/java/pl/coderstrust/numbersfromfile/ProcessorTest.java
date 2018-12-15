package pl.coderstrust.numbersfromfile;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Arrays;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProcessorTest {
    @Mock
    public FileProcessor fileProcessor;

    @Mock
    public NumbersProcessor numbersProcessor;

    @InjectMocks
    public Processor processor;
    @Test
    void shouldProcessProvidedInputFileAndSaveResultToProvidedOutputFile() throws IOException {
        // Given
        when(fileProcessor.readLinesFromFile("src/main/resources/Input.txt")).thenReturn(Arrays.asList("1 2 3", "4 5 6"));
        lenient().when(numbersProcessor.processLine("1 2 3")).thenReturn("1+2+3=6");
        when(numbersProcessor.processLine("4 5 6")).thenReturn("4+5+6=15");

        // When
        processor.process("src/main/resources/Input.txt", "src/main/resources/Output.txt");

        // Then
        verify(fileProcessor).readLinesFromFile("src/main/resources/Input.txt");
        verify(numbersProcessor).processLine("1 2 3");
        verify(numbersProcessor).processLine("4 5 6");

        verify(fileProcessor).writeLinesToFile("src/main/resources/Output.txt", Arrays.asList("1+2+3=6", "4+5+6=15"));

    }
}
