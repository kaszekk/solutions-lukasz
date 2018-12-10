package pl.coderstrust.Figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FigureTest {
    @Test
    @DisplayName("Should show polymorphism")
    void polymorphismTest() {
        //Given
        double actual;
        Figure figure = new Circle(2);

        //When
        actual = figure.calculateArea();

        //Then
        assertEquals(new Circle(2).calculateArea(), actual);

        //Given
        figure = new Square(3);

        //When
        actual = figure.calculateArea();

        //Then
        assertEquals(new Square(3).calculateArea(), actual);

        //Given
        figure = new Rectangle(2, 4);

        //When
        actual = figure.calculateArea();

        //Then
        assertEquals(new Rectangle(2, 4).calculateArea(), actual);

        //Given
        figure = new Triangle(2, 3);

        //When
        actual = figure.calculateArea();

        //Then
        assertEquals(new Triangle(2, 3).calculateArea(), actual);

        //Given
        figure = new Trapezoid(1, 3, 4);

        //When
        actual = figure.calculateArea();

        //Then
        assertEquals(new Trapezoid(1, 3, 4).calculateArea(), actual);
    }
}
