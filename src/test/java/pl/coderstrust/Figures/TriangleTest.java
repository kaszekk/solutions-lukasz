package pl.coderstrust.Figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {

    @ParameterizedTest(name = "{index} => baseLength={0}, height = {1}, expected = {2}")
    @DisplayName("Should return calculated area of triangle figure.")
    @MethodSource("paramsForTriangleArea")
    void calculateArea(double baseLength, double height, double expected) {

        //Given

        final double delta = 1e-15;
        Triangle triangle = new Triangle(baseLength, height);

        //When

        double actual = triangle.calculateArea();

        //Then

        assertEquals(expected, actual, delta);
    }

    private static Stream<Object> paramsForTriangleArea() {
        return
                Stream.of(Arguments.of(1, 1, 0.5),
                        (Arguments.of(2.0, 4.0, 4.0)),
                        (Arguments.of(2.02, 14.58, 14.7258)),
                        (Arguments.of(2.6666666666666, 6.3333333333333, 8.44444444444418888888888889)));
    }

    @ParameterizedTest(name = "{index} => height={0}, width = {1}")
    @DisplayName("Should throw exception if given baseLength <=0 or height <=0")
    @MethodSource("paramsForExceptionTest")
    void shouldThrowIllegalArgumentExceptionForIllegalCombinationOfParameters(double baseLength, double height) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    Triangle triangle = new Triangle(baseLength, height);
                });
    }

    private static Stream<Object> paramsForExceptionTest() {
        return
                Stream.of(Arguments.of(0, 0),
                        (Arguments.of(-5.03, 0)),
                        (Arguments.of(0, -7)),
                        (Arguments.of(0, 0.2)),
                        (Arguments.of(4, 0)),
                        (Arguments.of(-4, 1.5)),
                        (Arguments.of(1.34, -4.45)),
                        (Arguments.of(-4.45, -7)));
    }
}
