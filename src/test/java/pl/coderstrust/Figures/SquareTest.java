package pl.coderstrust.Figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SquareTest {

    @ParameterizedTest(name = "{index} => sideLength={0}, expected = {1}")
    @DisplayName("Should return calculated area of square figure.")
    @MethodSource("paramsForSquareArea")
    void calculateArea(double sideLength, double expected) {

        //Given

        Square square = new Square(sideLength);

        //When

        double actual = square.calculateArea();

        //Then

        assertEquals(expected, actual);
    }

    private static Stream<Object> paramsForSquareArea() {
        return
                Stream.of(Arguments.of(1, 1),
                        (Arguments.of(2.0, 4.0)),
                        (Arguments.of(2.5, 6.25)));
    }

    @ParameterizedTest(name = "{index} => a={0}")
    @DisplayName("Should throw exception if given a <=0")
    @MethodSource("paramsForExceptionTest")
    void shouldThrowIllegalArgumentExceptionForInvalidSize(double sideLenght) {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    double illegalSide = sideLenght;
                    Square square = new Square(illegalSide);
                });
    }

    private static Stream<Object> paramsForExceptionTest() {
        return
                Stream.of(Arguments.of(0),
                        (Arguments.of(-0.01)));
    }
}
