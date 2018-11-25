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
    void shouldReturnTrueForFibonacciNumber(long n, boolean isFibonacci) {
        FibonacciChecker fibCheck = new FibonacciChecker();

        //When
        boolean actual = fibCheck.isFibonacciNumber(n);

        //Then
        assertTrue(actual);
    }

    private static Stream<Arguments> paramsForFibonacciNumber() {
        return Stream.of(
                Arguments.of(0, true),
                Arguments.of(1, true),
                Arguments.of(2, true),
                Arguments.of(3, true),
                Arguments.of(5, true),
                Arguments.of(13, true),
                Arguments.of(21, true),
                Arguments.of(34, true),
                Arguments.of(10946, true)
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForNonFibonacciNumber")
    void shouldReturnFalseForNonFibonacciNumber(long n, boolean isFibonacci) {
        FibonacciChecker fibCheck = new FibonacciChecker();

        //When
        boolean actual = fibCheck.isFibonacciNumber(n);

        //Then
        assertFalse(actual);
    }

    private static Stream<Arguments> paramsForNonFibonacciNumber() {
        return Stream.of(
                Arguments.of(4, false),
                Arguments.of(6, false),
                Arguments.of(10, false),
                Arguments.of(15, false),
                Arguments.of(4180, false),
                Arguments.of(9180, false),
                Arguments.of(10947, false)
        );
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForNegativeArgument() {
        long n = -1;
        FibonacciChecker fibCheck = new FibonacciChecker();
        assertThrows(IllegalArgumentException.class, () -> fibCheck.isFibonacciNumber(n));
    }
}
