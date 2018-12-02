package pl.coderstrust.multiplication;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static pl.coderstrust.multiplication.MultiplicationTable.getFormattedOutput;
import static pl.coderstrust.multiplication.MultiplicationTable.getMultiplicationTableValues;

@DisplayName("MultiplicationTable test ")
class MultiplicationTest {
    @DisplayName("Should return multiplication result as int [][] of correct dimensions ")
    @ParameterizedTest(name = "{index} => a={0},   b={1},   expected_a={2},     expected_b={2} ")
    @MethodSource("paramsForTestMultiplicationTableDimensions")
    void testMultiplicationTableDimensions(int a, int b, int expected_a, int expected_b) {

        //Given
        int size = 4;
        int[][] returned = getMultiplicationTableValues(size);
        int resultDimension_a = returned.length - 1;
        int resultDimension_b = returned[b].length - 1;

        //When
        boolean is_a_sizeCorrect = resultDimension_a == expected_a;
        boolean is_b_sizeCorrect = resultDimension_b == expected_b;
        boolean isTableSquare = resultDimension_a == resultDimension_b;

        //Then
        assertTrue(is_a_sizeCorrect);
        assertTrue(is_b_sizeCorrect);
        assertTrue(isTableSquare);
    }

    private static Stream<Arguments> paramsForTestMultiplicationTableDimensions() {
        return
             Stream.of
              (
               Arguments.of(0, 4, 4, 4),
               Arguments.of(1, 4, 4, 4),
               Arguments.of(2, 4, 4, 4),
               Arguments.of(3, 4, 4, 4),
               Arguments.of(4, 0, 4, 4),
               Arguments.of(4, 1, 4, 4),
               Arguments.of(4, 2, 4, 4),
               Arguments.of(4, 3, 4, 4),
               Arguments.of(4, 4, 4, 4)
              );
    }

    @DisplayName("Should calculate the correct multiplicationTable values a * b = expected")
    @ParameterizedTest(name = "{index} => a={0},   b={1},   expected={2}")
    @MethodSource("paramsForMultiplicationTableValues")
    void shouldReturnCorrectMultiplicationResult(int a, int b, int expected) {

        //Given
        int size = 12;

        //When
        int[][] result = getMultiplicationTableValues(size);

        //Then
        assertEquals(expected, result[a][b]);
    }

    private static Stream<Arguments> paramsForMultiplicationTableValues() {
        return
             Stream.of
              (
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
    @ParameterizedTest(name = "{index} => size={0},   expected={1}")
    @MethodSource("paramsForMultiplicationTableFormattedOutput")
    void testFormatOfMultiplicationTable(int size, String[] expected) {

        //When
        String[] result = getFormattedOutput(getMultiplicationTableValues(size));

        //Then
        assertEquals(expected, result);
    }

    private static Stream<Object> paramsForMultiplicationTableFormattedOutput() {
        return
             Stream.of
              (
               Arguments.of(0,
                  new String[]
                       {"    "}),
               Arguments.of(2,
                  new String[]
                       {"       1   2",
                        "   1   1   2",
                        "   2   2   4"}),
               Arguments.of(4,
                  new String[]
                       {"       1   2   3   4",
                        "   1   1   2   3   4",
                        "   2   2   4   6   8",
                        "   3   3   6   9  12",
                        "   4   4   8  12  16"})
              );
    }

    @Test
    void throwExceptionForNegativeSize() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    int size = -1;
                    getMultiplicationTableValues(size);
                });
    }
}
