package pl.coderstrust.figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SquareTest {
    @Test
    @DisplayName("Should return calculated area of square figure.")
    void calculateArea() {
        //Given
        Square square = new Square(2);

        //When
        square.setSideLength(3);
        double actual = square.calculateArea();

        //Then
        assertEquals(9, actual);
    }

    @ParameterizedTest(name = "{index} => a={0}")
    @DisplayName("Should throw exception if given a <=0")
    @MethodSource("paramsForExceptionTest")
    void shouldThrowIllegalArgumentExceptionForInvalidSize(double sideLength) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    double illegalSide = sideLength;
                    Square square = new Square(illegalSide);
                });
    }

    private static Stream<Object> paramsForExceptionTest() {
        return
                Stream.of(Arguments.of(0),
                        (Arguments.of(-0.01)));
    }
}
