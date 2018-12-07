package pl.coderstrust.isThatFibonacci;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciCheckerTest {

    @ParameterizedTest
    @MethodSource("paramsForFibonacciNumber")
    void shouldReturnTrueForFibonacciNumber(long number) {

        //Given
        FibonacciChecker fibonacciChecker = new FibonacciChecker();

        //When
        boolean actual = fibonacciChecker.isFibonacciNumber(number);

        //Then
        assertTrue(actual);
    }

    private static Stream<Arguments> paramsForFibonacciNumber() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(1),
                Arguments.of(2),
                Arguments.of(3),
                Arguments.of(5),
                Arguments.of(13),
                Arguments.of(21),
                Arguments.of(34),
                Arguments.of(10946)
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForNonFibonacciNumber")
    void shouldReturnFalseForNonFibonacciNumber(long number) {

        //Given
        FibonacciChecker fibonacciChecker = new FibonacciChecker();

        //When
        boolean actual = fibonacciChecker.isFibonacciNumber(number);

        //Then
        assertFalse(actual);
    }

    private static Stream<Arguments> paramsForNonFibonacciNumber() {
        return Stream.of(
                Arguments.of(4),
                Arguments.of(6),
                Arguments.of(10),
                Arguments.of(15),
                Arguments.of(4180),
                Arguments.of(9180),
                Arguments.of(10947)
        );
    }

    @Test
    void shouldThrowExceptionForNegativeNumber() {
        long number = -1;
        FibonacciChecker fibCheck = new FibonacciChecker();
        assertThrows(IllegalArgumentException.class, () -> fibCheck.isFibonacciNumber(number));
    }
}
