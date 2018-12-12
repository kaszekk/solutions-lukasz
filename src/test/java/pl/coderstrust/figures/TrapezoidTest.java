package pl.coderstrust.figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TrapezoidTest {

    @ParameterizedTest(name = "{index} => lowerBase={0}, upperBase = {1}, height = {2}, expected = {3}")
    @DisplayName("Should return calculated area of trapezoid figure.")
    @MethodSource("paramsForTrapezoidArea")
    void calculateArea(double upperBase, double lowerBase, double height, double expected) {
        //Given
        double delta = 1e-15;
        Trapezoid trapezoid = new Trapezoid(lowerBase, upperBase, height);

        //When
        double actual = trapezoid.calculateArea();

        //Then
        assertEquals(expected, actual, delta);
    }

    private static Stream<Object> paramsForTrapezoidArea() {
        return
                Stream.of(Arguments.of(1, 1, 0.5, 0.5),
                        (Arguments.of(2.0, 4.0, 4.0, 12.0)),
                        (Arguments.of(2.02, 14.58, 14.7258, 122.22414)),
                        (Arguments.of(2.6666666666666, 6.3333333333333, 8.44444444444418888888888889, 37.99999999999843)));
    }

    @ParameterizedTest(name = "{index} => lowerBase={0}, upperBase = {1}, height = {2}")
    @DisplayName("Should throw exception if given lowerBase <=0 or upperBase <=0 or height <=0")
    @MethodSource("paramsForExceptionTest")
    void shouldThrowIllegalArgumentExceptionForIllegalCombinationOfParameters(double lowerBase, double upperBase, double height) {
        assertThrows(IllegalArgumentException.class, () -> {
            Trapezoid trapezoid = new Trapezoid(lowerBase, upperBase, height);
        });
    }

    private static Stream<Object> paramsForExceptionTest() {
        return
                Stream.of(Arguments.of(0, 0, 0),
                        (Arguments.of(-5.03, 0, 2)),
                        (Arguments.of(2.5, 0, 4)),
                        (Arguments.of(3, -0.2, 4)),
                        (Arguments.of(4, 4, 0)),
                        (Arguments.of(2.5, 1.5, -4)),
                        (Arguments.of(1.34, -4.45, 4)),
                        (Arguments.of(-4.45, -7, 4)));
    }
}
