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
    @MethodSource("getFiboParameters")
    void testWithSimpleMethodSource(long n, boolean isFibonacci) {
        //Given
        boolean input = fibonacciChecker(n);

        boolean expected = isFibonacci;
        //Then
        assertThat(input, is(expected));
    }

    private static Stream<Arguments> getFiboParameters() {
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
    public void whenExceptionThrown_thenAssertionSucceeds() {
        long n = -1;
        String expected = "Argument cannot be negative";
        String actual;
        assertThrows(IllegalArgumentException.class, () -> {
            fibonacciChecker(n);
            IllegalArgumentException ex;
            assertThat(ex.getLocalizedMessage());
            ///;
        });
    }
}