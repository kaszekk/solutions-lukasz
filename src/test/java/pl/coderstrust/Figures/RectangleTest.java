package pl.coderstrust.Figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {

    @ParameterizedTest(name = "{index} => height={0}, width = {1}, expected = {2}")
    @DisplayName("Should return calculated area of rectangle figure.")
    @MethodSource("shouldCalculateCorrectAreaParams")
    void shouldCalculateCorrectArea(double width, double height, double expected) {
        //Given
        double delta = 1e-15;
        Rectangle rectangle = new Rectangle(height, width);

        //When
        double actual = rectangle.calculateArea();

        //Then
        assertEquals(expected, actual, delta);
    }

    private static Stream<Object> shouldCalculateCorrectAreaParams() {
        return
                Stream.of(Arguments.of(1, 1, 1),
                        (Arguments.of(2.0, 4.0, 8.0)),
                        (Arguments.of(0.01, 0.05, 0.0005)),
                        (Arguments.of(2.6666666666666, 6.3333333333333, 16.88888888888837777777777778)));
    }

    @ParameterizedTest(name = "{index} => height={0}, width = {1}")
    @DisplayName("Should throw exception if given width <=0 or height <=0")
    @MethodSource("paramsForExceptionTest")
    void shouldThrowExceptionForIllegalCombinationOfParameters(double height, double width) {
        assertThrows(IllegalArgumentException.class,() -> {Rectangle rectangle = new Rectangle(height, width);});
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
