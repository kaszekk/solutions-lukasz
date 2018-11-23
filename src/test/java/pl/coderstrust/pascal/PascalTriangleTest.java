package pl.coderstrust.pascal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pl.coderstrust.pascal.PascalTriangle.getCalculatedValues;
import static pl.coderstrust.pascal.PascalTriangle.getFormattedOutput;

@DisplayName("PascalTriangle test ")
class PascalTriangleTest {

    @DisplayName("Should calculate the correct values for given [row] [column] of Pascal Triangle")
    @ParameterizedTest(name = "{index} => row={0}, col={1}, expected={2}")
    @MethodSource("parametersForPascalTriangleValues")
    void shouldReturnCorrectPascalTriangleValueForGivenRowAndColumn(int row, int col, int expected) {

        //Given
        int numberOfRows = row + 1;

        //When
        int[][] input = getCalculatedValues(numberOfRows);

        //Then
        assertThat(input[row][col], is(expected));
    }

    private static Stream<Arguments> parametersForPascalTriangleValues() {
        return Stream.of(
                Arguments.of(0, 0, 1),
                Arguments.of(4, 0, 1),
                Arguments.of(1, 1, 1),
                Arguments.of(2, 1, 2),
                Arguments.of(3, 2, 3),
                Arguments.of(11, 5, 462),
                Arguments.of(4, 4, 1),
                Arguments.of(6, 6, 1),
                Arguments.of(9, 4, 126)
        );
    }

    @DisplayName("Should return correctly formatted PascalTriangle for given numberOfRows")
    @ParameterizedTest(name = "{index} => numberOfRows={0}, expected={1}")
    @MethodSource("parametersForPascalTriangleFormattedOutput")
    void shouldReturnCorrectlyPascalTriangleForGivenSize(int numberOfRows, String[] expected) {

        //When

        String[] input = getFormattedOutput(getCalculatedValues(numberOfRows));

        //Then

        assertThat(input, is(expected));
    }

    private static Stream<Object> parametersForPascalTriangleFormattedOutput() {
        return Stream.of(
                Arguments.of(1,
                        new String[]{"     1"}),
                Arguments.of(2,
                        new String[]{
                                "       1",
                                "     1   1"}),
                Arguments.of(4,
                        new String[]{
                                "           1",
                                "         1   1",
                                "       1   2   1",
                                "     1   3   3   1",
                        }));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForNegativeSize() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    int numberOfRows = -1;
                    getCalculatedValues(numberOfRows);
                });
    }
}
