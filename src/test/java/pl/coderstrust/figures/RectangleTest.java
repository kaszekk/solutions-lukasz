package pl.coderstrust.figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {
    @Test
    @DisplayName("Should return calculated area of rectangle figure.")
    void shouldCalculateCorrectArea() {
        //Given
        double delta = 1e-15;
        Rectangle rectangle = new Rectangle(1, 2.5);

        //When
        rectangle.setHeight(3);
        rectangle.setWidth(4);
        double actual = rectangle.calculateArea();

        //Then
        assertEquals(12, actual, delta);
    }

    @ParameterizedTest(name = "{index} => height={0}, width = {1}")
    @DisplayName("Should throw exception if given width <=0 or height <=0")
    @MethodSource("exceptionTestParams")
    void shouldThrowExceptionForInvalidParameters(double height, double width) {
        assertThrows(IllegalArgumentException.class, () -> {
            Rectangle rectangle = new Rectangle(height, width);
        });
    }

    private static Stream<Object> exceptionTestParams() {
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
