package pl.coderstrust.Figures;

public class Circle implements Figure {
   private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI*radius*radius;
    }
}
