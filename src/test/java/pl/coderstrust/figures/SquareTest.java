package pl.coderstrust.figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("Should throw exception if sideLength passed to constructor <=0")
    void shouldThrowExceptionForInvalidParameterPassedToConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new Square(-1));
    }

    @Test
    @DisplayName("Should throw exception if sideLength passed to setter <=0")
    void shouldThrowExceptionForInvalidParameterPassedToSetter() {
        Square square = new Square(1);
        assertThrows(IllegalArgumentException.class, () -> square.setSideLength(-1));
    }
}
