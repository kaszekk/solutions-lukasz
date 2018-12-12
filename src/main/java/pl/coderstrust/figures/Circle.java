package pl.coderstrust.figures;

public class Circle implements Figure {
    private double radius;

    public Circle(double radius) {
        validateRadius(radius);
    }

    public void setRadius(double radius) {
        validateRadius(radius);
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    private void validateRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius of a circle must be greater than zero");
        } else {
            this.radius = radius;
        }
    }
}
