package pl.coderstrust.Figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CircleTest {

    @ParameterizedTest(name = "{index} => radius={0}, expected = {1}")
    @DisplayName("Should return calculated area of circle figure.")
    @MethodSource("shouldCalculateCorrectAreaParams")
    void shouldCalculateCorrectArea(double radius, double expected) {
        //Given
        double delta = 1e-15;
        Circle circle = new Circle(radius);

        //When
        double actual = circle.calculateArea();

        //Then
        assertEquals(expected, actual, delta);
    }

    private static Stream<Object> shouldCalculateCorrectAreaParams() {
        return
                Stream.of(Arguments.of(1, 3.141592653589793),
                        (Arguments.of(2.0, 12.566370614359172)),
                        (Arguments.of(2.5, 19.634954084936208)));
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
