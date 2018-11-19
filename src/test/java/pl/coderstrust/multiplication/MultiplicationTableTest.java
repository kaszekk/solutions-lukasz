package pl.coderstrust.multiplication;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pl.coderstrust.multiplication.MultiplicationTable.getFormattedStringOutput;
import static pl.coderstrust.multiplication.MultiplicationTable.getMultiplicationTableValues;

@DisplayName("MultiplicationTable test ")
class MultiplicationTest {

    @DisplayName("Should calculate the correct multiplicationTable")
    @ParameterizedTest(name = "{index} => a={0},   b={1},   c=a*b={2}")
    @MethodSource("provideExpectedMultiplicationValuesForGivenNumbers")
    void shouldReturnCorrectMultiplicationResult(int a, int b, int expected) {

        //Given
        int size = 12;

        //When
        int[][] input = getMultiplicationTableValues(size);

        //Then
        assertThat(input[a][b], is(expected));
    }

    private static Stream<Arguments> provideExpectedMultiplicationValuesForGivenNumbers() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(4, 0, 0),
                Arguments.of(1, 1, 1),
                Arguments.of(2, 1, 2),
                Arguments.of(3, 2, 6),
                Arguments.of(3, 4, 12),
                Arguments.of(4, 4, 16),
                Arguments.of(4, 3, 12),
                Arguments.of(2, 2, 4),
                Arguments.of(3, 3, 9)
        );
    }

    @DisplayName("Should return correctly formatted MultiplicationTable for given size")
    @ParameterizedTest(name = "{index} => size={0},   output={1}")
    @MethodSource("provideExpectedMultiplicationTableFormattedOutputForGivenSize")
    void shouldReturnCorrectlyFormattedMultiplicationTableForGivenSize(int size, String[] expected) {

        //When
        String[] input = getFormattedStringOutput(getMultiplicationTableValues(size));

        //Then
        assertThat(input, is(expected));
    }

    private static Stream<Object> provideExpectedMultiplicationTableFormattedOutputForGivenSize() {
        return Stream.of(
                Arguments.of(0,
                        new String[]{"    "}),
                Arguments.of(2,
                        new String[]{
                                "       1   2",
                                "   1   1   2",
                                "   2   2   4"}),
                Arguments.of(4,
                        new String[]{
                                "       1   2   3   4",
                                "   1   1   2   3   4",
                                "   2   2   4   6   8",
                                "   3   3   6   9  12",
                                "   4   4   8  12  16"}));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForNegativeSize() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    int size = -1;
                    getMultiplicationTableValues(size);
                });
    }
}
