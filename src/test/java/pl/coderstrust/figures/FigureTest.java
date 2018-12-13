package pl.coderstrust.figures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FigureTest {
    @Test
    @DisplayName("Should show polymorphism")
    void polymorphismTest() {
        double actual;
        Figure figure = new Circle(2);
        actual = figure.calculateArea();
        assertEquals(12.566370614359172, actual);

        figure = new Square(3);
        actual = figure.calculateArea();
        assertEquals(9, actual);

        figure = new Rectangle(2, 4);
        actual = figure.calculateArea();
        assertEquals(8, actual);

        figure = new Triangle(2, 3);
        actual = figure.calculateArea();
        assertEquals(3, actual);

        figure = new Trapezoid(1, 3, 4);
        actual = figure.calculateArea();
        assertEquals(8, actual);
    }
}
