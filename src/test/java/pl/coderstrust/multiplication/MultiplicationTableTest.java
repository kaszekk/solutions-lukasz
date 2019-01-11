package pl.coderstrust.multiplication;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pl.coderstrust.multiplication.MultiplicationTable.getFormattedOutput;
import static pl.coderstrust.multiplication.MultiplicationTable.getMultiplicationTableValues;

@DisplayName("MultiplicationTable test ")
class MultiplicationTableTest {
    @DisplayName("Should calculate the correct multiplicationTable values a * b = expected")
    @Test
    void shouldReturnCorrectMultiplicationResult() {
        //Given
        int size = 4;
        int[][] expected = {
                new int[]{0, 0, 0, 0, 0},
                new int[]{0, 1, 2, 3, 4},
                new int[]{0, 2, 4, 6, 8},
                new int[]{0, 3, 6, 9, 12},
                new int[]{0, 4, 8, 12, 16}};

        //When
        int[][] result = getMultiplicationTableValues(size);

        //Then
        for (int i = 0; i <= size; i++) {
            assertArrayEquals(expected[i], result[i]);
        }
    }

    @DisplayName("Should return correctly formatted MultiplicationTable for given size")
    @ParameterizedTest(name = "{index} => size={0},   expected={1}")
    @MethodSource("paramsForTestFormatOfMultiplicationTable")
    void testFormatOfMultiplicationTable(int size, String[] expected) {
        //When
        String[] result = getFormattedOutput(getMultiplicationTableValues(size));

        //Then
        assertArrayEquals(expected, result);
    }

    private static Stream<Object> paramsForTestFormatOfMultiplicationTable() {
        return Stream.of(
                Arguments.of(0, new String[]{
                        "    "}),
                Arguments.of(2, new String[]{
                        "       1   2",
                        "   1   1   2",
                        "   2   2   4"}),
                Arguments.of(4, new String[]{
                        "       1   2   3   4",
                        "   1   1   2   3   4",
                        "   2   2   4   6   8",
                        "   3   3   6   9  12",
                        "   4   4   8  12  16"}));
    }

    @Test
    void throwExceptionForNegativeSize() {
        assertThrows(IllegalArgumentException.class, () ->
        {
            int size = -1;
            getMultiplicationTableValues(size);
        });
    }
}
