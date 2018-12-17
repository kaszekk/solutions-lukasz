package pl.coderstrust.figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {

    @Test
    @DisplayName("Should return calculated area of triangle based on constructor.")
    void shouldCalculateAreaBasedOnConstructor() {
        //Given
        double delta = 1e-15;
        Triangle triangle = new Triangle(6, 5);

        //When
        double actual = triangle.calculateArea();

        //Then
        assertEquals(15, actual, delta);
    }

    @Test
    @DisplayName("Should return calculated area of triangle based on setters.")
    void shouldCalculateAreaBasedOnSetters() {
        //Given
        double delta = 1e-15;
        Triangle triangle = new Triangle(2, 4);

        //When
        triangle.setBaseLength(6);
        triangle.setHeight(5);
        double actual = triangle.calculateArea();

        //Then
        assertEquals(15, actual, delta);
    }

    @ParameterizedTest(name = "{index} => height={0}, width = {1}")
    @DisplayName("Should throw exception if given baseLength <=0 or height passed to constructor <=0")
    @MethodSource("invalidParameters")
    void shouldThrowExceptionForInvalidParametersPassedToConstructor(double baseLength, double height) {
        assertThrows(IllegalArgumentException.class, () -> {
            Triangle triangle = new Triangle(baseLength, height);
        });
    }

    @ParameterizedTest(name = "{index} => height={0}, width = {1}")
    @DisplayName("Should throw exception if given baseLength <=0 or height passed to setter <=0")
    @MethodSource("invalidParameters")
    void shouldThrowExceptionForInvalidParametersPassedToSetter(double baseLength, double height) {
        assertThrows(IllegalArgumentException.class, () -> {
            Triangle triangle = new Triangle(2, 3);
            triangle.setBaseLength(baseLength);
            triangle.setHeight(height);
        });
    }

    private static Stream<Object> invalidParameters() {
        return Stream.of(Arguments.of(0, 0),
                (Arguments.of(-5.03, 0)),
                (Arguments.of(0, -7)),
                (Arguments.of(0, 0.2)),
                (Arguments.of(4, 0)),
                (Arguments.of(-4, 1.5)),
                (Arguments.of(1.34, -4.45)),
                (Arguments.of(-4.45, -7)));
    }
}
