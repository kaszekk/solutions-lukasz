package pl.coderstrust.numbersfromfile;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumbersProcessorTest {

    @ParameterizedTest(name = "{index} => inputLine={0}, expected={1}")
    @MethodSource("shouldCorrectlyProcessLineParams")
    void shouldCorrectlyProcessLine(String inputLine, String expected) {
        //Given
        NumbersProcessor numbersProcessor = new NumbersProcessor();

        //When
        String actual = numbersProcessor.processLine(inputLine);

        //Then
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> shouldCorrectlyProcessLineParams() {
        return Stream.of(
                // TODO: 12/12/2018 what if null passed as parameter???

                Arguments.of("3d", ""),
                Arguments.of("`", ""),
                Arguments.of("$", ""),
                Arguments.of("#", ""),
                Arguments.of("4@", ""),
                Arguments.of("43*", ""),
                Arguments.of("3%", ""),
                Arguments.of("2,", ""),
                Arguments.of("9.", ""),
                Arguments.of(" 4 <", ""),
                Arguments.of("", ""),
                Arguments.of("3 4 5 f 44", ""),
                Arguments.of("3", "3=3"),
                Arguments.of("3 5 6 7", "3+5+6+7=21"),
                Arguments.of("2            0   ", "2+0=2"),
                Arguments.of("00 0 000  ", "0+0+0=0"),
                Arguments.of("                 ", ""),
                Arguments.of("3 5 6.4 6", "")
        );
    }
}
