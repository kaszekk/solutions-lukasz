package pl.coderstrust.Figures;

import java.util.ArrayList;
import java.util.List;

public interface Figure {
    double calculateArea();

    static void main(String[] args) {
        List<Figure> figuresList = new ArrayList<>();
        Figure figure1 = new Rectangle(3, 4);
        figuresList.add(figure1);
        Figure figure2 = new Square(3);
        figuresList.add(figure2);
        Figure figure3 = new Triangle(3, 4);
        figuresList.add(figure3);
        Figure figure4 = new Trapezoid(3, 4, 3);
        figuresList.add(figure4);
        Figure figure5 = new Circle(3);
        figuresList.add(figure5);

        double totalArea = getTotalArea(figuresList);
        System.out.println("Total area of figures is " + totalArea);

        /*double sumArea = addArea(figure1, figure2);
        System.out.println(sumArea);*/
    }

    static double getTotalArea(List<Figure> figures) {
        double totalArea = 0;
        for (Figure element : figures) {
            totalArea += element.calculateArea();
        }
        return totalArea;
    }

    static double addArea(Figure figureA, Figure figureB) {
        return figureA.calculateArea() + figureB.calculateArea();
    }
}
