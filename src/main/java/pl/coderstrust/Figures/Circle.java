package pl.coderstrust.Figures;

public class Circle implements Figure {
    private double radius;

    public Circle(double radius) {
        setIfValid(radius);
    }

    public void setRadius(double radius) {
        setIfValid(radius);
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    private void setIfValid(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius of a circle must be greater than zero");
        } else {
            this.radius = radius;
        }
    }
}
