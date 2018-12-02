package pl.coderstrust.pascal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pl.coderstrust.pascal.PascalTriangle.getPascalTriangle;


@DisplayName("PascalTriangle test ")
class PascalTriangleTest {

    @DisplayName("Should return correct PascalTriangle values in List<String> for given numberOfRows")
    @ParameterizedTest(name = "{index} => numberOfRows={0}, expected={1}")
    @MethodSource("parametersForValuesTest")
    void valuesTest(int numberOfRows, List<String> expected) {

        //When

        List<String> actual = getPascalTriangle(numberOfRows);

        //Then

        assertEquals(expected, actual);
    }

    private static Stream<Object> parametersForValuesTest() {
        return Stream.of(
                Arguments.of(1,
                        new ArrayList<>(Arrays.asList
                                 ("1"))),
                Arguments.of(2,
                        new ArrayList<>(Arrays.asList
                                (("1"),
                                 ("1 1")))),
                Arguments.of(4,
                        new ArrayList<>(Arrays.asList
                                (("1"),
                                 ("1 1"),
                                 ("1 2 1"),
                                 ("1 3 3 1")))));
    }

    @DisplayName("Should throw Exception for zero or negative numberOfRows")
    @ParameterizedTest(name = "{index} => numberOfRows={0}")
    @MethodSource("parametersForExceptionTest")
    void exceptionTest(int numberOfRows) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    getPascalTriangle(numberOfRows);
                });
    }

    private static Stream<Object> parametersForExceptionTest() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(-1));
    }
}
