package pl.coderstrust.isThatFibonacci;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pl.coderstrust.isThatFibonacci.FibonacciChecker.fibonacciChecker;

class FibonacciCheckerTest {

    @ParameterizedTest
    @MethodSource("paramsForFibonacciChecker")
    void shouldReturnTrueIfGivenNumberIsFibonacci(long n, boolean isFibonacci) {

        //Given
        boolean expected = isFibonacci;

        //When
        boolean input = fibonacciChecker(n);

        //Then
        assertThat(input, is(expected));
    }

    private static Stream<Arguments> paramsForFibonacciChecker() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(2, true),
                Arguments.of(4, false),
                Arguments.of(5, true),
                Arguments.of(10, false),
                Arguments.of(13, true),
                Arguments.of(15, false)
        );
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForNegativeArgument() {
        long n = -1;
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            fibonacciChecker(n);
        });
    }
}
