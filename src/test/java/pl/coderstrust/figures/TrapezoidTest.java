package pl.coderstrust.figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TrapezoidTest {
    @Test
    @DisplayName("Should return calculated area of trapezoid, based on setters parameters.")
    void shouldCalculateAreaBasedOnSetters() {
        //Given
        double delta = 1e-15;
        Trapezoid trapezoid = new Trapezoid(3, 4, 5);

        //When
        trapezoid.setLowerBase(1);
        trapezoid.setUpperBase(3);
        trapezoid.setHeight(4);
        double actual = trapezoid.calculateArea();

        //Then
        assertEquals(8, actual, delta);
    }

    @Test
    @DisplayName("Should return calculated area of trapezoid based on constructor parameters.")
    void shouldCalculateAreaBasedOnConstructor() {
        //Given
        double delta = 1e-15;
        Trapezoid trapezoid = new Trapezoid(1, 3, 4);

        //When
        double actual = trapezoid.calculateArea();

        //Then
        assertEquals(8, actual, delta);
    }

    @ParameterizedTest(name = "{index} => lowerBase={0}, upperBase = {1}, height = {2}")
    @DisplayName("Should throw exception if given lowerBase <=0 or upperBase <=0 or height passed to constructor <=0")
    @MethodSource("invalidParameters")
    void shouldThrowExceptionForInvalidParametersPassedToConstructor(double lowerBase, double upperBase, double height) {
        assertThrows(IllegalArgumentException.class, () -> new Trapezoid(lowerBase, upperBase, height));
    }

    @ParameterizedTest(name = "{index} => lowerBase={0}, upperBase = {1}, height = {2}")
    @DisplayName("Should throw exception if given lowerBase <=0 or upperBase <=0 or height passed to setter <=0")
    @MethodSource("invalidParameters")
    void shouldThrowExceptionForInvalidParametersPassedToSetter(double lowerBase, double upperBase, double height) {
        Trapezoid trapezoid = new Trapezoid(5, 3, 2);
        assertThrows(IllegalArgumentException.class, () -> {
            trapezoid.setLowerBase(lowerBase);
            trapezoid.setUpperBase(upperBase);
            trapezoid.setHeight(height);
        });
    }

    private static Stream<Object> invalidParameters() {
        return Stream.of(Arguments.of(0, 0, 0),
                (Arguments.of(-5.03, 0, 2)),
                (Arguments.of(2.5, 0, 4)),
                (Arguments.of(3, -0.2, 4)),
                (Arguments.of(4, 4, 0)),
                (Arguments.of(2.5, 1.5, -4)),
                (Arguments.of(1.34, -4.45, 4)),
                (Arguments.of(-4.45, -7, 4)));
    }
}
