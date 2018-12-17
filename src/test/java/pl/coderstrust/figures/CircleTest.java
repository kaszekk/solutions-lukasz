package pl.coderstrust.figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CircleTest {
    @Test
    @DisplayName("Should return calculated area of circle using constructor parameters.")
    void shouldCalculateCorrectAreaBasedOnConstructor() {
        //Given
        double delta = 1e-15;
        Circle circle = new Circle(2);

        //When
        double actual = circle.calculateArea();

        //Then
        assertEquals(12.566370614359172, actual, delta);
    }

    @Test
    @DisplayName("Should return calculated area of circle ,based on parameter passed to setter.")
    void shouldCalculateCorrectAreaBasedOnSetter() {
        //Given
        double delta = 1e-15;
        Circle circle = new Circle(1);

        //When
        circle.setRadius(2);
        double actual = circle.calculateArea();

        //Then
        assertEquals(12.566370614359172, actual, delta);
    }

    @Test
    @DisplayName("Should throw exception if given radius set in constructor <=0")
    void shouldThrowExceptionForInvalidRadiusPassedToConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new Circle(-1));
    }

    @Test
    @DisplayName("Should throw exception if given radius passed to setter <=0")
    void shouldThrowExceptionForInvalidRadiusPassedToSetter() {
        Circle circle = new Circle(1);
        assertThrows(IllegalArgumentException.class, () -> circle.setRadius(-1));
    }
}
