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
    @DisplayName("Should return calculated area of square, based on constructor parameter.")
    void shouldCalculateAreaBasedOnConstructor() {
        //Given
        Square square = new Square(3);

        //When
        double actual = square.calculateArea();

        //Then
        assertEquals(9, actual);
    }

    @Test
    @DisplayName("Should return calculated area of square, based on setter parameter.")
    void shouldCalculateAreaBasedOnSetter() {
        //Given
        Square square = new Square(2);

        //When
        square.setSideLength(3);
        double actual = square.calculateArea();

        //Then
        assertEquals(9, actual);
    }

    @ParameterizedTest
    @MethodSource("invalidSideLength")
    @DisplayName("Should throw exception if sideLength passed to constructor <=0")
    void shouldThrowExceptionForInvalidParameterPassedToConstructor(double sideLength) {
        assertThrows(IllegalArgumentException.class, () -> new Square(sideLength));
    }

    @ParameterizedTest
    @MethodSource("invalidSideLength")
    @DisplayName("Should throw exception if sideLength passed to setter <=0")
    void shouldThrowExceptionForInvalidParameterPassedToSetter(double sideLength) {
        Square square = new Square(1);
        assertThrows(IllegalArgumentException.class, () -> square.setSideLength(sideLength));
    }

    private static Stream<Object> invalidSideLength() {
        return Stream.of(Arguments.of(0),
                (Arguments.of(-5.03)));
    }
}
