package pl.coderstrust.figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CircleTest {
    @Test
    @DisplayName("Should return calculated area of circle figure.")
    void shouldCalculateCorrectArea() {
        //Given
        double delta = 1e-15;
        Circle circle = new Circle(1);

        //When
        circle.setRadius(2);
        double actual = circle.calculateArea();

        //Then
        assertEquals(12.566370614359172, actual, delta);
    }

    @ParameterizedTest(name = "{index} => a={0}")
    @DisplayName("Should throw exception if given radius <=0")
    @MethodSource("paramsForExceptionTest")
    void shouldThrowExceptionForInvalidRadius(double radius) {
        assertThrows(IllegalArgumentException.class, () -> {
            Circle circle = new Circle(radius);
        });
    }

    private static Stream<Object> paramsForExceptionTest() {
        return
                Stream.of(Arguments.of(0),
                        (Arguments.of(-0.01)));
    }
}
