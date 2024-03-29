package pl.coderstrust.numbersfromfile;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumbersProcessorTest {

    @ParameterizedTest(name = "{index} => inputLine={0}, expected={1}")
    @MethodSource("shouldReturnCorrectResultForLinesThatPassRegExTestParams")
    void shouldReturnCorrectResultForLinesThatPassRegExTest(String inputLine, String expected) {
        //Given
        NumbersProcessor numbersProcessor = new NumbersProcessor();

        //When
        String actual = numbersProcessor.processLine(inputLine);

        //Then
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> shouldReturnCorrectResultForLinesThatPassRegExTestParams() {
        return Stream.of(
                Arguments.of("3", "3=3"),
                Arguments.of("3 5 6 7", "3+5+6+7=21"),
                Arguments.of("3 5 6 346 65 23 0 35 0 125478 345456 34 7", "3+5+6+346+65+23+0+35+0+125478+345456+34+7=471458"),
                Arguments.of("2      3      0   ", "2+3+0=5"),
                Arguments.of("00 0 000  ", "0+0+0=0")
        );
    }

    @ParameterizedTest
    @MethodSource("shouldReturnEmptyStringForLinesThatFailRegExTestParams")
    void shouldReturnEmptyStringForLinesThatFailRegExTest(String inputLine) {
        //Given
        NumbersProcessor numbersProcessor = new NumbersProcessor();

        //When
        String actual = numbersProcessor.processLine(inputLine);

        //Then
        assertEquals("", actual);
    }

    private static Stream<Arguments> shouldReturnEmptyStringForLinesThatFailRegExTestParams() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("3d"),
                Arguments.of("`"),
                Arguments.of("$"),
                Arguments.of("#"),
                Arguments.of("4@"),
                Arguments.of("43*"),
                Arguments.of("3%"),
                Arguments.of("2,"),
                Arguments.of("9."),
                Arguments.of(" 4 <"),
                Arguments.of("3 5 6.4 6"),
                Arguments.of("3 4 5 f 44"),
                Arguments.of("-1 -1 "),
                Arguments.of("                 ")
        );
    }

    @Test
    void shouldThrowExceptionForInvalidArgument() {
        NumbersProcessor numbersProcessor = new NumbersProcessor();
        assertThrows(IllegalArgumentException.class, () -> numbersProcessor.processLine(null));
    }
}
